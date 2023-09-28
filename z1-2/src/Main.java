import java.util.Scanner;

public class Main {
    private static boolean ThisIsPalindrome(long number)
    {
        var textNumber = Long.toString(number);
        var length = textNumber.length();
        int replays = 0;
        for (int i = 0; i<(length/2);i++) {
            if (textNumber.charAt(i) == textNumber.charAt(length - 1 - i))
                replays++;
        }
        if (replays == length/2)
            return true;
        return false;
    }

    private static long[] FindPalindromes(long number)
    {
        double ambit = Math.pow(10, Long.toString(number).length()/2);
        long number_less = number-1;
        long number_more = number+1;
        boolean flag_1 = false;
        boolean flag_2 = false;
        long minPalindrome = 0;
        long maxPalindrome = 0;
        while ((number_less>=number-ambit) && (number_more<=number+ambit) && !(flag_1 && flag_2)) {
            if (ThisIsPalindrome(number_less) && !flag_1) {
                minPalindrome = number_less;
                flag_1 = true;
            }
            if (ThisIsPalindrome(number_more) && !flag_2) {
                maxPalindrome = number_more;
                flag_2 = true;
            }
            number_less--;
            number_more++;
        }
        long[] palindromes = {minPalindrome, maxPalindrome};
        return palindromes;
    }

    private static void OutputResult (long number, long minPalindrome, long maxPalindrome)
    {
        if (Math.abs(number-minPalindrome)<Math.abs(maxPalindrome-number))
            System.out.println("Ближайший к данному числу палиндром: "+minPalindrome);
        else if (Math.abs(number-minPalindrome)>Math.abs(maxPalindrome-number))
            System.out.println("Ближайший к данному числу палиндром: "+maxPalindrome);
        else System.out.println("Ближайшие к данному числу палиндромы: "+minPalindrome+
                    " и "+maxPalindrome);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите целое неотрицательное число: ");
        var number = sc.nextLong();
        System.out.println();
        if (ThisIsPalindrome(number))
            System.out.println("Данное число является палиндромом");
        else {
            long[] palindromes = FindPalindromes(number);
            OutputResult(number, palindromes[0], palindromes[1]);
        }
    }
}