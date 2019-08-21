import java.util.Scanner;

public class Main {

    private static ResponseCollector collector;
    private static Scanner scanner;

    public Main() {
        collector = new ResponseCollector();
        scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {

        // asks the user what level ("generation") item they need, and how many of them they need ("population")
        int specifiedGen = collector.collectIntResponse(scanner,"What lvl of item are you trying to obtain?");
        int finalGenPop = collector.collectIntResponse(scanner,"How many do you need?");

        // establishes how many items the user already has at each lvl of "life"
        int[] currentPopByGen = collector.collectIntArrayResponses(scanner,specifiedGen - 1);
    }

}
