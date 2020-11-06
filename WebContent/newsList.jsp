<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	
	<h3>评论</h3>
	<c:if test="${commentsByNid != null}">
		<c:forEach items="${commentsByNid}" var="comment">
			留言人：${comment.cauthor}  <br>
			留言内容：${comment.ccontent}  <br>
			留言时间：${comment.cdate}<br>
			<hr>
		</c:forEach>
	</c:if>
	<form action="${pageContext.request.contextPath}/AddCommentServlet" method="post">
			留言人：<input type="text" name="cauthor"><br>
			IP：<input type="text" name="cip" readonly="readonly" value="${pageContext.request.remoteAddr}"><br>
			<input type="hidden" name="cnid" value="${newsById.nid}"><br>
			<textarea rows="10" cols="100" name="ccontent"  onblur = "validateMess(this)">
			
			</textarea><span id="mess"> </span><br>
			<input type="submit">
	</form>
</body>
</html>