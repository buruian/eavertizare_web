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



				<c:if test="${not empty error}">
					<div class="error">${error}</div>
				</c:if>
				<c:if test="${not empty msg}">
					<div class="msg">${msg}</div>
				</c:if>

				<!-- Form Name -->
				<legend>
					<c:if test="${!not empty listClients}">
							Add clients<br />
							File must be Excel format.
							<c:url value="/addClient" var="clientAction" />
					</c:if>
					<c:if test="${not empty listClients}">
						<c:url value="/editClient" var="clientAction" />
							Edit the clients<br />
							File must be Excel format.
							
					</c:if>
				</legend>

				<form class="form-horizontal"
					action="${clientAction}?${_csrf.parameterName}=${_csrf.token}"
					method="POST" enctype="multipart/form-data">
					<fieldset>

						



						<!-- Text input-->
						<div class="form-group">
							<label class="col-md-4 control-label" for="name">File to
								upload:</label>
							<div class="col-md-4">
								<input id="name" name="file" type="file">

							</div>
						</div>


						<!-- Button -->
						<div class="form-group">
							<label class="col-md-4 control-label" for="signup"></label>
							<div class="col-md-4">
								<button id="signup" name="signup" class="btn btn-success">Press
									here to upload the file!</button>
							</div>
						</div>

					</fieldset>

				</form>


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
