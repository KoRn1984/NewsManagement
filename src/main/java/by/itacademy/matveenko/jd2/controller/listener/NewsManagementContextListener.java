package by.itacademy.matveenko.jd2.controller.listener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.itacademy.matveenko.jd2.dao.connectionpool.ConnectionPool;
import by.itacademy.matveenko.jd2.dao.connectionpool.ConnectionPoolException;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class NewsManagementContextListener implements ServletContextListener {
	private static final Logger log = LogManager.getRootLogger();
		
	public void contextInitialized(ServletContextEvent event) {
		try {
			ConnectionPool.getInstance().initPoolData();
		} catch (ConnectionPoolException e) {//xml настроить переход на error page
			log.error(e);
		} 
	}

	public void contextDestroyed(ServletContextEvent event) {
		try {
			ConnectionPool.getInstance().dispose();
		} catch (ConnectionPoolException e) {//xml настроить переход на error page
			log.error(e);
		}
	}
}