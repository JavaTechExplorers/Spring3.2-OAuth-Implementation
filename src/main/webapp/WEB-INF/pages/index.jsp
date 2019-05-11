<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<!-- Load bootstrap and font-awesome via CDN -->
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" />
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/font-awesome/4.0.0/css/font-awesome.css" />

<script type="text/javascript" src="./lib/jquery-3.3.1.js"></script>
<script type="text/javascript" src="./lib/angular.js"></script>
<script type="text/javascript" src="./lib/angular-route.js"></script>
</head>
<body>

	<!-- Header and Navigation bar -->
	<header>
		<nav class="navbar navbar-default">
			<div class="container">
				<div class="navbar-header">
					<a class="navbar-brand" href="http://localhost:8080/VickySpring3.2">Single Page app - Angular + Spring Boot!</a>
				</div>

				<ul class="nav navbar-nav navbar-right">

					<li><a href="http://localhost:8080/VickySpring3.2"><i class="fa fa-home"></i>Home</a></li>

					<li><a href="http://localhost:8080/VickySpring3.2/login"><i class="fa fa-home"></i> Login</a></li>

					<li><a href="http://localhost:8080/VickySpring3.2/data"><i class="fa fa-shield"></i> Data Capture</a></li>

					<li><a href="" data-ng-click="logout()">Logout</a></li>
				</ul>
			</div>
		</nav>
	</header>

	<!-- Main content and view injected here -->
	<div id="main">

	</div>

</body>
</html>