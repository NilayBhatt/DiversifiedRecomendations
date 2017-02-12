package edu.ccsu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.ccsu.dao.UserJDBC;
import edu.ccsu.model.User;

@RestController
public class UserController {

	@CrossOrigin
	@RequestMapping(value = "/loginV", method = RequestMethod.POST)
	public void implLogin(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("loginBean") User loginBean) {
		UserJDBC userJDBC = new UserJDBC();
		try {
			boolean isValidUser = userJDBC.validateUser(loginBean);
			if (isValidUser) {
				System.out.println("User Login Successful");
				request.setAttribute("loggedInUser", loginBean.getUserName());
				response.sendRedirect("/table.jsp");
				// model = new ModelAndView("welcome");
			} else {
				// model = new ModelAndView("login");
				// model.addObject("loginBean", loginBean);
				request.setAttribute("message", "Invalid credentials!!");
				response.sendRedirect("/login.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
