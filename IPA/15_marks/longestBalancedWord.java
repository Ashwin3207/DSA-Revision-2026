import java.util.*;
// A balanced word satisfies all of the following:

// Contains only alphabets.
// Contains at least one vowel.
// Contains at least one consonant.
// Number of vowels == Number of consonants.

// The method should return the longest balanced word.

// If multiple balanced words have the same maximum length, return the one that appears first.

// If no balanced word exists, return "None".

// Sample Input
// sky boat read moon code apple tree
// Output
// boat

public class longestBalancedWord {
    public static int findLongestBalanceWord(String word)
    {
 int vcount =0;
        int ccount =0;

        for(char c : word.toCharArray())
        {
            if(c=='a' ||c=='e' ||c=='i' ||c=='o' ||c=='u' ||c=='A' ||c=='E' ||c=='I' ||c=='O' ||c=='U')
            {
                vcount++;
            }
            else
            {
                ccount++;
            }
            

        }
        if(ccount==vcount)
        {
            return word.length();
        }
        return 0;

    }
    public static void main(String[]args)
    {
        Scanner sc = new Scanner(System.in);

        String sentence = sc.nextLine();

        String[] words = sentence.split(" ");
        String ans = "";
        for(String wh : words)
        {
            if(ans.length()<findLongestBalanceWord(wh))
            {
                ans = wh;
            }
        }

        System.out.println(ans);

        sc.close();
      

       
    }
}
