package by.itacademy.matveenko.jd2.controller.impl;

import java.io.IOException;
import by.itacademy.matveenko.jd2.service.IUserService;
import by.itacademy.matveenko.jd2.bean.ConnectorStatus;
import by.itacademy.matveenko.jd2.bean.UserRole;
import by.itacademy.matveenko.jd2.controller.Command;
import by.itacademy.matveenko.jd2.controller.JspPageName;
import by.itacademy.matveenko.jd2.controller.RequestParameterName;
import by.itacademy.matveenko.jd2.service.ServiceException;
import by.itacademy.matveenko.jd2.service.ServiceProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DoSignIn implements Command {

	private final IUserService service = ServiceProvider.getInstance().getUserService();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login;
		String password;
		login = request.getParameter(RequestParameterName.JSP_LOGIN_PARAM);
		password = request.getParameter(RequestParameterName.JSP_PASSWORD_PARAM);	

		// small validation
		try {
			UserRole role = service.signIn(login, password);
			if (!role.equals(UserRole.GUEST)) {
				request.getSession(true).setAttribute("user", ConnectorStatus.ACTIVE);
				request.getSession(true).setAttribute("role", role.getName());
				request.getSession(true).setAttribute("registered user", ConnectorStatus.REGISTERED);
				response.sendRedirect("controller?command=go_to_news_list");
			} else {
				request.getSession(true).setAttribute("user", ConnectorStatus.NOT_ACTIVE);
				response.sendRedirect("controller?command=go_to_base_page&AuthenticationError=Wrong login or password!");
			}			
		} catch (ServiceException e) {
			e.printStackTrace();
			response.sendRedirect(JspPageName.INDEX_PAGE);
		}		
	}
}