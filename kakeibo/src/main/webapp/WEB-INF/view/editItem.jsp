<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link href="css/bootstrap.min.css" rel="stylesheet" />
<link href="css/style.css" rel="stylesheet" />
<title>家計簿管理システム | 編集画面</title>
</head>
<body>
<div class = "container mt-3">
	<h1>編集画面</h1>
	<div class="row">
		<div class="col-md-12">
			<form action="" method="post">
				<div class="form-group mb-3">
					<label for="formContents">品名</label>
					<input type="text" name="contents" 
					        value="<c:out value="${contents}"/>"
					        id="formContents" class="form-control">
						
					<c:if test="${!empty contentsError}">
					<div class="alert alert-danger mt-1" role="alert">
						<c:out value="${contentsError}"/>
					</div>
					</c:if>
				</div>
 <div class="form-group mb-3">
          <label for="formAmount">金額</label>
          <input type="text" name="price" id="formPrice" class="form-control" 
                 value="<c:out value="${price}" />" />
          <c:if test="${!empty priceError}">
            <div class="alert alert-danger mt-1" role="alert">
                <c:out value="${priceError}" />
            </div>
          </c:if>
        </div>	
 <div class="form-group">
          <input type="submit" class="btn btn-primary" value="保存" />
          <a href="home" class="btn btn-secondary">キャンセル</a>
        </div>			
			</form>
		</div>
	</div>
</div>
<script src="js/bootstrap.bundle.min.js"></script>
<script src="js/jquery-3.6.0.min.js"></script>
</body>
</html>