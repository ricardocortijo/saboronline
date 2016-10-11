package edu.upc.saboronline.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexClienteController {
	
	@RequestMapping(value = "/indexCliente.html", method = RequestMethod.GET)	
	protected ModelAndView inicioCliente(HttpServletRequest request, HttpServletResponse response) throws Exception {
    request.getSession().setAttribute("opcion1Activa", "active");
    request.getSession().setAttribute("opcion2Activa", "");
    request.getSession().setAttribute("opcion3Activa", "");
		return new ModelAndView("indexCliente");
	}
  
}
