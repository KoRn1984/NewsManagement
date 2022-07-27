package by.itacademy.matveenko.jd2.controller.impl;

import java.io.IOException;
import java.util.List;

import by.itacademy.matveenko.jd2.bean.ConnectorStatus;
import by.itacademy.matveenko.jd2.bean.News;
import by.itacademy.matveenko.jd2.service.INewsService;
import by.itacademy.matveenko.jd2.service.ServiceException;
import by.itacademy.matveenko.jd2.service.ServiceProvider;
import by.itacademy.matveenko.jd2.controller.Command;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GoToBasePage implements Command{
	
	private final INewsService newsService = ServiceProvider.getInstance().getNewsService();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<News> latestNews;
		try {
			latestNews = newsService.latestList(5);
			request.setAttribute("user", ConnectorStatus.NOT_ACTIVE);
			request.setAttribute("news", latestNews);			
			request.getRequestDispatcher("WEB-INF/pages/layouts/baseLayout.jsp").forward(request, response);
		} catch (ServiceException e) {			
			e.printStackTrace();
		}		
	}
}