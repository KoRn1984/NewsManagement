package by.itacademy.matveenko.jd2.controller.impl;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.itacademy.matveenko.jd2.bean.News;
import by.itacademy.matveenko.jd2.controller.AttributsName;
import by.itacademy.matveenko.jd2.controller.Command;
import by.itacademy.matveenko.jd2.controller.JspPageName;
import by.itacademy.matveenko.jd2.controller.NewsParameterName;
import by.itacademy.matveenko.jd2.controller.PageUrl;
import by.itacademy.matveenko.jd2.service.INewsService;
import by.itacademy.matveenko.jd2.service.ServiceException;
import by.itacademy.matveenko.jd2.service.ServiceProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GoToViewNews implements Command {
	
	private final INewsService newsService = ServiceProvider.getInstance().getNewsService();
	private static final Logger log = LogManager.getRootLogger();	
			
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String local = request.getParameter(AttributsName.LOCAL);
		News news = null;						
		try {
			request.getSession(true).setAttribute(AttributsName.LOCAL, local);
			String id = request.getParameter(NewsParameterName.JSP_ID_NEWS);
			news = newsService.findById(Integer.parseInt(id));
			StringBuilder urlBuilder = new StringBuilder(PageUrl.VIEW_NEWS);
			urlBuilder.append(id);			
			if (news == null) {
				response.sendRedirect(JspPageName.ERROR_PAGE);
			} else {
				request.getSession(true).setAttribute(AttributsName.PAGE_URL, urlBuilder);
				request.setAttribute(AttributsName.NEWS, news);		
				request.setAttribute(AttributsName.PRESENTATION, AttributsName.VIEW_NEWS);
				request.getRequestDispatcher(JspPageName.BASELAYOUT_PAGE).forward(request, response);
			}					
		} catch (ServiceException e) {		
			log.error(e);
			response.sendRedirect(JspPageName.ERROR_PAGE);
		}		
	}
}