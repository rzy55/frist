<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
      <script type="text/javascript" >
        var xhr = new XMLHttpRequest();
        if(xhr == null){
        	xhr = new ActiveXObject("Microsoft.XMLHTTP");
        }
        xhr.open("GET","JSAjaxServlet?username=张三&age=18&sex=男",true);
        xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
        xhr.send(null);
        xhr.onreadystatechange = function (){
        	if(xhr.readyState == 4 && xhr.status == 200){
        		alert(xhr.responseText)
        	}
        }
      </script>
</body>
</html>