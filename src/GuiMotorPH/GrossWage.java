package GuiMotorPH;

import java.util.List;
import java.util.Scanner;

import static GuiMotorPH.Calculation.decimalFormat;

public class GrossWage {
    public static String targetEmployeeID;
    public static String employeeName;
    private static String employeeID;
    public static int targetMonth;
    public static double gross;
    private static double hourly;
    public static double hours;

    public double calculate() {
        List<Employee> employees = EmployeeRecords.getEmployeeModelList();
        Scanner sc = new Scanner(System.in);

        // Asks for User Input.
        System.out.println("-------------------------");
        System.out.print("Enter Employee #: ");
        targetEmployeeID = sc.next();
        System.out.println("-------------------------");
        System.out.println("Enter Month: ");
        targetMonth = sc.nextInt();
        System.out.println("-------------------------");

        // Read all rows from the txt file
        // Find the hourly rate for the chosen employee ID
        for (Employee employee : employees) {
            if (employee.getEmployeeNumber().equals(getTargetEmployeeID())) {
                setHourly(employee.getHourlyRate());
                setHourly(getHourly());
                employeeID = employee.getEmployeeNumber();
                if (isValidDecimal(Double.toString(getHourly()))) {
                    double HourlyRate = employee.getHourlyRate();
                    long hour = Attendance.calculateTotalHoursAndPrint(2022, getTargetMonth(), getTargetEmployeeID());
                    double hoursCalculated = HourlyRate * hour;

                    setHourly(HourlyRate);
                    hours = hour;
                    gross = hoursCalculated;
                    employeeName = employee.getFirstName() + employee.getLastName();
                } else {
                    System.out.println("Invalid hourly rate for Employee ID " + getEmployeeID() + ": " + getHourly());
                    System.out.println();
                }

                return gross;
            }
        }

        System.out.println("Employee ID " + getEmployeeID() + " not found.");
        return gross;
    }

    public static void printGross(){
        System.out.println("""
                ------------------------------------------           
                Employee ID: %s
                Name: %s
                Hourly Rate: $%.2f
                Total Hours: %s
                Gross Wage: $%s
                ------------------------------------------
                """.formatted(getEmployeeID(),
                employeeName, getHourly(),
                hours,
                decimalFormat.format(gross)
        ));
    }

    private static boolean isValidDecimal(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static String getTargetEmployeeID() {
        return targetEmployeeID;
    }

    public static int getTargetMonth() {
        return targetMonth;
    }

    public static String getEmployeeID() {
        return employeeID;
    }

    public static double getHourly() {
        return hourly;
    }

    public static void setHourly(double aHourly) {
        hourly = aHourly;
    }
}
