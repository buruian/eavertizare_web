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


				<c:if test="${not empty message}">
					<h2>${message}</h2>
				</c:if>



			


				<form:form class="form-horizontal" action="/addCompany"
					method="post" modelAttribute="company">
					<fieldset>

						<!-- Form Name -->
						<legend>
							<c:if test="${not empty company}">
							Add a company
					</c:if>
							<c:if test="${!not empty company}">
							Edit the company
					</c:if>
						</legend>

						<!-- Text input-->
						<div class="form-group">
							<form:label class="col-md-4 control-label" path="name">Name</form:label>
							<div class="col-md-4">
								<form:input id="name" placeholder="Enter the company name."
									class="form-control input-md" path="name" />
							</div>
						</div>

						<!-- Text input-->
						<div class="form-group">
							<form:label class="col-md-4 control-label" path="address">Address</form:label>
							<div class="col-md-4">
								<form:input id="name" placeholder="Enter the company address."
									class="form-control input-md" path="address" />
							</div>
						</div>

						<!-- Text input-->
						<div class="form-group">
							<form:label class="col-md-4 control-label" path="description">Description</form:label>
							<div class="col-md-4">
								<form:textarea rows="5" cols="30" id="email"
									placeholder="Enter a description about your company."
									class="form-control input-md" path="description" />
							</div>
						</div>

						<form:hidden path="user" />

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






