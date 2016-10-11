package edu.upc.saboronline.web;

import edu.upc.saboronline.servicios.PedidoClienteService;
import edu.upc.saboronline.web.forms.PedidoForm;
import edu.upc.saboronline.web.forms.UsuarioForm;
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
public class PedidosClienteController {
  
  private static PedidoClienteService pedidoClienteService = new PedidoClienteService();
	
	@RequestMapping(value = "/formPedidosDomicilio.html", method = RequestMethod.GET)	
	protected ModelAndView inicio(HttpServletRequest request, HttpServletResponse response) throws Exception {
    request.getSession().setAttribute("opcion1Activa", "");
    request.getSession().setAttribute("opcion2Activa", "active");
    request.getSession().setAttribute("opcion3Activa", "");
		return new ModelAndView("pedidosCliente", "pedido", new PedidoForm());
	}
  
  @RequestMapping(value = "/formPedidosDomicilio.html", method = RequestMethod.POST)
  public ModelAndView registrar(@Valid @ModelAttribute("pedido") PedidoForm pedido, BindingResult result,
                                Map<String, PedidoForm> model) {
    if (!result.hasErrors()) {
      pedido.getPedido().setId(1);
      pedidoClienteService.registrar(pedido.getPedido());
    }
    return new ModelAndView("pedidosCliente", "pedido", pedido);
  }
  
}
