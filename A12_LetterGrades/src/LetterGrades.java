import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LetterGrades {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ArrayList<Integer> intGrades = new ArrayList<>();

        while (true) {
            System.out.print("Enter grade or -1 to quit: ");
            int nextInt = s.nextInt();

            if (nextInt == -1) {
                break;
            }
            else {
                intGrades.add(nextInt);
            }
        }

        List<String> stringGrades = intGrades.stream().map(grade -> {
                if (grade >= 90) return "A";
                else if (grade >= 80) return "B";
                else if (grade >= 70) return "C";
                else if (grade >= 60) return "D";
                else return "F";
            })
            .collect(Collectors.toList());

        System.out.println("\nGrade Letter");
        for (int i = 0; i < intGrades.size(); i++) {
            System.out.printf("%4s%4s\n", intGrades.get(i), stringGrades.get(i));
        }
    }
}
