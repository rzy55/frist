<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
      <table>
  
      <c:forEach begin="1" end="${page.totalPage }" step="1" var="i">
                <a href="${pageContext.request.contextPath }/PageNewsServlet?contPage="+i+"&pageSize=10">下一页</a>
      </c:forEach>
      
			<tr>
				<th><input type="submit" value="删除所选"></th>
				<th>新闻标题</th>
				<th>新闻作者</th>
				<th>创建时间</th>
				<th>修改时间</th>
				<th>操作</th>
			</tr>
			<c:forEach var="news" items="${page.newsList}">
				<tr>
					<td><input type="checkbox" name="nids" value="${news.nid}"></td>
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
		总记录数：${page.totalSize}<br>
		每页显示记录数：${page.pageSize}<br>
		当前页数数：${page.currPage}<br>
		总页数：${page.totalPage}<br>
		
</body>
</html>