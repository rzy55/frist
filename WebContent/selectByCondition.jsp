<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
      <form action="${pageContext.request.contextPath}/selectNewsByConditionServlet" method="post">
           新闻标题：<input type="text" name="ntitle"><br>
           新闻创建时间：<input type="date" name="ncreateDate"><br>
           新闻作者：<input type="text" name="nauthor"><br>
           新闻类型：<select name="ntid">
                <option value="1">国际</option>
           </select><br>
           <input type="submit" value="提交">
      </form>
      <table>
			<tr>
				<th>新闻标题</th>
				<th>新闻作者</th>
				<th>创建时间</th>
				<th>修改时间</th>
				<th>操作</th>
			</tr>
			<c:forEach var="news" items="${newsByCondition}">
				<tr>
					<td>
						<a href="${pageContext.request.contextPath}/selectNewsServlet?nid=${news.nid}">${news.ntitle}</a>
					</td>
					<td>${news.nauthor}</td>
					<td>${news.ncreateDate}</td>
					<td>${news.nmodifyDate}</td>
					<td>	
						<a href="editNews.jsp">修改</a>
						<a href="${pageContext.request.contextPath}/deleteNewsServlet?nid=${news.nid}">删除</a>
					</td>
				</tr>
			</c:forEach>
		</table>
</body>
</html>