var book_from_server;
var attempt = 0;
var isAlive = false;

$(document).ready(function(){
	checkIfIsAlive();
});
function checkIfIsAlive(){
	$.ajaxSetup({ cache: false });
	$.ajax({
	    url: 'http://localhost:8080/RESTService/book/' ,
	    type: "GET",
	    dataType: 'json',
	    success: function(data) {
	    	isAlive = true;
	    },
	    error: function (request, status, error) {
	    	if(attempt < 9){
	    		 attempt = attempt + 1;
	    		 randomRequest();
	    	}else{
	    		showErrors("Server is not available");
	    	}
	    }
	  });
}
function showErrors(error){
	$(".errors").append('<div class="row"><div class="alert alert-danger" role="alert">'+error+'</div></div>');
	setTimeout(function() {
		$(".errors").empty();
	}, 5000);
}

function getBooks(){
	$.ajaxSetup({ cache: false });
	$.ajax({
	    url: 'http://localhost:8080/RESTService/book/' ,
	    type: "GET",
	    dataType: 'json',
	    success: function(data) {
	    	displayBooks(data);
	    },
	    error: function (request, status, error) {
	        showErrors(request.responseText);
	    }
	  });
}

function getBook(id){
	$.ajaxSetup({ cache: false });
	$.ajax({
	    url: 'http://localhost:8080/RESTService/book/' +id ,
	    type: "GET",
	    dataType: 'json',
	    success: function(data) {
	    	book_from_server = data;
	    	displayBook(data);
	    },
	    error: function (request, status, error) {
	        showErrors(request.responseText);
	    }
	  });
}

function updateBook(){
	book_from_server.title = $("input[name='title']").val();
	book_from_server.author = $("input[name='author']").val();
	book_from_server.genre = $("input[name='genre']").val();
	book_from_server.year = $("input[name='year']").val();
	
	var jsonData = JSON.stringify({book: book_from_server}); 
	console.log(jsonData);
	$.ajaxSetup({ cache: false });
	$.ajax({
	    url: 'http://localhost:8080/RESTService/book/' ,
	    type: "PUT",
	    data: jsonData,
	    contentType: "charset=utf-8", 
	    dataType: 'json',
	    contentType : 'application/json',
	    success: function(data) {
	    	getBooks();
	    },
	    error: function (request, status, error) {
	        showErrors(request.responseText);
	    }
	  });

	
}

function saveBook(){
	save_book = {
						"title"  : $("input[name='add_title']").val(),
						"author" : $("input[name='add_author']").val(),
						"genre"  : $("input[name='add_genre']").val(),
						"year" :   $("input[name='add_year']").val()
						}
	var jsonData = JSON.stringify({book: save_book}); 
	$.ajaxSetup({ cache: false });
	$.ajax({
	    url: 'http://localhost:8080/RESTService/book/' ,
	    type: "POST",
	    data: jsonData,
	    contentType: "charset=utf-8", 
	    dataType: 'json',
	    contentType : 'application/json',
	    success: function(data) {
	    	getBooks();
	    },
	    error: function (request, status, error) {
	        showErrors(request.responseText);
	    }
	  });
}

function deleteBook(id){
	$.ajaxSetup({ cache: false });
	$.ajax({
	    url: 'http://localhost:8080/RESTService/book/' +id ,
	    type: "DELETE",
	    dataType: 'json',
	    success: function(data) {
	    	getBooks();
	    },
	    error: function (request, status, error) {
	        showErrors(request.responseText);
	    }
	  });
	
}

function displayBook(book)
{
	 var out_data="";
	 	out_data = out_data + "<table class='table table-striped'><tr><td>Muutmine. Book id: <b>" + book.id + "</b></td></tr>";
		out_data = out_data + "<tr><td>Title:</td><td><input type=text class='form-control' name=title value='" + book.title + "'></td></tr>";
		out_data = out_data + "<tr><td>Author:</td><td><input type=text class='form-control' name=author value='" + book.author + "'></td></tr>";
		out_data = out_data + "<tr><td>Genre:</td><td><input type=text class='form-control' name=genre value='" + book.genre + "'></td></tr>";
		out_data = out_data + "<tr><td>Year:</td><td><input type=text class='form-control' name=year value='" + book.year + "'></td></tr>";
		out_data = out_data + "<td><button type='button' class='btn btn-primary'   onClick='updateBook()'>Salvesta muudatused</button></td>";
		out_data = out_data + "</table>";


	
	 $("#one_book").html(out_data);
}

function displayBooks(data)
{
	var out_data="";
	 out_data = out_data + "<table id='books' class='table'><tr><td colspan=4>Raamatuid kokku: <b>" + data.length + "</b></td></tr>";
	 for(var  i in data) {
   	  var book = data[i];
		out_data = out_data + "<tr id='book_"+book.id+"'><td>Title:</td><td bgcolor=ffffff>" + book.title + "</td><td>Author:</td><td bgcolor=ffffff>" + book.author + "</td>";
		out_data = out_data + "<td>Genre:</td><td bgcolor=ffffff>" + book.genre + "</td>";
		out_data = out_data + "<td>Year:</td><td bgcolor=ffffff>" + book.year + "</td>";
		out_data = out_data + "<td><button type='button' class='btn btn-success'  onClick='getBook(" + book.id + ")'>Vali</button></td>";
		out_data = out_data + "<td><button type='button' class='btn btn-danger'  onClick='deleteBook(" + book.id + ")'>Kustuta</button></td>";
	 }
	 out_data = out_data + "</table>";

	
	 $("#books_table").html(out_data);
}