package edu.ccsu.weka;

import java.util.List;
import java.util.TreeMap;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.ccsu.dao.MovieJDBC;
import edu.ccsu.model.Recommendations;
import weka.classifiers.lazy.IBk;
import weka.classifiers.lazy.KStar;
import weka.core.Instance;
import weka.core.Instances;

public class WekaKStar extends MiningAlgorithm {
	
	private Instances trainingSet;
	private KStar kStarClassifier = null;

	public WekaKStar(Instances trainingSet, KStar knnClassifier) {
		this.trainingSet = trainingSet;
		this.kStarClassifier = knnClassifier;

	}


	public List<Recommendations> recommendationsToJson(Instance passedInstance) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		MovieJDBC movieJDBC = (MovieJDBC) context.getBean("MovieJDBC");

		TreeMap<String, Double> rawRecommendations = null;
		List<Recommendations> recommendations = null;
		try {
			rawRecommendations = super.getRawRecommendations(this.trainingSet, passedInstance, this.kStarClassifier);
			recommendations = movieJDBC.listSpecificMovies(rawRecommendations);

			for (Recommendations r : recommendations) {
				r.setRating(rawRecommendations.get(r.getMovieId()));
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return recommendations;
	}


}
