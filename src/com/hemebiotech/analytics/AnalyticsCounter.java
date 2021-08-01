package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {

	public static void main(String args[]) throws Exception {
		// first get input
		BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
		String line = reader.readLine();

		Map<String, Integer> symptomName = new TreeMap<String, Integer>();

		int i = 0;	// set i to 0
		//int headCount = 0;	// counts headaches
		while (line != null) {
			if (!line.isEmpty()) {
				if (symptomName.containsKey(line)) {
					symptomName.put(line, symptomName.get(line) + 1);
				} else {
					symptomName.put(line, 1);
				}
			}
			line = reader.readLine();	// get another symptom
		}

		System.out.println("There are " + symptomName.size() + " symptoms in the file");
		for (Map.Entry<String, Integer> pair : symptomName.entrySet()) {
			System.out.println("Number of symptom \"" + pair.getKey() +"\" : " + pair.getValue());
		}

		// next generate output
		FileWriter writer = new FileWriter ("result.out");
		for (Map.Entry<String, Integer> pair : symptomName.entrySet()) {
			writer.write(pair.getKey() + " = " + pair.getValue() + "\n");
		}
		writer.close();
	}
}
