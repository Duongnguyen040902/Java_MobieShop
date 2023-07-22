<%@include file="template/header.jsp" %>
<c:set var="a" value="${account}" />
<div id="content-left">
    <h3 style="font-weight: normal;">Welcome ${c.getContactName()}</h3>
    <h3>Account Management</h3>
    <ul>
        <a href="<%=path%>/account/profile"><li>Personal information</li></a>
        <a href="<%=path%>/account/profile2"><li>Change Password</li></a>        
        <a href="<%=path%>/account/profile3"><li>Change Security Question</li></a>        
    </ul>
    <h3>My order</h3>
    <ul>
        <a href="<%=path%>/account/profile1"><li>All orders</li></a>
        <a href="#"><li>Canceled order</li></a>
    </ul>
</div>
<div id="content-right">
    <div class="path">Change Security Question</b></div>
    <form action="<%=path%>/account/profile3" method="post">
        <div class="content-main">
            <div id="profile-content">
                <div class="profile-content-col">
                    <c:if test="${incorrectPass!=null}">
                        <span class="msg-error">${incorrectPass}</span><br/>
                    </c:if>
                    <div>Your password <br/><input type="password" name="txtYourPassword" value=""></div>
                    <div>Security question <br/>
                        <select name="questionId" style="width: 100%;line-height: 30px;margin-bottom: 5px;">
                            <c:forEach items="${listQ}" var="q">
                                <option value="${q.getQuestionID()}">${q.getQuestion()}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div>Answer<br/><input type="text" name="txtAnswer" value=""></div>
                    <div>
                        <input type="submit" value="Change"/>
                    </div>
                </div>
            </div>

        </div>
    </form>
</div>
<%@include file="template/footer.jsp" %>