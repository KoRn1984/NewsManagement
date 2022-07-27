package by.itacademy.matveenko.jd2.util.validation;

import java.util.List;

import by.itacademy.matveenko.jd2.bean.NewUserInfo;
import by.itacademy.matveenko.jd2.service.ServiceException;

public interface UserDataValidation {
    boolean checkAuthDataLogination(String login, String password)  throws ServiceException;
    boolean checkAuthDataRegistration(NewUserInfo user) throws ServiceException;
    List<String> getInvalidRegistrationData();
}