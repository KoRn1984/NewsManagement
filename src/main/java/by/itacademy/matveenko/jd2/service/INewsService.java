package by.itacademy.matveenko.jd2.service;

import java.util.List;

import by.itacademy.matveenko.jd2.bean.News;

public interface INewsService {	  
	  List<News> latestList(int count)  throws ServiceException;
	  List<News> newsList(Integer pageNumber, Integer pageSize)  throws ServiceException;
	  News findById(int id) throws ServiceException;
	  int save(News news) throws ServiceException;
	  int update(News news) throws ServiceException;
	  void find(String[] idNewses) throws ServiceException;
	}