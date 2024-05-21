package com.bolsadeideas.springboot.webflux.client.app.models;

import java.util.Date;

public class Producto {

	private String id;
	private String nombre;
	private Double precio;
	private Date createAt;
	private String foto;
	private Categoria categoria;

	public Producto() {
	}

	public Producto(String id, String nombre, Double precio, Date createAt, String foto, Categoria categoria) {
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.createAt = createAt;
		this.foto = foto;
		this.categoria = categoria;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Producto{" +
				"id='" + id + '\'' +
				", nombre='" + nombre + '\'' +
				", precio=" + precio +
				", createAt=" + createAt +
				", foto='" + foto + '\'' +
				", categoria=" + categoria +
				'}';
	}
}
