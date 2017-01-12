<%@ include file="common/headerUser.jspf"%>

<security:authorize access="hasRole('ROLE_USER')">

	<!--   ----------------------------------Left------------------------------------ -->
	<div class="container-fluid text-center">
		<div class="row content">
			<div class="col-sm-2 sidenav">
				<!--       <p><a href="#">Link</a></p> -->
				<!--       <p><a href="#">Link</a></p> -->
				<!--       <p><a href="#">Link</a></p> -->
				<h3></h3>
				<hr>
				<br />
				<c:if test="${not empty listClients}">

					<ul class="nav nav-pills nav-stacked">
						<li><a href="/editClient" class="btn btn-default"
							role="button">Edit the clients</a></li>
						<li><a href="/editMessage" class=" btn-default" role="button">Update
								mesage</a></li>
						<li><a href="/exportPdf" class=" btn-default" role="button">Export
								pdf</a></li>
					</ul>

					<br />
				</c:if>

			</div>

			<!--   ------------------------------Center----------------------------------   -->
			<div class="col-sm-8 text-left">


				<h3 align="center">This is the page for customer management</h3>
				<hr>
				<%-- 				<h1>Message : ${message}</h1> --%>
				<%-- 				<h1>User : ${username}</h1> --%>

				<%-- 	<security:authorize property = "principal.username"></security:authorize> --%>

				<c:if test="${not empty sendEmailSucces}">
					<div class="msg">${sendEmailSucces}</div>
				</c:if>
				<c:if test="${!not empty listClients}">
					<a href="/addClient">Add clients</a>
				</c:if>
				<c:if test="${not empty listClients}">
					<!-- 					<div > -->
					<!-- 						<a href="/editClient" class="btn btn-info" role="button">Edit -->
					<!-- 							the clients</a> <a href="/editMessage" class="btn btn-info" -->
					<!-- 							role="button">Update mesage</a> <a href="/exportPdf" -->
					<!-- 							class="btn btn-info" role="button">Export pdf</a> -->
					<!-- 					</div> -->
					<!-- 					<br/> -->

					<table class="table table-bordered text-center">
						<tr>
							<th class="text-center">Id</th>
							<th class="text-center">First name</th>
							<th class="text-center">Last name</th>
							<th class="text-center">Phone number</th>
							<th class="text-center">Email</th>
							<th class="text-center">Expiration date</th>
							<th class="text-center">Message</th>
							<th class="text-center">Sent</th>
							<th class="text-center">Notice</th>
						</tr>

						<c:forEach items="${listClients}" var="client">

							<tr>
								<td>${client.id}</td>
								<td>${client.firstName}</td>
								<td>${client.lastName}</td>
								<td>${client.phoneNumber}</td>
								<td>${client.email}</td>
								<td>${client.expirationDate}</td>
								<td>${client.message}</td>
								<td>${client.sent}</td>
								<td><a href="<c:url value='/sendEmail/${client.id}' />">Send
								</a></td>

							</tr>

						</c:forEach>

					</table>




				</c:if>






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
