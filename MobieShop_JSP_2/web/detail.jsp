<%@include file="template/header.jsp" %>
<c:set var="p" value="${detail.getProducts()}"/>
<c:set var="c" value="${detail.getCategory()}"/>
<c:url var="img" value="${p.getImage()}"/>
<div id="content-detail">
                <div id="content-title">
                    <a href="<%=path%>/home">Home</a> >
                    <a href="<%=path%>/category?cid=${c.getCategoryID()}">${c.getCategoryName()}</a>
                </div>
                <div id="product">
                    <div id="product-name">
                        <h2>${p.getProductName()}</h2>
                        <div id="product-detail">
                            <div id="product-detail-left">
                                <div id="product-img">
                                    <img src="<%=path%>/${img}"/>
                                </div>
                                <div id="product-img-items">
                                    <div><img src="<%=path%>/${img}"></div>
                                    <div><img src="<%=path%>/${img}"></div>
                                    <div><img src="<%=path%>/${img}"></div>
                                    <div><img src="<%=path%>/${img}"></div>
                                </div>
                            </div>
                            <div id="product-detail-right">
                                <div id="product-detail-right-content">
                                    <div id="product-StorageCapacity">Storage Capacity: ${p.getStorageCapacity()}</div>
                                    <div id="product-price">${p.getUnitPrice()} $</div>
                                    <c:if test="${p.getUnitsInStock()>0}">
                                    <div id="product-status">In stock: ${p.getUnitsInStock()}</div>
                                    </c:if>
                                    <c:if test="${p.getUnitsInStock()<=0}">
                                    <div id="productt-status">Out stock: ${p.getUnitsInStock()}</div>
                                    </c:if>
                                    <div id="product-detail-buttons">
                                        <div id="product-detail-button">
                                            <c:if test="${p.getUnitsInStock()>0}">
                                            <a href="<%=path%>/shopping/buy?num=1&tid=${p.getProductID()}"><input type="button" value="BUY NOW"></a>
                                            <a href="<%=path%>/shopping/buy?tid=${p.getProductID()}"><input type="button" value="ADD TO CART" style="background-color: #fff; color:red;border: 1px solid gray;"></a>
                                            </c:if>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div id="info-detail">
                    <div id="info-detail-title">
                        <h2>Information deltail</h2>
                        <div style="margin:10px auto;">
                            Dubbed one of the most affordable IPhones to ever be released, the iPhone 11 has nearly everything you need packaged in a sleek design and at a fraction of the price.
                            The performance in this model is comparable to the Pro and Pro Max models, backed by the freaky fast A13 Bionic chip. Jump back and forth between apps and functions 
                            with ease, stream videos effortlessly and sharpen your gaming skills with the all-new Apple Arcade. Whether you're binge-watching your favorite new show or scrolling 
                            your feeds, the display on the iPhone 11 fully delivers. This model features a 6.1 inch Liquid Retina HD display, slightly larger than the iPhone XS with comparable color and motion. Step in and out of different environmental lighting and experience the magic that is True Tone technology, an auto-adjustment for color and screen intensity based on your surroundings.
                        </div>
                    </div>
                </div>
            </div>
<%@include file="template/footer.jsp" %>