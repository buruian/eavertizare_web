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

				<c:if test="${not empty error}">
					<div class="error">${error}</div>
				</c:if>
				<c:if test="${not empty messageEmpty}">
					<div class="error">${messageEmpty}</div>
				</c:if>
		
<%-- 				<c:if test="${not empty msg}"> --%>
<%-- 					<div class="msg">${msg}</div> --%>
<%-- 				</c:if> --%>




				<form:form class="form-horizontal" action="/sendEmail"
					method="post" modelAttribute="client">
					<fieldset>

						<!-- Form Name -->
						<legend>
						Send notice
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
						<form:hidden path="email" />
						<form:hidden path="firstName" />
						<form:hidden path="lastName" />
						<form:hidden path="phoneNumber" />
						<form:hidden path="expirationDate" />
						<form:hidden path="sent" />
						

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
