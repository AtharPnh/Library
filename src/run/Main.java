package run;

import commons.Book;
import commons.Manager;
import commons.Member;
import fileManager.TxtFileManager;
import manager.BooksManager;
import manager.ManagersManager;
import manager.MembersManager;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Book book=new Book();
        book.setId("0620358");
        book.setName("Football");
        book.setAuthor("Adel Ferdosi Pour");
        book.setPages("289");
        book.setSubject("Sport");
        book.setPublisher("Azad");
        book.setYear("1389");

        Book book2=new Book();
        book2.setId("14587");
        book2.setName("@@@@");
        book2.setAuthor("#####");
        book2.setPages("964");
        book2.setSubject("&&&&");
        book2.setPublisher("!!!!!!");
        book2.setYear("1347");

        Book book3=new Book();
        book3.setId("03541");
        book3.setName("-------");
        book3.setAuthor("----");
        book3.setPages("-----");
        book3.setSubject("------");
        book3.setPublisher("----");
        book3.setYear("----");

        Book book4=new Book();
        book4.setId("652587");
        book4.setName("^^^^^^^");
        book4.setAuthor("^^^^^");
        book4.setPages("^^^^^^^");
        book4.setSubject("^^^^^^");
        book4.setPublisher("^^^^^^^^");
        book4.setYear("^^^^^^^");

        BooksManager booksManager=new BooksManager();

//
//       booksManager.insert(book);
//       booksManager.insert(book2);
//
//       booksManager.insert(book3);
//       booksManager.insert(book4);

      //booksManager.deleteBook("Title: Football");
       // booksManager.deleteBook("Title: ^^^^^^^");

       booksManager.updateBook("^^^^^^^","000000","negah","1387","301","Sadegh Hedayat","kkkkkk");

//
    //    System.out.println(booksManager.searchBookByName("Title: ^^^^^^^^"));
//        booksManager.updateBook("Title: Football","120356","kole","1400","289",
//                "Adel Ferdosi Pour","Sport");
//
//        ArrayList<Book> books=booksManager.listOfBook();
//
//        for(int i=0;i<books.size();i++){
//            System.out.print(books.get(i).getId() + "    ");
//            System.out.print(books.get(i).getName()+ "    ");
//            System.out.print(books.get(i).getAuthor()+ "    ");
//            System.out.print(books.get(i).getPages()+ "    ");
//            System.out.print(books.get(i).getSubject()+ "    ");
//            System.out.print(books.get(i).getPublisher()+ "    ");
//            System.out.print(books.get(i).getYear()+ "    ");
//            System.out.println();
//
//        }

//////
//        Member member1=new Member();
//        member1.setId("127");
//        member1.setFirstName("Athar");
//        member1.setLastName("Panahi");
//        member1.setAge("15");
//        member1.setRegisteryDate("98/5/14");
//        member1.setPassword("203257845");
//
//        Member member2=new Member();
//        member2.setId("56900");
//        member2.setFirstName("Taha");
//        member2.setLastName("Panahi");
//        member2.setAge("9");
//        member2.setRegisteryDate("75/12/19");
//        member2.setPassword("4518963/;l");
//
//        Member member3=new Member();
//        member3.setId("63277");
//        member3.setFirstName("Bahador");
//        member3.setLastName("Panahi");
//        member3.setAge("45");
//        member3.setRegisteryDate("95/7/28");
//        member3.setPassword("14gjf7887");
//
        MembersManager managermem=new MembersManager();
//
//       managermem.insert(member1);
//        managermem.insert(member2);
//        managermem.insert(member3);

   //    managermem.deleteMember("Athar");

//        ArrayList<Member> members= managermem.listOfMember();
//
//        String memName=members.get(0).getFirstName();
//        System.out.println(memName);
//
//        String mempass=members.get(0).getPassword();
//        System.out.println(mempass);
////
//        for(int i=0;i<members.size();i++){
//            System.out.print(members.get(i).getId() + "    ");
//            System.out.print(members.get(i).getFirstName()+ "    ");
//            System.out.print(members.get(i).getLastName()+ "    ");
//            System.out.print(members.get(i).getAge()+ "    ");
//            System.out.print(members.get(i).getRegisteryDate()+ "    ");
//            System.out.println();
//
//        }

//
//        Manager manager1=new Manager();
//
//        manager1.setId("987lh");
//        manager1.setFirstName("Vida");
//        manager1.setLastName("Vajdi");
//        manager1.setPassword("123068124");
//
//        Manager manager2=new Manager();
//
//        manager2.setId("vc1035");
//        manager2.setFirstName("Fahime");
//        manager2.setLastName("Enteshari");
//        manager2.setPassword("568717478");
//
//        Manager manager3=new Manager();
//
//        manager3.setId("rsd5677");
//        manager3.setFirstName("Ebrahim");
//        manager3.setLastName("Talebi");
//        manager3.setPassword("036547000");
//
//        ManagersManager m=new ManagersManager();
//
//        m.insert(manager1);
//        m.insert(manager2);
//        m.insert(manager3);


//        ArrayList<Manager> managers=m.listOfManager();
//
//        Scanner scanner=new Scanner(System.in);
//
//        System.out.println("Enter User name: ");
//        String userName=scanner.nextLine();
//
//        System.out.println("enter password: ");
//        String password=scanner.nextLine();
//
//        String firstName=managers.get(1).getFirstName();
//        System.out.println(firstName);
//
//        String pass=managers.get(1).getPassword();
//        System.out.println(pass);
//
//        for(Manager ma : managers){
//            if(ma.getPassword().equals(password) && ma.getFirstName().equals(userName)){
//                System.out.println("you win");
//            }else{
//                System.out.println("you loos");
//            }
//        }
//
//
//        Book book=new Book();
//
//        book.setId("jfghd45");
//        book.setSubject("Art");
//        book.setName("Artist");
//        book.setPublisher("Noor");
//        book.setYear("1257");
//        book.setPages("964");
//        book.setAuthor("Sorush Sehat");
//
//        BooksManager booksManager=new BooksManager();
//
//        booksManager.insert(book);

//        ArrayList<Book> books=booksManager.listOfBook();
//
//        String name=books.get(0).getName();
//        System.out.println(name);
//
//        String year=books.get(0).getYear();
//        System.out.println(year);








    }
}
