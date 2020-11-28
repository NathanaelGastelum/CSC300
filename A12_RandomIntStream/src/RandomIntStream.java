import java.security.SecureRandom;
import java.util.Comparator;
import java.util.stream.Collectors;

public class RandomIntStream {

    public static void main(String[] args) {
        SecureRandom randy = new SecureRandom();

        String oddNumbers =
            randy.ints(50, 1, 1000)
                .filter(x -> x % 2 != 0)
                .mapToObj(String::valueOf)
                .sorted(Comparator.comparingInt(Integer::valueOf))
                .collect(Collectors.joining(" "));

        System.out.println(oddNumbers);
    }
}