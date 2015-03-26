<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../layout/taglib.jsp" %>

<script src="../js/tFormer.min.js"></script>

<div class="text-center">
	<h3>Создание нового отдела.</h3>
</div>
<br>
<form:form commandName="create-division" id="createDivision" cssClass="form-horizontal registrationForm">
	
	<c:if test="${param.success eq true}">
		<div class="alert alert-success">Новый отдел занесен в базу данных</div>
	 </c:if>
	
	<div class="form-group">
		<label for="name" class="col-sm-2 control-label">Название отдела</label>
		<div class="col-sm-10">
			<form:input path="name" placeholder="Введите название отдела" cssClass="form-control" />
			<form:errors path="name" />
			<p class="text-primary">Допускаются названия отделов из символов русского алфавита.<br> 
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
var createDivision = new tFormer('createDivision',{
	fields: {
		name: {
			rules: '* reg=^([А-я]){2,20}(\\s|-)?([а-я])*\\s?([а-я])*$'
		}
	}
});
</script>