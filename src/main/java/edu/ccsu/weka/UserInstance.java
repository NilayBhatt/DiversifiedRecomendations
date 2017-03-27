package edu.ccsu.weka;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.ModelAttribute;

import edu.ccsu.dao.RatingsJDBC;
import edu.ccsu.dao.UserJDBC;
import edu.ccsu.model.Rating;
import edu.ccsu.model.User;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;

public class UserInstance {
	private ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	private RatingsJDBC ratingsJDBC = (RatingsJDBC) context.getBean("RatingsJDBC");
	
	
	public Instance createUserInstance(Instances trainingInstances, String userName) {
		
		Instance dummyUserInstance = new DenseInstance(trainingInstances.numAttributes());
	    dummyUserInstance.setDataset(trainingInstances);
	    int numRatingsGiven = 0;
	    
	    List<Rating> userCurrentRatings = ratingsJDBC.getCurrentUserRatings(userName);
	    
	    for(Rating r : userCurrentRatings) {
	    	dummyUserInstance.setValue(Integer.parseInt(r.getMovieID()), Double.parseDouble(r.getUserRating()));
	    }
	    
	    return dummyUserInstance;
	}

}
