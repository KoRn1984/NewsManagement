package by.itacademy.matveenko.jd2.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import by.itacademy.matveenko.jd2.dao.DaoException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.itacademy.matveenko.jd2.bean.News;
import by.itacademy.matveenko.jd2.dao.INewsDao;
import by.itacademy.matveenko.jd2.dao.NewsDaoException;
import by.itacademy.matveenko.jd2.dao.connectionpool.ConnectionPool;
import by.itacademy.matveenko.jd2.dao.connectionpool.ConnectionPoolException;

public class NewsDao implements INewsDao {

    private static final Logger log = LogManager.getRootLogger();
    private final UserDao userDao = new UserDao();

    @Override
    public List<News> getLatestList(int pageSize) throws NewsDaoException {
        List<News> newsLatestList = new ArrayList<>();
        int startSize = pageSize;
        String selectNewsLatestList = "SELECT * from news limit " + startSize;
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement ps = connection.prepareStatement(selectNewsLatestList)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    News news = new News.Builder()
                            .withId(rs.getInt("id"))
                            .withTitle(rs.getString("title"))
                            .withBrief(rs.getString("brief"))
                            .withContent(rs.getString("content"))
                            .withDate(LocalDate.parse(rs.getString("date")))
                            .withAuthor(userDao.findById(rs.getInt("reporter")))
                            .build();
                    newsLatestList.add(news);
                }
            }
        } catch (SQLException | ConnectionPoolException | DaoException e) {
            log.error(e);
            throw new NewsDaoException(e);
        }
        return newsLatestList;
    }

    @Override
    public List<News> getNewsList(Integer pageNumber, Integer pageSize) throws NewsDaoException {
        List<News> newsList = new ArrayList<>();
//        int startSize = (pageNumber - 1) * pageSize;
//        String selectNewsList = "SELECT * from news limit " + startSize + "," + pageSize;
//        try (Connection connection = ConnectionPool.getInstance().takeConnection();
//             PreparedStatement ps = connection.prepareStatement(selectNewsList)) {
//            try (ResultSet rs = ps.executeQuery()) {
//                while (rs.next()) {
//                    int idNews = rs.getInt("id");
//                    String titleNews = rs.getString("titleNews");
//                    String briefNews = rs.getString("briefNews");
//                    String contentNews = rs.getString("contentNews");
//                    LocalDate dateNews = rs.getString("dateNews");
//                    //int idReporter = rs.getInt("idReporter");
//                    News news = new News(idNews, titleNews, briefNews, contentNews, dateNews);
//                    newsList.add(news);
//                }
//            }
//        } catch (SQLException | ConnectionPoolException e) {
//            log.error(e);
//            throw new NewsDaoException(e);
//        }
        return newsList;
    }

    @Override
    public News fetchById(Integer id) throws NewsDaoException {
        News news = null;
//        String selectNewsById = "SELECT * from news where id = ?";
//        try (Connection connection = ConnectionPool.getInstance().takeConnection();
//             PreparedStatement ps = connection.prepareStatement(selectNewsById)) {
//            ps.setInt(1, id);
//            try (ResultSet rs = ps.executeQuery()) {
//                if (rs.next()) {
//                    int idNews = rs.getInt("id");
//                    String titleNews = rs.getString("titleNews");
//                    String briefNews = rs.getString("briefNews");
//                    String contentNews = rs.getString("contentNews");
//                    LocalDate dateNews = rs.getString("dateNews");
//                    //int idReporter = rs.getInt("idReporter");
//                    news = new News(idNews, titleNews, briefNews, contentNews, dateNews);
//                }
//            }
//        } catch (SQLException | ConnectionPoolException e) {
//            log.error(e);
//            throw new NewsDaoException(e);
//        }
        return news;
    }

    @Override
    public int addNews(News news) throws NewsDaoException {
        int row = 0;
		/*String insertNews = "INSERT into news(titleNews, briefNews, contentNews, dateNews) values (?,?,?,?,?)";
		try (Connection connection = ConnectionPool.getInstance().takeConnection();
		    PreparedStatement ps = connection.prepareStatement(insertNews)) {
			ps.setString(1, news.getTitleNews());
            ps.setString(2, news.getBriefNews());
            ps.setString(3, news.getContentNews());
            ps.setString(4, news.getDateNews());
            ps.setInt(6, user.getIdReporter());
            row = ps.executeUpdate();
				} catch (SQLException | ConnectionPoolException e) {
					log.error(e);
					throw new NewsDaoException(e);
				}
				*/
        return row;
    }

    @Override
    public int updateNews(News news) throws NewsDaoException {
        int row = 0;
        // TODO Auto-generated method stub
        return row;
    }

    @Override
    public void deleteNewses(String[] idNewses) throws NewsDaoException {
        // TODO Auto-generated method stub
    }
}