package manager;

import commons.Book;
import commons.Commons;
import commons.Manager;
import commons.Member;
import fileManager.TxtFileManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ManagersManager {

    private TxtFileManager tfm;

    //----------------------------------------------------------------constructor

    public ManagersManager() {
        this.tfm = new TxtFileManager("Managers.txt");

        /** for create books.txt for first time you should to use from creat method and
         * for next time you should to comment this method
         */

       //this.tfm.creatFile();
    }

    //----------------------------------------------------------------methods

    /**
     * --------------------------------- insert() -----> get a Book object as a parameter an set it
     * into BookManager
     */

    public void insert(Manager m) {

        String s = m.getId() + Commons.SPLITTER + m.getFirstName()
                + Commons.SPLITTER + m.getLastName()
                + Commons.SPLITTER + m.getPassword();

        this.tfm.appendRow(s);
    }

    /**
     * --------------------------------- stringToBook() -----> get a row in Books file as a string
     * and convert it to a book
     */

    private Manager stringToManager(String row) {

        Manager manager=new Manager();
        ArrayList<String> save = new ArrayList<String>(Arrays.asList(row.split(Commons.SPLITTER)));

        for (int i = 0; i < save.size(); i++) {
            manager.setId(save.get(0));
            manager.setFirstName(save.get(1));
            manager.setLastName(save.get(2));
            manager.setPassword(save.get(3));
        }

        return manager;

    }

    /**
     * --------------------------------- listOfBook() -----> get a list of Books that there are
     */

    public ArrayList<Manager> listOfManager() {

        ArrayList<Manager> managers = new ArrayList<Manager>();
        ArrayList<String> save = this.tfm.getListFromFile();

        for (int i = 0; i < save.size(); i++) {

            /** in this function we set an object from Manager class that we get by stringToManager()
             * method from save list in i index in list ArrayList
             */
            managers.add(stringToManager(save.get(i)));
        }

        return managers;
    }

    /**
     * --------------------------------- updateBook() -----> get a book as a parameter and update that
     */

    public void updateManager(Manager manager) {

        String primaryKey = manager.getId();

        ArrayList<Manager> managers = this.listOfManager();

        for (Manager m : managers) {
            if (m.getId().equals(primaryKey)) {

                m.setFirstName(manager.getFirstName());
                m.setLastName(manager.getLastName());
            }
        }


    }

    /**--------------------------------- deleteMember() -----> get a String as a member id and delete it by its
     * index in the list of members
     */

    public void deleteManager(String idManager) {

        for(Manager m : this.listOfManager()){

            if(!m.getId().equals(idManager)){
                this.insert(m);
            }
        }

    }

    /**--------------------------------- selectBookByPK() -----> get a book as a parameter and return that
     */
    public Manager selectManagerByPK(String ID) {

        Manager m=new Manager();
        ArrayList<Manager> managers = this.listOfManager();

        for(Manager manager : managers){
            if(ID.equals(m.getId()))
                m=manager;
        }
        return m;

    }

}
