package com.hnjd.news.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hnjd.news.dao.NewsDao;
import com.hnjd.news.dao.NewsDaoImpl;
import com.hnjd.news.dao.TopicDao;
import com.hnjd.news.dao.TopicDaoImpl;
import com.hnjd.news.entity.News;
import com.hnjd.news.entity.Topic;

/**
 * Servlet implementation class ToIndexServlet
 */
@WebServlet("/ToIndexServlet")
public class ToIndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToIndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		NewsDao newsDao = new NewsDaoImpl();
		TopicDao topicDao = new TopicDaoImpl();
		List<News> newsList = new ArrayList<News>();
		List<Topic> topicList = new ArrayList<Topic>();
		try {
			newsList = newsDao.getAllNews();
			topicList = topicDao.allTopic();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("newsList", newsList);
		request.setAttribute("topicList", topicList);
		request.getRequestDispatcher("/index1.jsp").forward(request, response);
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
