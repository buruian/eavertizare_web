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
		

					<ul class="nav nav-pills nav-stacked">
						<li><a href="/userUpdate" class="btn btn-default"
							role="button">Update user</a></li>
<!-- 						<li><a href="/editMessage" class=" btn-default" role="button">Update -->
<!-- 								mesage</a></li> -->
<!-- 						<li><a href="/exportPdf" class=" btn-default" role="button">Export -->
<!-- 								pdf</a></li> -->
					</ul>

					<br />
				
				
			</div>

			<!--   ------------------------------Center----------------------------------   -->
			<div class="col-sm-8 text-left">



				<h3 align="center">This is the page for profile management</h3>
				<hr>
<!-- 				<h1>Your details</h1> -->



<!-- 				<table class="table "> -->
<!-- 					<tr> -->
<!-- 						<th>First Name</th> -->
<!-- 						<th>Last Name</th> -->
<!-- 						<th>Email</th> -->
<!-- 						<th>Username</th> -->

<!-- 					</tr> -->



<!-- 					<tr> -->
<%-- 						<td>${user.firstName}</td> --%>
<%-- 						<td>${user.lastName}</td> --%>
<%-- 						<td>${user.email}</td> --%>
<%-- 						<td>${user.username}</td> --%>

<!-- 					</tr> -->


<!-- 				</table> -->




           
                <div class="col-sm-12">
                    <div class="col-xs-12 col-sm-8">
                        <h2 style="text-decoration:underline;">Your details</h2>
                        <p><strong>First name: </strong>${user.firstName} </p>
                        <p><strong>Last name: </strong>${user.lastName} </p>
                        <p><strong>Email: </strong>${user.email} </p>
                         <p><strong>Username: </strong> ${user.username} </p>
                       
                       
                    </div>
                 
                </div>                
            




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







