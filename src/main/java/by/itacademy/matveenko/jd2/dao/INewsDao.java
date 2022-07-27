package by.itacademy.matveenko.jd2.dao;

import java.util.List;

import by.itacademy.matveenko.jd2.bean.News;

public interface INewsDao {
	List<News> getList() throws NewsDaoException;
	List<News> getLatestsList(int count) throws NewsDaoException;
	News fetchById(Integer id) throws NewsDaoException;
	int addNews(News news) throws NewsDaoException;
	void updateNews(News news) throws NewsDaoException;
	void deleteNewses(String[] idNewses)throws NewsDaoException;
}