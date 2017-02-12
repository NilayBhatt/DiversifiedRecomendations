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
									class="form-control" id="username" name="username"
									path="username" />
							</div>
							<div class="form-group">
								<label>Please enter your password</label> <input type="password"
									id="password" class="form-control" name="password"
									path="password" />
							</div>
							<input class="btn btn-lg btn-success btn-block" type="submit"
								value="Submit" />
							</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript"
		src="<c:url value="resources/vendor/jquery/jquery.min.js"/>"></script>
	<!-- Metis Menu Plugin JavaScript -->

	<script
		src="<c:url value="resources/vendor/metisMenu/metisMenu.min.js" />"></script>

	<!-- DataTables JavaScript -->

	<script
		src="<c:url value="resources/vendor/datatables/js/jquery.dataTables.min.js"/>"></script>


	<script
		src="<c:url value="resources/vendor/datatables-plugins/dataTables.bootstrap.min.js"/>"></script>


	<script
		src="<c:url value="resources/vendor/datatables-responsive/dataTables.responsive.js"/>"></script>

	<!-- Custom Theme JavaScript -->

	<script src="<c:url value="resources/dist/js/sb-admin-2.js" />"></script>
</body>
</html>