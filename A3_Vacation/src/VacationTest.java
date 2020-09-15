public class VacationTest {

    public static void main(String[] args) {
        AllInclusiveVacation aiv1 = new AllInclusiveVacation("Orlando", 1000.00 , "Disney", 4, 989.49);
        System.out.println("The first all-inclusive vacation is:");
        System.out.println(aiv1.toString());
        if (aiv1.overBudget() > 0) {
            System.out.printf("It is under budget by $%.2f \n", aiv1.overBudget());
        } else {
            System.out.printf("It is over budget by $%.2f \n", -1 * aiv1.overBudget());
        }

        AllInclusiveVacation aiv2 = new AllInclusiveVacation( "Bahamas", 2000.00, "ClubMed", 4, 2049.99);
        System.out.println("\nThe second all-inclusive vacation is:");
        System.out.println(aiv2.toString());
        if (aiv2.overBudget() > 0) {
            System.out.printf("It is under budget by $%.2f \n", aiv2.overBudget());
        } else {
            System.out.printf("It is over budget by $%.2f \n", -1 * aiv2.overBudget());
        }

        aiv2.setBrand("Disney");
        aiv2.setPrice(989.49);

        System.out.println();
        if (aiv1.equals(aiv2)) {
            System.out.println("aiv1 and aiv2 are now equal");
        }
        else {
            System.out.println("aiv1 and aiv2 are not equal");
        }

        aiv2.setDestination("Orlando");
        aiv2.setBudget(1000.00);

        if (aiv1.equals(aiv2)) {
            System.out.println("aiv1 and aiv2 are now equal");
        }
        else {
            System.out.println("aiv1 and aiv2 are not equal");
        }

        String[] itemsList1 = { "hotel", "meals", "airfare", "windsurfing" };
        double[] costsList1 =  { 750.00, 250.00, 400.00 };

        PieceMealVacation pmv1 = new PieceMealVacation("Miami", 1500.00, itemsList1, costsList1);
        System.out.println("\nThe first piecemeal vacation is:");
        System.out.println(pmv1.toString());
        if (pmv1.overBudget() > 0) {
            System.out.printf("It is under budget by $%.2f \n", pmv1.overBudget());
        } else {
            System.out.printf("It is over budget by $%.2f \n", -1 * pmv1.overBudget());
        }

        String[] itemsList2 = {  "hotel", "meals", "airfare", "windsurfing" };
        double[] costsList2 =  { 750.00, 250.00, 400.00, 120.00, 200.00 };

        PieceMealVacation pmv2 = new PieceMealVacation("Miami", 1500.00, itemsList2, costsList2);
        System.out.println("\nThe second piecemeal vacation is:");
        System.out.println(pmv2.toString());
        if (pmv2.overBudget() > 0) {
            System.out.printf("It is under budget by $%.2f \n", pmv2.overBudget());
        } else {
            System.out.printf("It is over budget by $%.2f \n", -1 * pmv2.overBudget());
        }

        System.out.println();
        if (pmv1.equals(pmv2)) {
            System.out.println("pmv1 and pmv2 are now equal");
        }
        else {
            System.out.println("pmv1 and pmv2 are not equal");
        }

        pmv2.setItems(itemsList1);
        pmv2.setCosts(costsList1);

        if (pmv1.equals(pmv2)) {
            System.out.println("pmv1 and pmv2 are now equal");
        }
        else {
            System.out.println("pmv1 and pmv2 are not equal");
        }
    }
}
