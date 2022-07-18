import java.util.*;
public class test
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a word: ");
        String word = input.next();

        int counter = 5;
        int length = word.length();
        String displayWord = "";
        
        for (int n = 0; n < length; n++) displayWord += '_';

        while (counter > 0) {

            System.out.println("\nMake a guess: ");
            char guess = input.next().charAt(0);
            int position = word.indexOf(guess);
            
            for (; position >= 0; position = word.indexOf(guess, position + 1))
                displayWord = displayWord.substring(0, position) + guess + displayWord.substring(position + 1);
            
            System.out.print(displayWord + " number of guess left: " + counter);
            counter--;
        }
        
        if (!displayWord.equals(word)) System.out.println("\nYou lost the game");
    }
}
