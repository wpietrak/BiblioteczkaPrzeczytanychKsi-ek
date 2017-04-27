<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/include/header.jsp" %>
<%@ include file="/WEB-INF/include/navbar.jsp" %>
<c:url var="createUserUrl" value="/user/create"/>
<c:url var="UserListUrl" value = "/user"/>
<div class="container">

    <h1>Create user</h1>

    <div class="row">
      <form role="form" class="form-horizontal" action="${createUserUrl}" method="post">
       
            <div class="form-group">
                <label class="control-label col-sm-2" for="firstName">Imie:</label>
                <div class="col-sm-6">
                    <input type="text" name="firstName" id="firstName" class="form-control" placeholder="Enter first name" autofocus>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="lastName">Nazwisko:</label>
                <div class="col-sm-6">
                    <input type="text" name="lastName" id="lastName" class="form-control" placeholder="Enter last name" autofocus>
                </div>
            </div>
              <div class="form-group">
                <label class="control-label col-sm-2" for="email">Email:</label>
                <div class="col-sm-6">
                    <input type="email" name="email" id="email" class="form-control" placeholder="Enter email" autofocus>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-6">
                    <button type="submit" class="btn btn-primary">Zapisz</button>
                    <a href="${UserListUrl }" class="btn btn-danger">Anuluj</a>
                </div>
            </div>
        </form>
    </div>

</div>

<%@ include file="/WEB-INF/include/footer.jsp" %>