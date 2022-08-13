package by.itacademy.matveenko.jd2.controller.impl;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.itacademy.matveenko.jd2.bean.News;
import by.itacademy.matveenko.jd2.controller.Command;
import by.itacademy.matveenko.jd2.controller.JspPageName;
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
		News news;		
		String id;
		id = request.getParameter("id");
		
		try {
			news  = newsService.findById(Integer.parseInt(id));
			request.setAttribute("news", news);
			request.setAttribute("presentation", "viewNews");
			request.getRequestDispatcher(JspPageName.BASELAYOUT_PAGE).forward(request, response);
		} catch (ServiceException e) {		
			log.error(e);
        	response.sendRedirect(JspPageName.ERROR_PAGE);
		}		
	}
}