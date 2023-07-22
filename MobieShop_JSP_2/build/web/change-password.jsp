<%@include file="template/header.jsp" %>
<div id="form">
    <h3 style="padding: 20px;">Change Password</h3>
    <div id="form-content">
        <form action="<%=path%>/change/password" method="post">
            <label>Your email<span style="color: red;">*</span></label><br/>
            <input name="txtemail" type="text" readonly="" value="${email}"><br/>
            <label>New Password<span style="color: red;">*</span></label><br/>
            <input name="txtPassword" type="password"/><br/>
            <label>Re-Password<span style="color: red;">*</span></label><br/>
            <c:if test="${(msgNotMatch!=null)}"> 
                <span class="msg-error">${msgNotMatch}</span><br/>
            </c:if>
            <input name="txtRe-password" type="password"/><br/>
            <input type="submit" value="CHANGE PASSWORD" style="margin-bottom: 30px;"/><br/>
        </form>
    </div>
</div>
<%@include file="template/footer.jsp" %> 