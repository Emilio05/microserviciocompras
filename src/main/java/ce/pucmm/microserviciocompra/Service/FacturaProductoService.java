package ce.pucmm.microserviciocompra.Service;

import ce.pucmm.microserviciocompra.Model.Factura;
import ce.pucmm.microserviciocompra.Model.FacturaProducto;

import java.util.List;

public interface FacturaProductoService {


    void crearFacturaProducto(FacturaProducto facturaProducto);

    void actualizarFacturaProducto(FacturaProducto facturaProducto);

    void borrarFacturaProductoPorId(long id);

    void borrarTodasLasFacturaProductos();

    List<FacturaProducto> buscarTodasFacturaProductos();

    FacturaProducto buscarPorId(long id);

    boolean facturaProductoExiste(FacturaProducto facturaProducto);


}
