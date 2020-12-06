import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProcessInvoices {

    public static void main(String[] args) {
	    Invoice[] invoices = new Invoice[]{
	            new Invoice(83, "Electric Sander", 7, 57.98),
                new Invoice(24, "Power saw", 18, 99.99),
                new Invoice(7, "Sledge hammer", 11, 21.50),
                new Invoice(77, "Hammer", 76, 11.99),
                new Invoice(39, "Lawn mower", 3, 79.50),
                new Invoice(68, "Screwdriver", 106, 6.99),
                new Invoice(56, "Jig saw", 21, 11.00),
                new Invoice(3, "Wrench", 34, 7.50)
        };

        List<Invoice> list = Arrays.asList(invoices);

        System.out.println("Invoices sorted by part description:");
        list.stream().sorted(Comparator.comparing(Invoice::getPartDescription)).forEach(System.out::println);

        System.out.println("\nInvoices sorted by price:");
        list.stream().sorted(Comparator.comparing(Invoice::getPrice)).forEach(System.out::println);

        System.out.println("\nInvoices mapped to description and quantity:");
        Map<String, Integer> partQuantities = list.stream()
                .collect(Collectors.toMap(Invoice::getPartDescription, Invoice::getQuantity));

        partQuantities.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(x -> System.out.printf("Description: %-15s Quantity: %d\n", x.getKey(), x.getValue()));

        System.out.println("\nInvoices mapped to description and invoice amount:");
        Map<String, Double> partValues = list.stream()
                .collect(Collectors.toMap(Invoice::getPartDescription, x -> x.getQuantity() * x.getPrice()));

        partValues.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(x -> System.out.printf("Description: %-15s Invoice amount: %.2f\n", x.getKey(), x.getValue()));

        System.out.println("\nInvoices mapped to description and invoice amount for invoices in the range 200-500:");
        partValues.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .filter(x -> (x.getValue() >= 200.0 && x.getValue() <= 500))
                .forEach(x -> System.out.printf("Description: %-15s Invoice amount: %.2f\n", x.getKey(), x.getValue()));
    }
}
