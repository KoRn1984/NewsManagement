package by.itacademy.matveenko.jd2.controller.impl;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import by.itacademy.matveenko.jd2.bean.UserRole;
import by.itacademy.matveenko.jd2.bean.ConnectorStatus;
import by.itacademy.matveenko.jd2.bean.User;
import by.itacademy.matveenko.jd2.service.ServiceException;
import by.itacademy.matveenko.jd2.controller.AttributsName;
import by.itacademy.matveenko.jd2.controller.Command;
import by.itacademy.matveenko.jd2.controller.JspPageName;
import by.itacademy.matveenko.jd2.controller.PageUrl;
import by.itacademy.matveenko.jd2.controller.UserParameterName;
import by.itacademy.matveenko.jd2.service.IUserService;
import by.itacademy.matveenko.jd2.service.ServiceProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class DoRegistration implements Command {
	
	private final IUserService service = ServiceProvider.getInstance().getUserService();
	private static final Logger log = LogManager.getRootLogger();
	private static final String ERROR_REGISTRATION_MESSAGE = "&RegistrationError=Incorrect data entered!";
		
		@Override
		public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String login = request.getParameter(UserParameterName.JSP_LOGIN_PARAM);
		    String password = request.getParameter(UserParameterName.JSP_PASSWORD_PARAM);
			String userName = request.getParameter(UserParameterName.JSP_NAME_PARAM);
		    String userSurname = request.getParameter(UserParameterName.JSP_SURNAME_PARAM);
		    String email = request.getParameter(UserParameterName.JSP_EMAIL_PARAM);		    
		    UserRole role = UserRole.USER;		    	    
		    String local = request.getParameter(AttributsName.LOCAL);
			HttpSession getSession = request.getSession(true);
						
			User user = new User.Builder()
					.withLogin(login)
                    .withPassword(password)                   
                    .withUserName(userName)
                    .withUserSurname(userSurname)                    
                    .withEmail(email)
                    .withRole(role)
                    .build();
		    try {		   
				if (service.registration(user)) {
					getSession.setAttribute(AttributsName.USER_STATUS, ConnectorStatus.ACTIVE);
					getSession.setAttribute(AttributsName.ROLE, user.getRole().getName());
					getSession.setAttribute(AttributsName.USER, user);
					getSession.setAttribute(AttributsName.REGISTER_USER, ConnectorStatus.REGISTERED);
					response.sendRedirect(PageUrl.NEWS_LIST_PAGE + PageUrl.AMPERSAND_LOCAL + local);					
				}
				else {					
					getSession.setAttribute(AttributsName.REGISTER_USER, ConnectorStatus.NOT_REGISTERED);
					request.setAttribute(AttributsName.SHOW_NEWS, AttributsName.DO_NOT_SHOW_NEWS);
					request.getRequestDispatcher(JspPageName.BASELAYOUT_PAGE).forward(request, response);
					}										
			} catch (ServiceException e) {
				log.error(e);			
				response.sendRedirect(PageUrl.REGISTRATION_PAGE + ERROR_REGISTRATION_MESSAGE + PageUrl.AMPERSAND_LOCAL + local);
		    } 
		}
}