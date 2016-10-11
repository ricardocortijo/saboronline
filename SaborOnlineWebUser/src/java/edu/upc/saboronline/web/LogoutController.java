package edu.upc.saboronline.web;

import edu.upc.saboronline.web.forms.UsuarioForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LogoutController {
   
  @RequestMapping(value = "/logout.html", method = RequestMethod.GET)
  protected ModelAndView salir(HttpServletRequest request, HttpServletResponse response) throws Exception {
    request.getSession().invalidate();
    return new ModelAndView("login", "usuario", new UsuarioForm());
  }
  
}
