public class Dinosaur {

    static int dinoCounter = 1;
    private String dinoName;
    private int dinoWeight;

    Dinosaur() {
        dinoName = "Barney";
    }

    Dinosaur(int dinoWeight) {
        setDinoWeight(dinoWeight);
        dinoName = "DINO" + dinoCounter;
        dinoCounter++;
    }

    public int getDinoWeight() {
        return dinoWeight;
    }

    public void setDinoWeight(int dinoWeight) {
        this.dinoWeight = dinoWeight;
    }

    @Override
    public String toString() {
        return String.format("%-7s\t%d", dinoName, dinoWeight);
    }
}
