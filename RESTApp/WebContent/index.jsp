<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<script charset="utf-8" src="Resources/jquery-3.1.1.min.js"></script>
<script charset="utf-8" src="Resources/app.js"></script>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<title>Insert title here</title>
</head>
<style>
h1 {
	text-align: center;
	}

</style>
<body class="container">
 <h1> REST Raamatu teenus!</h1>
 <p><div style="text-align:center;" >
 <p><div class="errors"></div>
 <input type=button value="Kõik raamatud" class="btn btn-primary" onClick="getBooks()">
 </div>
 </p>
  <div class="row">
   <div align="center" class="col-md-8" id="books_table"></div>
 	<div align="center" class="col-md-4"  id="one_book"></div>
 </div>
  <p>
  <div class="row">
  <div class="col-md-offset-4 col-md-4">
  <div class="panel panel-primary">
  <div class="panel-heading">Add Book</div>
  <div class="panel-body">
    <table align="center">
  	<tr>
 		 <td>Pealkiri</td>
 		 <td><input type="text" class="form-control" name="add_title"/></td>
  	</tr>
  	<tr>
 		 <td>Autor</td>
 		 <td><input type="text" class="form-control" name="add_author"/></td>
  	</tr>
  	<tr>
 		 <td>Zanr</td>
 		 <td><input type="text" class="form-control" name="add_genre"/></td>
  	</tr>
  	<tr>
 		 <td>Aasta</td>
 		 <td><input type="text" class="form-control" name="add_year"/></td>
  	</tr>
  	<tr>
  		<td><input type="submit" class="btn btn-success" value="Lisa" onclick="saveBook()"/></td>
  	</tr>
  </table>
  </div>
</div>
</div>
</div>
</body>
</html>