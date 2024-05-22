package GuiMotorPH;

public class NetWage extends Calculation {
    @Override
    public double calculate() {
        // Initialize instances of each Java.class for usage.
        SSS sss = new SSS();
        Philhealth philhealth = new Philhealth();
        Pagibig pagibig = new Pagibig();
        WithholdingTax withholdingTax = new WithholdingTax();
        GrossWage grossWage = new GrossWage();
        LatePenalty latePenalty = new LatePenalty();

        // Call GrossWage calculation to prepare necessary values.
        grossWage.calculate();

        // Call the calculate() method of each class and assign their values to temporary variables.
        double sssData = sss.calculate();
        double philhealthData = philhealth.calculate();
        double pagibigData = pagibig.calculate();
        double lateData = latePenalty.calculate();
        double totalDeduction = sssData + philhealthData + pagibigData + lateData;

        double net = withholdingTax.calculate();

        // Gets the value of taxableIncome and tax to be used for printing.
        double taxableIncome = WithholdingTax.taxableIncome;
        double tax = WithholdingTax.tax;

        // This is used to Print the net wage along with other details
        System.out.println("""
                ------------------------------------------
                Employee ID: %s
                Employee Name: %s
                ------------------------------------------
                Total Hours: %s               
                Gross Wage: $%s

                SSS Deduction: $%s
                Philhealth Deduction: $%s
                Pag-Ibig Deduction: $%s                       
                Late Deductions: $%s

                Total Deductions: $%s                                  

                Taxable Income: $%s

                Withholding Tax: $%s

                Net Wage: $%s
                ------------------------------------------
                """.formatted(GrossWage.getEmployeeID(),
                GrossWage.employeeName,
                GrossWage.hours,
                decimalFormat.format(GrossWage.gross),
                decimalFormat.format(sssData),
                decimalFormat.format(philhealthData),
                decimalFormat.format(pagibigData),
                decimalFormat.format(lateData),
                decimalFormat.format(totalDeduction),
                decimalFormat.format(taxableIncome),
                decimalFormat.format(tax),
                decimalFormat.format(net)
        ));
        return net;  // Return the net wage
    }
}


