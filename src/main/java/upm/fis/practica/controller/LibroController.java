package upm.fis.practica.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import spark.Request;
import spark.Response;
import upm.fis.practica.exceptions.RenderTemplateException;
import upm.fis.practica.model.Libro;
import upm.fis.practica.view.VelocityRenderer;
import upm.fis.practica.view.ViewRenderer;

public class LibroController {

	private List<Libro> libros;
	private ViewRenderer renderer;
	
	public LibroController() {
		libros = new ArrayList<>();
		renderer = new VelocityRenderer();
		
		Libro libro1 = new Libro("Blade runner", "AAA", 1111);
		Libro libro2 = new Libro("El principito", "VVV", 2222);
		Libro libro3 = new Libro("De euclides a Java", "CCC", 0000);
		libros.add(libro3);
		libros.add(libro2);
		libros.add(libro1);
	}
	
	public String recuperarLibro(Request request, Response response){
		String isbn = request.queryParams("isbn");
		Libro aux = null;
		for(Libro libro : libros) {
			if(libro.getIsbn().equals(isbn)) {
				aux = libro;
				break;
			}
		}
		if(aux!=null) {
			Map<String,Object> model = renderer.toModel(aux);
			String template = "libro.vm";
			try {
				return renderer.render(model, template);
			} catch (RenderTemplateException e) {
				e.printStackTrace();
			}
			return "";
		}
		return "";
	}
	
	public String listarLibros(Request request, Response response){
		
		Map<String,Object> model = renderer.toModel(libros, "libros");
		String template = "libros.vm";
		try {
			return renderer.render(model, template);
		} catch (RenderTemplateException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public String crearLibro(Request request, Response response) {
		String titulo = request.queryParams("titulo");
		String isbn = request.queryParams("isbn");
		Integer year = Integer.valueOf(request.queryParams("year"));
		
		Libro libro = new Libro(titulo, isbn, year);
		libros.add(libro);
		
		Map<String, Object> model = renderer.toModel(libro);
		String template = "libro.vm";
		
		try {
			return renderer.render(model, template);
		} catch (RenderTemplateException e) {
			e.printStackTrace();
		}
		return "";
	}
	
}
