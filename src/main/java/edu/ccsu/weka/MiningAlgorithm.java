package edu.ccsu.weka;

import java.util.TreeMap;

import weka.core.Instance;

public interface MiningAlgorithm {

	TreeMap<String, Double> makeRecommendation(Instance passedInstance);
}
