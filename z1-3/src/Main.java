import java.util.Scanner;

public class Main {
    private static boolean thisIsPalindrome(long number)
    {
        var textNumber = Long.toString(number);
        var length = textNumber.length();
        int replays = 0;
        for (int i = 0; i<(length/2);i++) {
            if (textNumber.charAt(i) == textNumber.charAt(length - 1 - i))
                replays++;
        }
        return replays == length/2;
    }

    private static long[] findPalindromes(long number)
    {
        double ambit = Math.pow(10, Long.toString(number).length()/2);
        long numberLess = number-1;
        long numberMore = number+1;
        boolean flagLessPalindrome = false;
        boolean flagMorePalindrome = false;
        long lessPalindrome = 0;
        long morePalindrome = 0;
        while ((numberLess>=number-ambit) && (numberMore<=number+ambit) && !(flagLessPalindrome && flagMorePalindrome)) {
            if (thisIsPalindrome(numberLess) && !flagLessPalindrome) {
                lessPalindrome = numberLess;
                flagLessPalindrome = true;
            }
            if (thisIsPalindrome(numberMore) && !flagMorePalindrome) {
                morePalindrome = numberMore;
                flagMorePalindrome = true;
            }
            numberLess--;
            numberMore++;
        }
        return new long[] {lessPalindrome, morePalindrome};
    }

    private static void outputResult (long number, long minPalindrome, long maxPalindrome)
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
        if (thisIsPalindrome(number))
            System.out.println("Данное число является палиндромом");
        else {
            long[] palindromes = findPalindromes(number);
            outputResult(number, palindromes[0], palindromes[1]);
        }
    }
}