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
