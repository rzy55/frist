/**
 * 
 */
package com.hnjd.news.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hnjd.news.entity.News;

/**
 * @author Administrator
 *
 */
public class NewsDaoImpl extends BaseDao implements NewsDao {

	/* （非 Javadoc）
	 * @see com.hnjd.news.dao.NewsDao#getAllNews()
	 */
	@Override
	public List<News> getAllNews() throws SQLException {
		List<News> newsList = new ArrayList<News>();
		ResultSet res = excuteQuery("select * from news");
		while(res.next()) {
			News news = new News();
			news.setNid(res.getInt("nid"));
			news.setNtitle(res.getString("ntitle"));
			news.setNsummary(res.getString("nsummary"));
			news.setNpicPath(res.getString("npicPath"));
			news.setNcreateDate(res.getDate("ncreateDate"));
			news.setNmodifyDate(res.getDate("nmodifyDate"));
			news.setNcontent(res.getString("ncontent"));
			news.setNauthor(res.getString("nauthor"));
			news.setNtid(res.getInt("ntid"));
			newsList.add(news);
		}
		return newsList;
	}

	/* （非 Javadoc）
	 * @see com.hnjd.news.dao.NewsDao#getNewsByTopicId(int)
	 */
	@Override
	public List<News> getNewsByTopicId(int ntid) {
		// TODO 自动生成的方法存根
		return null;
	}

	/* （非 Javadoc）
	 * @see com.hnjd.news.dao.NewsDao#getNewsById(int)
	 */
	@Override
	public News getNewsById(int nid) throws SQLException {
		String sql = "select * from news where nid = ?";
		ResultSet resultSet = excuteQuery(sql, nid);
		News news = new News();
		while(resultSet.next()) {
			news.setNid(resultSet.getInt("nid"));
			news.setNtid(resultSet.getInt("ntid"));
			news.setNtitle(resultSet.getString("ntitle"));
			news.setNcontent(resultSet.getString("ncontent"));
			news.setNauthor(resultSet.getString("nauthor"));
			news.setNcreateDate(resultSet.getDate("ncreateDate"));
			news.setNmodifyDate(resultSet.getDate("nmodifyDate"));
			news.setNsummary(resultSet.getString("nsummary"));
			news.setNpicPath(resultSet.getString("npicPath"));
		}
		return news;
	}

	

	
	/* （非 Javadoc）
	 * @see com.hnjd.news.dao.NewsDao#addNews(com.hnjd.news.entity.News)
	 */
	@Override
	public int addNews(News news) throws SQLException {
		//引用父类basedao的excuteUpdate方法，注意输入参数、输出参数
		String sql = "insert into news (ntid,ntitle,nauthor,ncreateDate,npicPath,ncontent,nmodifyDate,nsummary) values (?,?,?,?,?,?,?,?)";
		int result = excuteUpdate(sql , 
				news.getNtid(),
				news.getNtitle(),
				news.getNauthor(),
				news.getNcreateDate(),
				news.getNpicPath(),
				news.getNcontent(),
				news.getNmodifyDate(),
				news.getNsummary());
		return result;
	}

	/* （非 Javadoc）
	 * @see com.hnjd.news.dao.NewsDao#editNews(int)
	 */
	@Override
	public int editNews(int nid,News news ) throws SQLException {
		String sql = "update news set  ntid = ?  ,ntitle = ?, nauthor = ? ,ncreateDate = ? ,npicPath = ?, "+
				"ncontent = ? ,nmodifyDate = ?,nsummary = ?  where nid = ? ";
		int result = excuteUpdate(sql, news.getNtid(),
					news.getNtitle(),
					news.getNauthor(),
					news.getNcreateDate(),
					news.getNpicPath(),
					news.getNcontent(),
					news.getNmodifyDate(),
					news.getNsummary(),
					news.getNid());
		return result;
	}

	/*public static void main(String[] args) {
		NewsDaoImpl newsDao = new NewsDaoImpl();
		//构建需要修改之后的对象
		News news = new News();
		news.setNid(187);
		news.setNcontent("123");
		news.setNtitle("测试");
		news.setNauthor("测试");
		news.setNsummary("测试");
		news.setNtid(3);
		news.setNcreateDate(new Date());
		try {
			newsDao.editNews(187, news);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}*/
	
	
	/* （非 Javadoc）
	 * @see com.hnjd.news.dao.NewsDao#deleteNews(int)
	 */
	@Override
	public int deleteNews(int nid) throws SQLException {
		String sql = "delete from news where nid = ?";
		int result = excuteUpdate(sql , nid);
		return result;
	}

	@Override
	public List<News> getNewsByPage(int contPage, int pageSize) throws SQLException {
		List<News> newsList=new ArrayList<News>();
		String sql="select * from news limit ?,?";
		ResultSet rs = excuteQuery(sql, 
				contPage*pageSize-9,
				pageSize);
		while(rs.next()) {
			News news = new News();
			news.setNid(rs.getInt("nid"));
			news.setNtitle(rs.getString("ntitle"));
			news.setNsummary(rs.getString("nsummary"));
			news.setNpicPath(rs.getString("npicPath"));
			news.setNcreateDate(rs.getDate("ncreateDate"));
			news.setNmodifyDate(rs.getDate("nmodifyDate"));
			news.setNcontent(rs.getString("ncontent"));
			news.setNauthor(rs.getString("nauthor"));
			news.setNtid(rs.getInt("ntid"));
			newsList.add(news);
		}
		return newsList;
	}

	@Override
	public List<News> getNewsByCondition(News news) throws SQLException {
		List<News> newsList=new ArrayList<News>();
		String sql="select * from news where "
				+"ntitle like concat('%',?,'%') "
				+"and date_format( ncreateDate ,'%Y-%m-%d') =date_format(?,'%Y-%m-%d') "
				+"and nid=?"
				+"and nauthor like concat('%','?','%')";
		ResultSet rs=excuteQuery(sql,
				news.getNtitle(),
				new java.sql.Date(news.getNcreateDate().getTime()),
				news.getNtid(),
				news.getNauthor());
		while(rs.next()) {
			News newsobj = new News();
			newsobj.setNid(rs.getInt("nid"));
			newsobj.setNtitle(rs.getString("ntitle"));
			newsobj.setNsummary(rs.getString("nsummary"));
			newsobj.setNpicPath(rs.getString("npicPath"));
			newsobj.setNcreateDate(rs.getDate("ncreateDate"));
			newsobj.setNmodifyDate(rs.getDate("nmodifyDate"));
			newsobj.setNcontent(rs.getString("ncontent"));
			newsobj.setNauthor(rs.getString("nauthor"));
			newsobj.setNtid(rs.getInt("ntid"));
			newsList.add(newsobj);
		}
		return newsList;
	}

	@Override
	public List<News> getNewsByTid(int tid) throws SQLException {
		String sql = "select * from news where ntid = ? ";
		ResultSet res = excuteQuery(sql, tid);
		List<News> newsList = new ArrayList<News>();
		while(res.next()) {
			News newsObj = new News();
			newsObj.setNid(res.getInt("nid"));
			newsObj.setNtitle(res.getString("ntitle"));
			newsObj.setNsummary(res.getString("nsummary"));
			newsObj.setNpicPath(res.getString("npicPath"));
			newsObj.setNcreateDate(res.getDate("ncreateDate"));
			newsObj.setNmodifyDate(res.getDate("nmodifyDate"));
			newsObj.setNcontent(res.getString("ncontent"));
			newsObj.setNauthor(res.getString("nauthor"));
			newsObj.setNtid(res.getInt("ntid"));
			newsList.add(newsObj);
		}
		return newsList;
	}

}
