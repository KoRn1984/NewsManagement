package by.itacademy.matveenko.jd2.controller;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.itacademy.matveenko.jd2.dao.connectionpool.ConnectionPool;
import by.itacademy.matveenko.jd2.dao.connectionpool.ConnectionPoolException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String COMMAND_NAME = "command";
	private static final Logger log = LogManager.getRootLogger();
	
	private final CommandProvider provider = new CommandProvider();
       
    public FrontController() {
        super();
    }
    
    @Override
    public void init() throws ServletException {
		try {
			ConnectionPool.getInstance();
		} catch (ConnectionPoolException e) {
			log.error(e);
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String commandName = request.getParameter(COMMAND_NAME);
		
		Command command = provider.getCommand(commandName);
		command.execute(request, response);		
	}

	@Override
	public void destroy() {
		try {
			ConnectionPool.getInstance().dispose();
		} catch (ConnectionPoolException e) {
			log.error(e);
			e.printStackTrace();
		}
	}
}