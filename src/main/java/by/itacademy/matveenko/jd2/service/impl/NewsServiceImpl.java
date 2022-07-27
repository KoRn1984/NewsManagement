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
	public void save() {
		// TODO Auto-generated method stub		
	}

	@Override
	public void find() {
		// TODO Auto-generated method stub		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub		
	}

	@Override
	public List<News> latestList(int count) throws ServiceException {		
		try {
			return newsDao.getLatestsList(5);
		} catch (NewsDaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public List<News> list() throws ServiceException {
		try {
			return newsDao.getList();
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
}