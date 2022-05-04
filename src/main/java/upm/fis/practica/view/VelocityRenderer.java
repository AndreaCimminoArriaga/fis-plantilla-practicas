package upm.fis.practica.view;

import java.util.Map;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import upm.fis.practica.exceptions.RenderTemplateException;

public class VelocityRenderer implements ViewRenderer {

	private VelocityTemplateEngine engine;
	
	public VelocityRenderer() {
		engine = new VelocityTemplateEngine();
		
	}
	
	@Override
	public String render(Map<String,Object> model, String template) throws RenderTemplateException {
		try{
			return engine.render(new ModelAndView(model, template));
		}catch(Exception e) {
			throw new RenderTemplateException(e.toString());
		}
	}
	
}
