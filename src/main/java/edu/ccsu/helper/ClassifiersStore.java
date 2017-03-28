package edu.ccsu.helper;

import java.util.Comparator;
import java.util.TreeMap;

import weka.classifiers.Classifier;
import weka.classifiers.lazy.IBk;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.core.neighboursearch.NearestNeighbourSearch;

public class ClassifiersStore {

	private Classifier knnClassifier;
	private TreeMap<String, Classifier> classifiers = new TreeMap(Comparator.naturalOrder().reversed());;

	public TreeMap<String, Classifier> getClassifiers() {
		return classifiers;
	}

	public String getTrainingFile() {
		return trainingFile;
	}

	public DataSource getSource() {
		return source;
	}

	public Instances getInstances() {
		return instances;
	}

	private static ClassifiersStore singletonInstance = null;

	private String trainingFile = "src/main/resources/data/user_ratedmovies.arff";
	private DataSource source;
	private Instances instances;

	private ClassifiersStore() {
		try {
			source = new DataSource(trainingFile);
			instances = source.getDataSet();
			
			setUpIBkClassifier(this.instances);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static ClassifiersStore getInstance() {
		if (singletonInstance == null) {

			singletonInstance = new ClassifiersStore();
		}

		return singletonInstance;
	}

	private void setUpIBkClassifier(Instances trainingSet) {
		trainingSet.setClassIndex(trainingSet.numAttributes() - 1);
		try {
			this.knnClassifier = new IBk();
			
			this.knnClassifier.buildClassifier(trainingSet);
			
			this.classifiers.put("IBK", this.knnClassifier);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
