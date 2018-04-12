<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Index Page</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">        
    </head>
    <body>
        <div class="container">
            <h1 style="text-align: center">Vending Machine</h1>
            <hr/>
            <ul class="list-group" id="errorMessages"></ul>

            <div class="row">
              <div class="col-md-8">
                <h2 style="text-align: center">Available Snacks</h2>
                <div id="displayVendingItems">
                    <c:forEach var="item" items="${items}">
                        <div class="col-md-4">
                            <div class="panel panel-default">
                                <a href="${pageContext.request.contextPath}/makeSelection/${item.itemNumber}">
                                <div class="panel-body">
                                    <p class="text-left">${item.itemNumber}</p>
                                    <p class="text-center">${item.itemName}</p>
                                    <p class="text-center">$${item.cost}</p>
                                    <br><p class="text-center">Quantity Left: ${item.quantity}</p>
                                </div>
                                </a>
                            </div>
                        </div>
                        
                    </c:forEach>
                </div> <!-- closes displayVendingItems -->
              </div>


              <div id="inputContainer">
                <div class="col-md-4" align="center">
                  <h2 style="text-align: center">Total $ In</h2>
                  <br>
                  <input value="${currentAmount}" class="form-control"
                  type="text"
                  id="cashInput" disabled>
                  <br>
                  <div class="row"> <!-- row for first row buttons -->
                    <div class="col-md-6">
                      <a href="${pageContext.request.contextPath}/inputCash/100" class="btn btn-default" id="addDollarBtn">Add Dollar</a>
                    </div>

                    <div class="col-md-6">
                      <a href="${pageContext.request.contextPath}/inputCash/25" class="btn btn-default" id="addQuarterBtn">Add Quarter</a>
                  </div>

                  </div>

                  <br>

                  <div class="row"> <!-- row for second row buttons -->

                    <div class="col-md-6">
                      <a href="${pageContext.request.contextPath}/inputCash/10" class="btn btn-default" id="addDimeBtn">Add Dime</a>
                    </div>

                    <div class="col-md-6">
                      <a href="${pageContext.request.contextPath}/inputCash/5" class="btn btn-default" id="addNickelBtn">Add Nickel</a>
                  </div>

                  </div>

                <hr/>

              <!-- Start of messages section -->

                <h2 style="text-align: center">Messages</h2>
                <br>
                <input value="${displayMessage}" class="form-control"
                type="text"
                id="messageBox" disabled>
                <br>

              <form class="form-horizontal" role="form" id="itemForm">
                <div class="form-group">
                  <label for="itemInput" class="col-md-4 control-label">Item: </label>
                  <div class="col-md-8">
                    <input value="<c:if test="${currentItemSelected != 0}">${currentItemSelected}</c:if>" class="form-control"
                    type:"text"
                    id="itemInput" disabled>
                  </div>
                  <br>
                </div>
              </form>

                <a href="makePurchase" class="btn btn-default" id="makePurchaseBtn">Make Purchase</a>

            <hr/>

            <!-- Start of change section -->

              <h2 style="text-align: center">Change</h2>
              <input value="<c:if test="${change != null}">Quarters ${change.quarters} Dimes ${change.dimes} Nickels ${change.nickels} Pennies ${change.pennies}</c:if>" class="form-control"
              type="text"
              id="changeOutput" disabled>
                    <br>

              <a class="btn btn-default" href="changeReturn">Change Return</a>
              
            </div>

        </div>
      </div>
    </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>

