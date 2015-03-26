<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../layout/taglib.jsp" %>

<script src="../js/tFormer.min.js"></script>

<div class="text-center">
<h3>Редактирование названия отдела: <c:out value="${division.name}" /></h3>
</div>
<br>

<form:form commandName="editedDivision" id="editDivision" cssClass="form-horizontal registrationForm">
	
	<c:if test="${param.success eq true}">
		<div class="alert alert-success">Изменения занесены в базу данных</div>
	 </c:if>
	
	<div class="form-group">
		<label for="name" class="col-sm-2 control-label">Новое название</label>
		<div class="col-sm-10">
			<form:input path="name" cssClass="form-control" />
			<form:errors path="name" />
			<p class="text-primary">Допускаются названия отделов только из символов русского алфавита.<br>
			Название отдела может быть от одного до трех слов либо состоять из двух слов через дефис.</p>
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-2">
			<input type="submit" value="Сохранить" class="btn btn-lg btn-primary">
		</div>
	</div>
</form:form>

<script>
var editDivision = new tFormer('editDivision',{
	fields: {
		name: {
			rules: '* reg=^([А-я]){2,20}(\\s|-)?([а-я])*\\s?([а-я])*$'
		}
	}
});
</script>