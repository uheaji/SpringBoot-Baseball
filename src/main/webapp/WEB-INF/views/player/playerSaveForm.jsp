<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../layout/header.jsp"%>

<br />
<div class="container">
	<h2>선수 등록</h2>
	<br />
	<form action="/savePlayer" method="POST">
		<div class="form-group">
			<label>선수명:</label> <input type="text" class="form-control" placeholder="Enter player name"
				name="playerName">
		</div>
		<div class="form-group">
			<label>포지션:</label> <input type="text" class="form-control" placeholder="Enter position"
				name="position">
		</div>
		<label>팀:</label> 
		<select class="form-control" aria-label="Default select example" name="teamId">
			<option selected>팀을 선택하세요.</option>
			<c:forEach var="team" items="${teams }">
				<option value="${team.id }">${team.teamName }</option>
			</c:forEach>
		</select> <br />


		<button type="submit" class="btn btn-primary">등록</button>
	</form>
</div>

</body>
</html>