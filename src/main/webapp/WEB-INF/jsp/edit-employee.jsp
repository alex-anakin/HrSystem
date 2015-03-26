<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../layout/taglib.jsp" %>

 <link rel="stylesheet" href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
<script src="../js/tFormer.min.js"></script>

<div class="text-center">
	<h3>Изменение данных сотрудника: <c:out value="${editedEmployee.firstName}" /> <c:out value="${editedEmployee.lastName}" /></h3>
</div>
<br>
<table class="table table-bordered table-hover table-striped">
	<thead>
		<tr class="active">
			<th>Имя</th>
			<th>Фамилия</th>
			<th>Зарплата</th>
			<th>Дата рождения</th>
			<th>Отдел</th>
			<th>В штате</th>			
		</tr>
	</thead>
	<tbody>
		<tr class="danger">
			<td>
				<c:out value="${editedEmployee.firstName}" /> 
			</td>
			<td>
				<c:out value="${editedEmployee.lastName}" />
			</td>
			<td>
				<c:out value="${editedEmployee.salary}" />
			</td>
			<td>
				<c:out value="${editedEmployee.birthdate}" />
			</td>
			<td>
				<c:out value="${editedEmployee.divisionName}" />
			</td>
			<td>
				<c:out value="${editedEmployee.active}" />
			</td>			
		</tr>
	</tbody>
</table>
<br>

<form:form commandName="editedEmployee" id="editEmployee" cssClass="form-horizontal">
	
	<c:if test="${param.success eq true}">
		<div class="alert alert-success">Новая запись занесена в базу данных</div>
	 </c:if>
	
	<div class="form-group">
		<label for="firstName" class="col-sm-2 control-label">Имя:</label>
		<div class="col-sm-10">
			<form:input path="firstName" placeholder="Введите имя сотрудника" cssClass="form-control" />
			<form:errors path="firstName" />
			<p class="text-primary">Допускаются имена только из символов русского алфавита, а также двойные имена через дефис.</p>
		</div>
	</div>
	<div class="form-group">
		<label for="lastName" class="col-sm-2 control-label">Фамилия:</label>
		<div class="col-sm-10">
			<form:input path="lastName" placeholder="Введите фамилию сотрудника" cssClass="form-control" />
			<form:errors path="lastName" />
			<p class="text-primary">Допускаются фамилии только из символов русского алфавита, а также двойные фамилии через дефис.</p>
		</div>
	</div>
  	<div class="form-group">
		<label for="salary" class="col-sm-2 control-label">Зарплата:</label>
		<div class="col-sm-10">
			<form:input path="salary" cssClass="form-control" />
			<form:errors path="salary" />
			<p class="text-primary">Допускаются числа больше 0 и меньше 100000 в формате "NN.NN" (с десятичной точкой).</p>
		</div>
	</div>
	<div>
		<div class="form-group">
		<label for="divisionName" class="col-sm-2 control-label">Отдел:</label>
		<div class="col-sm-10">
		<form:select path="divisionName" cssClass="form-control">
  			<c:forEach items="${divisions}" var="division_var">
  			<option><c:out value="${division_var.name}" /></option>
  			</c:forEach>
		</form:select>
		</div>
		</div>
	</div>
	<div class="form-group">
		<label for="birthdate" class="col-sm-2 control-label">Дата рождения</label>
		<div class="col-sm-10">
			<input class="form-control" type="text" placeholder="<c:out value="${editedEmployee.birthdate}" />" disabled>
		</div>
	</div>
	<div class="form-group">
		<label for="active" class="col-sm-2 control-label">В штате:</label>
		<div class="col-sm-10">
			<label class="radio-inline">
				<input type="radio" name="active" id="active" value="true" checked>Да
			</label>
			<label class="radio-inline">
				<input type="radio" name="active" id="active" value="false">Нет
			</label>
		</div>
	</div>	
	<div class="form-group">
		<div class="col-sm-2">
			<input type="submit" value="Сохранить" class="btn btn-lg btn-primary">
		</div>
	</div>
	
</form:form>

<script>
var editEmployee = new tFormer('editEmployee',{
	fields: {
		firstName: {
			rules: '* reg=^([А-я]){2,20}(-([а-я]){2,20})?$'
		},
		lastName: {
			rules: '* reg=^([А-я]){2,20}(-([а-я]){2,20})?$'
		},
		salary: {
			rules: '* reg=^[1-9]{1,1}[0-9]{0,4}(\\.([0-9]){2,2})?$'
		}
	}
	
});
</script>