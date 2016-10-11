package edu.upc.sistemaventas.web;

import edu.upc.sistemaventas.dominio.PlanNegocioDomain;
import edu.upc.sistemaventas.dominio.UsuarioDomain;
import edu.upc.sistemaventas.servicios.PlanNegocioService;
import edu.upc.sistemaventas.web.forms.PlanNegocioBusquedaForm;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PlanesNegocioEmprendedorController {
  
  private static PlanNegocioService planNegocioService = new PlanNegocioService();
	
	@RequestMapping(value = "/planesNegocioEmprendedorBusqueda.html", method = RequestMethod.GET)	
	protected ModelAndView inicio(HttpServletRequest request, HttpServletResponse response) throws Exception {
    request.getSession().setAttribute("opcion1Activa", "");
    request.getSession().setAttribute("opcion2Activa", "active");
    request.getSession().setAttribute("opcion3Activa", "");
		return new ModelAndView("planesNegocioEmprendedorBusqueda", "planNegocioBusqueda", new PlanNegocioBusquedaForm());
	}
  
  @RequestMapping(value = "/planesNegocioEmprendedorBusqueda.html", method = RequestMethod.POST)
  public ModelAndView buscar(@Valid @ModelAttribute("planNegocioBusqueda") PlanNegocioBusquedaForm planNegocioBusqueda, BindingResult result,
                             Map<String, PlanNegocioBusquedaForm> model) {
    if (!result.hasErrors()) {
      List<PlanNegocioDomain> listaPlanesNegocioResultados = planNegocioService.buscarPlanesNegocio(planNegocioBusqueda.getCriterioBusqueda());
      planNegocioBusqueda.setExisteResultados((listaPlanesNegocioResultados != null && listaPlanesNegocioResultados.size() > 0));
      planNegocioBusqueda.setListaResultadosBusqueda(listaPlanesNegocioResultados);
    }
    return new ModelAndView("planesNegocioEmprendedorBusqueda", "planNegocioBusqueda", planNegocioBusqueda);
  }
  
  @RequestMapping(value = "/planNegocioEmprendedorVer.html", method = RequestMethod.GET)	
	protected ModelAndView verPlanNegocio(HttpServletRequest request, HttpServletResponse response) throws Exception {
    String paramPlanNegocio = request.getParameter("id1");
    if (paramPlanNegocio != null) {
      int idPlanNegocio = Integer.parseInt(paramPlanNegocio);
      PlanNegocioDomain planNegocio = planNegocioService.obtenerPlanNegocio(idPlanNegocio);
      return new ModelAndView("planNegocioEmprendedorVer", "planNegocio", planNegocio);
    }
    return new ModelAndView("planNegocioEmprendedorVer", "planNegocio", new PlanNegocioDomain());
	}
  
}
