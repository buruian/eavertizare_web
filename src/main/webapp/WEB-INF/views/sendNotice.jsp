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


				<h3 align="center">This is the page for send notice</h3>
				<hr>
				<%-- 				<h1>Message : ${message}</h1> --%>
				<%-- 				<h1>User : ${username}</h1> --%>
				${listClients}



				<form:form class="form-horizontal" action="/sendEmail" method="post"
					modelAttribute="client">
					<fieldset>

						<!-- 						Form Name -->
						<!-- 						<legend> -->
						<%-- 							<c:if test="${not empty company}"> --%>
						<!-- 							Add a company -->
						<%-- 					</c:if> --%>
						<%-- 							<c:if test="${!not empty company}"> --%>
						<!-- 							Edit the company -->
						<%-- 					</c:if> --%>
						<!-- 						</legend> -->

						<!-- Text input-->
						<div class="form-group">
<%-- 							<form:label class="col-md-4 control-label" path="clients">Name</form:label> --%>
							<div class="col-md-4">
								<%-- 								<form:input id="name" placeholder="Enter the company name." --%>
								<%-- 									class="form-control input-md" path="name" /> --%>


								<form:select path="email" size="8">
									<form:option value="0" label="Select" />
									<form:options items="${listClients}" />
								</form:select>
							</div>
						</div>


						<!-- Button -->
						<div class="form-group">
							<label class="col-md-4 control-label" for="signup"></label>
							<div class="col-md-4">
								<button id="signup" name="signup" class="btn btn-success">Submit</button>
							</div>
						</div>

					</fieldset>
				</form:form>




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
