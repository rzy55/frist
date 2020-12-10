<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
      <form>
            <input name="uname" placeholder="请输入用户名">
            <input name="upwd" placeholder="请输入密码">
            <input name="upwd2" placeholder="请再次输入密码">
            <input type="submit" id="add">
      </form>
      <script type="text/javascript" src="/first/js/jquery.min.js"></script>
      <script type="text/javascript" >
           $("form").on("submit",function(){
        	   uname = $("input[name='uname']").val;
        	   upwd = $("input[name='upwd']").val;
        	   upwd2 = $("input[name='upwd2']").val;
        	   
        	   if(uname.lenght == 0 || upwd.lenght == 0 || upwd2.lenght == 0){
        		  alert("请勿输入空值！") 
        		  return false;
        	   }else if( ! (upwd == upwd2)){
        		   alert("两次密码不一样！")
        		   return false;
        	   }
        	   
        	   $.ajax({
        		   "url":"UserServlet",
        		   "type":"post",
        		   "dataType":"JSON",
        		   "data":$("form").serializeArray(),
        		   "success":function(data){
        			   alert(data.result);
        			   if(data.code == "000")
        				   location.href = "index.jsp";
        		   }
        		   
        	   })
        	   return false;
           })
      </script>
</body>
</html>