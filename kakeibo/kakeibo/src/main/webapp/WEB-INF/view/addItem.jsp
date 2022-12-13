<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link href="css/bootstrap.min.css" rel="stylesheet" />
<link href="css/style.css" rel="css/stylesheet" />
<title>家計簿管理システム | 追加画面</title>
</head>
<body>
 <div class="container mt-5">
 <h1>備品登録</h1>
  <div class="row">
   <div class="col-md-12">
    <form action="" method="post">
     <div class="form-group mb-3">
     </div>
     <div class="form-group mb-3">
      <label for="formContents">内容</label>
      <input type="text" name="contents" id="formContents" class="form-control">
     </div>
     <div class="form-group mb-3">
      <label for="formPrice">値段</label>
      <input type="text" name="price" id="formPrice" class="form-control">
     </div>
     <div class="form-group">
      <input type="submit" class="btn btn-success" value="登録"/>
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