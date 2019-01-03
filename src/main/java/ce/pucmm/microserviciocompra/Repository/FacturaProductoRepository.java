package ce.pucmm.microserviciocompra.Repository;

import ce.pucmm.microserviciocompra.Model.FacturaProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaProductoRepository extends JpaRepository<FacturaProducto, Long> {
}
