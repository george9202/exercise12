import java.util.*;

public class Algorithms {
    //Pascal's Triangle
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the row column: ");
        int column = scanner.nextInt();
        System.out.print("Enter the row number: ");
        int row = scanner.nextInt();
        var x = GetPasVal(column, row);
        System.out.println("The value you were looking for in Pascal's Triangle is: " + x);

        System.out.println("Now for the Balanced exercise");
        System.out.print("Please type your input: ");
        String input  = scanner.next();
        boolean result = isBalanced(input);
        System.out.println(result);

    }

    public static long GetPasVal(int col, int row)
    {
        int factOfRow = 1,i;
        for(i = 1;i<=(row - 1);i++)
            factOfRow *= i;
        int factOfRowMinusCol = 1;
        for(i = 1;i<=(row - 1)- (col - 1);i++)
            factOfRowMinusCol *= i;
        int factOfCol = 1;
        for(i = 1;i<= (col - 1);i++)
            factOfCol *=i;
        return factOfRow / (factOfCol * factOfRowMinusCol);
    }


    public static boolean isBalanced(String str) {
        int count = 0;

        for (int i = 0; i < str.length() && count >= 0; i++) {
            if (str.charAt(i) == '(')
                count++;
            else if (str.charAt(i) == ')')
                count--;
        }

        return count == 0;
    }
}

