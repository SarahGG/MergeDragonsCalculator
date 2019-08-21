import java.util.Scanner;

class ResponseCollector {

    // delivers a prompt, and then collects the next int response from the user
    int collectIntResponse(Scanner scanner, String collectionPrompt) {
        System.out.println(collectionPrompt);
        return scanner.nextInt();
    }

    // delivers a prompt and collects the next int response for as many times as requested.
    int[] collectIntArrayResponses(Scanner scanner, int responsesNeeded) {
        int[] intResponses = new int[responsesNeeded];

        for (int i = responsesNeeded - 1; i >= 0; --i) {
            intResponses[i] = collectIntResponse(scanner,"\nHow many Lvl " + (i + 1) + " items do you already have?");
        }

        return intResponses;
    }
}
