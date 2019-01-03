package ce.pucmm.microserviciocompra.Service;


import ce.pucmm.microserviciocompra.Model.Factura;
import ce.pucmm.microserviciocompra.Repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("facturaService")
@Transactional
public class FacturaServiceImpl implements FacturaService {

    @Autowired
    private FacturaRepository facturaRepository;

    public void crearFactura(Factura factura) {
        facturaRepository.save(factura);
    }

    public void actualizarFactura(Factura factura) {
        crearFactura(factura);
    }

    public void borrarFacturaPorId(long id) {
        facturaRepository.deleteById(id);
    }

    public void borrarTodasLasFacturas() {
        facturaRepository.deleteAll();
    }

    public List<Factura> buscarTodasFacturas() {
        return facturaRepository.findAll();
    }

    @Override
    public Factura buscarPorId(long id) {
        return facturaRepository.findById(id).get();
    }

    public boolean facturaExiste(Factura factura) {
        return buscarPorId(factura.getId()) != null;
    }

    public List<Factura> facturasPorCliente(int idcliente){
        return facturaRepository.facturasPorCliente(idcliente);
    }

//    public List<Factura> facturasPendientes() {
//            return facturaRepository.facturasPendientes();
//        }

//    public List<Factura> facturasDelDia() {
//        return facturaRepository.facturasDelDia();
//    }
}
