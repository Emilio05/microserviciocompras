package ce.pucmm.microserviciocompra.Service;


import ce.pucmm.microserviciocompra.Model.FacturaProducto;
import ce.pucmm.microserviciocompra.Repository.FacturaProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("facturaProductoService")
@Transactional
public class FacturaProductoServiceImpl implements FacturaProductoService {

    @Autowired
    private FacturaProductoRepository facturaProductoRepository;

    public void crearFacturaProducto(FacturaProducto facturaProducto) {
        facturaProductoRepository.save(facturaProducto);
    }

    public void actualizarFacturaProducto(FacturaProducto facturaProducto) {
        crearFacturaProducto(facturaProducto);
    }

    public void borrarFacturaProductoPorId(long id) {
        facturaProductoRepository.deleteById(id);
    }

    public void borrarTodasLasFacturaProductos() {
        facturaProductoRepository.deleteAll();
    }

    public List<FacturaProducto> buscarTodasFacturaProductos() {
        return facturaProductoRepository.findAll();
    }

    @Override
    public FacturaProducto buscarPorId(long id) {
        return facturaProductoRepository.findById(id).get();
    }

    public boolean facturaProductoExiste(FacturaProducto facturaProducto) {
        return buscarPorId(facturaProducto.getId()) != null;
    }
}
