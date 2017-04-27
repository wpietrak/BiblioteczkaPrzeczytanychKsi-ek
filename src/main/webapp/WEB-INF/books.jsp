<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/include/header.jsp"%>
<%@ include file="/WEB-INF/include/navbar.jsp"%>

<c:url value="/book/edit" var="editBookUrl" />
<c:url value="/book/delete" var="deleteBookUrl" />
<c:url value="/read/book" var="readBookUrl" />
<div class="container">

	<h1>Ksiazki do przeczytania</h1>

	<div class="row">
		<div class="col-md-12">
			<table class="table table-striped table-hover table-bordered">
				<thead>
					<tr>
						<th class="text-center col-md-1">Id</th>
						<th class="text-center">Tytul</th>
						<th class="text-center">Autor</th>
						
						<th class="text-center col-md-1">przeczytane?</th>
						<th class="text-center col-md-1">edytuj</th>
						<th class="text-center col-md-1">usun</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="book" items="${bookList}">
						<tr>
							<td>${book.id}</td>
							<td>${book.title}</td>
							<td>${book.author}</td>
					  <td class="text-center">
					  <form method="post" action="${readBookUrl}/${book.id}">
					  	
                            <input type="hidden" name="bookId" value="${book.id}">
                            <button
                                 
                                    type="submit" class="btn btn-sm btn-primary">Przeczytane!</button>
                        </form>		</td>	
							<%-- <td class="text-center"><a href="${readBookUrl}/${book.id}"
							
								class="btn btn-sm btn-success">Przeczytane!</a></td> --%>
							<td class="text-center"><a href="${editBookUrl}/${book.id}"
								class="btn btn-sm btn-primary">Edytuj</a></td>
							<td class="text-center">

								<form action="${deleteBookUrl}/${book.id}" method="post">
									<input name="id" type="hidden" value="${book.id}"> 
									<input class="btn btn-sm btn-danger" type="submit" value="Usun">
								</form> 
								</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</div>

<%@ include file="/WEB-INF/include/footer.jsp"%>