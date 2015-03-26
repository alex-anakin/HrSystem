<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../layout/taglib.jsp" %>

<script type="text/javascript">
$(document).ready(function() {
	$(".triggerRemove").click(function(e) {
		e.preventDefault();
		$("#modalRemove .removeBtn").attr("href", $(this).attr("href"));
		$("#modalRemove").modal();
	});
});
</script>

<div class="text-center">
	<h3>Данные о сотруднике компании "Рога и копыта"</h3>
</div>
<br>

<table class="table table-bordered table-hover table-striped">
	<thead>
		<tr>
			<th>Имя</th>
			<th>Фамилия</th>
			<th>Зарплата</th>
			<th>Дата рождения</th>
			<th>Отдел</th>
			<th>В штате</th>
			<security:authorize access="hasRole('ROLE_EDITOR')">
				<th>Действие</th>
			</security:authorize>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>
				<c:out value="${employee.firstName}" /> 
			</td>
			<td>
				<c:out value="${employee.lastName}" />
			</td>
			<td>
				<c:out value="${employee.salary}" />
			</td>
			<td>
				<fmt:formatDate value="${employee.birthdate}" pattern="dd.MM.yyyy"/>			
			</td>
			<td>
				<c:out value="${employee.division}" />
			</td>
			<td>
				<c:out value="${employee.active}" />
			</td>
			<security:authorize access="hasRole('ROLE_EDITOR')">
				<td>
					<a href="<spring:url value="/edit-employee/${employee.id}.html"/>" class="btn btn-warning">
						Редактировать
					</a>				
					<a href="<spring:url value="/remove-employee/${employee.id}.html"/>" class="btn btn-danger triggerRemove">
						Удалить
					</a>
				</td>
			</security:authorize>
		</tr>
	</tbody>
</table>

<!-- Modal -->
<div class="modal fade" id="modalRemove" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Удаление сотрудника</h4>
      </div>
      <div class="modal-body">
        Вы действительно хотите удалить запись о сотруднике?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Отмена</button>
        <a href="" class="btn btn-danger removeBtn">Удалить</a>
      </div>
    </div>
  </div>
</div>