package edu.upc.sistemaventas.web;

import edu.upc.sistemaventas.dominio.UsuarioDomain;
import edu.upc.sistemaventas.servicios.UsuarioService;
import edu.upc.sistemaventas.web.forms.UsuarioForm;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class LogeoController {
  
  private static UsuarioService usuarioService = new UsuarioService();
  private UsuarioForm usuario;
  
  public UsuarioForm getUsuario() {
    return usuario;
  }
  public void setUsuario(UsuarioForm usuario) {
    this.usuario = usuario;
  }
  
  @RequestMapping(value = "/logeo.html", method = RequestMethod.GET)
  protected ModelAndView inicio(HttpServletRequest request, HttpServletResponse response) throws Exception {
    return new ModelAndView("logeo", "usuario", new UsuarioForm());
  }

  @RequestMapping(value = "/logeo.html", method = RequestMethod.POST)
  public ModelAndView autenticar(@Valid @ModelAttribute("usuario") UsuarioForm usuario, BindingResult result,
                                 Map<String, UsuarioForm> model) {
    if (!result.hasErrors()) {
      UsuarioDomain usuarioDomain = usuarioService.obtenerUsuario(usuario.getUsuario());
      if (usuarioDomain != null) {
        if (usuarioDomain.getClave().equals(usuario.getClave())) {
          usuario.setTieneErrores(false);
          model.put("usuarioForm", usuario);
          if (usuarioDomain.getRol().getId() == 1) {
            return new ModelAndView("redirect:indexAdmin.html");
          }
          return new ModelAndView("redirect:indexEmprendedor.html");
        } else {
          usuario.setTieneErrores(true);
          ModelAndView mav = new ModelAndView("logeo", "usuario", usuario);
          mav.addObject("logeo_error", "La clave no es correcta.");
          return mav;
        }
      } else {
        usuario.setTieneErrores(true);
        ModelAndView mav = new ModelAndView("logeo", "usuario", usuario);
        mav.addObject("logeo_error", "El usuario no existe.");
        return mav;
      }
    }
    return new ModelAndView("logeo", "usuario", usuario);
  }

//	@RequestMapping(value = "/logeo.html", method = RequestMethod.POST)
//        protected ModelAndView autenticar(HttpServletRequest request, HttpServletResponse response) throws Exception {
//    String usuario = request.getParameter("idUsuario");
//    String clave = request.getParameter("clave");
//    if (usuario)
//		return new ModelAndView("logeo");
//	} 
  
}
