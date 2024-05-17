package com.bolsadeideas.springboot.webflux.app.controllers;

import java.time.Duration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bolsadeideas.springboot.webflux.app.models.dao.ProductoDao;
import com.bolsadeideas.springboot.webflux.app.models.documents.Producto;

import org.thymeleaf.spring6.context.webflux.ReactiveDataDriverContextVariable;
import reactor.core.publisher.Flux;


@Controller
public class ProductoController {

	private final ProductoDao dao; //productRepository
	
	private static final Logger log = LoggerFactory.getLogger(ProductoController.class);

    public ProductoController(ProductoDao dao) {
        this.dao = dao;
    }

	//De esta forma se listan todos los productos sin tener en cuenta backpressure
    @GetMapping({"/listar", "/"})
	public String listar(Model model) {

		//Consultar productos en Mongo
		Flux<Producto> productos = dao.findAll().map(producto -> {
			
			producto.setNombre(producto.getNombre().toUpperCase());
			return producto;
		});
		
		productos.subscribe(prod -> log.info(prod.getNombre()));

		//Setear productos al modelo para que puedan ser leídos desde el front
		//Los nombres de los atributos (productos, titulo) son accedidos desde el front
		model.addAttribute("productos", productos);
		model.addAttribute("titulo", "Listado de productos");

		//Se debe retornar el mismo nombre del template de HTML
		return "listar";
	}
	
	@GetMapping("/listar-datadriver")
	public String listarDataDriver(Model model) {
		
		Flux<Producto> productos = dao.findAll().map(producto -> {
			
			producto.setNombre(producto.getNombre().toUpperCase());
			return producto;
		}).delayElements(Duration.ofSeconds(1));
		
		productos.subscribe(prod -> log.info(prod.getNombre()));
		
		model.addAttribute("productos", new ReactiveDataDriverContextVariable(productos, 1));
		model.addAttribute("titulo", "Listado de productos");
		return "listar";
	}
	
	@GetMapping("/listar-full")
	public String listarFull(Model model) {
		
		Flux<Producto> productos = dao.findAll().map(producto -> {
			
			producto.setNombre(producto.getNombre().toUpperCase());
			return producto;
		}).repeat(5000);
		
		model.addAttribute("productos", productos);
		model.addAttribute("titulo", "Listado de productos");
		return "listar";
	}
	
	@GetMapping("/listar-chunked")
	public String listarChunked(Model model) {
		
		Flux<Producto> productos = dao.findAll().map(producto -> {
			
			producto.setNombre(producto.getNombre().toUpperCase());
			return producto;
		}).repeat(5000);
		
		model.addAttribute("productos", productos);
		model.addAttribute("titulo", "Listado de productos");
		return "listar-chunked";
	}
}
