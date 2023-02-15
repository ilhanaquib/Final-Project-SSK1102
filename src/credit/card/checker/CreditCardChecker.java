
package credit.card.checker;
import java.util.Scanner;

public class CreditCardChecker {


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Your Credit Card Number : ");
        long number = input.nextLong();
        System.out.println(number + " is " + (isValid(number) ? "valid" : "invalid"));
    }
    
    public static int sumOfDoubleEvenPlace(long number){
        String a = String.valueOf(number);// converterd to string
        int sum = 0;
        for(int i = getSize(number)-2;i>=0;i-=2){//start 14
        sum += getDigit(Integer.parseInt(a.charAt(i) + "")*2);
        }

        return sum;
    }
    
    public static boolean prefixMatched(long number, int d) {
        return getPrefix(number, getSize(d)) == d;
    }

    public static long getPrefix(long number, int k) {
        if (getSize(number) > k) {
        String num = number + "";
        return Long.parseLong(num.substring(0, k));
        }
        return number;
    }

    public static boolean isValid(long number) {
        boolean valid =
        (getSize(number) >= 13 && getSize(number) <= 16) &&
        (prefixMatched(number, 4) || prefixMatched(number, 5) ||
        prefixMatched(number, 37) || prefixMatched(number, 6)) &&
        ((sumOfDoubleEvenPlace(number) + sumOfOddPlace(number)) % 10 == 0);
        return valid;
    }

    public static int sumOfOddPlace(long number){
        String a = String.valueOf(number);// converterd to string
        int sum = 0;
        for(int i = getSize(number)-1;i>=0;i-=2){//start 14
        sum += getDigit(Integer.parseInt(a.charAt(i) + ""));
        }

        return sum;
    }
    public static int getSize(long number){
        String a = String.valueOf(number);//converted to string
        int length = a.length();
        return length;//return 16 as int
    }
    
    public static int getDigit(int number){
        if(number<9){
        return number;
        }
            else{
            return number / 10 + number % 10;//seperate number
        }
    }

    
}
