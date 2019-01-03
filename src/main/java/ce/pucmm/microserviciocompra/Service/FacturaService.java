package ce.pucmm.microserviciocompra.Service;


import ce.pucmm.microserviciocompra.Model.Factura;

import java.util.List;

public interface FacturaService {

    void crearFactura(Factura factura);

    void actualizarFactura(Factura factura);

    void borrarFacturaPorId(long id);

    void borrarTodasLasFacturas();

    List<Factura> buscarTodasFacturas();

    Factura buscarPorId(long id);

    boolean facturaExiste(Factura factura);

    List<Factura> facturasPorCliente(int idcliente);

//    List<Factura> facturasPendientes();

//    List<Factura> facturasDelDia();

}
