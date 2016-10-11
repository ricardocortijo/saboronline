<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<fieldset>
<legend>Planes de Negocio : Buscar</legend>
  <form:form cssClass="well form-search" action="planesNegocioEmprendedorBusqueda.html" modelAttribute="planNegocioBusqueda" method="post">
        <form:input cssClass="input-xxlarge search-query" path="criterioBusqueda" />
        <button type="submit" class="btn btn-primary">Buscar</button>
        <form:errors path="criterioBusqueda" cssStyle="color:red" />
  </form:form>
  <table class="table table-hover">
    <tr>
      <th>ID</th>
      <th>Título</th>
      <th>Categoría</th>
      <th>Visión del Negocio</th>
      <th>Razonamiento de la Propuesta</th>
    </tr>
    <c:if test="${planNegocioBusqueda.existeResultados}">
      <c:forEach items="${planNegocioBusqueda.listaResultadosBusqueda}" var="planNegocio">
        <tr>
          <td><a href="planNegocioEmprendedorVer.html?id1=${planNegocio.id}" target="_blank"><b>${planNegocio.id}</b></td>
          <td>${planNegocio.titulo}</td>
          <td>${planNegocio.categoria.nombreCategoria}</td>
          <td>${planNegocio.visionNegocio}</td>
          <td>${planNegocio.razonamientosPropuesta}</td>
        </tr>
      </c:forEach>
    </c:if>
    <c:if test="${!planNegocioBusqueda.existeResultados}">
    <tr style="height:30px; vertical-align:middle">
      <td colspan="5" style="text-align:center; font-size:18px">No se han encontrado resultados de búsqueda para el criterio especificado.</td>
    </tr>
    </c:if>
  </table>
</fieldset>