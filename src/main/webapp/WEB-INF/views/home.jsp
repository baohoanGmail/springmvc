<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="resources/ui.clientlibs/css/bootstrap/bootstrap.min.css">

<link rel="stylesheet" href="resources/ui.clientlibs/css/custom.css">

<title>Home Page</title>
</head>
<body>
	<header class="header bg-dark">
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
			<a class="navbar-brand" href="#">NTATVR</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
	
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item active">
						<a class="nav-link" href="/home">Home
							<span class="sr-only">(current)</span>
						</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="/post">Post</a></li>
					<li class="nav-item"><a class="nav-link" href="/contact">Contact</a></li>
					<li class="nav-item dropdown">
						<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> Crawler </a>
						<div class="dropdown-menu" aria-labelledby="navbarDropdown">
							<a class="dropdown-item" href="/springmvc/crawler/news">News</a>
							<a class="dropdown-item" href="#">Another action</a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item" href="#">Something else here</a>
						</div></li>
					<li class="nav-item"><a class="nav-link disabled" href="/swagger-ui.html">Swagger UI</a>
					</li>
				</ul>
				<form class="form-inline my-2 my-lg-0">
					<input class="form-control mr-sm-2" type="search"
						placeholder="Search" aria-label="Search">
					<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
				</form>
			</div>
		</nav>
	</header>

	<!-- Bootstrap JS -->
	<script src="resources/ui.clientlibs/js/jquery-3.3.1.min.js"></script>
	<script src="resources/ui.clientlibs/js/bootstrap/bootstrap.min.js"></script>
</body>
</html>