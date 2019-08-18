<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>시스템 관리</title>
</head>

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
</style>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login/login.css">
<body class="text-center">

	<!--  
	<form class="form-signin">
		<img class="mb-4" src="/img/svg/bootstrap-solid.svg" alt="" width="72" height="72">
		<h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
		<label for="inputEmail" class="sr-only">Email address</label> 
		<input type="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus> <label for="inputPassword" class="sr-only">Password</label> 
		<input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
		<div class="checkbox mb-3">
			<label> 
				<input type="checkbox" value="remember-me">Remember me
			</label>
		</div>
		<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
		<p class="mt-5 mb-3 text-muted">&copy; 2017-2019</p>
	</form>
	-->
	
	<form class="form-signin" action="${pageContext.request.contextPath}/authenticate" method="POST">
		<img class="mb-4" src="/img/svg/bootstrap-solid.svg" alt="" width="72" height="72">
		<h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
		<label for="member_id" class="sr-only">member id</label> 
		<input type="text" id="member_id" name="username" class="form-control" placeholder="member_id" required autofocus> 
		
		<label for="password" class="sr-only">Password</label> 
		<input type="password" id="password" name="password" class="form-control" placeholder="Password" required>
		<div class="checkbox mb-3">
			<label> 
				<input type="checkbox" value="remember-me">Remember me
			</label>
		</div>
		<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
		<input name="${_csrf.parameterName}" type="hidden"value="${_csrf.token}">
		<p class="mt-5 mb-3 text-muted">&copy; 2017-2019</p>
	</form>
	


</body>
</html>