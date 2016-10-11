package edu.upc.sistemaventas.web;

import edu.upc.sistemaventas.dominio.EmprendedorDomain;
import edu.upc.sistemaventas.servicios.EmprendedorService;
import edu.upc.sistemaventas.utils.BusinessException;
import edu.upc.sistemaventas.web.forms.EmprendedorBusquedaForm;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.propertyeditors.CustomDateEditor;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MantenimientoEmprendedorController {
  
  private static EmprendedorService emprendedorService = new EmprendedorService();
	  
  @InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
  
	@RequestMapping(value = "/listadoEmprendedores.html", method = RequestMethod.GET)	
	protected ModelAndView inicio(HttpServletRequest request, HttpServletResponse response) throws Exception {
    request.getSession().setAttribute("opcion1Activa", "");
    request.getSession().setAttribute("opcion2Activa", "active");
    request.getSession().setAttribute("opcion3Activa", "");
		return new ModelAndView("listadoEmprendedores", "emprendedorBusqueda", new EmprendedorBusquedaForm());
	}
  
  @RequestMapping(value = "/listadoEmprendedores.html", method = RequestMethod.POST)
  public ModelAndView ejecutarAccion(@Valid @ModelAttribute("emprendedorBusqueda") EmprendedorBusquedaForm emprendedorBusqueda, BindingResult result,
                                     Map<String, EmprendedorBusquedaForm> model) {
    String accion = emprendedorBusqueda.getAccion();
    if (accion.equals("delete")) {
      int idEmprendedor = Integer.parseInt(emprendedorBusqueda.getElementoSeleccionado());
      emprendedorService.eliminarEmprendedor(idEmprendedor);
    }
    if (accion.equals("new")) {
      return new ModelAndView("formEmprendedor", "emprendedor", new EmprendedorDomain());
    }
    if (accion.equals("edit")) {
      int idEmprendedor = Integer.parseInt(emprendedorBusqueda.getElementoSeleccionado());
      EmprendedorDomain emprendedor = emprendedorService.buscarEmprendedor(idEmprendedor);
      return new ModelAndView("formEmprendedor", "emprendedor", emprendedor);
    }
    if (accion.equals("search") || accion.equals("delete")) {
      if (!result.hasErrors()) {
        List<EmprendedorDomain> listaPlanesNegocioResultados = emprendedorService.buscarListaEmprendedores(emprendedorBusqueda.getNombresApellidos(),
                                                                                                           emprendedorBusqueda.getTipoDocumento(),
                                                                                                           emprendedorBusqueda.getNumeroDocumento());
        emprendedorBusqueda.setExisteResultados((listaPlanesNegocioResultados != null && listaPlanesNegocioResultados.size() > 0));
        emprendedorBusqueda.setListaResultadosBusqueda(listaPlanesNegocioResultados);
      }
    }
    return new ModelAndView("listadoEmprendedores", "emprendedorBusqueda", emprendedorBusqueda);
  }
  
  @RequestMapping(value = "/formEmprendedor.html", method = RequestMethod.POST)	
  public ModelAndView guardarFormulario(@Valid @ModelAttribute("emprendedor") EmprendedorDomain emprendedor, BindingResult result,
                                  Map<String, EmprendedorDomain> model) {
    try {
      if (emprendedor.getId() > 0) {
        emprendedorService.actualizarEmprendedor(emprendedor);
      } else {
        emprendedorService.registrarEmprendedor(emprendedor);
      }
    } catch (BusinessException bex) {
      emprendedor.setTieneErrores(true);
      bex.printStackTrace();
      ModelAndView mav = new ModelAndView("formEmprendedor", "emprendedor", emprendedor);
      mav.addObject("mantenimiento_error", bex.getMessage());
      return mav;
    } catch (Exception ex) {
      emprendedor.setTieneErrores(true);
      ex.printStackTrace();
      ModelAndView mav = new ModelAndView("formEmprendedor", "emprendedor", emprendedor);
      mav.addObject("mantenimiento_error", "Error del Sistema: " + ex.getMessage());
      return mav;
    }
    emprendedor.setTieneErrores(false);
    return new ModelAndView("listadoEmprendedores", "emprendedorBusqueda", new EmprendedorBusquedaForm());
	}
  
}
