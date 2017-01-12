<%@ include file="common/header.jspf"%>
<body onload='document.loginForm.username.focus();'>




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
<!-- 				<div id="login-box"> -->

<!-- 					<h2>Login with Username and Password</h2> -->
					<c:if test="${not empty error}">
						<div class="error">${error}</div>
					</c:if>
					<c:if test="${not empty msg}">
						<div class="msg">${msg}</div>
					</c:if>
					<form class="form-horizontal" name='loginForm'
						action="<c:url value='/j_spring_security_check' />" method='POST'>
						<fieldset>

							<!-- Form Name -->
							<legend>Login form</legend>



							<!-- Text input-->
							<div class="form-group">
								<label class="col-md-4 control-label" for="name">User name:</label>
								<div class="col-md-4">
									<input id="name" name="username" type="text"
										placeholder="Enter your username" class="form-control input-md"
										>

								</div>
							</div>

							<!-- Password input-->
							<div class="form-group">
								<label class="col-md-4 control-label" for="password">Password:</label>
								<div class="col-md-4">
									<input id="password" name="password" type="password"
										placeholder="Enter a password" class="form-control input-md"
										>

								</div>
							</div>

							<!-- Button -->
							<div class="form-group">
								<label class="col-md-4 control-label" for="signup"></label>
								<div class="col-md-4">
									<button id="signup" name="signup" class="btn btn-success">Login</button>
								</div>
							</div>

						</fieldset>
							<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
					</form>

				

<!-- 				</div> -->

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