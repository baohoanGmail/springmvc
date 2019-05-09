<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="UTF-8">
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body class="container">
	<div class="col-md-12">
		<h1>This is News site!</h1>
		<a href="/springmvc">Back to Home!</a>
		<h5>Current Page ${currentPage}</h5>
		<p> <span>Pageing: </span>
			<c:forEach begin="1" end="${totalPage}" varStatus="loop">
				<c:if test="${loop.index == currentPage}">
					<a class="text-danger bg-warning p-1" href="./news?page=${loop.index}">${loop.index}</a>
				</c:if>
				<c:if test="${loop.index != currentPage}">
					<a class="bg-light p-1" href="./news?page=${loop.index}">${loop.index}</a>
				</c:if>
			</c:forEach>
		</p>
	</div>
	<table class="col-md-12 table table-striped">
		<thead>
			<tr>
				<th>#ID</th>
				<th>Title</th>
				<th>Reader</th>
				<th>Reply</th>
				<th>Status</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${news}">
				<tr>
					<td>${item.id}</td>
					<td><a href="${item.uri}" target="_blank">${item.title}</a></td>
					<td>${item.reader}</td>
					<td>${item.reply}</td>
					<td>
						<c:choose>
							<c:when test="${item.isActive == '1'}">
								true
							</c:when>
							<c:otherwise>
								<span class="text-danger">false</span>
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<th>#ID</th>
				<th>Title</th>
				<th>Reader</th>
				<th>Reply</th>
				<th>Status</th>
			</tr>
		</tfoot>
	</table>

	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>
