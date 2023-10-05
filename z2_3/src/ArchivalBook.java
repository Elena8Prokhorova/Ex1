public class ArchivalBook extends Book {
    private int numberCopies;
    /*
    В данном классе также присутсвуют: Цена, Версия, Популярность и Значимость
    Для данного блока они нужны. В методах они также отсутсвуют.
     */

    ArchivalBook() {
        this.setName("");
        this.setAuthor("");
        this.setGenre("");
        this.setYear(0);
        this.numberCopies = 0;
    }
    ArchivalBook(String name, String author, String genre, int year, int numberCopies)
    {
        this.setName(name);
        this.setAuthor(author);
        this.setGenre(genre);
        this.setYear(year);
        this.numberCopies = numberCopies;
    }

    public void setNumberCopies (int numberCopies) {
        if (this.numberCopies < 0) throw new IllegalArgumentException();
        this.numberCopies = numberCopies;
    }
    public int getNumberCopies () {
        return this.numberCopies;
    }
}
