<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>

    <jsp:body>

        <div class="container-fluid">
            <c:if test="${requestScope.Dashpage eq 'Orders'}">
                <nav aria-label="...">
                    <ul class="pagination pagination-lg">
                        <li class="page-item active">
                            <span class="page-link">Orders</span>
                        </li>
                        <li class="page-item">
                            <a class="page-link" href="DashServlet?Dashpage=Customers">Customers</a>
                        </li>
                    </ul>
                </nav>
            </c:if>

            <c:if test="${requestScope.Dashpage eq 'Customers'}">
                <nav aria-label="...">
                    <ul class="pagination pagination-lg">
                        <li class="page-item ">
                            <a class="page-link" href="DashServlet?Dashpage=Orders">Orders</a>
                        </li>
                        <li class="page-item active">
                            <span class="page-link" >Customers</span>
                        </li>
                    </ul>
                </nav>
            </c:if>

            <c:if test="${requestScope.Dashpage eq 'Orders'}">
                <div class="row">

                    <div class="col">
                        <table class="table">  <%-- List of all orders--%>
                            <thead>
                            <tr>
                                <th scope="col">Order number</th>
                                <th scope="col">Customer ID/name</th>
                                <th scope="col">Total Cupcakes</th>
                                <th scope="col">Price</th>
                            </tr>
                            </thead>
                            <tbody>

                            <tr>
                                <td>101</td>
                                    <%-- Link to specific order--%>
                                <td>3/John Johnson</td>
                                <td>5</td>
                                <td>50</td>
                            </tr>
                            <tr>
                                <td>102</td>
                                    <%-- Link to specific order--%>
                                <td>4/Gunner Gunnerson</td>
                                <td>2</td>
                                <td>24</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>

                    <div class="col">
                        <table class="table"> <%-- List of cupcakes in one order--%>
                            <thead>
                            <tr>
                                <th scope="col">Cupcake</th>
                                <th scope="col">Amount</th>
                                <th scope="col">Price</th>
                            </tr>
                            </thead>
                            <tbody>

                            <tr>
                                <td>Daily Special</td>
                                <td>1</td>
                                <td>50</td>
                            </tr>
                            <tr>
                                <td>Chocolate cupcake with Lemon topping</td>
                                <td>1</td>
                                <td>40</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>

                </div>
            </c:if>

            <c:if test="${requestScope.Dashpage eq'Customers'}">
                <div class="row">

                    <div class="col">
                        <table class="table">  <%-- List of all orders--%>
                            <thead>
                            <tr>
                                <th scope="col">Customer ID</th>
                                <th scope="col">Customer Email</th>
                                <th scope="col">Orders</th>
                                <th scope="col">Balance</th>
                            </tr>
                            </thead>
                            <tbody>

                            <tr>
                                <td>1</td>
                                <td>b@b.dk</td>
                                <td>123456</td>
                                <td>200</td>
                            </tr>
                            <tr>
                                <td>2</td>
                                <td>c@c.dk</td>
                                <td>7891011</td>
                                <td>200</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>

                    <div class="col">
                        <table class="table"> <%-- List of cupcakes in one order--%>
                            <thead>
                            <tr>
                                <th scope="col">Cupcake</th>
                                <th scope="col">Amount</th>
                                <th scope="col">Price</th>
                            </tr>
                            </thead>
                            <tbody>

                            <tr>
                                <td>Daily Special</td>
                                <td>1</td>
                                <td>50</td>
                            </tr>
                            <tr>
                                <td>Chocolate cupcake with Lemon topping</td>
                                <td>1</td>
                                <td>40</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>

                </div>


            </c:if>

        </div>

    </jsp:body>

</t:pagetemplate>
