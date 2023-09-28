import java.util.Scanner;

public class Main {

    public static ArchivalBook[] GetArchive() {
        ArchivalBook[] archive = new ArchivalBook[11];
        archive[0] = new ArchivalBook("Чудесатая_долина", "Дж.Корн", "Фольклор", 2015);
        archive[0].numberCopies = 12;
        archive[1] = new ArchivalBook("Симфония_грифа", "Г.Норленко", "Музыка", 2021);
        archive[1].numberCopies = 7;
        archive[2] = new ArchivalBook("Приключения_дворецкого", "Е.Ушакова", "Детектив", 2008);
        archive[2].numberCopies = 23;
        archive[3] = new ArchivalBook("Развивайся_сам", "Р.Осадчев", "Карьера", 2023);
        archive[3].numberCopies = 2;
        archive[4] = new ArchivalBook("Зеркальное_озеро", "С.Квинсо", "Ужасы", 1998);
        archive[4].numberCopies = 16;
        archive[5] = new ArchivalBook("Жаргон_сегодня", "П.Петрогорский", "Языкознание", 2022);
        archive[5].numberCopies = 7;
        archive[6] = new ArchivalBook("Подземелье_ангела", "А.Цургеш", "Приключения", 2009);
        archive[6].numberCopies = 11;
        archive[7] = new ArchivalBook("Корзинка_пика._Часть_4", "О.Настюшкена", "Кулинария", 2017);
        archive[7].numberCopies = 13;
        archive[8] = new ArchivalBook("Чайник_для_Pascal", "Л.Ростров", "Учебная_литература", 2002);
        archive[8].numberCopies = 4;
        archive[9] = new ArchivalBook("Легенда_Романовых", "И.Деркин", "История", 2015);
        archive[9].numberCopies = 19;
        archive[10] = new ArchivalBook("Затмение_тумана", "Е.Костюнин", "Роман", 2013);
        archive[10].numberCopies = 8;

        return archive;
    }

    public static Book GetBook() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Вводите данные о книге.");
        Book newBook = new Book();
        System.out.print("Название: ");
        newBook.name = sc.next();
        System.out.print("Автор: ");
        newBook.author = sc.next();
        System.out.print("Жанр: ");
        newBook.genre = sc.next();
        System.out.print("Год: ");
        newBook.year = sc.nextInt();
        return newBook;
    }

    public static void PrintArchive (ArchivalBook[] archive)
    {
        for (int i=0;i<archive.length;i++)
            System.out.println("\""+archive[i].name+"\" "+archive[i].author+", "+
                    archive[i].genre+", "+archive[i].year+" г.");
    }

    public static boolean IsThereBook(ArchivalBook archivalBook, Book book) {
        if (archivalBook.name.equals(book.name) && archivalBook.author.equals(book.author) &&
                archivalBook.genre.equals(book.genre) && archivalBook.year==book.year)
            return true;
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArchivalBook[] archive = GetArchive();

        System.out.println("Приветствуем Вас, покупатель, в нашей книжной лавке \"Домовушка\"!" +
                " Вы хотите что-нибудь приобрести или продать?\n" +
                " Нажмите 1, если Вы желаете купить заинтересовавшую Вас книгу;\n" +
                " Нажмите 2, если Вы желаете продать книгу;\n" +
                " И любой другой символ в противном случае.");
        var answer = sc.nextLine();;
        while (answer.equals("1") || answer.equals("2")) {
            if (answer.equals("1")) {
                Book newBook = GetBook();
                boolean flagFound = false;
                for (int i=0;i< archive.length;i++)
                {
                    if (IsThereBook(archive[i], newBook)) {
                        if (archive[i].numberCopies > 0) {
                            archive[i].numberCopies -= 1;
                            System.out.println("Поздравляем с покупкой!");
                        } else System.out.println("Сожалеем, но экземпляр данной книги отсутствует.");
                        flagFound = true;
                    }
                }
                if (!flagFound)
                    System.out.println("К сожалению, данной книги нет в нашей лавке...");
            }
            else {
                Book newBook = GetBook();
                boolean flagFoundInList = false;
                for (int i = 0; i < archive.length; i++) {
                    if (IsThereBook(archive[i], newBook)) {
                        archive[i].numberCopies += 1;
                        flagFoundInList = true;
                    }
                }
                if (!flagFoundInList)
                {
                    ArchivalBook[] additionalArchive = archive;
                    archive = new ArchivalBook[additionalArchive.length+1];
                    for (int j=0;j<archive.length;j++)
                    {
                        if (j!=archive.length-1)
                            archive[j] = additionalArchive[j];
                        else {
                            archive[j] = new ArchivalBook(newBook.name, newBook.author,
                                    newBook.genre, newBook.year);
                            archive[j].numberCopies = 1;
                        }
                    }
                }
                System.out.println("Благодарим Вас за продажу необходимого издания!\n" +
                        "Хотите посмотреть наш перечень?\nНажмите 1, если да;\n" +
                        " И любой другой символ в противном случае.");
                if (sc.next().equals("1"))
                    PrintArchive(archive);
            }
            System.out.println("Вы хотите что-нибудь приобрести или продать?");
            answer = sc.next();
        }
        System.out.println("До свидания!");
    }
}
class Book {
    String name;
    String author;
    String genre;
    int year;

    Book() {
        this.name = "";
        this.author = "";
        this.genre = "";
        this.year = 0;
    }
    Book(String name, String author, String genre, int year)
    {
        this.name = name;
        this.author = author;
        this.genre = genre;
        this.year = year;
    }
}

class ArchivalBook extends Book {
    int numberCopies;
    /*
    В данном классе также присутсвуют: Цена, Версия, Популярность и Значимость
    Для данного блока они нужны. В методах они также отсутсвуют.
     */

    ArchivalBook() {
        this.name = "";
        this.author = "";
        this.genre = "";
        this.year = 0;
        this.numberCopies = 0;
    }
    ArchivalBook(String name, String author, String genre, int year)
    {
        this.name = name;
        this.author = author;
        this.genre = genre;
        this.year = year;
        this.numberCopies = 0;
    }
}