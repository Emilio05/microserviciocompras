package ce.pucmm.microserviciocompra.Model;

import java.util.Base64;

public class Producto {

    private int id;

    private String nombre;

    private int stock;

    private double precio;

    private byte[] imagen;

    public Producto(){

    }

    public Producto(int id, String nombre, int stock, double precio, byte[] imagen) {
        this.id = id;
        this.nombre = nombre;
        this.stock = stock;
        this.precio = precio;
        this.imagen = imagen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getImagen() {
        return Base64.getEncoder().encodeToString(imagen);

    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }
}
