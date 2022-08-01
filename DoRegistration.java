package by.itacademy.matveenko.jd2.controller.impl;

import java.io.IOException;

import by.itacademy.matveenko.jd2.bean.UserRole;
import by.itacademy.matveenko.jd2.bean.ConnectorStatus;
import by.itacademy.matveenko.jd2.bean.NewUserInfo;
import by.itacademy.matveenko.jd2.service.ServiceException;
import by.itacademy.matveenko.jd2.controller.Command;
import by.itacademy.matveenko.jd2.service.IUserService;
import by.itacademy.matveenko.jd2.service.ServiceProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DoRegistration implements Command {
	private final IUserService service = ServiceProvider.getInstance().getUserService();
	
	private static final String JSP_NAME_PARAM = "name";
	private static final String JSP_SURNAME_PARAM = "surname";
	private static final String JSP_EMAIL_PARAM = "email";
	private static final String JSP_LOGIN_PARAM = "login";
	private static final String JSP_PASSWORD_PARAM = "password";	
		
		@Override
		public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String userName = request.getParameter(JSP_NAME_PARAM);
		    String userSurname = request.getParameter(JSP_SURNAME_PARAM);
		    String email = request.getParameter(JSP_EMAIL_PARAM);
		    String login = request.getParameter(JSP_LOGIN_PARAM);
		    String password = request.getParameter(JSP_PASSWORD_PARAM);
		    String role = UserRole.USER;  
		    
			NewUserInfo userData = new NewUserInfo (userName, userSurname, email, login, password, role);
		    try {		   
				if (service.registration(userData)) {
					request.getSession(true).setAttribute("user", ConnectorStatus.ACTIVE);
					request.getSession(true).setAttribute("registered_user", ConnectorStatus.REGISTERED);
					request.getSession(true).setAttribute("role", role);
					response.sendRedirect("controller?command=go_to_news_list");														
				}				        
				else {					
					request.getSession(true).setAttribute("registered_user", ConnectorStatus.NOT_REGISTERED);
					request.setAttribute("registration error", "Incorrect data entered!");
					//request.getRequestDispatcher("/WEB-INF/pages/layouts/baseLayout.jsp").forward(request, response);
					response.sendRedirect("controller?command=go_to_base_page");
					}				
			}catch (ServiceException e) {
				e.printStackTrace();
		    }		
	}
}