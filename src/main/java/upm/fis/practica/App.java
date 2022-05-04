package upm.fis.practica;

import static spark.Spark.*;


/**
 * APP
 *
 */
public class App {
	
    public static void main( String[] args ) {
    	setUp();
    	// get("/sample_route", (req, res) -> {return sampleController.action(req, res);}); 
    	// post("/sample_route", (req, res) -> {return sampleController.action(req, res);}); 
    	get("/test", (req, res) -> {return "hi";});
    	
    }
    
    public static void setUp() {
    	
    }
	
}
