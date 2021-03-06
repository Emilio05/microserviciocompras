package ce.pucmm.microserviciocompra.Controller;

import ce.pucmm.microserviciocompra.Model.*;
import ce.pucmm.microserviciocompra.Service.FacturaProductoServiceImpl;
import ce.pucmm.microserviciocompra.Service.FacturaServiceImpl;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.sparkpost.Client;
import com.sparkpost.exception.SparkPostException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.spi.LocaleServiceProvider;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/compras")
public class FacturaProductoController {

    @Autowired
    private FacturaProductoServiceImpl facturaProductoService;


    @Autowired
    private FacturaServiceImpl facturaService;

    @Autowired
    RestTemplate restTemplate;


    @GetMapping(value = "/total")
    public int total(){
        return facturaProductoService.buscarTodasFacturaProductos().size();
    }

    @GetMapping(value = "/totaldespachosefectuados")
    public int totaldespachosefectuados(){
        List<Factura> facturas = facturaService.buscarTodasFacturas();
        int ans =0;
        for(Factura f : facturas){
            if(f.getCondicion().equals("Despachado"))ans++;
        }
        return ans;
    }

    @GetMapping(value = "/totaldespachospendientes")
    public int totaldespachospendientes(){
        List<Factura> facturas = facturaService.buscarTodasFacturas();
        int ans =0;
        for(Factura f : facturas){
            if(f.getCondicion().equals("Pendiente"))ans++;
        }
        return ans;
    }


    @RequestMapping("/todos")
    public List<Factura> verTodasLasFacturas() {

        return facturaService.buscarTodasFacturas();
    }

    @PostMapping(value = "/entregar/")
    public void despacho(@RequestParam("client") String idcliente, @RequestParam("cant[]") List<String> cantidades,
                           @RequestParam("ids[]") List<String> ids, @RequestParam("fecha") String fecha,
                           @RequestParam("condicion") String condicion, @RequestParam("total") String total) {


        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        List<Producto> productos = restTemplate.exchange("http://localhost:8082/productos/todos", HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Producto>>() {
                }).getBody();

        List<Producto> productoList = new ArrayList<>();

        String informacionDespacho = "";


        Factura factura = new Factura();
        FacturaProducto detalles = new FacturaProducto();

        factura.setCliente_id(idcliente);
        LocalDate date = LocalDate.parse(fecha);
        factura.setFecha(date);
        factura.setTotal(Double.parseDouble(total));
        factura.setCondicion(condicion);

        facturaService.crearFactura(factura);

        for (int i = 0; i < ids.size(); i++) {

            detalles.setFactura_id(Integer.toString(factura.getId()));
            detalles.setProducto_id(ids.get(i));
            detalles.setCantidad(Integer.parseInt(cantidades.get(i)));
            for (Producto producto : productos){
                if(ids.get(i) == Integer.toString(producto.getId())){
                    detalles.setSubtotal(Integer.parseInt(cantidades.get(i)) * producto.getPrecio());
                    informacionDespacho = "Producto: "+ producto.getNombre() + ", Cantidad: "+ cantidades.get(i) +"";
                }
            }
            facturaProductoService.crearFacturaProducto(detalles);
        }


        HttpHeaders headers2 = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity2 = new HttpEntity<String>(headers2);
        List<Usuario> usuariosAlmacen = restTemplate.exchange("http://localhost:8083/usuarios/usuariosalmacen",
                HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Usuario>>() {
                }).getBody();


        for (Usuario usuario : usuariosAlmacen){

            String API_KEY = "eca1ad61d12248452578b2c4f1eda5963d6d94b5";
            Client client = new Client(API_KEY);
            try{
                client.sendMessage(
                        "20120994@ce.pumm.edu.do",
                        usuario.getEmail(),
                        "Despacho de Mercancia",
                         informacionDespacho,
                        "<b>Hola Mundo desde SparkPost</b>");
            }
            catch (SparkPostException s){
                System.out.println("ERROR");
            }
        }

    }

    @PostMapping(value = "/entrega/{id}")
    public String entrega(@PathVariable("id") String id) {

        Factura factura = facturaService.buscarPorId(Long.parseLong(id));
        factura.setCondicion("Entregado");
        facturaService.actualizarFactura(factura);
        return "redirect:/compras/";
    }

    @GetMapping(value = "/entregado/{id}")
    public String entregado(Model model, @PathVariable("id") String id) {
        Factura factura = facturaService.buscarPorId(Long.parseLong(id));
        model.addAttribute("factura", factura);
        return "factura";
    }



}
