import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Book[] archive = new Book[11];
        archive[0] = new Book("Чудесатая_долина", "Дж.Корн", "Фольклор", 2015);
        archive[0].copy = 12;
        archive[1] = new Book("Симфония_грифа", "Г.Норленко", "Музыка", 2021);
        archive[1].copy = 7;
        archive[2] = new Book("Приключения_дворецкого", "Е.Ушакова", "Детектив", 2008);
        archive[2].copy = 23;
        archive[3] = new Book("Развивайся_сам", "Р.Осадчев", "Карьера", 2023);
        archive[3].copy = 2;
        archive[4] = new Book("Зеркальное_озеро", "С.Квинсо", "Ужасы", 1998);
        archive[4].copy = 16;
        archive[5] = new Book("Жаргон_сегодня", "П.Петрогорский", "Языкознание", 2022);
        archive[5].copy = 7;
        archive[6] = new Book("Подземелье_ангела", "А.Цургеш", "Приключения", 2009);
        archive[6].copy = 11;
        archive[7] = new Book("Корзинка_пика._Часть_4", "О.Настюшкена", "Кулинария", 2017);
        archive[7].copy = 13;
        archive[8] = new Book("Чайник_для_Pascal", "Л.Ростров", "Учебная_литература", 2002);
        archive[8].copy = 4;
        archive[9] = new Book("Легенда_Романовых", "И.Деркин", "История", 2015);
        archive[9].copy = 19;
        archive[10] = new Book("Затмение_тумана", "Е.Костюнин", "Роман", 2013);
        archive[10].copy = 8;

        System.out.println("Приветствуем Вас, покупатель, в нашей книжной лавке \"Домовушка\"!" +
                " Вы хотите что-нибудь приобрести или продать?\n" +
                " Нажмите 1, если Вы желаете купить заинтересовавшую Вас книгу;\n" +
                " Нажмите 2, если Вы желаете продать книгу;\n" +
                " И любой другой символ в противном случае.");
        var an = sc.nextLine();;
        while (an.equals("1") || an.equals("2")) {
            if (an.equals("1")) {
                System.out.println("Вводите данные о книге.");
                Book nb = new Book();
                System.out.print("Название: ");
                nb.name = sc.next();
                System.out.print("Автор: ");
                nb.author = sc.next();
                System.out.print("Жанр: ");
                nb.genre = sc.next();
                System.out.print("Год: ");
                nb.year = sc.nextInt();
                boolean fl = false;
                for (int i=0;i< archive.length;i++)
                {
                    if (archive[i].name.equals(nb.name) && archive[i].author.equals(nb.author) &&
                            archive[i].genre.equals(nb.genre) && archive[i].year==nb.year) {
                        if (archive[i].copy > 0) {
                            archive[i].copy -= 1;
                            System.out.println("Поздравляем с покупкой!");
                        } else System.out.println("Сожалеем, но экземпляр данной книги отсутствует.");
                        fl = true;
                    }
                }
                if (!fl)
                    System.out.println("К сожалению, данной книги нет в нашей лавке...");
            }
            else {
                System.out.println("Вводите данные о книге.");
                Book nb = new Book();
                System.out.print("Название: ");
                nb.name = sc.next();
                System.out.print("Автор: ");
                nb.author = sc.next();
                System.out.print("Жанр: ");
                nb.genre = sc.next();
                System.out.print("Год: ");
                nb.year = sc.nextInt();
                boolean flag = false;
                for (int i = 0; i < archive.length; i++) {
                    if (archive[i].name.equals(nb.name) && archive[i].author.equals(nb.author) &&
                            archive[i].genre.equals(nb.genre) && archive[i].year==nb.year) {
                        archive[i].copy += 1;
                        flag = true;
                    }
                }
                if (!flag)
                {
                    Book[] add = archive;
                    archive = new Book[add.length+1];
                    for (int j=0;j<archive.length;j++)
                    {
                        if (j!=archive.length-1)
                            archive[j] = add[j];
                        else {
                            archive[j] = nb;
                            archive[j].copy = 1;
                        }
                    }
                }
                System.out.println("Благодарим Вас за продажу необходимого издания!\nХотите посмотреть наш перечень?\n" +
                        " Нажмите 1, если да;\n" +
                        " И любой другой символ в противном случае.");
                if (sc.next().equals("1"))
                {
                    for (int i=0;i<archive.length;i++)
                        System.out.println("\""+archive[i].name+"\" "+archive[i].author+", "+
                                archive[i].genre+", "+archive[i].year+" г.");
                }
            }
            System.out.println("Вы хотите что-нибудь приобрести или продать?");
            an = sc.next();
        }
        System.out.println("До свидания!");
    }
}
class Book {
    String name;
    String author;
    String genre;
    int year;
    int copy;

    Book() {
        this.name = "";
        this.author = "";
        this.genre = "";
        this.year = 0;
        this.copy = 0;
    }
    Book(String name, String author, String genre, int year)
    {
        this.name = name;
        this.author = author;
        this.genre = genre;
        this.year = year;
        this.copy = 0;
    }
}