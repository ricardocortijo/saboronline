<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">
  
function ejecutarAccion(accion) {
  var form = document.forms[0];
  form.accion.value = accion;
  if (accion == 'search') {
    form.submit();
    return true;
  } else if (accion == 'new') {
    form.submit();
    return true;
  } else if (accion == 'edit') {
    form.submit();
    return true;
  } else if (accion == 'delete') {
    var listaSeleccionados = $("input:radio[id^='elementoSeleccionado']:checked");
    if (listaSeleccionados.length > 0) {
      if (confirm('¿Está seguro de eliminar el registro seleccionado?')) {
        form.submit();
        return true;
      }
    } else {
      alert('Debe seleccionar un registro para ejecutar esta acción.');
    }
  }
  return false;
}
  
</script>

<fieldset>
<legend>Emprendedores : Buscar</legend>
  <form:form cssClass="form-horizontal" action="listadoEmprendedores.html" modelAttribute="emprendedorBusqueda" method="post">
    <form:hidden path="accion" />
    <div class="well form-search">
      <div class="control-group">
        <label class="control-label" for="nombresApellidos">Nombres y/o Apellidos:</label>
        <div class="controls">
          <form:input cssClass="input-xlarge search-query" path="nombresApellidos" />
          <form:errors path="nombresApellidos" cssStyle="color:red" />
        </div>
      </div>
      <div class="control-group">
        <label class="control-label" for="tipoDocumento">Documento de Identidad:</label>
        <div class="controls">
          <form:select cssClass="input-xlarge search-query" path="tipoDocumento">
            <form:option value="">Seleccione...</form:option>
            <form:option value="1">DNI</form:option>
            <form:option value="2">RUC</form:option>
            <form:option value="3">Carnet de Extranjeria</form:option>
            <form:option value="4">Brevete</form:option>
          </form:select>
          <form:input cssClass="input-xlarge search-query" path="numeroDocumento" />
          <button type="submit" class="btn btn-primary" onclick="return ejecutarAccion('search')">Buscar</button>
          <form:errors path="tipoDocumento" cssStyle="color:red" />
          <form:errors path="numeroDocumento" cssStyle="color:red" />
        </div>
      </div>
    </div>
    <table class="table table-hover">
      <tr>
        <th width="5%">Seleccione</th>
        <th width="5%">ID</th>
        <th width="35%">Apellidos y Nombres</th>
        <th width="15%">Documento de Identidad</th>
        <th width="5%">Sexo</th>
        <th width="10%">Fecha de Nacimiento</th>
        <th width="25%">Correo Electrónico</th>
      </tr>
      <c:if test="${emprendedorBusqueda.existeResultados}">
        <c:forEach items="${emprendedorBusqueda.listaResultadosBusqueda}" var="emprendedor">
          <tr>
            <td><form:radiobutton path="elementoSeleccionado" value="${emprendedor.id}" /></td>
            <td><b>${emprendedor.id}</td>
            <td>${emprendedor.apellidoPaterno} ${emprendedor.apellidoMaterno}, ${emprendedor.nombres}</td>
            <td>${emprendedor.tipoNumeroDocumento}</td>
            <td>${emprendedor.sexo}</td>
            <td>${emprendedor.fechaNacimiento}</td>
            <td>${emprendedor.correo}</td>
        </tr>
        </c:forEach>
      </c:if>
      <c:if test="${!emprendedorBusqueda.existeResultados}">
      <tr style="height:30px; vertical-align:middle">
        <td colspan="7" style="text-align:center; font-size:18px">No se han encontrado resultados de búsqueda para el criterio especificado.</td>
      </tr>
      </c:if>
    </table>
    <div class="form-actions" style="text-align:right">
      <button type="submit" class="btn btn-primary" onclick="return ejecutarAccion('new')">Nuevo</button>
      <button type="submit" class="btn" onclick="return ejecutarAccion('edit')">Editar</button>
      <button type="submit" class="btn" onclick="return ejecutarAccion('delete')">Eliminar</button>
    </div>
  </form:form>
</fieldset>