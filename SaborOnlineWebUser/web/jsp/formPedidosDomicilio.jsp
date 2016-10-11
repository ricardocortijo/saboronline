<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script type="text/javascript">
  
$('.datepicker').datepicker();

function ejecutarAccion(accion) {
  var form = document.forms[0];
  form.accion.value = accion;
  if (accion == 'save') {
    form.submit();
    return true;
  }
  return false;
}
  
</script>

<form:form cssClass="form-horizontal" modelAttribute="pedido" action="formPedidosDomicilio.html" method="post">
  
  <fieldset>
    <legend>Pedido : ${pedido.pedido.id > 0 ? 'Editar' : 'Nuevo'}</legend>
  </fieldset>
  <c:if test="${pedido.tieneErrores}">
  <div class="container">
    <div class="row">
        <div class="alert">
          <a class="close" data-dismiss="alert">×</a>
          <span style="color:red"><%= request.getAttribute("mantenimiento_error") %></span>
        </div>
    </div>
  </div>
  </c:if>
  <c:if test="${pedido.pedido.id > 0}">
  <div class="control-group">
    <label class="control-label" for="idPedido">ID:</label>
    <div class="controls" style="margin-top:5px">
      <form:hidden path="pedido.id" />
      <span id="idPedido" style="font-size:18px">${pedido.pedido.id}</span>
    </div>
  </div>
  </c:if>
  <div class="control-group">
    <label class="control-label" for="fecha">Fecha de Atención:</label>
    <div class="controls" style="margin-top:5px">
      <form:input cssClass="input-xlarge" path="pedido.fecha" />
      <form:errors path="pedido.fecha" cssStyle="color:red" />
    </div>
  </div>
  <div class="control-group">
    <label class="control-label" for="distrito">Distrito:</label>
    <div class="controls" style="margin-top:5px">
      <form:input cssClass="input-xxlarge" path="pedido.distrito" />
      <form:errors path="pedido.distrito" cssStyle="color:red" />
    </div>
  </div>
  <div class="control-group">
    <label class="control-label" for="direccionEntrega">Dirección de Entrega:</label>
    <div class="controls" style="margin-top:5px">
      <form:textarea cssClass="input-xxlarge" path="pedido.direccionEntrega" rows="6" />
      <form:errors path="pedido.direccionEntrega" cssStyle="color:red" />
    </div>
  </div>
  <div class="control-group">
    <label class="control-label" for="medioPago">Modo de Pago:</label>
    <div class="controls" style="margin-top:5px">
      <form:select cssClass="input-medium" path="pedido.modoPago">
        <form:option value="">Seleccione...</form:option>
        <form:option value="01">Efectivo</form:option>
        <form:option value="02">Tarjeta de Credito</form:option>
        <form:option value="03">Tarjeta de Debito</form:option>
        <form:option value="04">Bonos</form:option>
        <form:option value="05">Depósito a Cuenta (voucher)</form:option>
      </form:select>
      <form:errors path="pedido.modoPago" cssStyle="color:red" />
    </div>
  </div>
  <div class="form-actions">
    <button type="submit" class="btn btn-primary" onclick="return ejecutarAccion('save')">Guardar</button>
  </div>
      
</form:form>
