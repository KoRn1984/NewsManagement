package by.itacademy.matveenko.jd2.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.itacademy.matveenko.jd2.bean.News;
import by.itacademy.matveenko.jd2.dao.INewsDao;
import by.itacademy.matveenko.jd2.dao.NewsDaoException;
import by.itacademy.matveenko.jd2.dao.connectionpool.ConnectionPool;
import by.itacademy.matveenko.jd2.dao.connectionpool.ConnectionPoolException;

public class NewsDao implements INewsDao {
	
	private static final Logger log = LogManager.getRootLogger();

	@Override
	public List<News> getLatestList(int pageSize) throws NewsDaoException {
		List<News> newsLatestList = new ArrayList<>();
		int startSize = pageSize;
		String selectNewsLatestList = "SELECT * from news limit " + startSize;	 
	        try (Connection connection = ConnectionPool.getInstance().takeConnection();
	        	PreparedStatement ps = connection.prepareStatement(selectNewsLatestList)) {
	            try (ResultSet rs = ps.executeQuery()) {
	                while (rs.next()) {
	                	int idNews = rs.getInt("id");
	    				String titleNews = rs.getString("titleNews");
	    				String briefNews = rs.getString("briefNews");
	    				String contentNews = rs.getString("contentNews");
	    				String dateNews = rs.getString("dateNews");	    				
	    				News latestNews = new News(idNews, titleNews, briefNews, contentNews, dateNews);
	    				newsLatestList.add(latestNews);
	    			}	    						
	        }	        
	    } catch (SQLException | ConnectionPoolException e) {
	    	log.error(e);
	    	e.printStackTrace();
	    	}
	        return newsLatestList;
	 }				

	@Override
	public List<News> getNewsList(Integer pageNumber, Integer pageSize) throws NewsDaoException {
		List<News> newsList = new ArrayList<>();
		int startSize = (pageNumber - 1) * pageSize;
		String selectNewsList = "SELECT * from news limit " + startSize + "," + pageSize;	 
	        try (Connection connection = ConnectionPool.getInstance().takeConnection();
	        	PreparedStatement ps = connection.prepareStatement(selectNewsList)) {
	            try (ResultSet rs = ps.executeQuery()) {
	                while (rs.next()) {
	                	int idNews = rs.getInt("id");
	    				String titleNews = rs.getString("titleNews");
	    				String briefNews = rs.getString("briefNews");
	    				String contentNews = rs.getString("contentNews");
	    				String dateNews = rs.getString("dateNews");	    				
	    				News news = new News(idNews, titleNews, briefNews, contentNews, dateNews);
	    				newsList.add(news);
	    			}	    						
	        }	        
	    } catch (SQLException | ConnectionPoolException e) {
	    	log.error(e);
	    	e.printStackTrace();
	    	}
	        return newsList;
	 }				
	
	@Override
	public News fetchById(Integer id) throws NewsDaoException {
		News news = null;
		String selectNewsById = "SELECT * from news where id = ?";
		try (Connection connection = ConnectionPool.getInstance().takeConnection();
	        PreparedStatement ps = connection.prepareStatement(selectNewsById)) {
			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                	int idNews = rs.getInt("id");
                	String titleNews = rs.getString("titleNews");
    				String briefNews = rs.getString("briefNews");
    				String contentNews = rs.getString("contentNews");
    				String dateNews = rs.getString("dateNews");
    				news = new News(idNews, titleNews, briefNews, contentNews, dateNews);
    				}
                }
			} catch (SQLException | ConnectionPoolException e) {
				log.error(e);
				e.printStackTrace();
			}
			return news;
	}

	@Override
	public int addNews(News news) throws NewsDaoException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateNews(News news) throws NewsDaoException {
		// TODO Auto-generated method stub
	}

	@Override
	public void deleteNewses(String[] idNewses) throws NewsDaoException {
		// TODO Auto-generated method stub
	}
}