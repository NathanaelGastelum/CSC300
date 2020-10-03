import java.util.ArrayList;

public class WildCardTester {

    public static void main(String[] args) {
        ArrayList<Animal> animal = new ArrayList();
        ArrayList<RedCat> redCat = new ArrayList();

        addCat(animal,"Tiger");
        addCat(redCat,"Tom");
        addCat(redCat,"Siamese");
        addCat(redCat,"Tiger");

        System.out.println("The list of animals:");
        printAll(animal);
        System.out.println("The list of redCats:");
        printAll(redCat);

        deleteCat(redCat, "Tom");
        printAll(redCat);
    }

    public static void addCat(ArrayList<? super RedCat> list, String name) {
        list.add(new RedCat(name));
        System.out.printf("Cat Added named %s was added\n", name);
    }

    public static void deleteCat(ArrayList<? extends RedCat> list, String name) {
        Cat deletedCat = null;
        for (Cat cat : list) {
            if (cat.toString().equals(name)) {
                deletedCat = cat;
            }
        }
        list.remove(deletedCat);
        System.out.printf("Removed cat named %s", name);
    }

    public static void printAll(ArrayList<?> list) {
        for (Object o : list) {
            System.out.printf("%s ", o.toString());
        }
        System.out.println();
    }
}
