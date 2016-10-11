package edu.upc.saboronline.web;

import edu.upc.saboronline.servicios.UsuarioService;
import edu.upc.saboronline.web.forms.UsuarioForm;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class LoginController {
  
  private static UsuarioService usuarioService = new UsuarioService();
  private UsuarioForm usuario;
  
  public UsuarioForm getUsuario() {
    return usuario;
  }
  public void setUsuario(UsuarioForm usuario) {
    this.usuario = usuario;
  }
  
  @RequestMapping(value = "/login.html", method = RequestMethod.GET)
  protected ModelAndView inicio(HttpServletRequest request, HttpServletResponse response) throws Exception {
    return new ModelAndView("login", "usuario", new UsuarioForm());
  }

  @RequestMapping(value = "/login.html", method = RequestMethod.POST)
  public ModelAndView autenticar(@Valid @ModelAttribute("usuario") UsuarioForm usuario, BindingResult result,
                                 Map<String, UsuarioForm> model) {
    if (!result.hasErrors()) {
      boolean validarUsuario = usuarioService.validarUsuario(usuario.getUsuario(), usuario.getClave());
      if (validarUsuario) {
        usuario.setTieneErrores(false);
        model.put("usuarioForm", usuario);
        return new ModelAndView("redirect:indexCliente.html");
      } else {
        usuario.setTieneErrores(true);
        ModelAndView mav = new ModelAndView("login", "usuario", usuario);
        mav.addObject("login_error", "El usuario y/o clave no existe o no tiene los permisos necesarios para acceder.");
        return mav;
      }
    }
    return new ModelAndView("login", "usuario", usuario);
  }

//	@RequestMapping(value = "/login.html", method = RequestMethod.POST)
//        protected ModelAndView autenticar(HttpServletRequest request, HttpServletResponse response) throws Exception {
//    String usuario = request.getParameter("idUsuario");
//    String clave = request.getParameter("clave");
//    if (usuario)
//		return new ModelAndView("login");
//	} 
  

  
}
