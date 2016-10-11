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

<form:form cssClass="form-horizontal" modelAttribute="reserva" action="formReservasMesas.html" method="post">
  
  <fieldset>
    <legend>Reserva de Mesa : ${reserva.reserva.id > 0 ? 'Editar' : 'Nuevo'}</legend>
  </fieldset>
  <c:if test="${reserva.tieneErrores}">
  <div class="container">
    <div class="row">
        <div class="alert">
          <a class="close" data-dismiss="alert">×</a>
          <span style="color:red"><%= request.getAttribute("mantenimiento_error") %></span>
        </div>
    </div>
  </div>
  </c:if>
  <c:if test="${reserva.reserva.id > 0}">
  <div class="control-group">
    <label class="control-label" for="idPedido">ID:</label>
    <div class="controls" style="margin-top:5px">
      <form:hidden path="reserva.id" />
      <span id="idPedido" style="font-size:18px">${reserva.reserva.id}</span>
    </div>
  </div>
  </c:if>
  <div class="control-group">
    <label class="control-label" for="fecha">Fecha de Reserva:</label>
    <div class="controls" style="margin-top:5px">
      <form:input cssClass="input-medium" path="reserva.fechaReserva" />
      <form:errors path="reserva.fechaReserva" cssStyle="color:red" />
    </div>
  </div>
  <div class="control-group">
    <label class="control-label" for="numeroMesa">No. de Mesa:</label>
    <div class="controls" style="margin-top:5px">
      <form:select cssClass="input-medium" path="reserva.numeroMesa">
        <form:option value="">Seleccione...</form:option>
        <form:option value="1">1</form:option>
        <form:option value="2">2</form:option>
        <form:option value="3">3</form:option>
        <form:option value="4">4</form:option>
        <form:option value="5">5</form:option>
        <form:option value="6">6</form:option>
        <form:option value="7">7</form:option>
        <form:option value="8">8</form:option>
        <form:option value="9">9</form:option>
        <form:option value="10">10</form:option>
        <form:option value="11">11</form:option>
        <form:option value="12">12</form:option>
        <form:option value="13">13</form:option>
        <form:option value="14">14</form:option>
        <form:option value="15">15</form:option>
        <form:option value="16">16</form:option>
        <form:option value="17">17</form:option>
        <form:option value="18">18</form:option>
        <form:option value="19">19</form:option>
      </form:select>
      <form:errors path="reserva.numeroMesa" cssStyle="color:red" />
    </div>
  </div>
  <div class="control-group">
    <label class="control-label" for="distrito">No. de Sillas:</label>
    <div class="controls" style="margin-top:5px">
      <form:input cssClass="input-medium" path="reserva.numeroSillas" />
      <form:errors path="reserva.numeroSillas" cssStyle="color:red" />
    </div>
  </div>
  <div class="control-group">
    <label class="control-label" for="direccionEntrega">Observaciones:</label>
    <div class="controls" style="margin-top:5px">
      <form:textarea cssClass="input-xxlarge" path="reserva.comentarios" rows="6" />
      <form:errors path="reserva.comentarios" cssStyle="color:red" />
    </div>
  </div>
  <div class="form-actions">
    <button type="submit" class="btn btn-primary" onclick="return ejecutarAccion('save')">Guardar</button>
  </div>
      
</form:form>
