package manager;

import commons.Book;
import commons.Commons;
import commons.Member;
import fileManager.TxtFileManager;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class MembersManager {

    private TxtFileManager tfm;

    //----------------------------------------------------------------constructor

    public MembersManager() {
        this.tfm = new TxtFileManager("Members.txt");

        /** for create Members.txt for first time you should to use from creat method and
         * for next time you should to comment this method
         */

        //this.tfm.creatFile();
    }

    //----------------------------------------------------------------methods

    /**
     * --------------------------------- insert() -----> get a Book object as a parameter an set it
     * into MembersManager
     */

    public void insert(Member m) {

        String s =m.getId() + Commons.SPLITTER + m.getFirstName() + Commons.SPLITTER +
                m.getLastName() + Commons.SPLITTER + m.getAge() + Commons.SPLITTER +
                m.getRegisteryDate() + Commons.SPLITTER + m.getPassword();

        this.tfm.appendRow(s);
    }

    /**
     * --------------------------------- stringToMember() -----> get a row in members file as a string
     * and convert it to a member
     */

    private Member stringToMember(String row) {

        Member member=new Member();
        ArrayList<String> save = new ArrayList<String>(Arrays.asList(row.split(Commons.SPLITTER)));

        for (int i = 0; i < save.size(); i++) {
            member.setId(save.get(0));
            member.setFirstName(save.get(1));
            member.setLastName(save.get(2));
            member.setAge(save.get(3));
            member.setRegisteryDate(save.get(4));
            member.setPassword(save.get(5));

        }

        return member;

    }

    /**
     * --------------------------------- memberToString() -----> get a member
     * and convert it to a String
     */

    private String memberToString(Member m){

        String s =m.getId() + Commons.SPLITTER + m.getFirstName() + Commons.SPLITTER +
                m.getLastName() + Commons.SPLITTER + m.getAge() + Commons.SPLITTER +
                m.getRegisteryDate() + Commons.SPLITTER + m.getPassword();

        return s;

    }


    /**
     * --------------------------------- listOfMember() -----> get a list of members that there are
     */

    public ArrayList<Member> listOfMember() {

        ArrayList<Member> members = new ArrayList<Member>();
        ArrayList<String> save = this.tfm.getListFromFile();

        for (int i = 0; i < save.size(); i++) {

            /** in this function we set an object from Member class that we get by stringToMember() method from save list
             * in i index in list ArrayList
             */
            members.add(stringToMember(save.get(i)));
        }

        return members;
    }

    /**
     * --------------------------------- updateMember() -----> get a Member name as a parameter and update that
     */

    public void updateMember(String id, String firstName, String lastName, String age, String registryDate, String password) {

        ArrayList<Member> members = this.listOfMember();
        Member member=new Member();

        for (Member m : members) {
            if (this.searchMemberByName(firstName)) {
                m.setId(id);
                m.setFirstName(firstName);
                m.setLastName(lastName);
                m.setAge(age);
                m.setRegisteryDate(registryDate);
                m.setPassword(password);
            }

            member=m;
        }

        this.deleteMember(firstName);
        this.insert(member);

    }

    /**--------------------------------- deleteMember() -----> get a Member as a parameter and delete that
     */

    public void deleteMember(String title) {

        ArrayList<Member> list=this.listOfMember();

        this.tfm.clear();

        ArrayList<String> stringList=new ArrayList<String>();

        for(int i=0;i<list.size();i++){
            if(!title.equals(list.get(i).getFirstName())){
                stringList.add(memberToString(list.get(i)));
            }
        }

        String save="";

        for(int i=0;i<stringList.size();i++){
            save=save+stringList.get(i)+ "\n";
        }

        try {

            PrintWriter printWriter=new PrintWriter("E:\\IdeaProjects\\Library\\src\\manager\\Members.txt");
            printWriter.print(save);
            printWriter.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    /**--------------------------------- selectBookByPK() -----> get a book as a parameter and return that
     */
    public boolean searchMemberByName(String name) {

        boolean flag=false;

        ArrayList<Member> members = this.listOfMember();

        for(Member member : members){
            if(member.getFirstName().equals(name)){
                flag=true;
            }
        }

        return flag;
    }

    /**--------------------------------- quantityBooks() -----> return the books quantity
     */

    public int quantityMembers(){
        ArrayList<Member> members = this.listOfMember();

        int quantity=members.size();

        return quantity;
    }

    /**--------------------------------- updateQuantityBooks() -----> return books quantity updates
     */

    public void updateQuantityBooks(){

    }

}
