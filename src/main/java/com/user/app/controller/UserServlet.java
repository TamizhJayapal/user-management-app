package com.user.app.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.user.app.dao.UserDAO;
import com.user.app.model.User;


@WebServlet("/")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDao;
       
  
    public UserServlet() {
        super();
    }
    
    public void init() {
    	userDao = new UserDAO();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		
		switch(action) {
	
		case "/insert":
			createNewUser(request, response);
			break;
		
		
		case "/update":
			editUser(request, response);
			break;
		
		case "/delete":
			deleteUser(request, response);
			break;
		
		case "/new":
			showNewForm(request, response);
			break;
			
		case "/edit":
			showEditForm(request, response);
			break;
			
		default:
			listUser(request, response);
			break;
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void createNewUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		User user = new User(request.getParameter("name"),request.getParameter("email"),request.getParameter("country"));
		userDao.addUser(user);
		response.sendRedirect("list");
	}
	
	private void editUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		User user = new User(Integer.parseInt(request.getParameter("id")), request.getParameter("name"),request.getParameter("email"),request.getParameter("country"));
		userDao.updateUser(user);
		response.sendRedirect("list");
	}
	
	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		userDao.deleteUser(Integer.parseInt(request.getParameter("id")));
		response.sendRedirect("list");
	}
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		dispatcher.forward(request, response);
	}
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		User existingUser = userDao.getUserById(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("user", existingUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");		
		dispatcher.forward(request, response);
	}
	
	private void listUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		List<User> users = userDao.getAllUsers();
		request.setAttribute("users", users);		
		RequestDispatcher dispatcher = request.getRequestDispatcher("list-user.jsp");		
		dispatcher.forward(request, response);
	}

}
