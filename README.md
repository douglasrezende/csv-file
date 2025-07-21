# csv-file

Using FileWriter and BufferedWriter (Basic Approach):
This approach provides fundamental control over file writing and is suitable for simple CSV generation.

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CsvWriterExample {

    public static void main(String[] args) {
        String fileName = "my_data.csv";
        String[] headers = {"Name", "Age", "City"};
        String[][] data = {
                {"Alice", "30", "New York"},
                {"Bob", "25", "London"},
                {"Charlie", "35", "Paris"}
        };

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            // Write headers
            writer.write(String.join(",", headers));
            writer.newLine();

            // Write data rows
            for (String[] row : data) {
                writer.write(String.join(",", row));
                writer.newLine();
            }
            System.out.println("CSV file created successfully at: " + fileName);
        } catch (IOException e) {
            System.err.println("Error writing CSV file: " + e.getMessage());
        }
    }
}




Explanation:

    FileWriter: Used to write character streams to a file.
    BufferedWriter: Wraps the FileWriter to improve performance by buffering output.
    String.join(",", array): Concatenates array elements with a comma as the delimiter.
    writer.newLine(): Writes a platform-specific new line character.
    try-with-resources: Ensures that the BufferedWriter is automatically closed, even if exceptions occur.

Using a Library like OpenCSV (Recommended for Complex Scenarios):
For more robust CSV handling, including quoting, escaping, and various configurations, libraries like OpenCSV are highly recommended.

    Add OpenCSV dependency: If using Maven, add to your pom.xml:


        <dependency>
        <groupId>com.opencsv</groupId>
        <artifactId>opencsv</artifactId>
        <version>5.9</version>
    </dependency>


    
Example with OpenCSV.



    import com.opencsv.CSVWriter;
    import java.io.FileWriter;
    import java.io.IOException;
    import java.util.ArrayList;
    import java.util.List;

    public class OpenCsvWriterExample {

        public static void main(String[] args) {
            String fileName = "my_data_opencsv.csv";

            List<String[]> data = new ArrayList<>();
            data.add(new String[]{"Name", "Age", "City"}); // Headers
            data.add(new String[]{"Alice", "30", "New York"});
            data.add(new String[]{"Bob", "25", "London"});
            data.add(new String[]{"Charlie", "35", "Paris, France"}); // Example with comma in data

            try (CSVWriter writer = new CSVWriter(new FileWriter(fileName))) {
                writer.writeAll(data);
                System.out.println("CSV file created successfully with OpenCSV at: " + fileName);
            } catch (IOException e) {
                System.err.println("Error writing CSV file with OpenCSV: " + e.getMessage());
            }
        }
    }



    
Key Advantages of OpenCSV:

    Handles quoting and escaping of special characters (like commas within data fields) automatically.
    Provides methods for writing single lines (writeNext()) or multiple lines (writeAll()).
    Offers more configuration options (e.g., custom delimiters, quote characters).


