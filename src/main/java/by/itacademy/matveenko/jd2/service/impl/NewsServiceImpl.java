package by.itacademy.matveenko.jd2.service.impl;

import java.util.List;

import by.itacademy.matveenko.jd2.bean.News;
import by.itacademy.matveenko.jd2.dao.DaoProvider;
import by.itacademy.matveenko.jd2.dao.INewsDao;
import by.itacademy.matveenko.jd2.dao.NewsDaoException;
import by.itacademy.matveenko.jd2.service.INewsService;
import by.itacademy.matveenko.jd2.service.ServiceException;

public class NewsServiceImpl implements INewsService{
	private final INewsDao newsDao = DaoProvider.getInstance().getNewsDao();
	
	@Override
	public List<News> latestList(int count) throws ServiceException {		
		try {
			return newsDao.getLatestList(5);
		} catch (NewsDaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public List<News> newsList(Integer pageNumber, Integer pageSize) throws ServiceException {
		try {
			return newsDao.getNewsList(pageNumber, pageSize);
		} catch (NewsDaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public News findById(int id) throws ServiceException {
		try {
			return newsDao.fetchById(id);
		} catch (NewsDaoException e) {
			throw new ServiceException(e);
		}
	}
	
	@Override
	public int save(News news) throws ServiceException {
		try {
			return newsDao.addNews(news);
		} catch (NewsDaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public int update(News news) throws ServiceException {
		try {
			return newsDao.updateNews(news);
		} catch (NewsDaoException e) {
			throw new ServiceException(e);
		}
	}
	
	@Override
	public void find(String[] idNewses) throws ServiceException {		
	}
}