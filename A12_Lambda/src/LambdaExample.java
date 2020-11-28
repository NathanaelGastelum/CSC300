public class LambdaExample {

    public static void main(String[] args) {
        Addable ad1 = (x,y) -> x + y;
        Addable ad2 = (x,y) -> {return x + y;};

        System.out.println("ad1: " + ad1.add(2,2));
        System.out.println("ad2: " + ad2.add(3,2));
    }
}

interface Addable
{
    int add(int a,int b);
}
