package upm.fis.practica.view;

import java.util.Map;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

public class FreemarkerRenderer implements ViewRenderer{

	private FreeMarkerEngine engine;
	
	public FreemarkerRenderer() {
		engine = new FreeMarkerEngine();
		
	}
	
	public String render(Map<String,Object> model, String template) {
		String result = null;
		try{
			result = engine.render(new ModelAndView(model, "hello.flt"));
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
