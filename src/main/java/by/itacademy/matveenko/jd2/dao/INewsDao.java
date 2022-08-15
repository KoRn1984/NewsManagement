package by.itacademy.matveenko.jd2.dao;

import java.util.List;

import by.itacademy.matveenko.jd2.bean.News;

public interface INewsDao {
	List<News> getLatestList(int pageSize) throws NewsDaoException;
	List<News> getNewsList(Integer pageNumber, Integer pageSize) throws NewsDaoException;
	News fetchById(Integer id) throws NewsDaoException;
	int addNews(News news) throws NewsDaoException;
	int updateNews(News news) throws NewsDaoException;
	void deleteNewses(String[] idNewses)throws NewsDaoException;	
}