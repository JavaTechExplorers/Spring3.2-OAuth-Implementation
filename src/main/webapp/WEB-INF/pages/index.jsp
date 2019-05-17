<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="request" value="${pageContext.request}" />
<c:set var="baseUrl"
	value="${request.scheme}://${request.serverName}:${request.serverPort}${request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
<title>Spring 3.2 - Demo Application</title>

<!-- Load bootstrap and font-awesome via CDN -->
<link rel="stylesheet" href="./css/bootstrap.css" />
<link rel="stylesheet" href="./css/bootstrap-grid.css" />
<link rel="stylesheet" href="./css/bootstrap-reboot.css" />

<script type="text/javascript" src="./lib/jquery-3.4.1.js"></script>
<script type="text/javascript" src="./lib/bootstrap.js"></script>
<script type="text/javascript" src="./lib/bootstrap.bundle.js"></script>

<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}

body {
	padding-top: 5rem;
}

.starter-template {
	padding: 3rem 1.5rem;
	text-align: center;
}
</style>


<!-- Logout logic implemented here -->
<script>
    function formSubmit() {
	document.getElementById("logoutForm").submit();
    }
</script>

</head>
<body>

	<!-- Logout logic implemented here -->
	<c:url value="/j_spring_security_logout" var="logoutUrl" />

	<form action="${logoutUrl}" method="post" id="logoutForm">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>

	<nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
		<a class="navbar-brand" href="${baseUrl}">Spring 3.x Experiments</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarsExampleDefault"
			aria-controls="navbarsExampleDefault" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarsExampleDefault">
			<ul class="navbar-nav mr-auto">
				<!-- <li class="nav-item active">
        <a class="nav-link" href="${baseUrl}">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Link</a>
      </li>
      <li class="nav-item">
        <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Dropdown</a>
        <div class="dropdown-menu" aria-labelledby="dropdown01">
          <a class="dropdown-item" href="#">Action</a>
          <a class="dropdown-item" href="#">Another action</a>
          <a class="dropdown-item" href="#">Something else here</a>
        </div>
      </li> -->
			</ul>
			<form class="form-inline my-2 my-lg-0">
				<!-- <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
      <button class="btn btn-secondary my-2 my-sm-0" type="submit">Login</button> -->

				<c:if test="${pageContext.request.userPrincipal.name == null}">
					<a href="${baseUrl}/login" class="btn btn-secondary my-2 my-sm-0">Login</a>
				</c:if>

				<c:if test="${pageContext.request.userPrincipal.name != null}">
					<a href="javascript:formSubmit()"
						class="btn btn-secondary my-2 my-sm-0">Logout</a>
				</c:if>

			</form>
		</div>
	</nav>

	<main role="main" class="container">

	<div class="starter-template">
		<h1>Spring 3.2 - Demo Application</h1>
		<p class="lead">
			Use this project as a way to quickly start any new Spring 3.x Feature
			experiments<br>
		</p>
	</div>

	</main>

</body>
</html>
