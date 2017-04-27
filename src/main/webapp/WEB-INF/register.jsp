
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/include/header.jsp"%>

<c:url value="/register" var="registerUrl" />
<c:url value="/login" var="loginUrl" />

<div class="container">
<div class="col-md-6 col-md-offset-3">
<div class="form">
	<div class="form-group">
		<h4>Stwórz swoje konto</h4>
		
<%-- 		<form:form action="${registerUrl}" modelAttribute="form" method="post">
		Emial
		<form:input path="email" id="email" ></form:input>
		<form:errors path="email" cssclass="error" />
		</form:form> --%>
		
		<form class="form-signin" method="post" action="${registerUrl}">
		<label for="exampleInputEmail1">Adres email</label>
			<input name="email" type="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus> 
		<label for="exampleInputFirstName">Imie</label>
			<input name="firstName" type="text" id="inputFirstName" class="form-control" placeholder="First name" required> 
		<label for="exampleInputLastName">Nazwisko</label>
			<input name="lastName" type="text" id="inputLastName" class="form-control" placeholder="Last name" required> 
		<label for="exampleInputPassword">Haslo</label>	
			<input name="password" type="password" id="inputPassword" class="form-control" placeholder="Password" required> 
	<div class="form-group">
		<label for="exampleInputRepeatPassword">Powtorz haslo</label>	
			<input name="repeatPassword" type="password" id="inputRepeatedPassword" class="form-control" placeholder="Repeat password" required>
			</div>
			<span></span>
			<button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Utworz</button>
		</form>
		<div class="margin-bottom-10">
			<a href="${loginUrl}" class="forgot-password">Powrot do logowania</a>
		</div>
	</div>
	</div>
	</div>
</div>

<%@ include file="/WEB-INF/include/footer.jsp"%>