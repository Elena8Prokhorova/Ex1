import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите целое неотрицательное число: ");
        var a = sc.nextLong();
        System.out.println();
        if (a<10)
            System.out.println("Данное число является палиндромом");
        else {
            var l = Long.toString(a).length();
            int f = 0;
            for (int j=0;j<(l/2);j++)
            {
                if (Long.toString(a).charAt(j) == Long.toString(a).charAt((l-1)-j))
                    f++;
            }
            if (f == (l/2))
                System.out.println("Данное число является палиндромом");
            else {
                l /= 2;
                double k = Math.pow(10,l);
                long min = 0;
                long max = 0;
                boolean flag = false;
                long i = a-1;
                while (!flag && i>=(a-k))
                {
                    int f1 = 0;
                    for (int j=0;j<Long.toString(i).length()/2;j++) {
                        if (Long.toString(i).charAt(j) == Long.toString(i).charAt((Long.toString(i).length() - 1) - j))
                            f1++;
                    }
                    if (f1 == (Long.toString(i).length() / 2)) {
                        min = i;
                        flag = true;
                    }
                    i--;
                }
                i = a+1;
                flag=false;
                while (!flag && i<=(a+k))
                {
                    int f2 = 0;
                    for (int j=0;j<Long.toString(i).length()/2;j++) {
                        if (Long.toString(i).charAt(j) == Long.toString(i).charAt((Long.toString(i).length() - 1) - j))
                            f2++;
                    }
                    if (f2 == (Long.toString(i).length()/2))
                    {
                        max = i;
                        flag=true;
                    }
                    i++;
                }
                if ((a-min)<(max-a))
                    System.out.println("Ближайший к данному числу палиндром: "+min);
                else if ((a-min)>(max-a))
                    System.out.println("Ближайший к данному числу палиндром: "+max);
                else System.out.println("Ближайшие к данному числу палиндромы: "+min+" и "+max);
            }
        }
    }
}