package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import model.BackpackProblem;

/**
 * 
 * @author Beniamin Scridon
 *
 */
public class FileReader {
	
	public static BackpackProblem readFromFile(String fileName) {

		BackpackProblem backpackProblem = new BackpackProblem();

		try (BufferedReader reader = new BufferedReader(new java.io.FileReader(fileName))) {

			ArrayList<model.ObjectBP> objects = new ArrayList<>();

			String next, line = reader.readLine();
			for (boolean first = true, last = (line == null); !last; first = false, line = next) {
				last = ((next = reader.readLine()) == null);

				if (first) {
					backpackProblem.setNumberOfObjects(Integer.parseInt(line));
				} else if (last) {
					backpackProblem.setMaxWeight(Integer.parseInt(line));
				} else {
					objects.add(constructObject(line.trim().split("\\s+")));
				}
			}
			
			backpackProblem.setObjects(objects);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return backpackProblem;
	}

	private static model.ObjectBP constructObject(String[] objectInfo) {
		model.ObjectBP object = new model.ObjectBP();

		object.setId(Integer.parseInt(objectInfo[0]));
		object.setValue(Integer.parseInt(objectInfo[1]));
		object.setWeight(Integer.parseInt(objectInfo[2]));

		return object;
	}
}
