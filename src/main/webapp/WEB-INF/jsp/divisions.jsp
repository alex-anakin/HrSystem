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

var counter = function() {
	return counter.count++;
};
counter.count = 0;
</script>

<div class="text-center">
	<h3>Перечень отделов компании "Рога и копыта"</h3>
</div>
<br>

<table class="table table-bordered table-hover table-striped">
<thead>
	<tr>
		<th>Название отдела</th>
		<th>Количество сотрудников</th>
		<th>Действие</th>
	</tr>
</thead>
<tbody>
	<c:forEach items="${divisions}" var="division">
		<tr>
			<td>
				<c:out value="${division.name}" /> 
			</td>
			<td>
				<c:out value="${fn:length(division.employees)}" />
			</td>
			<td>
				<a href="<spring:url value="/edit-division/${division.id}.html"/>" class="btn btn-warning">
					Редактировать
				</a>				
				<a href="<spring:url value="/remove-division/${division.id}.html"/>" class="btn btn-danger triggerRemove">
					Удалить
				</a>
			</td>
		</tr>
	
	</c:forEach>
</tbody>

</table>

<!-- Modal -->
<div class="modal fade" id="modalRemove" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Удаление отдела</h4>
      </div>
      <div class="modal-body">
        Вы действительно хотите удалить отдел?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Отмена</button>
        <a href="" class="btn btn-danger removeBtn">Удалить</a>
      </div>
    </div>
  </div>
</div>