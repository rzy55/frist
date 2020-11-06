<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
      <from>
                           用户名：<input type="text" name="user" onblur="validateUsername">
      </from>
      <script type="text/javascript" src="/first/js/jquery.min.js"></script>
      <script type="text/javascript" >
            function validateUsername(obj) {
				var username=obj.value();
			}
      </script>
</body>
</html>