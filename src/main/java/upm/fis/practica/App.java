package upm.fis.practica;

import static spark.Spark.*;

import upm.fis.practica.controller.LibroController;


/**
 * APP
 *
 */
public class App {
	
    public static void main( String[] args ) {
    	LibroController controladorLibros = new LibroController();
    	
    	setUp();
    	get("/", (req, res) -> {return controladorLibros.listarLibros(req, res);}); 
    	get("", (req, res) -> {return controladorLibros.listarLibros(req, res);}); 

    	get("/libros", (req, res) -> {return controladorLibros.listarLibros(req, res);}); 
    	get("/newlibro", (req, res) -> {return controladorLibros.crearLibro(req, res);}); 
    	get("/libro", (req, res) -> {return controladorLibros.recuperarLibro(req, res);}); 

    	
    	// post("/sample_route", (req, res) -> {return sampleController.action(req, res);}); 
    	
    }
    
    public static void setUp() {
    	staticFiles.location("./src/test/resource");
        staticFiles.externalLocation("./src/test/resource");
    }
	
}
