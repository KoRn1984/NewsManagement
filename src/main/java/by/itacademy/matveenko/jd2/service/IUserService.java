package by.itacademy.matveenko.jd2.service;

import by.itacademy.matveenko.jd2.bean.NewUserInfo;

public interface IUserService {
	
	String signIn(String login, String password) throws ServiceException;
	boolean registration(NewUserInfo user) throws ServiceException;
}