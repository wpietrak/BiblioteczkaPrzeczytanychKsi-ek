<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/include/header.jsp"%>
<%@ include file="/WEB-INF/include/navbar.jsp"%>

<div class="container">

	<h1>Przeczytane Ksiazki</h1>

	<div class="row">
		<div class="col-md-12">
			<table class="table table-striped table-hover table-bordered">
				<thead>
					<tr>
						<th class="text-center col-md-1">Id</th>
						<th class="text-center">Data dodania</th>
						<!-- <th class="text-center">date przeczytania</th> -->
						<th class="text-center col-md-3">Uzytkownik</th>
						<th class="text-center col-md-3">Ksiazka</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="read" items="${reads}">
						<tr>
                        <td>${read.id}</td>
                        <td>${read.addDate}</td>
                       <%--  <td>${read.readDate}</td> --%>
                        <td>${read.user.firstName} ${read.user.lastName}</td>
                        <td>${read.book.title} (${read.book.author})</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</div>

<%@ include file="/WEB-INF/include/footer.jsp"%>