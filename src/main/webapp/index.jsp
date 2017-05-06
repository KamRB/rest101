<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <title> My JSON Test </title>
    <script   src="https://code.jquery.com/jquery-3.2.1.min.js"   integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="   crossorigin="anonymous"></script>
    <script>
    function getAuthor(){
    	 $.ajax({
 	        url: 'http://localhost:8080/messenger/webapi/messages',
 	        dataType: 'json',
 	        type: 'get',
 	        cahce: false,
 	        success: function(data){
 	        	$('#jsonString').text(JSON.stringify(data));
 	           $(data).each(function(index, value){
 	        	   $("#names").append('<p>' +  value.author + ', ' +  value.message + '</p>');
 	           })
 	        }
 	    })
    };
    
    function getAuthor2 () {
    	
    	$.getJSON('http://localhost:8080/messenger/webapi/messages', function(data){
    		$('#jsonString').text(JSON.stringify(data)); 
    		$(data).each(function(index, value){
	        	   $("#names").append('<p>' +  value.author + ', ' + value.message  + '</p>');
	           })
    	});
    }
	   
    </script>
</head>
<body>
    <p> kam is god! <p>
     <button onclick="getAuthor()">Get Author1</button>
     <button onclick="getAuthor2()">Get Author2</button>
   <h1> JSON String</h1>
    <div id = "jsonString"></div>
    
     <h1> Names</h1>
    <div id ="names"></div>
</body>
</html>