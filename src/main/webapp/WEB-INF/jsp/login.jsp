<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="<c:url value="resources/vendor/bootstrap/css/bootstrap.min.css" />" />

<!-- MetisMenu CSS -->
<link
	href="<c:url value="resources/vendor/metisMenu/metisMenu.min.css"/>"
	rel="stylesheet">

<!-- DataTables CSS -->

<link
	href="<c:url value="resources/vendor/datatables-plugins/dataTables.bootstrap.css" />"
	rel="stylesheet">

<!-- DataTables Responsive CSS -->

<link
	href="<c:url value="resources/vendor/datatables-responsive/dataTables.responsive.css"/>"
	rel="stylesheet">

<!-- Custom CSS -->
<link href="<c:url value="resources/dist/css/sb-admin-2.css" />"
	rel="stylesheet">

<!-- Custom Fonts -->

<link
	href="<c:url value="resources/vendor/font-awesome/css/font-awesome.min.css"/>"
	rel="stylesheet" type="text/css">

<title>login</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="login-panel panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Please Sign In</h3>
					</div>
					<div class="panel-body">
						<form id="loginForm" method="post" action="loginV"
							modelAttribute="loginBean">
							<div class="form-group">
								<label>Enter your user-name</label> <input type="text"
									class="form-control" id="userName" name="userName"
									path="userName" />
							</div>
							<div class="form-group">
								<label>Please enter your password</label> <input type="password"
									id="password" class="form-control" name="password"
									path="password" />
							</div>
							<input class="btn btn-lg btn-success btn-block" type="submit"
								value="Login" />
						</form>
						<button type="button" class="btn btn-block btn-lg btn-warning"
							id="signUp">Sign Up!</button>
					</div>
				</div>
			</div>
			<div class="modal fade" id="signUpModal" role="dialog">
							<div class="modal-dialog">
								<form id="signUpForm" method="post" action="signUpUser"
									modelAttribute="userBean">
									<div class="modal-content">
										<div class="modal-header">
											<h3 id="signUp_Title" class="modal-title">Create an
												Account</h3>
										</div>
										<div class="modal-body">
											<div class="form-gorup">
												<label for="user-name" class="control-label">User
													Name:</label> <input type="text" name="userName" class="form-control" id="userName">
											</div>
											<div class="form-gorup">
												<label for="last-name" class="control-label">User Last
													Name:</label> <input type="text" name="lastName" class="form-control" id="lastName">
											</div>
											<div class="form-group">
											<label for="last-name" class="control-label">Password: </label> 
												<input type="password" class="form-control"
													name="password" path="password" id="userPassword">
											</div>
										</div>
										<div class="modal-footer">
											<button type="submit" id="userRateSubmit"
												class="btn btn-success ">SignUp!</button>
											<button type="button" class="btn btn-primary"
												data-dismiss="modal">Cancel</button>
										</div>
									</div>
								</form>
								<!-- /.modal-content -->
							</div>
							<!-- /.modal-dialog -->
						</div>
		</div>
	</div>
<script type="text/javascript"
	src="<c:url value="resources/vendor/jquery/jquery.min.js"/>"></script>
<script
	src="<c:url value="resources/vendor/bootstrap/js/bootstrap.min.js" />"></script>
	
	<!-- Metis Menu Plugin JavaScript -->
	<script
		src="<c:url value="resources/vendor/metisMenu/metisMenu.min.js" />"></script>

	<!-- DataTables JavaScript -->

<%-- 	<script
		src="<c:url value="resources/vendor/datatables/js/jquery.dataTables.min.js"/>"></script>


	<script
		src="<c:url value="resources/vendor/datatables-plugins/dataTables.bootstrap.min.js"/>"></script>


	<script
		src="<c:url value="resources/vendor/datatables-responsive/dataTables.responsive.js"/>"></script>

	<!-- Custom Theme JavaScript -->

	<script src="<c:url value="resources/dist/js/sb-admin-2.js" />"></script>
 --%>
 	<script>
		$(document).ready(function() {
			$('#signUp').on('click', function() {
				$('#signUpModal').modal('show');
			});
		});
	</script>
</body>
</html>