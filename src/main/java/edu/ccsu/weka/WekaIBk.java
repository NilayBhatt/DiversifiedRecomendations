package edu.ccsu.weka;

import java.util.Comparator;
import java.util.TreeMap;

import weka.classifiers.lazy.IBk;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.neighboursearch.NearestNeighbourSearch;

public class WekaIBk implements MiningAlgorithm {

	private Instances trainingSet;
	private IBk knnClassifier = new IBk();
	private NearestNeighbourSearch nnSearch;

	public WekaIBk(Instances trainingSet) {
		this.trainingSet = trainingSet;
		this.setUpClassifier();
	}

	@Override
	public TreeMap<Double, String> MakeRecommendation(Instance passedInstance) {

		TreeMap<Double, String> recommendations = new TreeMap(Comparator.naturalOrder().reversed());
		Instances currentTrainInstances = this.trainingSet;
		try {
			currentTrainInstances = nnSearch.kNearestNeighbours(passedInstance, knnClassifier.getKNN());
			// Go through each rating
			for (int attrIndex = 1; attrIndex < passedInstance.numAttributes(); attrIndex++) {
				// Only predict rating for missing attributes
				if (passedInstance.isMissing(attrIndex)) {
					currentTrainInstances.setClassIndex(attrIndex);

					this.knnClassifier.buildClassifier(currentTrainInstances);

					double predictedRating = knnClassifier.classifyInstance(passedInstance);
					recommendations.put(predictedRating, attrIndex + "");
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return recommendations;
	}

	private void setUpClassifier() {
		trainingSet.setClassIndex(trainingSet.numAttributes() - 1);
		try {
			knnClassifier.buildClassifier(trainingSet);
			nnSearch = knnClassifier.getNearestNeighbourSearchAlgorithm();
			nnSearch.setInstances(trainingSet);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void recommendationsToJson() {
		
	}

}
