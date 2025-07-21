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
