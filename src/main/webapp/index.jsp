<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Create your cupcake
    </jsp:attribute>

    <jsp:attribute name="footer">
        Create your cupcake
    </jsp:attribute>

    <jsp:body>
        <form class="form-inline" method="post" action="Updatet">
            <div class="row g-3 align-items-center mt-5">
                <div class="col-auto">
                    <div class="dropdown">
                        <button class="btn btn-primary dropdown-toggle btn-lg" type="button" name="topping" id="toppingDropDown"
                                data-bs-toggle="dropdown" aria-expanded="false" style="width: 200px;">
                                ${(applicationScope.cupcakefactory.get("toppings").size() == 0 ? "no toppings" : "Chooose topping")}
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
                        <button class="btn btn-primary dropdown-toggle btn-lg" type="button" name="bot" id="bottomDropDown"
                                data-bs-toggle="dropdown" aria-expanded="false" style="width: 200px;">
                                ${(applicationScope.cupcakefactory.get("bottoms").size() == 0 ? "no bottoms" : "Chooose bottom")}
                        </button>
                        <ul class="dropdown-menu dropdown-menu-dark" aria-labelledby="bottomDropDown">
                            <li><a class="dropdown-item active" href="#">Action</a></li>
                            <li><a class="dropdown-item" href="#">Another action</a></li>
                            <li><a class="dropdown-item" href="#">Something else here</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-auto">
                    <input class="form-control form-control-lg" type="number" id="amount" value="1" name="amountOf" min="1" style="width: 75px;">
                </div>
                <div class="col-auto">
                    <button class="btn btn-primary btn-lg" type="submit">Add to cart</button>
                </div>
            </div>
        </form>

    </jsp:body>

</t:pagetemplate>