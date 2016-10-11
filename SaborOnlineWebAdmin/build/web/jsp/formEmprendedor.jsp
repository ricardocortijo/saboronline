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

<form:form cssClass="form-horizontal" modelAttribute="emprendedor" action="formEmprendedor.html" method="post">
  <fieldset>
    <legend>Emprendedor : ${emprendedor.id > 0 ? 'Editar' : 'Nuevo'}</legend>
  </fieldset>
  <c:if test="${emprendedor.tieneErrores}">
  <div class="container">
    <div class="row">
        <div class="alert">
          <a class="close" data-dismiss="alert">×</a>
          <span style="color:red"><%= request.getAttribute("mantenimiento_error") %></span>
        </div>
    </div>
  </div>
  </c:if>
  <c:if test="${emprendedor.id > 0}">
  <div class="control-group">
    <label class="control-label" for="idEmprendedor">ID:</label>
    <div class="controls" style="margin-top:5px">
      <form:hidden path="id" />
      <span id="idEmprendedor" style="font-size:18px">${emprendedor.id}</span>
    </div>
  </div>
  </c:if>
  <div class="control-group">
    <label class="control-label" for="apellidoPaterno">Apellido Paterno:</label>
    <div class="controls" style="margin-top:5px">
      <form:input cssClass="input-xlarge" path="apellidoPaterno" />
      <form:errors path="apellidoPaterno" cssStyle="color:red" />
    </div>
  </div>
  <div class="control-group">
    <label class="control-label" for="apellidoMaterno">Apellido Materno:</label>
    <div class="controls" style="margin-top:5px">
      <form:input cssClass="input-xlarge" path="apellidoMaterno" />
      <form:errors path="apellidoMaterno" cssStyle="color:red" />
    </div>
  </div>
  <div class="control-group">
    <label class="control-label" for="nombres">Nombres:</label>
    <div class="controls" style="margin-top:5px">
      <form:input cssClass="input-xlarge" path="nombres" />
      <form:errors path="nombres" cssStyle="color:red" />
    </div>
  </div>
  <div class="control-group">
    <label class="control-label" for="sexo">Sexo:</label>
    <div class="controls" style="margin-top:5px">
      <form:radiobutton path="sexo" value="M"/>&nbsp;Masculino&nbsp;&nbsp;&nbsp;<form:radiobutton path="sexo" value="F"/>&nbsp;Femenino
      <form:errors path="sexo" cssStyle="color:red" />
    </div>
  </div>
  <div class="control-group">
    <label class="control-label" for="fechaNacimiento">Fecha de Nacimiento:</label>
    <div class="controls date" id="dp3" data-date="2012-01-01" data-date-format="yyyy-mm-dd" style="margin-top:5px">
      <form:input cssClass="input-medium span2" path="fechaNacimiento" />
      <span class="add-on"><i class="icon-th"></i></span>
      <form:errors path="fechaNacimiento" cssStyle="color:red" />
    </div>
  </div>
  <div class="control-group">
    <label class="control-label" for="tipoDocumentoIdentidad">Documento de Identidad:</label>
    <div class="controls" style="margin-top:5px">
      <form:select cssClass="input-medium" path="tipoDocumentoIdentidad">
        <form:option value="">Seleccione...</form:option>
        <form:option value="1">DNI</form:option>
        <form:option value="2">RUC</form:option>
        <form:option value="3">Carnet de Extranjeria</form:option>
        <form:option value="4">Brevete</form:option>
      </form:select>
      <form:input cssClass="input-medium" path="numeroDocumentoIdentidad" />
      <form:errors path="tipoDocumentoIdentidad" cssStyle="color:red" />
      <form:errors path="numeroDocumentoIdentidad" cssStyle="color:red" />
    </div>
  </div>
  <div class="control-group">
    <label class="control-label" for="correo">Correo Electrónico:</label>
    <div class="controls" style="margin-top:5px">
      <form:input cssClass="input-xxlarge" path="correo" />
      <form:errors path="correo" cssStyle="color:red" />
    </div>
  </div>
  <div class="control-group">
    <label class="control-label" for="celular">Celular:</label>
    <div class="controls" style="margin-top:5px">
      <form:input cssClass="input-medium" path="celular" />
      <form:errors path="celular" cssStyle="color:red" />
    </div>
  </div>
  <div class="control-group">
    <label class="control-label" for="direccion">Dirección</label>
    <div class="controls" style="margin-top:5px">
      <form:textarea cssClass="input-xxlarge" path="direccion" rows="4" />
      <form:errors path="direccion" cssStyle="color:red" />
    </div>
  </div>
  <div class="control-group">
    <label class="control-label" for="clave">Clave:</label>
    <div class="controls" style="margin-top:5px">
      <form:password cssClass="input-medium" path="clave" />
      <form:errors path="clave" cssStyle="color:red" />
    </div>
  </div>
  <div class="form-actions">
    <button type="submit" class="btn btn-primary" onclick="return ejecutarAccion('save')">Guardar</button>
    <button type="submit" class="btn" onclick="location.href='listadoEmprendedores.html';">Cerrar</button>
  </div>
</form:form>