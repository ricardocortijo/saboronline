<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form:form cssClass="form-horizontal" action="logeo.html" modelAttribute="usuario" method="post">
  <fieldset>
    <legend>Autenticaci�n</legend>
    <c:if test="${usuario.tieneErrores}">
    <div class="container">
      <div class="row">
          <div class="alert">
            <a class="close" data-dismiss="alert">�</a>
            <span style="color:red"><%= request.getAttribute("logeo_error") %></span>
          </div>
      </div>
    </div>
    </c:if>
    <div class="control-group">
      <label class="control-label" for="idUsuario">Usuario:</label>
      <div class="controls">
        <form:input cssClass="input-xlarge" path="usuario" />
        <p class="help-block">Ingrese su valor de usuario.</p>
        <form:errors path="usuario" cssStyle="color:red" />
      </div>
    </div>
    <div class="control-group">
      <label class="control-label" for="clave">Clave:</label>
      <div class="controls">
        <form:password cssClass="input-xlarge" path="clave" />
        <p class="help-block">Ingrese su contrase�a.</p>
        <form:errors path="clave" cssStyle="color:red" />
      </div>
    </div>
    <div class="form-actions">
      <button type="submit" class="btn btn-primary">Iniciar Sesi�n</button>
    </div>
  </fieldset>
</form:form>