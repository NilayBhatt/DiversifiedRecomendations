package edu.ccsu.weka;

import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.gson.Gson;

import edu.ccsu.dao.MovieJDBC;
import edu.ccsu.model.Recommendations;
import weka.classifiers.lazy.IBk;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.neighboursearch.NearestNeighbourSearch;

public class WekaIBk implements MiningAlgorithm {

	private Instances trainingSet;
	private IBk knnClassifier = new IBk();
	private NearestNeighbourSearch nnSearch;

	public WekaIBk(Instances trainingSet, IBk knnClassifier) {
		this.trainingSet = trainingSet;
		this.knnClassifier = knnClassifier;

		this.nnSearch = ((IBk) knnClassifier).getNearestNeighbourSearchAlgorithm();
		try {
			nnSearch.setInstances(trainingSet);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public TreeMap<String, Double> makeRecommendation(Instance passedInstance) {

		TreeMap<String, Double> recommendations = new TreeMap(Comparator.naturalOrder().reversed());
		Instances currentTrainInstances = this.trainingSet;
		try {
			currentTrainInstances = this.nnSearch.kNearestNeighbours(passedInstance, this.knnClassifier.getKNN());
			// Go through each rating
			for (int attrIndex = 1; attrIndex < passedInstance.numAttributes(); attrIndex++) {
				// Only predict rating for missing attributes
				if (passedInstance.isMissing(attrIndex)) {
					currentTrainInstances.setClassIndex(attrIndex);

					this.knnClassifier.buildClassifier(currentTrainInstances);

					double predictedRating = this.knnClassifier.classifyInstance(passedInstance);
					String movieId = currentTrainInstances.attribute(attrIndex).name();

					recommendations.put(movieId, predictedRating);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return recommendations;
	}

	public List<Recommendations> recommendationsToJson(Instance passedInstance) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		MovieJDBC movieJDBC = (MovieJDBC) context.getBean("MovieJDBC");
		
		TreeMap<String, Double> rawRecommendations = makeRecommendation(passedInstance);
		List<Recommendations> recommendations = movieJDBC.listSpecificMovies(rawRecommendations);

		for (Recommendations r : recommendations) {
			r.setRating(rawRecommendations.get(r.getMovieId()));
		}
		
		return recommendations;
	}

}
