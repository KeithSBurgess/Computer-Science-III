package cs244.robward;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Main {

	public static void main(String[] args) {

		ArrayList<Student> students = new ArrayList<Student>();
		
		
		loadFile("StudentsGrades.txt", students);
		students.sort(null);
		students.forEach(value -> System.out.println(value));
		Heap<Student> heap = new Heap<>();
		students.forEach(value -> heap.add(value));

		//System.out.println(heap.toArrayList());
		while (!heap.isEmpty()) {
			System.out.println(heap.pop());
		}
	}

	public static void loadFile(String fileName, ArrayList<Student> update) {

		// This will reference one line at a time
		String line = null;

		try {
			// FileReader reads text files in the default encoding.
			FileReader fileReader = new FileReader(fileName);

			// Always wrap FileReader in BufferedReader.
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while ((line = bufferedReader.readLine()) != null) {

				String fields[] = line.split(",");

				Student student = new Student(fields[0], fields[1], fields[2]);
				for (int i = 3; i < 8; i++) {
					student.addGrade(Double.parseDouble(fields[i]));
				}
				update.add(student);
			}

			// Always close files.
			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");

		}
	}

}
