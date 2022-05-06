package upm.fis.practica.view;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;

import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;
import upm.fis.practica.AppUtils;
import upm.fis.practica.exceptions.RenderTemplateException;

public class FreemarkerRenderer implements ViewRenderer{

	private FreeMarkerEngine engine;
	private File viewsDirectory;
	private static final String VIEWS_PATH = "./src/test/resources/spark/template/freemarker";
	private ObjectMapper mapper;
	
	public FreemarkerRenderer() {
		engine = new FreeMarkerEngine();
		viewsDirectory = new File(VIEWS_PATH);
		mapper = new ObjectMapper();
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
	
	@Override
	public Map<String, Object> toModel(Object object) {
		@SuppressWarnings("unchecked")
		Map<String, Object> model = mapper.convertValue(object, Map.class);
		return model;
	}
	
	@Override
	public String render(Object object, String template) throws RenderTemplateException {
		return render(toModel(object), template);
	}
	
	@Override
	public Map<String, Object> toModel(List<?> object, String variable) {
		Map<String,Object> model = new HashMap<>();
		List<Object> values = object.parallelStream().map(elem -> toModel(elem)).collect(Collectors.toList());
		model.put(variable, values);
		return model;
	}
	
}
