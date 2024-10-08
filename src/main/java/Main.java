
/*
   Мій номер у списку групи - 18.
   С3 = 18 % 3 = 0
   С17 = 18 % 17 = 1
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter a few sentences separated by '. '");
        Scanner sc = new Scanner(System.in);
        String sentence = sc.nextLine();

        StringBuilderHandler stringBuilderHandler = new StringBuilderHandler();
        stringBuilderHandler.displaySentencesInWordsCountOrder(new StringBuilder(sentence));
    }
}
