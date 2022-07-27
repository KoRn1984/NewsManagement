package by.itacademy.matveenko.jd2.dao;

import by.itacademy.matveenko.jd2.bean.NewUserInfo;
import by.itacademy.matveenko.jd2.service.ServiceException;

public interface IUserDao {	
	boolean logination(String login, String password) throws DaoException;
	boolean registration(NewUserInfo user) throws DaoException, ServiceException;
	public String getUserRole(String login, String password) throws DaoException;
}