<%@ include file="common/headerAdmin.jspf"%>


<security:authorize access="hasRole('ROLE_ADMIN')">

	<!--   ----------------------------------Left------------------------------------ -->
	<div class="container-fluid text-center">
		<div class="row content">
			<div class="col-sm-2 sidenav">
				<!--       <p><a href="#">Link</a></p> -->
				<!--       <p><a href="#">Link</a></p> -->
				<!--       <p><a href="#">Link</a></p> -->
			</div>

			<!--   ------------------------------Center----------------------------------   -->
			<div class="col-sm-8 text-left">







				<h1>Title : ${title}</h1>
				<h2>Wellcom ${pageContext.request.userPrincipal.name}</h2>




				<c:if test="${not empty allCompany}">


					<table class="table">
						<tr>
							<th>Companyes</th>
							<th>Clients</th>
						</tr>

						<c:forEach items="${allCompany}" var="company">

							<tr>
								<td><a href="/showCompany?name=${company.name}">Detail
										about ${company.name}</a> <%-- 					<a href="<c:url value='/updateCountry/${country.id}' />" > --%></td>

								<td><a href="/clientCompany?name=${company.name}">Clienti
										for ${company.name}</a> <%-- 					<a href="<c:url value='/updateCountry/${country.id}' />" > --%></td>
							</tr>

						</c:forEach>

					</table>

				</c:if>



				<c:if test="${not empty company}">


					<table class="table">
						<tr>
							<th>Id</th>
							<th>Name</th>
							<th>Address</th>
							<th>Descrition</th>
						</tr>

						<%-- 				<c:forEach items="${company}" var="comanuDetail"> --%>

						<tr>
							<td>${company.id}</td>
							<td>${company.name}</td>
							<td>${company.address}</td>
							<td>${company.description}</td>

						</tr>

						<%-- 				</c:forEach> --%>

					</table>

				</c:if>

				<%-- ${company} --%>

				<c:if test="${not empty clientCompany}">


					<table class="table">
						<tr>
							<th>Id</th>
							<th>First name</th>
							<th>Last name</th>
							<th>Phone number</th>
							<th>Email</th>
							<th>Expiration date</th>
							<th>Message</th>
							<th>Send</th>
						</tr>

						<c:forEach items="${clientCompany}" var="client">

							<tr>
								<td>${client.id}</td>
								<td>${client.firstName}</td>
								<td>${client.lastName}</td>
								<td>${client.phoneNumber}</td>
								<td>${client.email}</td>
								<td>${client.expirationDate}</td>
								<td>${client.message}</td>
								<td>${client.sent}</td>
							</tr>

						</c:forEach>

					</table>

				</c:if>


				<%-- ${clientCompany} --%>








			</div>
			<!--   ---------------------------------Right--------------------------------------------- -->

			<div class="col-sm-2 sidenav">
				<!-- 			<div class="well"> -->
				<!-- 				<p>ADS</p> -->
				<!-- 			</div> -->
				<!-- 			<div class="well"> -->
				<!-- 				<p>ADS</p> -->
				<!-- 			</div> -->
			</div>
		</div>
	</div>

</security:authorize>
<%@ include file="common/footer.jspf"%>







