import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BasePlusCommissionEmployeeTest {

    //TODO change to try/catch?
    public static void main(String[] args) throws FileNotFoundException {
        List<CommissionEmployee> commOnlyEmp = new ArrayList();
        List<BasePlusCommissionEmployee> basePlusCommEmp = new ArrayList();

        Scanner s = new Scanner(System.in);

        System.out.println("Please enter the CommissionEmployee text file");

        String inFilePath = s.nextLine();
        File inFile = new File(inFilePath);
        Scanner fileScanner = new Scanner(inFile);

        while (fileScanner.hasNextLine()) {
            String[] nextLine = fileScanner.nextLine().split(" ");
            CommissionEmployee employee = new CommissionEmployee(nextLine[0], nextLine[1], Double.valueOf(nextLine[2]), Double.valueOf(nextLine[3]));
            commOnlyEmp.add(employee);
        }

        System.out.println("Please enter the BasePlusCommissionEmployee text file");

        inFilePath = s.nextLine();
        inFile = new File(inFilePath);
        fileScanner = new Scanner(inFile);

        while (fileScanner.hasNextLine()) {
            String[] nextLine = fileScanner.nextLine().split(" ");
            BasePlusCommissionEmployee employee = new BasePlusCommissionEmployee(nextLine[0], nextLine[1], Double.valueOf(nextLine[2]), Double.valueOf(nextLine[3]), Double.valueOf(nextLine[4]));
            basePlusCommEmp.add(employee);
        }

        System.out.println("Please enter the output filename");

        String outFileName = s.nextLine() + ".txt";
        PrintWriter outFile = new PrintWriter(outFileName);

        outFile.write("Statistics On Commission Only Employees\n");
        outFile.write(String.format("%-10s %-10s %-10s", "FNAME", "LNAME", "Total Compensation\n"));
        double totalEarnings = 0.0;
        for (CommissionEmployee employee : commOnlyEmp){
            outFile.write(String.format("%-10s %-10s $%.2f\n", employee.getFirstName(), employee.getLastName(), employee.earnings()));

            totalEarnings += employee.earnings();
        }
        outFile.write(String.format("Total Compensation For Commission Only Employees Is: $%.2f\n\n", totalEarnings));

        outFile.write("Statistics On Base Pay Plus Commission Employees\n");
        outFile.write(String.format("%-10s %-10s %-10s", "FNAME", "LNAME", "Total Compensation\n"));
        totalEarnings = 0.0;
        for (BasePlusCommissionEmployee employee : basePlusCommEmp){
            outFile.write(String.format("%-10s %-10s $%.2f\n", employee.getFirstName(), employee.getLastName(), employee.earnings()));

            totalEarnings += employee.earnings();
        }
        outFile.write(String.format("Total Compensation For Base Plus Commission Employees Is: $%.2f\n", totalEarnings));

        outFile.close();
    }
}