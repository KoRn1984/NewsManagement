package by.itacademy.matveenko.jd2.service;

import by.itacademy.matveenko.jd2.bean.User;
import by.itacademy.matveenko.jd2.bean.UserRole;

public interface IUserService {	
	UserRole signIn(String login, String password) throws ServiceException;
	boolean registration(User user) throws ServiceException;
}