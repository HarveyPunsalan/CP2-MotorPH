package GuiMotorPH;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRecords {
    // List to store loaded employee data
    private static List<Employee> employeeModelList = new ArrayList<>();

    // Path to the text file containing Employee data
    private static String TXT_FILE_PATH = "src/main/resources/Data.txt";

    // Returns the list of employee data
    public static List<Employee> getEmployeeModelList() {
        return employeeModelList;
    }

    // Loads employee data from the text file
    public static void loadEmployees() {
        // Initialize the list to avoid duplicates when loading multiple times
        employeeModelList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(TXT_FILE_PATH))) {
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                List<String> employeeData = parseTxtLine(currentLine);
                if (employeeData.size() >= 19) { // Assuming you expect 19 fields
                    Employee employee = new Employee(employeeData.toArray(new String[0]));
                    employeeModelList.add(employee);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Parses a line of text into individual data fields
    private static List<String> parseTxtLine(String line) {
        List<String> tokens = new ArrayList<>();
        boolean inQuotes = false;
        StringBuilder buffer = new StringBuilder();
        for (char c : line.toCharArray()) {
            if (c == '"') {
                inQuotes = !inQuotes; // Toggle the inQuotes flag
            } else if (c == ',' && !inQuotes) {
                // End of a token
                tokens.add(buffer.toString());
                buffer = new StringBuilder(); // Reset buffer
            } else {
                buffer.append(c);
            }
        }
        // Add the last token, if any
        if (buffer.length() > 0) {
            tokens.add(buffer.toString());
        }
        return tokens;
    }

    /**
     * Set the path to the text file containing Employee data
     * @param aTXT_FILE_PATH the TXT_FILE_PATH to set
     */
    public static void setTXT_FILE_PATH(String aTXT_FILE_PATH) {
        TXT_FILE_PATH = aTXT_FILE_PATH;
    }
}
