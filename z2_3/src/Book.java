import java.time.Year;

public class Book {
    private String name;
    private String author;
    private String genre;
    private int year;

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

    public void setName (String name) {
        this.name = name;
    }
    public void setAuthor (String author) {
        this.author = author;
    }
    public void setGenre (String genre) {
        this.genre = genre;
    }
    public void setYear (int year) {
        if (year <= 0 || year > Year.now().getValue()) throw new IllegalArgumentException();
        this.year = year;
    }

    public String getName() {
        return this.name;
    }
    public String getAuthor() {
        return this.author;
    }
    public String getGenre() {
        return this.genre;
    }
    public String getYear() {
        return this.year + " г.";
    }
}
