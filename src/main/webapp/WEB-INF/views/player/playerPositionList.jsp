<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../layout/header.jsp"%>
<br/>
<div class="container">
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>포지션</th>
				<th>기아</th>
				<th>롯데</th>
				<th>NC</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="dto"  items="${position}">
			<tr>
				<td>${dto.position}</td>
				<td>${dto.team1}</td>
				<td>${dto.team2}</td>
				<td>${dto.team3}</td>
			</tr>
		</c:forEach>
			
		</tbody>
	</table>
</div>

</body>
</html>