<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Choose your cupcake
    </jsp:attribute>

    <jsp:attribute name="footer">
        Choose your cupcake
    </jsp:attribute>

    <jsp:body>

    <form method="post">
        <div class="row justify-content-center">
            <div class="col-auto">
            <div class="col-auto">
                <div class="dropdown">
                    <button class="btn btn-secondary dropdown-toggle" type="button" id="toppingDropDown" data-bs-toggle="dropdown" aria-expanded="false" style="width: 200px;">
                        ${(sessionScope.topping == null ? "Cupcake toppings" : sessionScope.topping)}
                    </button>
                    <ul class="dropdown-menu dropdown-menu-dark" aria-labelledby="toppingDropDown">
                        <li><a class="dropdown-item active" href="#">Action</a></li>
                        <li><a class="dropdown-item" href="#">Another action</a></li>
                        <li><a class="dropdown-item" href="#">Something else here</a></li>
                    </ul>
                </div>
            </div>
            <div class="col-auto">
                <div class="dropdown">
                    <button class="btn btn-secondary dropdown-toggle" type="button" id="bottomDropDown" data-bs-toggle="dropdown" aria-expanded="false" style="width: 200px;">
                            ${(sessionScope.bottom == null ? "Cupcake bottoms" : sessionScope.bottom)}
                    </button>
                    <ul class="dropdown-menu dropdown-menu-dark" aria-labelledby="bottomDropDown">
                        <li><a class="dropdown-item active" href="#">Action</a></li>
                        <li><a class="dropdown-item" href="#">Another action</a></li>
                        <li><a class="dropdown-item" href="#">Something else here</a></li>
                    </ul>
                </div>
            </div>
            <div class="col-auto">
                <input class="form-control" type="number" id="amount" style="width: 75px;">
            </div>
            <div class="col-auto">
                <button class="btn btn-secondary" type="submit">Add to cart</button>
            </div>
            </div>
        </div>
    </form>

    </jsp:body>

</t:pagetemplate>