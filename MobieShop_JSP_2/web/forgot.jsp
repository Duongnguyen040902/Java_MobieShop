<%@include file="template/header.jsp" %>
<div id="form">
    <h3 style="padding: 20px;">Forgot your account password?</h3>
    <div style="padding: 0px 20px 10px;">
        Please choose your security question and answer correctly to be able to recover your password                </div>
    <div id="form-content">
        <form action="<%=path%>/forgot/password" method="post">
            <label>Your Email<span style="color: red;">*</span></label><br/>
            <input name="txtEmail" type="text"/><br/>
            <c:if test="${(msgEmailExist!=null)}"> 
                <span class="msg-error">${msgEmailExist}</span><br/>
            </c:if>
            <label>Security question<span style="color: red;">*</span></label><br/>
            <select name="questionId" style="width: 100%;line-height: 30px;margin-bottom: 5px;"> 
                <c:forEach items="${ListQ}" var="o">
                    <option value="${o.getQuestionID()}">${o.getQuestion()}</option>                             
                </c:forEach>
            </select><br/>
            <label>Answer<span style="color: red;">*</span></label><br/>
            <input name="txtAnswer" type="text"/><br/>
            <c:if test="${(wrong!=null)}"> 
                <span class="msg-error">${wrong}</span><br/>
            </c:if> 
            <input type="submit" value="GET PASSWORD" style="margin-bottom: 30px;"/><br/>
        </form>
    </div>
</div>
<%@include file="template/footer.jsp" %>