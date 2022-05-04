package upm.fis.practica.view;

import java.io.File;
import java.util.Arrays;
import java.util.Map;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;
import upm.fis.practica.AppUtils;
import upm.fis.practica.exceptions.RenderTemplateException;

public class FreemarkerRenderer implements ViewRenderer{

	private FreeMarkerEngine engine;
	private File viewsDirectory;
	private static final String VIEWS_PATH = "./src/test/resources/spark/template/freemarker";

	public FreemarkerRenderer() {
		engine = new FreeMarkerEngine();
		viewsDirectory = new File(VIEWS_PATH);
	}
	
	public String render(Map<String,Object> model, String template) throws RenderTemplateException {
		String result = null;
		try{
			if(!fileExists(template))
				throw new RenderTemplateException(AppUtils.concat("Template ",template," is not located under the directory ",VIEWS_PATH));
			
			result = engine.render(new ModelAndView(model, template));
		}catch(Exception e) {
			throw new RenderTemplateException(e.toString());
		}
		return result;
	}
	
	private boolean fileExists(String name) {
		return Arrays.asList(viewsDirectory.listFiles()).parallelStream().anyMatch(file -> file.getName().equals(name));
	}
	
}
