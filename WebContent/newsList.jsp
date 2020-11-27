<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新闻详细信息</title>
</head>
<body>
	新闻ID：${newsById.nid}<br>
	新闻标题：${newsById.ntitle}<br>
	新闻内容：${newsById.ncontent}<br>
	
	<div if="comment">
	<c:if test="${commentsByNid != null}">
		<c:forEach items="${commentsByNid}" var="comment">
			留言人：${comment.cauthor}  <br>
			留言内容：${comment.ccontent}  <br>
			留言时间：${comment.cdate}<br>
			<hr>
		</c:forEach>
	</c:if>
	</div>
	
	<h3>评论</h3>

	<form action="${pageContext.request.contextPath}/AddCommentServlet" method="post">
			留言人：<input type="text" name="cauthor"><br>
			IP：<input type="text" name="cip" readonly="readonly" value="${pageContext.request.remoteAddr}"><br>
			<input type="hidden" name="cnid" value="${newsById.nid}"><br>
			<textarea rows="10" cols="100" name="ccontent"  onblur = "validateMess(this)">
			
			</textarea><span id="mess"> </span><br>
			<input type="submit" value="整页刷新">
			<input type="button" value="局部刷新" onclick="sumbmitByAjax()">
	</form>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	<script type="text/javascript">
			function  validateMess(obj) {
				$.ajax( {
				     "url":  "MinGanValidateServlet",                      // 要提交的URL路径
				     "type" :  "post",                    // 发送请求的方式
				     "data"  :  {"ccontent":obj.value.trim()},                    // 要发送到服务器的数据
				     "dataType" :  "text",               // 指定传输的数据格式
				     "success" :  function(result) {
				    	 $("#mess").text(result);
				    	 // 请求成功后要执行的代码
					     },
				      "error" :  function() {   
				    	  // 请求失败后要执行的代码
					     }
				} );
			}
			function submitByAjax(){
				var obj = {};
				var arr = $("#form").serializeArray();
				for(var i = 0 ; i < arr.length ; i++){
					obj[arr[i].name] = arr[i].value;
				}
				$.ajax({
					"url":"AddCommentServlet",
					"type":"GET",
					"dataType":"json",
					"data":obj,
					"success":function(data){
						$("#comment").html( $("#comment").html()+  
								"留言人：" + data.cauthor +
								"  <br> 留言内容：" + data.ccontent +
								"   <br> 留言时间：" + dateToString(data.cdate) +
								" <br> <hr>");
					},
					"error":function(){
						alert("内部错误！")
					}
				})
			}
			function dateToString(date){
				date = new Date(date.time);
				return date.getFullYear() + "-"+ (date.getMonth()+1) + "-" + date.getDate() + " " + 
				date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds();
			}
	</script>
	
	
</body>
</html>