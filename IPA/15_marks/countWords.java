
// Create a program to count the number of words present in a given string. Create class
// Solution with main method.
// Implement the below static method in Solution class.
// CountWords(String str): The method should take string as an input and return the total
// number of words in the string. If the input is null/empty, return 0.
// Constraints:
// • Words are separated by one or more spaces.
// • Leading and trailing whitespaces should be ignored.
// • Empty string should return 0.
// Sample Input 1:
// “Hello World”
// Sample Output 1:
// 2
// Sample Input 2:
// “ Java is fun”
// Sample Output 2:
// 3
import java.util.*;

public class countWords {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String sentence = sc.nextLine();

        sentence = sentence.trim();
        int count = 0;

        String[] words = sentence.split("\\s+");

        for (String word : words) {
            count++;
        }
        System.out.println(count);

        sc.close();
    }
}
