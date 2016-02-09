import java.util.*;
import java.io.*;

public class IOLab {
	private double[][] data;
	int nrows;
	int ncols;

	// rows = data.length;
	// cols = data[i].length;

	public static void main(String[] args) throws IOException {
		IOLab fileTest = new IOLab();
		fileTest.readData();
		// fileTest.displayData();
		fileTest.writeData();
	}

	public void readData() throws IOException {

		Scanner console = new Scanner(System.in);
		System.out.print("Please enter a file name to read: ");
		String inFile = console.next();
		try {
			File file = new File(inFile);// connect to the file
			Scanner tokens = new Scanner(file); // buffer the data

			nrows = tokens.nextInt(); // get the number of rows.
			ncols = tokens.nextInt();
			data = new double[nrows][ncols];

			for (int i = 0; i < nrows; i++) {
				for (int j = 0; j < ncols; j++) {
					data[i][j] = tokens.nextDouble();
				}
			}
			System.out.println("Completed reading ");
		}

		catch (Exception e) {
			System.err.println("Error: " + e.getMessage());

		}
		// 4. close the file:file.close();
	} // end readData()

	public void writeData() throws IOException {
		Scanner console = new Scanner(System.in);
		System.out.print("Please enter a file name to write in: ");
		String outFile = console.next();

		File file = new File(outFile);// connect to the file

		if (!file.exists()) {
			file.createNewFile();
			System.out
					.println("New file \"myfile.txt\" has been created to the current directory");
		}

		try {
			// Create file
			FileWriter fstream = new FileWriter(outFile);
			BufferedWriter out = new BufferedWriter(fstream);

			out.write(nrows + "\n");
			out.newLine();
			out.write(ncols + "\n");
			out.newLine();
			for (int i = 0; i < nrows; i++) {
				for (int j = 0; j < ncols; j++) {
					out.write(String.valueOf(data[i][j]) + "\n");
					out.newLine();
				}
			}

			out.write("Alina Rozenbaum");

			// Close the output stream
			out.close();
		}

		catch (Exception e) {
			// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}

	} // end of writeData

} // end class