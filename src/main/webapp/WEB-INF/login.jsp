<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/include/header.jsp" %>

<c:url value="/register" var="registerUrl" />
<c:url value="/login" var="loginUrl"/>

<div class="container">
	<c:if test="${param.logout!=null}">
    <div class="alert alert-success fade in">
        <a class="close" data-dismiss="alert" href="#">&times;</a>
        <p>You've logged out</p>
    </div>
    </c:if>
    <c:if test="${param.register!=null}">
    <div class="alert alert-info fade in">
        <a class="close" data-dismiss="alert" href="#">&times;</a>
        <p>Register successful. You can log in</p>
    </div>
    </c:if>
    <c:if test="${param.error!=null}">
    <div class="alert alert-danger fade in">
        <a class="close" data-dismiss="alert" href="#">&times;</a>
        <p>Username or password is incorrect</p>
    </div>
</c:if>
<div class="container">
<div class="col-md-6 col-md-offset-3">
<div class="form">
	<div class="form-group">
        <h4>Zaloguj sie na swoje konto</h4>
        <form action="${loginUrl}" method="post" class="form-signin">
        	<label for="exampleInputEmail">Wpisz Emial</label>	
            <input name="email" type="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
			<label for="exampleInputPassword">Wpisz haslo</label>	           
			<input name="password" type="password" id="inputPassword" class="form-control" placeholder="Password" required>
            <div id="remember" class="checkbox">
                <label>
                    <input type="checkbox" value="remember-me"> Remember me (nie dziala jeszcze)
                </label>
            </div>
            <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Zaloguj sie</button>
        </form>
        <div class="margin-bottom-10">
            <a href="#" class="forgot-password">Zapomniales hasla? (nie dziala jeszcze)</a>
        </div>
        <div class="margin-bottom-10">
            Nie masz jeszcze konta? <a href="${registerUrl}" class="register">Stworz konto</a>
        </div>
    </div>
    </div>
    </div>
    </div>
</div>
<%@ include file="/WEB-INF/include/footer.jsp" %>