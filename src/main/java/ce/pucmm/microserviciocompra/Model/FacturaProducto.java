package ce.pucmm.microserviciocompra.Model;


import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "FacturaProducto")
@Table(name = "detalles_factura")
@Where(clause = "deleted = 0")
public class FacturaProducto implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "detalles_factura_id", nullable = false, unique = true, updatable = false)
    private int id;

    @Column(name = "factura_id")
    private String factura_id;

    @Column(name = "producto_id")
    private String producto_id;

    @Column(name = "cantidad")
    private int cantidad;

    @Column(name = "subtotal")
    private double subtotal;

    private boolean deleted = false;

    private int port;

    public FacturaProducto() {

    }

    public FacturaProducto(String factura_id, String producto_id, int cantidad, double subtotal) {
        this.factura_id = factura_id;
        this.producto_id = producto_id;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFactura_id() {
        return factura_id;
    }

    public void setFactura_id(String factura_id) {
        this.factura_id = factura_id;
    }

    public String getProducto_id() {
        return producto_id;
    }

    public void setProducto_id(String producto_id) {
        this.producto_id = producto_id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
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
