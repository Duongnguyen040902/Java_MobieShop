<%@include file="template/header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="form">
    <div id="form-title">
        <span><a href="<%=path%>/account/signup" style="color: red;">SIGN UP</a></span>
        <span><a href="<%=path%>/account/signin">SIGN IN</a></span>
    </div>
    <div id="form-content">
        <form action="<%=path%>/account/signup" method="post">
            <label>Company name</label><br/>
            <input name="txtCompanyName" type="text" value="${companyname}"/><br/>
            <c:if test="${(msgCompanyName!=null)}"> 
                <span class="msg-error">Company name is required</span><br/>
            </c:if>
            <label>Contact name</label><br/>
            <input name="txtContactName" type="text" value="${contactname}"/><br/>
            <c:if test="${(msgContactName!=null)}">                                   
                <span class="msg-error">Contact name is required</span><br/>
            </c:if>
            <label>Contact title</label><br/>
            <input name="txtContactTitle" type="text" value="${contacttitle}"/><br/>
            <c:if test="${(msgContactTitle!=null)}">           
                <span class="msg-error">Contact title required</span><br/>
            </c:if>
            <label>Address</label><br/>
            <input name="txtAddress" type="text" value="${address}"/><br/>
            <c:if test="${(msgAddress!=null)}"> 
                <span class="msg-error">Address is required</span><br/>
            </c:if>
            <label>Email</label><br/>
            <input name="txtEmail" type="text" value="${email}"/><br/>
            <c:if test="${(msgEmailExist!=null)}"> 
                <span class="msg-error"><c:out value="${msgEmailExist}" /></span><br/>
            </c:if>
            <c:if test="${(msgEmail!=null)}"> 
                <span class="msg-error">Email is required</span><br/>
            </c:if>                      
            <label>Password</label><br/>
            <input name="txtPass" type="password"/><br/>
            <c:if test="${(msgPass!=null)}">
                <span class="msg-error">Password is required</span><br/>   
            </c:if>
            <label>Re-Password</label><br/>
            <input name="txtRePass" type="password"/><br/>
            <c:if test="${(msgRePass!=null)}"> 
                <span class="msg-error">Re-Password is required</span><br/>
            </c:if>
            <c:if test="${(msg2RePass!=null)}"> 
                <span class="msg-error"><c:out value="${msg2RePass}"/></span><br/>
            </c:if>
            <label>Security question<span style="color: red;">*</span></label><br/>
            <select name="questionID" style="width: 100%;line-height: 30px;margin-bottom: 5px;"> 
                <c:forEach items="${ListQ}" var="o">
                    <option value="${o.getQuestionID()}">${o.getQuestion()}</option>                             
                </c:forEach>
            </select><br/>
            <label>Answer<span style="color: red;">*</span></label><br/>
            <input name="txtAnswer" type="text"/><br/>
            <c:if test="${(msgAnswer!=null)}"> 
                <span class="msg-error">Answer is required</span><br/>
            </c:if>      

            <input type="submit" value="SIGN UP" style="margin-bottom: 30px;"/>
        </form>
    </div>
</div>
<%@include file="template/footer.jsp" %>