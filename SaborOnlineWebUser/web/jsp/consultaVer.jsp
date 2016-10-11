<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fieldset>
  <legend>Plan de Negocio : Ver</legend>
</fieldset>
<form:form cssClass="form-horizontal" modelAttribute="planNegocio" method="post">
    <div class="control-group">
      <label class="control-label" for="idPlanNegocio">ID:</label>
      <div class="controls" style="margin-top:5px">
        <span id="idPlanNegocio" style="font-size:20px">${planNegocio.id}</span>
      </div>
    </div>
    <div class="control-group">
      <label class="control-label" for="titulo">Título:</label>
      <div class="controls" style="margin-top:5px">
        <span id="titulo" style="font-size:16px"><b>${planNegocio.titulo}</b></span>
      </div>
    </div>
    <div class="control-group">
      <label class="control-label" for="categoria">Categoría</label>
      <div class="controls" style="margin-top:5px">
        <span id="categoria">${planNegocio.categoria.nombreCategoria}</span>
      </div>
    </div>
    <div class="control-group">
      <label class="control-label" for="visionNegocio">Visión del Negocio</label>
      <div class="controls" style="margin-top:5px">
        <span id="visionNegocio">${planNegocio.visionNegocio}</span>
      </div>
    </div>
    <div class="control-group">
      <label class="control-label" for="razonamientosPropuesta">Razonamiento de la Propuesta:</label>
      <div class="controls" style="margin-top:5px">
        <span id="razonamientosPropuesta">${planNegocio.razonamientosPropuesta}</span>
      </div>
    </div>
    <div class="control-group">
      <label class="control-label" for="tiempoEjecucion">Tiempo de Ejecución (en días):</label>
      <div class="controls" style="margin-top:5px">
        <span id="tiempoEjecucion"><fmt:formatNumber pattern="#,##0" value="${planNegocio.tiempoEjecucion}" /> días</span>
      </div>
    </div>
    <div class="control-group">
      <label class="control-label" for="inversionTotal">Inversión Total:</label>
      <div class="controls" style="margin-top:5px">
        <span id="inversionTotal">US$ <fmt:formatNumber pattern="#,##0.00" value="${planNegocio.inversionTotal}" /></span>
      </div>
    </div>
    <div class="control-group">
      <label class="control-label" for="margenNeto">Margen Neto:</label>
      <div class="controls" style="margin-top:5px">
        <span id="margenNeto">US$ <fmt:formatNumber pattern="#,##0.00" value="${planNegocio.margenNeto}" /></span>
      </div>
    </div>
    <div class="control-group">
      <label class="control-label" for="roi">ROI:</label>
      <div class="controls" style="margin-top:5px">
        <span id="roi">US$ <fmt:formatNumber pattern="#,##0.00" value="${planNegocio.roi}" /></span>
      </div>
    </div>
    <div class="form-actions">
      <button type="button" class="btn" onclick="window.close()">Cerrar</button>
    </div>
</form:form>