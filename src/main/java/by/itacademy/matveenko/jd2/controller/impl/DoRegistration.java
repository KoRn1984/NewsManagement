package by.itacademy.matveenko.jd2.controller.impl;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mindrot.jbcrypt.BCrypt;

import by.itacademy.matveenko.jd2.bean.UserRole;
import by.itacademy.matveenko.jd2.bean.ConnectorStatus;
import by.itacademy.matveenko.jd2.bean.User;
import by.itacademy.matveenko.jd2.service.ServiceException;
import by.itacademy.matveenko.jd2.controller.AttributsName;
import by.itacademy.matveenko.jd2.controller.Command;
import by.itacademy.matveenko.jd2.controller.JspPageName;
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
		
		@Override
		public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String login = request.getParameter(UserParameterName.JSP_LOGIN_PARAM);
		    String password = request.getParameter(UserParameterName.JSP_PASSWORD_PARAM);
			String userName = request.getParameter(UserParameterName.JSP_NAME_PARAM);
		    String userSurname = request.getParameter(UserParameterName.JSP_SURNAME_PARAM);
		    String email = request.getParameter(UserParameterName.JSP_EMAIL_PARAM);		    
		    UserRole role = UserRole.USER;
		    String hashPassword = BCrypt.hashpw(password, BCrypt.gensalt());
		    
		    HttpSession getSession = request.getSession(true);
			User user = new User.Builder()
					.withLogin(login)
                    .withPassword(hashPassword)                    
                    .withUserName(userName)
                    .withUserSurname(userSurname)                    
                    .withEmail(email)
                    .withRole(role)
                    .build();
		    try {		   
				if (service.registration(user)) {
					getSession.setAttribute(AttributsName.USER_STATUS, ConnectorStatus.ACTIVE);
					getSession.setAttribute(AttributsName.ROLE, role.getName());
					getSession.setAttribute(AttributsName.REGISTER_USER, ConnectorStatus.REGISTERED);					
					response.sendRedirect("controller?command=go_to_news_list");														
				}				        
				else {					
					getSession.setAttribute(AttributsName.REGISTER_USER, ConnectorStatus.NOT_REGISTERED);
					response.sendRedirect("controller?command=go_to_base_page&RegistrationError=Incorrect data entered!");
					}				
			}catch (ServiceException e) {
				log.error(e);
				response.sendRedirect(JspPageName.INDEX_PAGE);
		    }
		}
}