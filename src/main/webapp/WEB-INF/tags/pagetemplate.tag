<%@tag description="Overall Page template" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>

<!DOCTYPE html>
<html lang="da">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>
        <jsp:invoke fragment="header"/>
    </title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<div class="container-fluid">
    <header>
        <div class="row" style="height: 150px">
            <div class="text-center bg-image col p-0"
                 style="background-image: url('<%=request.getContextPath()%>/images/olskercupcakes.png'); background-repeat: no-repeat; background-size: 100% 150px;
                         height: 100%;"></div>
            <div class="col text-center bg-image p-0"
                 style="background-image: url('<%=request.getContextPath()%>/images/olskercupcakes.png'); background-repeat: no-repeat; transform: scaleX(-1); -webkit-transform: scaleX(-1); background-size: 100% 150px;
                         height: 100%;"></div>
        </div>

        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container-fluid">
                <a class="navbar-brand" href="index.jsp">
                    Home
                </a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                        data-bs-target="#navbarNavAltMarkup"
                        aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse justify-content-end" id="navbarNavAltMarkup">
                    <div class="navbar-nav">

                        <c:choose>
                            <c:when test="${sessionScope.user.role.equals('admin')}">
                                <a class="nav-item nav-link" href="${pageContext.request.contextPath}/">Customers</a>
                                <a class="nav-item nav-link" href="${pageContext.request.contextPath}/">Orders</a>
                            </c:when>
                            <c:when test="${sessionScope.user.role.equals('customer')}">
                                <a class="nav-item nav-link disabled align-content-center" href="#">Balance - ${sessionScope.user.balance}</a>
                            </c:when>
                            <c:otherwise>
                            </c:otherwise>
                        </c:choose>

                        <div class="dropdown">
                            <button class="btn btn-sm px-4" type="button" data-bs-toggle="dropdown"
                                    aria-expanded="false"><img src="<%=request.getContextPath()%>/images/ProfilePic.png"
                                                               alt="ProfilePicture" width="50">
                            </button>
                            <ul class="dropdown-menu dropdown-menu-end px-2" style="width: 300px !important;">

                                <c:if test="${sessionScope.user == null }">
                                    <h5> Login </h5>
                                    <div class="dropdown-divider"></div>

                                    <form method="post">
                                        <div class="form-group">
                                            <label for="inputEmail1">Email address</label>
                                            <input type="email" name="username" class="form-control" id="inputEmail1"
                                                   placeholder="Enter email">
                                        </div>
                                        <div class="form-group">
                                            <label for="inputPassword1">Password</label>
                                            <input type="password" name="password" class="form-control"
                                                   id="inputPassword1" placeholder="Password">
                                        </div>
                                        <br>
                                        <button formaction="login" type="submit" class="btn btn-primary">Login</button>

                                        <button formaction="register" type="submit" class="btn btn-primary">Register</button>
                                    </form>
                                </c:if>
                                <c:if test="${sessionScope.user != null }">
                                    <span style="text-align: center">${sessionScope.user.username}</span>
                                    <hr>
                                    <a class="dropdown-item" href="${pageContext.request.contextPath}/logout">Log
                                        out</a>
                                </c:if>
                            </ul>
                        </div>
                    </div>
                </div>
                <button class="btn position-relative p-0" type="button" data-bs-toggle="offcanvas"
                        data-bs-target="#offcanvasRight"
                        aria-controls="offcanvasRight"><img src="<%=request.getContextPath()%>/images/carticon.png"
                                                            alt="cart" width="50">
                    <span class="position-absolute top-0 start-98 translate-middle badge rounded-pill bg-danger">
                        ${(sessionScope.user != null ? sessionScope.cart.orderLines.size() : 0)}
                        <span class="visually-hidden">items in cart</span>
                    </span>
                </button>

            </div>
        </nav>

        <%-- Offcanvas Bar --%>
        <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasRight" data-width="600px"
             data-bs-backdrop="false"
             aria-labelledby="offcanvasRightLabel">
            <div class="offcanvas-header">
                <h5 id="offcanvasRightLabel">Shopping Cart</h5>
                <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas"
                        aria-label="Close"></button>
            </div>
            <div class="offcanvas-body">

                <table class="table">
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
                    <tr onclick="notNew(this)">
                        <td>Chocolate cupcake with Lemon topping</td>
                        <td>1</td>
                        <td>40</td>
                    </tr>
                    </tbody>
                </table>


                <button type="button" class="btn btn-primary">Confirm Order
                </button>

            </div>
        </div>

    </header>

    <div id="body" class="container-fluid" style="min-height: 400px;">
        <h1>
            <jsp:invoke fragment="header"/>
        </h1>
        <jsp:doBody/>
    </div>

    <!-- Footer -->
    <div class="row justify-content-between">
        <hr/>
        <div class="col">
            Nørgaardsvej 30<br/>
            2800 Lyngby
        </div>
        <div class="col">
            <jsp:invoke fragment="footer"/>
            <br/>
            <p>&copy; 2022 Cphbusiness</p>
        </div>
        <div class="col">
            Datamatikeruddannelsen<br/>
            2. semester forår 2022
        </div>
    </div>
</div>
<!-- Bootstrap Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
<script src="<%=request.getContextPath()%>/js/script.js"></script>
</body>
</html>