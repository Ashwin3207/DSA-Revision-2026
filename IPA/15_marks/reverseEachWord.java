import java.util.Scanner;

class reverseEachWord {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String sent = sc.nextLine();

        String [] words = sent.split("\\s+");

        for(String word : words)
        {
            System.out.print(revWord(word)+" ");
        }


    }

    public static StringBuilder revWord(String word)
    {
        StringBuilder sb = new StringBuilder();
        int n = word.length()-1;
        for(int i=n;i>=0;i--)
        {
            sb.append(word.charAt(i));
        }

        return sb;
    }
}
