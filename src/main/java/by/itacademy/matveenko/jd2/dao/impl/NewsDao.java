package by.itacademy.matveenko.jd2.dao.impl;

import java.util.ArrayList;
import java.util.List;

import by.itacademy.matveenko.jd2.bean.News;
import by.itacademy.matveenko.jd2.dao.INewsDao;
import by.itacademy.matveenko.jd2.dao.NewsDaoException;

public class NewsDao implements INewsDao {

	@Override
	public List<News> getLatestsList(int count) throws NewsDaoException {
		List<News> result = new ArrayList<News>();
		result.add(new News(1, "title1", "brief1brief1brief1brief1brief1brief1brief1", "contect1", "11/11/22"));
		result.add(new News(2, "title2", "brief2brief2brief2brief2brief2brief2brief2", "contect2", "11/11/22"));
		result.add(new News(3, "title3", "brief3brief3brief3brief3brief3brief3brief3", "contect3", "11/11/22"));
		result.add(new News(4, "title4", "brief4brief4brief4brief4brief4brief4brief4", "contect4", "11/11/22"));
		result.add(new News(5, "title5", "brief5brief5brief5brief5brief5brief5brief5", "contect5", "11/11/22"));
		return result;
	}

	@Override
	public List<News> getList() throws NewsDaoException {
		List<News> result = new ArrayList<News>();
		result.add(new News(1, "title1", "brief1brief1brief1brief1brief1brief1brief1", "contect1", "11/11/22"));
		result.add(new News(2, "title2", "brief2brief2brief2brief2brief2brief2brief2", "contect2", "11/11/22"));
		result.add(new News(3, "title3", "brief3brief3brief3brief3brief3brief3brief3", "contect3", "11/11/22"));
		result.add(new News(4, "title4", "brief4brief4brief4brief4brief4brief4brief4", "contect4", "11/11/22"));
		result.add(new News(5, "title5", "brief5brief5brief5brief5brief5brief5brief5", "contect5", "11/11/22"));
		return result;
	}

	@Override
	public News fetchById(Integer id) throws NewsDaoException {
		return new News(1, "title1", "brief1brief1brief1brief1brief1brief1brief1", "contect1", "11/11/22");
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