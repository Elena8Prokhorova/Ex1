import java.util.Scanner;

public class Main {
    public static void printArchive(ArchivalBook[] archive) {
        for (int i=0;i<archive.length;i++)
            System.out.println("\"" + archive[i].getName() +"\" "+archive[i].getAuthor()+", "+
                    archive[i].getGenre()+", "+archive[i].getYear());
    }
    public static ArchivalBook[] addBookToArchive(ArchivalBook[] archive, Book newBook) {
        ArchivalBook[] additionalArchive = archive;
        archive = new ArchivalBook[additionalArchive.length+1];
        for (int j = 0; j < archive.length; j++)
        {
            if (j != archive.length-1)
                archive[j] = additionalArchive[j];
            else {
                archive[j] = new ArchivalBook(newBook.getName(), newBook.getAuthor(), newBook.getGenre(),
                        Integer.parseInt(newBook.getYear().substring(0,4)), 1);
            }
        }
        return archive;
    }
    public static void contactingUserEnd(ArchivalBook[] archive) {
        System.out.println("Благодарим Вас за продажу необходимого издания!\n" +
                "Хотите посмотреть наш перечень?\nНажмите 1, если да;\n" +
                " И любой другой символ в противном случае.");
        if (new Scanner(System.in).next().equals("1"))
            printArchive(archive);
    }
    public static boolean hasInArchive(ArchivalBook archivalBook, Book book) {
        return archivalBook.getName().equalsIgnoreCase(book.getName()) &&
                archivalBook.getAuthor().equalsIgnoreCase(book.getAuthor()) &&
                archivalBook.getGenre().equalsIgnoreCase(book.getGenre()) &&
                archivalBook.getYear().equalsIgnoreCase(book.getYear());
    }
    public static ArchivalBook[] buyingAndSellingBook(ArchivalBook[] archive, Book newBook, String actionType) {
        boolean flagFoundInList = false;
        for (int i = 0; i < archive.length; i++) {
            if (hasInArchive(archive[i], newBook)) {
                switch (actionType) {
                    case ("1"):
                        if (archive[i].getNumberCopies() > 0) {
                            archive[i].setNumberCopies(archive[i].getNumberCopies() - 1);
                            System.out.println("Поздравляем с покупкой!");
                        } else System.out.println("Сожалеем, но экземпляр данной книги отсутствует.");
                        break;
                    case ("2"):
                        archive[i].setNumberCopies(archive[i].getNumberCopies() + 1);
                        contactingUserEnd(archive);
                        break;
                }
                flagFoundInList = true;
            }
        }
        if (!flagFoundInList)
            switch (actionType) {
                case ("1"):
                    System.out.println("К сожалению, данной книги нет в нашей лавке...");
                    break;
                case ("2"):
                    archive = addBookToArchive(archive, newBook);
                    contactingUserEnd(archive);
            }
        return archive;
    }
    public static Book buildSearchedBook() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Вводите данные о книге.");
        Book newBook = new Book();
        System.out.print("Название: ");
        newBook.setName(sc.next());
        System.out.print("Автор: ");
        newBook.setAuthor(sc.next());
        System.out.print("Жанр: ");
        newBook.setGenre(sc.next());
        System.out.print("Год: ");
        newBook.setYear(sc.nextInt());
        return newBook;
    }
    public static String contactingUserStart() {
        System.out.println("Приветствуем Вас, покупатель, в нашей книжной лавке \"Домовушка\"!" +
                " Вы хотите что-нибудь приобрести или продать?\n" +
                " Нажмите 1, если Вы желаете купить заинтересовавшую Вас книгу;\n" +
                " Нажмите 2, если Вы желаете продать книгу;\n" +
                " И любой другой символ в противном случае.");
        return new Scanner(System.in).nextLine();
    }
    public static ArchivalBook[] getArchive() {
        ArchivalBook[] archive = new ArchivalBook[11];
        archive[0] = new ArchivalBook("Чудесатая_долина", "Дж.Корн", "Фольклор", 2015, 12);
        archive[1] = new ArchivalBook("Симфония_грифа", "Г.Норленко", "Музыка", 2021, 7);
        archive[2] = new ArchivalBook("Приключения_дворецкого", "Е.Ушакова", "Детектив", 2008, 23);
        archive[3] = new ArchivalBook("Развивайся_сам", "Р.Осадчев", "Карьера", 2023, 2);
        archive[4] = new ArchivalBook("Зеркальное_озеро", "С.Квинсо", "Ужасы", 1998, 16);
        archive[5] = new ArchivalBook("Жаргон_сегодня", "П.Петрогорский", "Языкознание", 2022, 7);
        archive[6] = new ArchivalBook("Подземелье_ангела", "А.Цургеш", "Приключения", 2009, 11);
        archive[7] = new ArchivalBook("Корзинка_пика._Часть_4", "О.Настюшкена", "Кулинария", 2017, 13);
        archive[8] = new ArchivalBook("Чайник_для_Pascal", "Л.Ростров", "Учебная_литература", 2002, 4);
        archive[9] = new ArchivalBook("Легенда_Романовых", "И.Деркин", "История", 2015, 19);
        archive[10] = new ArchivalBook("Затмение_тумана", "Е.Костюнин", "Роман", 2013, 8);

        return archive;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArchivalBook[] archive = getArchive();
        var answer = contactingUserStart();

        while (answer.equals("1") || answer.equals("2")) {
            Book newBook = buildSearchedBook();
            archive = buyingAndSellingBook(archive, newBook, answer);

            System.out.println("Вы хотите что-нибудь приобрести или продать?");
            answer = sc.next();
        }
        System.out.println("До свидания!");
    }
}