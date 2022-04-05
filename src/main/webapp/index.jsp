<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Welcome to the frontpage
    </jsp:attribute>

    <jsp:attribute name="footer">
        Welcome to the frontpage
    </jsp:attribute>

    <jsp:body>

        <form class="form-inline" method="post">
        <div class="form-group mb-2">
                <%-- First button with topping selection --%>
            <button class="btn btn-secondary btn-lg dropdown-toggle" type="button" data-bs-toggle="dropdown"
                    aria-haspopup="true" aria-expanded="false">
                ${(sessionScope.topping == null) ? "Cupcake toppings" : sessionScope.topping}
            </button>
            <div class="dropdown-menu">
                ...
            </div>
        </div>
        <div class="form-group mx-sm-3 mb-2">
                <%-- Second button with cakebody selection --%>
            <button class="btn btn-secondary btn-lg dropdown-toggle" type="button" data-bs-toggle="dropdown"
                    aria-haspopup="true" aria-expanded="false">
                    ${(sessionScope.bottom == null) ? "Cupcake bottom" : sessionScope.bottom}
            </button>
            <div class="dropdown-menu">
                ...
            </div>
        </div>
        <div class="form-group mx-sm-3 mb-2">
                <%-- Text for number of cupcakes --%>
            <label for="inputZip" class="sr-only">Number of cupcakes</label>
            <input type="number" class="form-control" placeholder="Number of cupcakes" id="inputZip">
        </div>
                <%-- Third button with submit the selected cupcake combination --%>
            <button type="button" class="btn btn-lg btn-secondary mb-2">Submit cupcake</button>
        </form>

    </jsp:body>

</t:pagetemplate>