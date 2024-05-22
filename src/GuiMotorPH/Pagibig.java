package GuiMotorPH;

public class Pagibig extends Calculation {
    private static double pagibigDeduction;

    @Override
    public double calculate(){
        double gross = GrossWage.gross;
        double pagibig;

        // Conditional statement to calculate the Pagibig deduction based on gross wage range
        if (gross > 1000.00 && gross <= 1500.00) {
            pagibig = gross * 0.03;
        } else {
            pagibig = gross * 0.04;
        }

        // Maximum amount must not exceed 100.
        if (pagibig > 100) {
            pagibig = 100;
        }
        // To store the Pagibig deduction value and return it
        return pagibigDeduction = pagibig;
    }

}

