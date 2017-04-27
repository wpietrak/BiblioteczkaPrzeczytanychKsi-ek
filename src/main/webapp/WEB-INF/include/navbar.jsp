<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<c:url var="booksUrl" value="/books" />
<c:url var="createBookUrl" value="/book/create" />
<c:url var="createUserUrl" value="/user/create" />
<c:url var="usersUrl" value="/user" />
<c:url value="/logout" var="logoutUrl" />
<c:url var="myReadsUrl" value="/read" />

<nav class="navbar navbar-inverse" role="navigation">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="bs-example-navbar-collapse-1" aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#"></a>
		</div>
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-2">
			<ul class="nav navbar-nav" role="menu">
				<sec:authorize access="hasRole('ADMIN')">
					<li><a href="${createUserUrl }">add New User</a></li>
					<li><a href="${usersUrl }">Show all Users</a></li>
				</sec:authorize>
				<li><a href="${createBookUrl}">Add Book</a></li>
				<li><a href="${booksUrl }">Books to Read</a></li>
				<li><a href="${myReadsUrl}">Read Books</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#">My account</a></li>
				<li role="separator" class="divider"></li>
				<li><a href="${logoutUrl}">Logout</a></li>
			</ul>
		</div>
	</div>
</nav>