<%@ include file="common/headerUser.jspf"%>

<security:authorize access="hasRole('ROLE_USER')">

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




				<h3 align="center">This is the page for the company management</h3>
				<hr>

				<c:if test="${not empty message}">
					<h2>${message}</h2>
				</c:if>

				<c:if test="${!not empty company}">
					<a href="/addCompany" class="btn btn-info" role="button">Add a
						company</a>
				</c:if>
				<c:if test="${not empty company}">
					<a href="/updateCompany" class="btn btn-default btn-sm btn-block"
						role="button">Edit the company</a>
					<br />

					<!-- 					<table class="table"> -->
					<!-- 						<thead> -->
					<!-- 							<tr> -->
					<!-- 								<th>Nume</th> -->
					<!-- 								<th>Adresa</th> -->
					<!-- 								<th>Descriere</th> -->
					<!-- 							</tr> -->
					<!-- 						</thead> -->
					<!-- 						<tbody> -->
					<!-- 							<tr> -->
					<%-- 								<td>${company.name}</td> --%>
					<%-- 								<td>${company.address}</td> --%>
					<%-- 								<td>${company.description}</td> --%>
					<!-- 							</tr> -->

					<!-- 						</tbody> -->
					<!-- 					</table> -->




					<div class="col-sm-12">
						<div class="col-xs-12 col-sm-8">
							<h2 style="text-decoration: underline;">Company details</h2>
							<p>
								<strong>Company name: </strong>${company.name}
							</p>
							<p>
								<strong>Address: </strong>${company.address}
							</p>
							<p>
								<strong>Descrition: </strong>${company.description}
							</p>
							


						</div>

					</div>

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











