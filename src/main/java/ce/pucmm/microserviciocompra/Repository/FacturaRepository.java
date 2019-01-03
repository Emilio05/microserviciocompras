package ce.pucmm.microserviciocompra.Repository;

import ce.pucmm.microserviciocompra.Model.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Long> {

//
//    @Query("select factura from Factura where factura.condicion = 'Pendiente' ")
//    List<Factura> facturasPendientes();
@Query("select factura from Factura factura where factura.cliente_id = ?1")
List<Factura> facturasPorCliente(int idcliente);
//    @Query("select factura from Factura where factura.fecha = current_date ")
//    List<Factura> facturasDelDia();


}
