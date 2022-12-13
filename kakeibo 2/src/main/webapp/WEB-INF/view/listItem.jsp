<%@ page  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"/>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link href="css/bootstrap.min.css" rel="stylesheet" />
<link href="css/style.css" rel="stylesheet" />
<title>管理システム | ホーム画面家計簿</title>
</head>
<body>
<c:import url="parts/header.jsp" />
<div class="conteiner mt-5">
	<div class="row">
		<div class="col-md-12">
			<table class="table table-striped">
			<thead>
				<tr>
										
					<th>内容</th>
					<th>金額</th>
					<th>日付</th>
					<th colspan="2"></th>
				</tr>
			</thead>
				<c:forEach items="${itemList}" var="item">
				<tr>
					
					<td><c:out value="${item.contents}"/></td>
					<td><c:out value="${item.price}"/></td>
					<td><fmt:formatDate value="${item.registered}" pattern="y年MM月dd日 HH:mm:ss"/></td>
					<td><a class="btn btn-warning" href="editItem?id=<c:out value="${item.id}" />">編集</a></td>
					<th><a class="btn btn-danger" 
						   href="deleteItem?id=<c:out value="${item.id}"/>"
						   data-itemToDelete="<c:out value="${item.contents}"/>"
          				   data-role="deleteItem">削除</a></th>
				</tr>
				</c:forEach>
			</table>
			<a class="btn btn-success" href="addItem">新しく追加する</a>
		</div>
	</div>
</div><!-- /.conteiner -->
</body>
</html>