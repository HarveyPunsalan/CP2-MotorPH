package GuiMotorPH;

public class Philhealth extends Calculation {
    private static double philhealthDeduction;

    @Override
    public double calculate() {
        double gross = GrossWage.gross;
        double PhilDed;

        // If gross is more than 60,000 limit philhealth deduction to 1,800 max
        if (gross > 60000) {
            PhilDed = 1800;
        } else {
            PhilDed = (gross * 0.03) / 2; //
        }
        // To store the Philhealth deduction value and return it
        philhealthDeduction = PhilDed;
        return philhealthDeduction;
    }
}

