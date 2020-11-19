package com.hnjd.news.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hnjd.news.dao.CommentsDao;
import com.hnjd.news.dao.CommentsDaoImpl;
import com.hnjd.news.entity.Comment;

/**
 * Servlet implementation class AddCommentServlet
 */
@WebServlet("/AddCommentServlet")
public class AddCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cnid = request.getParameter("cnid");
		String cauthor = request.getParameter("cauthor");
		String cip = request.getParameter("cip");
		String ccontent = request.getParameter("ccontent");
		
		CommentsDao commentsDao = new CommentsDaoImpl();
		Comment comment = new Comment();
		comment.setCnid(Integer.valueOf(cnid));
		comment.setCauthor(cauthor);
		comment.setCip(cip);
		comment.setCcontent(ccontent);
		comment.setCdate(new Date());
		
		try {
			 int addComment = commentsDao.addComment(comment);
		}catch(SQLException e){
			e.printStackTrace();
		}
//		JSONObject jo = JSONObject.fromObject(comment);
//		
//		response.getWriter().append(jo.toString());
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cnid = request.getParameter("cnid");
		String cauthor = request.getParameter("cauthor");
		String cip = request.getParameter("cip");
		String ccontent = request.getParameter("ccontent");
		
		CommentsDao commentsDao = new CommentsDaoImpl();
		Comment comment = new Comment();
		comment.setCnid(Integer.valueOf(cnid));
		comment.setCauthor(cauthor);
		comment.setCip(cip);
		comment.setCcontent(ccontent);
		comment.setCdate(new Date());
		
		try {
			 int addComment = commentsDao.addComment(comment);
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("/selectNewsServlet?nid="+cnid).forward(request, response);
	}

}
