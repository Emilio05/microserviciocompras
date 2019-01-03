package ce.pucmm.microserviciocompra.Model;

import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Entity(name = "Factura")
@Table(name = "factura")
@Where(clause = "deleted = 0")
public class Factura implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "factura_id", nullable = false, unique = true, updatable = false)
    private int id;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "total")
    private double total;

    @Column(name = "condicion")
    private String condicion;

    @Column(name = "cliente_id")
    private String cliente_id;


    private int port;

    private boolean deleted = false;

    public Factura() {

    }

    public Factura(LocalDate fecha, double total, String condicion, String cliente_id) {
        this.fecha = fecha;
        this.total = total;
        this.condicion = condicion;
        this.cliente_id = cliente_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    public String getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(String cliente_id) {
        this.cliente_id = cliente_id;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
