package manager;

import commons.Book;
import commons.Commons;
import fileManager.TxtFileManager;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class BooksManager {

    private TxtFileManager tfm;

    //----------------------------------------------------------------constructor

    public BooksManager() {
        this.tfm = new TxtFileManager("Books.txt");

        /** for create books.txt for first time you should to use from creat method and
         * for next time you should to comment this method
         */

       //this.tfm.creatFile();
    }

    //----------------------------------------------------------------methods

    /**
     * --------------------------------- insert() -----> get a Book object as a parameter an set it
     * into BoookManager
     */

    public void insert(Book b) {

        String s =b.getId() + Commons.SPLITTER + b.getName() + Commons.SPLITTER +
                 b.getSubject() + Commons.SPLITTER + b.getAuthor() +
                Commons.SPLITTER +  b.getPages() + Commons.SPLITTER +
                 b.getPublisher() + Commons.SPLITTER +  b.getYear();

        this.tfm.appendRow(s);
    }

    /**
     * --------------------------------- stringToBook() -----> get a row in Books file as a string
     * and convert it to a book
     */

    private Book stringToBook(String row) {

        Book book = new Book();
        ArrayList<String> save = new ArrayList<String>(Arrays.asList(row.split(Commons.SPLITTER)));

        for (int i = 0; i < save.size(); i++) {
            book.setId(save.get(0));
            book.setName(save.get(1));
            book.setSubject(save.get(2));
            book.setAuthor(save.get(3));
            book.setPages(save.get(4));
            book.setPublisher(save.get(5));
            book.setYear(save.get(6));
        }

        return book;

    }

    /**
     * --------------------------------- bookToString() -----> get a Book
     * and convert it to a String
     */

    private String bookToString(Book b){

        String s =b.getId() + Commons.SPLITTER + b.getName() + Commons.SPLITTER +
                b.getSubject() + Commons.SPLITTER + b.getAuthor() +
                Commons.SPLITTER + b.getPages() + Commons.SPLITTER +
                b.getPublisher() + Commons.SPLITTER + b.getYear();

        return s;

    }


    /**
     * --------------------------------- listOfBook() -----> get a list of Books that there are
     */

    public ArrayList<Book> listOfBook() {

        ArrayList<Book> books = new ArrayList<Book>();
        ArrayList<String> save = this.tfm.getListFromFile();

        for (int i = 0; i < save.size(); i++) {

            /** in this function we set an object from Book class that we get by stringToBook() method from save list
             * in i index in list ArrayList
             */
            books.add(stringToBook(save.get(i)));
        }

        return books;
    }

    /**
     * --------------------------------- updateBook() -----> get a book name as a parameter and update that
     */

    public void updateBook(String name, String id, String publisher, String year, String pages, String author,String subject) {

        ArrayList<Book> books = this.listOfBook();
        Book book=new Book();

        for (Book b : books) {
            if (this.searchBookByName(name)) {
                b.setName(name);
                b.setId(id);
                b.setPublisher(publisher);
                b.setYear(year);
                b.setPages(pages);
                b.setAuthor(author);
                b.setSubject(subject);
            }

            book=b;
        }

        this.deleteBook(name);
        this.insert(book);

    }

    /**--------------------------------- deleteBook() -----> get a book as a parameter and delete that
     */

    public void deleteBook(String title) {

        ArrayList<Book> list=this.listOfBook();

        this.tfm.clear();

        ArrayList<String> stringList=new ArrayList<String>();

        for(int i=0;i<list.size();i++){
            if(!title.equals(list.get(i).getName())){
                stringList.add(bookToString(list.get(i)));
            }
        }

        String save="";

        for(int i=0;i<stringList.size();i++){
            save=save+stringList.get(i)+ "\n";
        }

        try {

            PrintWriter printWriter=new PrintWriter("E:\\IdeaProjects\\Library\\src\\manager\\Books.txt");
            printWriter.print(save);
            printWriter.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    /**--------------------------------- selectBookByPK() -----> get a book as a parameter and return that
     */
    public boolean searchBookByName(String name) {

        boolean flag=false;

        ArrayList<Book> books = this.listOfBook();

        for(Book book:books){
            if(book.getName().equals(name)){
                flag=true;
            }
        }

        return flag;
    }

    /**--------------------------------- quantityBooks() -----> return the books quantity
     */

    public int quantityBooks(){
        ArrayList<Book> books = this.listOfBook();

        int quantity=books.size();

        return quantity;
    }

    /**--------------------------------- updateQuantityBooks() -----> return books quantity updates
     */

    public void updateQuantityBooks(){

    }

}
