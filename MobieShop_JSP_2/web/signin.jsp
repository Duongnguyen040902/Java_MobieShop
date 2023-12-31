<%@include file="template/header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="form">
    <div id="form-title">
        <span><a href="<%=path%>/account/signup">SIGN UP</a></span>
        <span><a href="<%=path%>/account/signin" style="color: red;">SIGN IN</a></span>
    </div>
    <div id="form-content">
        <div style="color:red; text-align: left">            
            <c:if test="${(requestScope.msgexist!=null)}">
                ${requestScope.msgexist}
            </c:if>
            <c:if test="${(requestScope.msgInfoNotNull!=null)}">
                ${requestScope.msgInfoNotNull}
            </c:if>
        </div>
        <div style="color:green; text-align: left">
            <c:if test="${(requestScope.msgChangeSuccess!=null)}">
                ${requestScope.msgChangeSuccess}
            </c:if>
        </div>
        <form action="<%=path%>/account/signin" method="post">
            <label>Email<span style="color: red;">*</span></label><br/>
            <input type="text" name="txtEmail" value="${txtEmail}"/><br/>
            <c:if test="${(requestScope.msgEmailNull)!=null}">
                <span class="msg-error">${msgEmailNull}</span><br/>
            </c:if>
            <label>Password<span style="color: red;">*</span></label><br/>
            <input type="password" name="txtPass"/><br/>
            <c:if test="${(requestScope.msgPassNull)!=null}">
                <span class="msg-error">${msgPassNull}</span><br/>
            </c:if>
            <div><a style="text-decoration: none" href="../forgot/password">Forgot password?</a></div>
            <input type="submit" value="SIGN IN"/><br/>

        </form>
    </div>
</div>

<%@include file="template/footer.jsp" %>
