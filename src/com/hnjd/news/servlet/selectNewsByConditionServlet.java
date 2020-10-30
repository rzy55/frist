package com.hnjd.news.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hnjd.news.dao.NewsDao;
import com.hnjd.news.dao.NewsDaoImpl;
import com.hnjd.news.entity.News;

/**
 * Servlet implementation class selectNewsByConditionServlet
 */
@WebServlet("/selectNewsByConditionServlet")
public class selectNewsByConditionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public selectNewsByConditionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ntitle = request.getParameter("ntitle");
		String ncreateDate = request.getParameter("ncreateDate");
		String ntid = request.getParameter("ntid");
		String nauthor = request.getParameter("nauthor");
		try {
			NewsDao newsdao=new NewsDaoImpl();
			News news=new News();
			news.setNtitle(ntitle);
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		    news.setNcreateDate(sdf.parse(ncreateDate));
		    news.setNtid(Integer.valueOf(ntid));
		    news.setNauthor(nauthor);
		    List<News> newsByCondition=newsdao.getNewsByCondition(news);
		    request.setAttribute("newsByCondition", newsByCondition);
		} catch (ParseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		request.getRequestDispatcher("/selectByCondition.jsp").forward(request, response);
	}

}
