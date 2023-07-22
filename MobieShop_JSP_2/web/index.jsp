<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="template/header.jsp" %>

<div id="content-left">
    <h3>CATEGORY</h3>

    <ul>
        <c:forEach items="${ListC}" var="o" >

            <c:url value="/category" var="category">
                <c:param name="cid" value="${o.getCategoryID()}"/>
            </c:url>

            <a href="${category}"><li>${o.getCategoryName()}</li></a>
                </c:forEach>
    </ul>
</div>

<div id="content-right">
    <c:if test="${sessionScope.homeStatus == 3}">
        <%-- Neu ko tim kiem gi ma nhan search thi se hien thi AllProduct --%>
        <c:if test="${txt == \"\" }">
            <div class="path">${allProduct}</b></div>
            </c:if>
            <%-- Neu tim kiem txt ma nhan search thi se hien thi txt --%>
            <c:if test="${txt != \"\" }">
            <div class="path">${txt}</b></div>
            </c:if>
        <div class="content-mainn">
            <c:forEach var="o" items="${listS}">
                <div class="productt">
                    <a href="<%=path%>/product/detail?txtId=${o.getProductID()}"><img src="<%=path%>/${o.getImage()}" width="100%"/></a>
                    <div class="name"><a href="<%=path%>/product/detail?txtId=${o.getProductID()}">${o.getProductName()}</a></div>
                    <div class="price">${o.getUnitPrice()} $</div>
                    <c:if test="${o.getUnitsInStock()>0}">
                        <div class="buynow"><a href="<%=path%>/shopping/buy?num=1&tid=${o.getProductID()}">Buy now</a></div>
                    </c:if>
                    <c:if test="${o.getUnitsInStock()<=0}">
                         <div class="buynow" style="font-weight: bold;">Out Stocks</a></div>
                    </c:if>
                </div>
            </c:forEach>
        </div>

        <%-- Paging Search Product --%>
        <%-- chay doGet ben servlet de hien trang ke tiep --%>
        <div id="paging">
            <div class="pagination">
                <c:if test="${tag>1}">
                    <a href="<%=path%>/search?index=${tag-1}&txt=${txt}">Previous</a>
                </c:if>   

                <c:forEach begin="${1}" end="${endP}" var="i">

                    <%-- Khi an vao page i thi boi den de biet dang o page do --%>
                    <c:if test="${tag==i}">
                        <a style="background-color: burlywood" href="<%=path%>/search?index=${i}&txt=${txt}">${i}</a>
                    </c:if>
                    <c:if test="${tag!=i}">
                        <a href="<%=path%>/search?index=${i}&txt=${txt}">${i}</a>
                    </c:if>
                </c:forEach>
                <c:if test="${tag<endP}">
                    <a href="<%=path%>/search?index=${tag+1}&txt=${txt}">Next</a>
                </c:if>
            </div> 
        </div>

    </c:if>
    <c:if test="${sessionScope.homeStatus != 3}">
        <div class="path">Best Sale</b></div>
        <form action="<%=path%>/product/detail">
            <div class="content-main">
                <c:forEach var="o" items="${listH}">
                    <div class="product">
                        <a href="<%=path%>/product/detail?txtId=${o.getProductID()}"><img src="<%=path%>/${o.getImage()}" width="100%"/></a>
                        <div class="name"><a href="<%=path%>/product/detail?txtId=${o.getProductID()}">${o.getProductName()}</a></div>
                        <div class="price">${o.getUnitPrice()} $</div>
                        <c:if test="${o.getUnitsInStock()>0}">
                            <div class="buynow"><a href="<%=path%>/shopping/buy?num=1&tid=${o.getProductID()}">Buy now</a></div>
                        </c:if>
                        <c:if test="${o.getUnitsInStock()<=0}">
                             <div class="buynow" style="font-weight: bold;">Out Stocks</a></div>
                        </c:if>
                    </div>
                </c:forEach>
            </div>
        </form>

        <div class="path">New Product</b></div>
        <form action="<%=path%>/product/detail">
            <div class="content-main">

                <c:forEach var="o" items="${listN}">
                    <div class="product">
                        <a href="<%=path%>/product/detail?txtId=${o.getProductID()}"><img src="<%=path%>/${o.getImage()}" width="100%"/></a>
                        <div class="name"><a href="<%=path%>/product/detail?txtId=${o.getProductID()}">${o.getProductName()}</a></div>
                        <div class="price">${o.getUnitPrice()} $</div>
                        <c:if test="${o.getUnitsInStock()>0}">
                            <div class="buynow"><a href="<%=path%>/shopping/buy?num=1&tid=${o.getProductID()}">Buy now</a></div>
                        </c:if>
                        <c:if test="${o.getUnitsInStock()<=0}">
                            <div class="buynow" style="font-weight: bold;">Out Stocks</a></div>
                        </c:if>
                    </div>
                </c:forEach>
            </div>
        </form>
    </c:if>

</div>

<%@include file="template/footer.jsp" %>
