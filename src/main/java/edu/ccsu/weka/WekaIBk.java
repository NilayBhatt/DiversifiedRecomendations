package edu.ccsu.weka;

import java.util.List;
import java.util.TreeMap;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.ccsu.dao.MovieJDBC;
import edu.ccsu.model.Recommendations;
import weka.classifiers.lazy.IBk;
import weka.core.Instance;
import weka.core.Instances;

public class WekaIBk extends MiningAlgorithm {

	private Instances trainingSet;
	private IBk knnClassifier = null;
	//private NearestNeighbourSearch nnSearch;

	public WekaIBk(Instances trainingSet, IBk knnClassifier) {
		this.trainingSet = trainingSet;
		this.knnClassifier = knnClassifier;

		super.nnSearch = knnClassifier.getNearestNeighbourSearchAlgorithm();
		try {
			super.nnSearch.setInstances(trainingSet);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public List<Recommendations> recommendationsToJson(Instance passedInstance) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		MovieJDBC movieJDBC = (MovieJDBC) context.getBean("MovieJDBC");

		TreeMap<String, Double> rawRecommendations = null;
		List<Recommendations> recommendations = null;
		try {
			rawRecommendations = super.getRawRecommendations(this.trainingSet, passedInstance, this.knnClassifier);
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
