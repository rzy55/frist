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
import com.hnjd.news.entity.News;
import com.hnjd.news.entity.Page;

/**
 * Servlet implementation class PageNewsServlet
 */
@WebServlet("/PageNewsServlet")
public class PageNewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageNewsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String contPage = request.getParameter("contPage");
		String pageSize = request.getParameter("pageSize");
		Integer m=Integer.valueOf(contPage);
		Integer n=Integer.valueOf(pageSize);
		List<News> newsByPage = new ArrayList<News>();
		Page page = new Page();
		
		NewsDao newsDao= new NewsDaoImpl();
		try {
			newsByPage = newsDao.getNewsByPage(m, n);
			
			page.setNewsList(newsByPage);
			page.setCurrPage(m);
			page.setPageSize(n);
			page.setTotalSize(newsDao.getAllNews().size());
			page.setTotalPage(n);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("page", page);
		request.getRequestDispatcher("/selectNewsByPage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
