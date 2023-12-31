<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="template/ContentLeft.jsp" %>
<div id="content-right">
    <c:if test="${productStatus == 2}">
        <div class="path-admin">UPDATE A NEW PRODUCT</b></div>
        <c:url var="action" value="/admin/edit"/>
    </c:if>
    <c:if test="${productStatus == 1}">
        <div class="path-admin">CREATE A NEW PRODUCT</b></div>
        <c:url var="action" value="/admin/create"/>
    </c:if>
    <div class="content-main">
        <form method="post" action="${action}" id="content-main-product">
            <div class="content-main-1">
                <label>Product name (*):</label><br/>
                <input type="text" name="txtProductName" id="" value="${product.getProductName()}"><br/>
                <c:if test="${productNameMsg!=null}">
                    <span class="msg-error">${productNameMsg}</span><br/>
                </c:if>
                <label>Unit price:</label><br/>
                <input type="text" name="txtUnitPrice" id="" value="${product.getUnitPrice()}"><br/>
                <c:if test="${unitPriceMsg!=null}">
                    <span class="msg-error">${unitPriceMsg}</span><br/>
                </c:if>
                <label>Storage Capacity:</label><br/>
                <input type="text" name="txtStorageCapacity" id="" value="${product.getStorageCapacity()}"><br/>          
                <label>Units in stock (*):</label><br/>
                <input type="text" name="txtUnitsInStock" id="" value="${product.getUnitsInStock()}"><br/>
                <c:if test="${unitsInStockMsg!=null}">
                    <span class="msg-error">${unitsInStockMsg}</span><br/>
                </c:if>
            </div>
            <div class="content-main-1">
                <label>Category (*):</label><br/>
                <select name="ddlCategory">
                    <c:forEach items="${ListC}" var="category">
                        <c:choose>
                            <c:when test="${category.getCategoryID() == product.getCategoryID()}">
                                <option value="${category.getCategoryID()}" selected="selected"><c:out value="${category.getCategoryName()}"/></option>
                            </c:when>
                            <c:otherwise>
                                <option value="${category.getCategoryID()}"><c:out value="${category.getCategoryName()}"/></option>
                            </c:otherwise>
                        </c:choose>                               
                    </c:forEach>
                </select>
                <br/>
                <label>Discontinued:</label><br/>
                <c:if test="${product.isDiscontinued()==true && product != null}">
                    <input type="checkbox" name="chkDiscontinued" id="" value="true" checked><br/>
                </c:if>
                <c:if test="${product.isDiscontinued()==false && product != null}">
                    <input type="checkbox" name="chkDiscontinued" id="" value="false"><br/>
                </c:if>
                <c:if test="${product == null}">
                    <input type="checkbox" name="chkDiscontinued" id="" value="true"><br/>
                </c:if>
                <label> Photo link (*):</label><br/>
                <input type="file" name="image" id="" value="${product.getImage()}"><br/>
                <input style="display: none" type="text" name="txtProductId" value="${product.getProductID()}">

                <input type="submit" value="Save"/>
            </div>
        </form>
    </div>
</div>
</div>             
<%@include file="template/footer.jsp" %>
</div>