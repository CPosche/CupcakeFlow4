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
                    <label for="topselect"><h5>Choose topping</h5></label><br>
                    <select name="topping" class="btn btn-primary btn-lg" size="1" id="topselect">
                        <option value="" disabled selected hidden>Choose topping</option>
                        <c:forEach items="${applicationScope.cupcakefactory.get('toppings')}" var="topping">
                            <option value="${topping.id}">${topping.name} (${topping.price} kr,-)</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="col-auto">
                    <label for="botselect"><h5>Choose bottom</h5></label><br>
                    <select name="bottom" class="btn btn-primary btn-lg" size="1" id="botselect">
                        <option value="" disabled selected hidden>Choose bottom</option>
                        <c:forEach items="${applicationScope.cupcakefactory.get('bottoms')}" var="bottom">
                            <option value="${bottom.id}">${bottom.name} (${bottom.price} kr,-)</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="col-auto">
                    <h5></h5>
                    <br>
                    <input class="form-control form-control-lg" type="number" id="amount" value="1" name="amountOf"
                           min="1" style="width: 75px;">
                </div>
                <div class="col-auto">
                    <h5></h5>
                    <br>
                    <button class="btn btn-primary btn-lg" type="submit">Add to cart</button>
                </div>
            </div>
        </form>

        ${requestScope.msg}
    </jsp:body>

</t:pagetemplate>