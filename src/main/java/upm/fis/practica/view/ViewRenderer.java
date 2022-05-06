package upm.fis.practica.view;

import java.util.List;
import java.util.Map;

import upm.fis.practica.exceptions.RenderTemplateException;

public interface ViewRenderer {

	String render(Object object, String template) throws RenderTemplateException;
	String render(Map<String, Object> model, String template) throws RenderTemplateException;
	Map<String, Object> toModel(Object object);
	Map<String, Object> toModel(List<?> object, String variable);
}