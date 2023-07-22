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
    <div class="path">Change Password</b></div>
    <form action="<%=path%>/account/profile2" method="post">
        <div class="content-main">
            <div id="profile-content">
                <div class="profile-content-col">
                    <c:if test="${wrongPass!=null}">
                        <span class="msg-error">${wrongPass}</span><br/>
                    </c:if>
                        <div>Old password <br/><input type="password" name="txtOldPassword" value="" placeholder="Enter old password"></div>
                        <div>New password <br/><input type="password" name="txtNewPassword" value="" placeholder="Enter new password"></div>
                    <c:if test="${rePassNotMatch!=null}">
                        <span class="msg-error">${rePassNotMatch}</span><br/>
                    </c:if>
                        <div>Re-password <br/><input type="password" name="txtRePassword" value="" placeholder="Enter re-password"></div>
                    <div>
                        <input type="submit" value="Change"/>
                    </div>
                </div>
            </div>

        </div>
    </form>
</div>
<%@include file="template/footer.jsp" %>