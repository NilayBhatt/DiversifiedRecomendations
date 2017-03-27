package edu.ccsu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.ccsu.dao.RatingsJDBC;
import edu.ccsu.dao.UserJDBC;
import edu.ccsu.model.Rating;
import edu.ccsu.model.User;

@RestController
public class UserController {

	private ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	private UserJDBC userJDBC = (UserJDBC) context.getBean("UserJDBC");
	private RatingsJDBC ratingsJDBC = (RatingsJDBC) context.getBean("RatingsJDBC");
	
	@CrossOrigin
	@RequestMapping(value = "/loginV", method = RequestMethod.POST)
	public void implLogin(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("loginBean") User loginBean) {
		
		try {
			if (this.userJDBC.validateUser(loginBean)) {
				System.out.println("User Login Successful");
				HttpSession session = request.getSession();
				session.setAttribute("loggedInUser", loginBean.getUserName());

				// return redirect();
				response.sendRedirect("/table");
			} else {
				request.setAttribute("message", "Invalid credentials!!");
				response.sendRedirect("/login");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@CrossOrigin
	@RequestMapping(value = "/userRated", method = RequestMethod.POST)
	public void userRating(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("ratingBean") Rating ratingBean) {
		try {
			ratingBean.setUserName((String) request.getSession().getAttribute("loggedInUser"));
			
			if (this.ratingsJDBC.insertRating(ratingBean)) {
				response.sendRedirect("/table");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@CrossOrigin
	@RequestMapping(value = "/signUpUser", method = RequestMethod.POST)
	public void newUser(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("signUpBean") User signUpBean) {

		try {
			
			if (this.userJDBC.insertNewUser(signUpBean)) {
				HttpSession session = request.getSession();
				session.setAttribute("loggedInUser", signUpBean.getUserName());

				// return redirect();
				response.sendRedirect("/table");
			} else {
				request.setAttribute("message", "Please Try Again");
				response.sendRedirect("/login");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
