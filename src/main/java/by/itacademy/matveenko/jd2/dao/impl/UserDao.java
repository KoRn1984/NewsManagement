package by.itacademy.matveenko.jd2.dao.impl;

import java.sql.SQLException;

import by.itacademy.matveenko.jd2.bean.UserRole;
import by.itacademy.matveenko.jd2.dao.SQLDataBase;
import by.itacademy.matveenko.jd2.service.ServiceException;
import by.itacademy.matveenko.jd2.bean.NewUserInfo;
import by.itacademy.matveenko.jd2.dao.DaoException;
import by.itacademy.matveenko.jd2.dao.IUserDao;

public class UserDao implements IUserDao{
	
	private SQLDataBase dataBase = SQLDataBase.getInstance ();	
		 
	public boolean isSQLDataBase (String login, String password) throws DaoException {
		boolean result = false;
		try {
        if (dataBase == null) {            
                throw new SQLException("Database not available!");
            } else {
           		 result = true;
           	 }
            return result;
			}catch(SQLException e) {
				throw new DaoException(e);
		}       
	}
	
	@Override
	public boolean logination(String login, String password) throws DaoException {
		boolean result = false;
		
		if (isSQLDataBase (login, password)) {
			for (NewUserInfo user : dataBase.getDataBase()) {
				if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
					result = true;
					}
			}
		}			  
		return result;		
	}
		
	@Override
	public String getUserRole(String login, String password) throws DaoException {
    	String role = UserRole.GUEST;
    	if (logination(login, password)) {
			for (NewUserInfo user : dataBase.getDataBase()) {
				if (user.getLogin().equals(login)) {
				role = user.getRole();
				}
			}			
		}
		return role;
	}
	
	@Override
	public boolean registration(NewUserInfo user) throws DaoException, ServiceException  {
		boolean result = false;
		
		if (!isUserAlreadyRegistered (user)) {
			if (isLoginNotUsed (user) && isEmailNotlUsed (user)) {
			    addDataBase (user);
			    
			    result = true;
			}						
		}						
		return result;        
	}
	
	public SQLDataBase addDataBase (NewUserInfo user) {
		dataBase.getDataBase().add(user);
		System.out.println (dataBase);
	   	return dataBase;
    }	
	
	private boolean isUserAlreadyRegistered (NewUserInfo user) {
		boolean result = true;
		for (NewUserInfo registredUsers : dataBase.getDataBase()) {
		if (!user.equals(registredUsers)) {
			result = false;
		    }
		}
		return result;				
	}

	public boolean isLoginNotUsed (NewUserInfo user) throws ServiceException {
		boolean result = true;
		
		for (NewUserInfo userRegistered : dataBase.getDataBase()) {
			if (user.getLogin().equals(userRegistered.getLogin())) {
				result = false;
				break;
            } else {
            	throw new ServiceException("Login already used!");   			  
   		   }
        }	
	      return result;
	}
	
	public boolean isEmailNotlUsed (NewUserInfo user) throws ServiceException {
		boolean result = true;
		
		for (NewUserInfo userRegistered : dataBase.getDataBase()) {
			if (user.getEmail().equals(userRegistered.getEmail())) {
				result = false;
				break;
				} else {
					throw new ServiceException("Email already used!");
					}
                }
		return result;
	}
}