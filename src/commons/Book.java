package commons;

public class Book {

    private String id;
    private String name;
    private String author;
    private String subject;
    private String publisher;
    private String year;
    private String pages;

    public String getId() {
        return this.id;
    }


    public void setId(String id) {
        if(id.length()>=3 || id.length()<8)
            this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {

        this.year = year;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
            this.pages = pages;
    }

}
