package com.hnjd.news.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hnjd.news.dao.CommentsDao;
import com.hnjd.news.dao.CommentsDaoImpl;
import com.hnjd.news.dao.NewsDao;
import com.hnjd.news.dao.NewsDaoImpl;
import com.hnjd.news.entity.Comment;
import com.hnjd.news.entity.News;

/**
 * Servlet implementation class SelectNewsServlet
 */
@WebServlet("/selectNewsServlet")
public class SelectNewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectNewsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nidStr = request.getParameter("nid");
		Integer nid = Integer.valueOf(nidStr);
		String option = request.getParameter("option");
		String target = "/newsList.jsp";
		if("edit".equals(option)) {
			target = "/editNews.jsp";
		}
		NewsDao newsDao = new NewsDaoImpl();
		News newsById = new News();
		
		CommentsDao commentsDao=new CommentsDaoImpl();
		try {
			newsById = newsDao.getNewsById(nid);
			List<Comment> commentsByNid = commentsDao.getCommentsById(nid);
			request.setAttribute("newsById", newsById);
			request.setAttribute("commentsByNid", commentsByNid);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		request.getRequestDispatcher(target).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
