package edu.upc.saboronline.web;

import edu.upc.saboronline.servicios.ReservaMesaService;
import edu.upc.saboronline.web.forms.ReservaForm;
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
public class ReservaMesaController {
  
  private static ReservaMesaService reservaMesaService = new ReservaMesaService();
	
	@RequestMapping(value = "/formReservasMesas.html", method = RequestMethod.GET)	
	protected ModelAndView inicio(HttpServletRequest request, HttpServletResponse response) throws Exception {
    request.getSession().setAttribute("opcion1Activa", "");
    request.getSession().setAttribute("opcion2Activa", "active");
    request.getSession().setAttribute("opcion3Activa", "");
		return new ModelAndView("reservasCliente", "reserva", new ReservaForm());
	}
  
  @RequestMapping(value = "/formReservasMesas.html", method = RequestMethod.POST)
  public ModelAndView registrar(@Valid @ModelAttribute("reserva") ReservaForm reserva, BindingResult result,
                                Map<String, ReservaForm> model) {
    if (!result.hasErrors()) {
      reserva.getReserva().setId(1);
      reservaMesaService.registrar(reserva.getReserva());
    }
    return new ModelAndView("reservasCliente", "reserva", reserva);
  }
  
}
