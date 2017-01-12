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


<%-- 				<h1>Title : ${title}</h1> --%>
<%-- 				<h2>Message : ${message}</h2> --%>
<%-- 				<h3>User : ${username}</h3> --%>

				

				<form:form class="form-horizontal" action="/editMessage" method="post"
					modelAttribute="client">
					<fieldset>

						<!-- Form Name -->
						<legend>
							<c:if test="${not empty client}">
							Add a client
					</c:if>
							<c:if test="${!not empty client}">
							Edit the client
					</c:if>
						</legend>


						<!-- Text input-->
						<div class="form-group">
							<form:label class="col-md-4 control-label" path="message">Message</form:label>
							<div class="col-md-4">
								<form:textarea rows="5" cols="30" id="email"
									placeholder="Enter a message for the client."
									class="form-control input-md" path="message" />
							</div>
						</div>

						<form:hidden path="id" />

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
