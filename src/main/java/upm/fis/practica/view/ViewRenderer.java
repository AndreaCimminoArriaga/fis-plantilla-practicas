package upm.fis.practica.view;

import java.util.Map;

import upm.fis.practica.exceptions.RenderTemplateException;

public interface ViewRenderer {

	String render(Map<String, Object> model, String template) throws RenderTemplateException;

}