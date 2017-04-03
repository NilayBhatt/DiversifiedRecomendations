package edu.ccsu.weka;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import edu.ccsu.dao.RatingsJDBC;
import edu.ccsu.model.Rating;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;

public class UserInstance {
	private ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	private RatingsJDBC ratingsJDBC = (RatingsJDBC) context.getBean("RatingsJDBC");
	
	
	public Instance createUserInstance(Instances trainingInstances, String userName) {
		
		Instance dummyUserInstance = new DenseInstance(trainingInstances.numAttributes());
	    dummyUserInstance.setDataset(trainingInstances);
	    
	    List<Rating> userCurrentRatings = ratingsJDBC.getCurrentUserRatings(userName);
	    
	    for(Rating r : userCurrentRatings) {
	    	//did the divide by two to get the rating out of 5.
	    	dummyUserInstance.setValue(trainingInstances.attribute(r.getMovieID()).index() , Double.parseDouble(r.getUserRating())/2);
	    }
	    
	    return dummyUserInstance;
	}

}
