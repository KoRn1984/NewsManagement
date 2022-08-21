package by.itacademy.matveenko.jd2.controller.impl;

import java.io.IOException;
import java.time.LocalDate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.itacademy.matveenko.jd2.bean.ConnectorStatus;
import by.itacademy.matveenko.jd2.bean.News;
import by.itacademy.matveenko.jd2.bean.User;
import by.itacademy.matveenko.jd2.controller.AttributsName;
import by.itacademy.matveenko.jd2.controller.Command;
import by.itacademy.matveenko.jd2.controller.JspPageName;
import by.itacademy.matveenko.jd2.controller.NewsParameterName;
import by.itacademy.matveenko.jd2.dao.NewsDaoException;
import by.itacademy.matveenko.jd2.dao.impl.NewsDao;
import by.itacademy.matveenko.jd2.service.ServiceException;
import by.itacademy.matveenko.jd2.service.impl.NewsServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class DoEditNews implements Command {
	
	private final NewsDao newsDao = new NewsDao();
	private final NewsServiceImpl service = new NewsServiceImpl();
	private static final Logger log = LogManager.getRootLogger();
	public static final String COMMAND_EXECUTED = "command_executed";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String title = request.getParameter(NewsParameterName.JSP_TITLE_NEWS);
		String brief = request.getParameter(NewsParameterName.JSP_BRIEF_NEWS);
		String content = request.getParameter(NewsParameterName.JSP_CONTENT_NEWS);
		int idNews = Integer.parseInt((String)request.getSession().getAttribute("newsId"));
		System.out.println(idNews);
		

		HttpSession getSession = request.getSession(true);
				
		try {	
			var news = new News.Builder()
					.withId(idNews)
					.withDate(LocalDate.now())
					.withTitle(title)
					.withBrief(brief)
					.withContent(content)
					.withAuthor((User)getSession.getAttribute(AttributsName.USER))
					.build();


			if (service.update(news)) {				
				getSession.setAttribute(AttributsName.USER_STATUS, ConnectorStatus.ACTIVE);
				getSession.setAttribute(AttributsName.EDIT_NEWS, COMMAND_EXECUTED);
				response.sendRedirect("controller?command=go_to_news_list");					
			} else {
				response.sendRedirect(JspPageName.ERROR_PAGE);
			}
		} catch (ServiceException e) {
			log.error(e);
			response.sendRedirect(JspPageName.INDEX_PAGE);
		}		
	}
}