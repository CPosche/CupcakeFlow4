<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>

    <jsp:attribute name="header">
         Please confirm your order and pay
    </jsp:attribute>

    <jsp:body>
        <div class="container-fluid">


            <table class="table table-striped">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Cupcake</th>
                    <th scope="col">Amount</th>
                    <th scope="col">Price</th>
                </tr>
                </thead>
                <tbody style="font-size: 12px" data-bs-toggle="collapse" data-bs-target="#collapseOne">
                <c:forEach items="${sessionScope.cart.orderLines}" var="line">
                    <tr>
                        <th scope="row">${sessionScope.cart.orderLines.indexOf(line)+1}</th>
                        <td>${line.assembledCupcake}</td>
                        <td>${line.amount}</td>
                        <td>${line.lineTotal} kr</td>
                    </tr>
                    <tr>
                        <td colspan=5>
                            <div id="full_order_line" style="color: lightslategray">
                                <p>+ full orderline here</p>
                            </div>
                        </td>

                    </tr>
                </c:forEach>
                </tbody>
                <tfoot>
                <tr>
                    <td colspan="4">Total: ${sessionScope.cart.total} kr</td>
                </tr>
                </tfoot>
            </table>


            <button type="button" class="btn btn-primary">Confirm and pay</button>

            <a class="btn btn-primary"  href="index.jsp">Return</a>

        </div>

    </jsp:body>

</t:pagetemplate>