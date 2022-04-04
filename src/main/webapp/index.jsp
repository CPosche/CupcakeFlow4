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

        <div class="row g-3">
        <div class="col-sm">
                <%-- First button with topping selection --%>
            <button class="btn btn-secondary btn-lg dropdown-toggle" type="button" data-toggle="dropdown"
                    aria-haspopup="true" aria-expanded="false">
                Cupcake toppings
            </button>
            <div class="dropdown-menu">
                ...
            </div>
        </div>
        <div class="col-sm">
                <%-- Second button with cakebody selection --%>
            <button class="btn btn-secondary btn-lg dropdown-toggle" type="button" data-toggle="dropdown"
                    aria-haspopup="true" aria-expanded="false">
                Cupcake caketype
            </button>
            <div class="dropdown-menu">
                ...
            </div>
        </div>
        <div class="col-sm">
                <%-- Text for number of cupcakes --%>
            <label for="inputZip">Number of cupcakes</label>
            <input type="number" class="form-control" id="inputZip">
        </div>
        <div class="col-sm">
                <%-- Third button with submit the selected cupcake combination --%>
            <button type="button" class="btn btn-secondary">Submit cupcake</button>
        </div>

    </jsp:body>

</t:pagetemplate>