package edu.ccsu.weka;

import java.util.Comparator;
import java.util.TreeMap;

import weka.classifiers.Classifier;
import weka.classifiers.lazy.IBk;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.neighboursearch.NearestNeighbourSearch;

public abstract class MiningAlgorithm {

	protected NearestNeighbourSearch nnSearch;

	protected TreeMap<String, Double> getRawRecommendations(Instances trainingInstances, Instance passedInstance,
			Classifier currentClassifier) throws Exception {
		TreeMap<String, Double> recommendations = new TreeMap(Comparator.naturalOrder().reversed());
		Instances currentTrainInstances = trainingInstances;
		// If KNN only do nearest neighbor comparison once
		if (currentClassifier instanceof IBk) {
			IBk knnClassifier = (IBk) currentClassifier;
			currentTrainInstances = this.nnSearch.kNearestNeighbours(passedInstance, knnClassifier.getKNN());
		}
		// Go through each rating
		for (int attrIndex = 1; attrIndex < passedInstance.numAttributes(); attrIndex++) {
			// Only predict rating for missing attributes
			if (passedInstance.isMissing(attrIndex)) {
				currentTrainInstances.setClassIndex(attrIndex);
				currentClassifier.buildClassifier(currentTrainInstances);

				double predictedRating = currentClassifier.classifyInstance(passedInstance);
				String movieId = currentTrainInstances.attribute(attrIndex).name();

				recommendations.put(movieId, predictedRating);
			}
		}

		return recommendations;
	}
}
