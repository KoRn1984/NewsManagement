package by.itacademy.matveenko.jd2.controller;

import java.io.IOException;

import by.itacademy.matveenko.jd2.dao.connectionpool.ConnectionPool;
import by.itacademy.matveenko.jd2.dao.connectionpool.ConnectionPoolException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public  static ConnectionPool instance;
	
	private final CommandProvider provider = new CommandProvider();
       
    public FrontController() {
        super();
    }
    
    @Override
	public void init() throws ServletException {
    	super.init();
    	try {
			instance = ConnectionPool.getInstance();
		} catch (ConnectionPoolException e) {
					e.printStackTrace();
		}		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String commandName = request.getParameter("command");

		Command command = provider.getCommand(commandName);
		command.execute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	@Override
	public void destroy() {
		instance.dispose();
		super.destroy();
	}
}