package by.itacademy.matveenko.jd2.controller.impl;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.itacademy.matveenko.jd2.bean.ConnectorStatus;
import by.itacademy.matveenko.jd2.bean.News;
import by.itacademy.matveenko.jd2.service.INewsService;
import by.itacademy.matveenko.jd2.service.ServiceException;
import by.itacademy.matveenko.jd2.service.ServiceProvider;
import by.itacademy.matveenko.jd2.controller.AttributsName;
import by.itacademy.matveenko.jd2.controller.Command;
import by.itacademy.matveenko.jd2.controller.JspPageName;
import by.itacademy.matveenko.jd2.controller.PageUrl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class GoToBasePage implements Command{
	
	private final INewsService newsService = ServiceProvider.getInstance().getNewsService();
	private static final Logger log = LogManager.getRootLogger();
	private static final int COUNT_NEWS = 5;

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String local = request.getParameter(AttributsName.LOCAL);
		List<News> latestNews;
		try {
			HttpSession getSession = request.getSession(true);
			getSession.setAttribute(AttributsName.LOCAL, local);
			request.getSession(true).setAttribute(AttributsName.PAGE_URL, PageUrl.BASE_PAGE);
			latestNews = newsService.latestList(COUNT_NEWS);			
			request.setAttribute(AttributsName.NEWS, latestNews);			
		} catch (ServiceException e) {			
			log.error(e);
			response.sendRedirect(JspPageName.ERROR_PAGE);
		} finally {
			request.setAttribute(AttributsName.USER_STATUS, ConnectorStatus.NOT_ACTIVE);
			request.getSession(true).setAttribute(AttributsName.PAGE_URL, PageUrl.BASE_PAGE);
			request.getRequestDispatcher(JspPageName.BASELAYOUT_PAGE).forward(request, response);
		}
	}
}