<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<head>
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
<script type="text/javascript"
	src="<c:url value="resources/vendor/jquery/jquery.min.js"/>"></script>
<script
	src="<c:url value="resources/vendor/bootstrap/js/bootstrap.min.js" />"></script>

</head>
<title>Movies</title>
</head>
<body>
	<jsp:include page="include.jsp" />
	<div id="page-wrapper">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Tables</h1>
			</div>
			<!-- /.col-lg-12 -->
		</div>
		<!-- /.row -->
		<div class="row">
			<div class="col-lg-12">
				<table width="100%"
					class="table table-striped table-bordered table-hover"
					id="dataTables-recommendations">
					<thead>
						<th>movieTitle</th>
						<th>movieId</th>
						<th>rating</th>
					</thead>
				</table>
			</div>
			<!-- /.table-responsive -->

			<!-- /.col-lg-12 -->
		</div>
	</div>
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

	<!-- Page-Level Demo Scripts - Tables - Use for reference -->
	<script>
		$(document).ready(function() {
			var movieID;
			var table = $('#dataTables-recommendations').DataTable({
				"ajax" : {
					"datatype" : "json",
					"url" : "http://localhost:8080/recommendations",
					crossDomain : true,
					contentType : 'application/json; charset=utf-8',
				},
				responsive : true
				//"deferRender" : true,
			/* "fnCreatedRow" : function(nRow, aData, iDataIndex) {
			$(nRow).attr('id', aData[1]);
			} */
			//"sScrollX" : "100%"
			});
			/* 
			 $('#dataTables-example tbody').on('click', 'tr', function() {
			 var data = table.row(this).data();
			 movieID = data[0];
			 $('#movieTitle').html("Rate " + data[1]);
			 $('#movieID').val(movieID);
			 $('#ratingsModal').modal('show');
			 //alert('You clicked on ' + data[0] + '\'s row');
			 });

			 $('#userRatingSubmit').on('click', function() {

			 }); */
		});
	</script>
</body>
</html>