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
                        <div class="list-group" id="list-tab" role="tablist">
                            <a class="list-group-item list-group-item-action active" id="list-home-list" data-bs-toggle="list" href="#list-order-home" role="tab" aria-controls="list-home">Home</a>
                            <a class="list-group-item list-group-item-action" id="list-profile-list" data-bs-toggle="list" href="#list-order-profile" role="tab" aria-controls="list-profile">Profile</a>
                            <a class="list-group-item list-group-item-action" id="list-messages-list" data-bs-toggle="list" href="#list-order-messages" role="tab" aria-controls="list-messages">Messages</a>
                            <a class="list-group-item list-group-item-action" id="list-settings-list" data-bs-toggle="list" href="#list-order-settings" role="tab" aria-controls="list-settings">Settings</a>
                        </div>
                    </div>
                    <div class="col">
                        <div class="tab-content" id="nav-tabContent">
                            <div class="tab-pane fade show active" id="list-order-home" role="tabpanel" aria-labelledby="list-home-list">...</div>
                            <div class="tab-pane fade" id="list-order-profile" role="tabpanel" aria-labelledby="list-profile-list">...</div>
                            <div class="tab-pane fade" id="list-order-messages" role="tabpanel" aria-labelledby="list-messages-list">...</div>
                            <div class="tab-pane fade" id="list-order-settings" role="tabpanel" aria-labelledby="list-settings-list">...</div>
                        </div>
                    </div>
                </div>
            </c:if>

            <c:if test="${requestScope.Dashpage eq'Customers'}">
                <div class="row">
                    <div class="col-4">
                        <div class="list-group" id="customer-list-tab" role="tablist">
                            <a class="list-group-item list-group-item-action active" data-bs-toggle="list" href="#list-home" role="tab" aria-controls="list-home">Home</a>
                            <a class="list-group-item list-group-item-action"  data-bs-toggle="list" href="#list-profile" role="tab" aria-controls="list-profile">Profile</a>
                            <a class="list-group-item list-group-item-action"  data-bs-toggle="list" href="#list-messages" role="tab" aria-controls="list-messages">Messages</a>
                            <a class="list-group-item list-group-item-action"  data-bs-toggle="list" href="#list-settings" role="tab" aria-controls="list-settings">Settings</a>
                        </div>
                    </div>
                    <div class="col-8">
                        <div class="tab-content" id="nav-customer-tabContent">
                            <div class="tab-pane fade show active" id="list-home" role="tabpanel" aria-labelledby="list-home-list">...</div>
                            <div class="tab-pane fade" id="list-profile" role="tabpanel" aria-labelledby="list-profile-list">...</div>
                            <div class="tab-pane fade" id="list-messages" role="tabpanel" aria-labelledby="list-messages-list">...</div>
                            <div class="tab-pane fade" id="list-settings" role="tabpanel" aria-labelledby="list-settings-list">...</div>
                        </div>
                    </div>
                </div>


            </c:if>

        </div>

    </jsp:body>

</t:pagetemplate>
