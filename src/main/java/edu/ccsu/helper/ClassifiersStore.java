package edu.ccsu.helper;

import java.util.Comparator;
import java.util.TreeMap;

import weka.classifiers.Classifier;
import weka.classifiers.lazy.IBk;
import weka.classifiers.lazy.KStar;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class ClassifiersStore {

	private Classifier classifier;
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
			setUpKStarClassifier(this.instances);
			
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
			this.classifier = new IBk(20);

			trainingSet.setClassIndex(trainingSet.numAttributes() - 1);
			this.classifier.buildClassifier(trainingSet);
			
			this.classifiers.put("IBK", this.classifier);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void setUpKStarClassifier(Instances trainingSet){
		trainingSet.setClassIndex(trainingSet.numAttributes() - 1);
		try {
			this.classifier = new KStar();

			trainingSet.setClassIndex(trainingSet.numAttributes() - 1);
			this.classifier.buildClassifier(trainingSet);
			
			this.classifiers.put("KStar", this.classifier);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
