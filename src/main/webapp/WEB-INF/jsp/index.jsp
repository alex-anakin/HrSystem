<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../layout/taglib.jsp" %>

<security:authorize access="! isAuthenticated()">
	<br>
	<div class="text-center">
		
		<h2>Система автоматизации работы отдела кадров</h2>
		<h2>компании "Рога и Копыта"</h2>
		<br><br>
		
		<img src="images/img.jpg" alt="Human Resource system" />
		<br><br>	
	
		<h3>Для просмотра информации о сотрудниках, пожалуйста,
			<a href="<spring:url value = "/login.html"/>">авторизуйтесь</a>.</h3>

	</div>
</security:authorize>

<security:authorize access="isAuthenticated()">

	<div class="text-center">
		<h3>Перечень сотрудников компании "Рога и копыта"</h3>
	</div>
	<br>
	<table class="table table-bordered table-hover table-striped">
		<thead>
			<tr>
				<th>Имя</th>
				<th>Фамилия</th>
				<th>Отдел</th>
				<th>Действие</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${employees}" var="employee">
				<tr>
					<td><c:out value="${employee.firstName}" /></td>
					<td><c:out value="${employee.lastName}" /></td>
					<td><c:out value="${employee.division}" /></td>
					<td><a href="<spring:url value="/employee-detail/${employee.id}.html"/>" class="btn btn-info">Просмотр</a> </td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</security:authorize>