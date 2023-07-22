<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Lilita+One&display=swap" rel="stylesheet">
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Index</title>
        <%
            String path = request.getContextPath(); //Lay duong link goc
        %>
        <link href="<%=path%>/css/style.css" rel="stylesheet"/>
    </head>
    <body>
        <div id="container">
            <div id="header">
                <div id="logo">
                    <c:url value="/home" var="logo"></c:url>
                    <c:url value="/shopping/order" var="cart"></c:url>
                    <c:url value="/account/signin" var="signin"></c:url>
                    <c:url value="/account/signup" var="signup"></c:url>
                    <c:url value="/account/profile" var="profile"></c:url>
                    <c:url value="/account/signout" var="signout"></c:url>

                        <a href="${logo}" style=" font-family: 'Lilita One', cursive; text-decoration: none; color: black; font-size: 50px;">HAIDUONGSTORE</a>
                    <div id="logo_price">Filter by Price</div>
                    <li id="logo-down"><a href="${signin}">Price High-low</a></li>
                    <li id="logo-up"><a href="${signup}">Price low-High</a></li>
                </div>

                <div id="banner">
                    <c:if test="${ordermsg!=null}">
                        <p style="color: green">${ordermsg}</p>
                    </c:if>
                    <c:if test="${updatemsg!=null}">
                        <p style="color: green">${updatemsg}</p>
                    </c:if>
                    <c:if test="${updatePassmsg!=null}">
                        <p style="color: green">${updatePassmsg}</p>
                    </c:if>
                    <c:if test="${changeSuccsess!=null}">
                        <p style="color: green">${changeSuccsess}</p>
                    </c:if>

                    <ul>
                        <form action="<%=path%>/search" method="post">
                            <input type="text" name="txt" placeholder="Search..." value="${txt}" style="margin-bottom: 7px"/>
                            <input type="submit" value="Search"/>
                        </form>
                        <li id="banner-cart"><a href="${cart}">Cart: ${sessionScope.size}</a></li>

                        <%-- Khi AccSession == null la khi chua SignIn Thi Hien Thi SignIn va SignUp --%>
                        <c:if test="${sessionScope.AccSession==null}">
                            <li id="banner-signin"><a href="${signin}">SignIn</a></li>
                            <li id="banner-signup"><a href="${signup}">SignUp</a></li>
                            </c:if>
                            <%-- Khi AccSession != null la khi Da SignIn Thi Hien Thi Profile va SignOut --%>
                            <c:if test="${sessionScope.AccSession!=null}">
                            <li id="banner-profile"><a href="${profile}">Profile</a></li>
                            <li id="banner-profile"><a href="${signout}">SignOut</a></li>
                            </c:if>
                    </ul>
                </div>
            </div>
            <div id="content">