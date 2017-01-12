<%@ include file="common/header.jspf"%>

<body onload='document.registrationForm.firstName.focus();'>


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

				<c:if test="${not empty error}">
					<div class="error">${error}</div>
				</c:if>

				<form:form class="form-horizontal" action="/registration"
					method="post" name="registrationForm" modelAttribute="client">
					<fieldset>

						<legend> Registration form </legend>

						<form:hidden path="id" />

						<!-- Text input-->
						<div class="form-group">
							<form:label class="col-md-4 control-label" path="firstName">First Name</form:label>
							<div class="col-md-4">
								<form:input id="name" placeholder="Enter first name."
									class="form-control input-md" path="firstName" />
							</div>
						</div>

						<!-- Text input-->
						<div class="form-group">
							<form:label class="col-md-4 control-label" path="lastName">Last Name</form:label>
							<div class="col-md-4">
								<form:input id="name" placeholder="Enter last name."
									class="form-control input-md" path="lastName" />
							</div>
						</div>

						<!-- Text input-->
						<div class="form-group">
							<form:label class="col-md-4 control-label" path="email">Email</form:label>
							<div class="col-md-4">
								<form:input id="email" placeholder="Enter your email."
									class="form-control input-md" path="email" />
							</div>
						</div>


						<c:choose>
							<c:when test="${client.username == null}">
								<!-- Text input-->
								<div class="form-group">
									<form:label class="col-md-4 control-label" path="username">Username</form:label>
									<div class="col-md-4">
										<form:input id="name" placeholder="Enter username for login."
											class="form-control input-md" path="username" />
									</div>
								</div>
							</c:when>
							<c:otherwise>
								<!-- Text input-->
								<div class="form-group">
									<form:label class="col-md-4 control-label" path="username">Username</form:label>
									<div class="col-md-4">
										<form:input disabled="true" id="name"
											placeholder="Enter username for login."
											class="form-control input-md" path="username" />
										<form:hidden path="username" />
									</div>
								</div>
							</c:otherwise>
						</c:choose>


						<!-- Password input-->
						<div class="form-group">
							<form:label class="col-md-4 control-label" path="password">Password</form:label>
							<div class="col-md-4">
								<form:input id="password"
									placeholder="Enter a password for login."
									class="form-control input-md" path="password" />
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





	<%@ include file="common/footer.jspf"%>