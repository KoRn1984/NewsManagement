package by.itacademy.matveenko.jd2.dao;

import by.itacademy.matveenko.jd2.bean.User;
import by.itacademy.matveenko.jd2.service.ServiceException;

public interface IUserDao {	
	User findUserByLoginAndPassword(String login, String password) throws DaoException;
	boolean saveUser(User user) throws DaoException, ServiceException;	
}