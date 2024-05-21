package com.bolsadeideas.springboot.webflux.client.app.models;

public class CreateProductResponse {
    private Producto producto;
    private String mensaje;
    private String timestamp;

    public CreateProductResponse() {
    }

    public CreateProductResponse(Producto producto, String mensaje, String timestamp) {
        this.producto = producto;
        this.mensaje = mensaje;
        this.timestamp = timestamp;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
