package upm.fis.practica.view;

import java.io.File;
import java.util.Arrays;
import java.util.Map;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import upm.fis.practica.AppUtils;
import upm.fis.practica.exceptions.RenderTemplateException;

public class VelocityRenderer implements ViewRenderer {

	private VelocityTemplateEngine engine;
	private File viewsDirectory;
	private static final String VIEWS_PATH = "./src/test/resources";

	public VelocityRenderer() {
		engine = new VelocityTemplateEngine();
		viewsDirectory = new File(VIEWS_PATH);
	}
	
	@Override
	public String render(Map<String,Object> model, String template) throws RenderTemplateException {
		try{
			if(!fileExists(template))
				throw new RenderTemplateException(AppUtils.concat("Template ",template," is not located under the directory ",VIEWS_PATH));

			return engine.render(new ModelAndView(model, template));
		}catch(Exception e) {
			throw new RenderTemplateException(e.toString());
		}
	}
	
	private boolean fileExists(String name) {
		return Arrays.asList(viewsDirectory.listFiles()).parallelStream().anyMatch(file -> file.getName().equals(name));
	}
}
