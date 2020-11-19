package com.hnjd.news.servlet;

import java.io.IOException;
import java.sql.SQLException;
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
 * Servlet implementation class SelectNewsByTidServlet
 */
@WebServlet("/SelectNewsByTidServlet")
public class SelectNewsByTidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectNewsByTidServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String tid = request.getParameter("tid");
		NewsDao newsDao = new NewsDaoImpl();
		List<News> newsByTid = null;
		try {
			newsByTid = newsDao.getNewsByTid(Integer.valueOf(tid));
		} catch (NumberFormatException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
//		JSONArray newsList = new JSONArray();
//		for(News news : newsByTid){
//			JSONObject jo = new JSONObject();
//			jo.put("nid", news.getNid());
//			jo.put("ntitle", news.getNtitle());
//			jo.put("nauthor",news.getNauthor());
//			jo.put("ncreateDate",news.getNcreateDate().toString());
//			newsList.add(jo);
//		}
//		response.getWriter().append(newsList.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
