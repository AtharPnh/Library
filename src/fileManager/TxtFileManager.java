package fileManager;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class TxtFileManager {

    //----------------------------------------------------------------identifies


    private File file;
    private int numberOfRows;


    //-----------------------------------------------------------------constructor

    public TxtFileManager(String fileName){

        //inits
        this.file=new File("E:\\IdeaProjects\\Library\\src\\manager\\"+fileName);
        this.numberOfRows=0;

    }

    //----------------------------------------------------------------methods

    //--------------------------------------- creatFile() -----> creat  a file to manage it

    public void creatFile(){
            try {

                PrintWriter out = new PrintWriter(this.file);
                out.close();
                this.numberOfRows=0;

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

    }


    //---------------------------------------clear() -----> clear content of the file
    public void clear(){
        if(!this.file.exists()){
            System.out.println("This file doesn't exist.");
        }else{

            PrintWriter out= null;
            try {

                out = new PrintWriter(this.file);
                out.close();
                this.numberOfRows=0;

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }
    }


    //--------------------------------------- delete() -----> delete a file

    public void delete(){

        if(this.file.exists()){
            file.delete();
        }else{
            System.out.println("This file doesn't exist.");
        }

    }


    //--------------------------------------- setIntoFile() -----> set a row into a file
    private void setIntoFile(String row){

        try {

            PrintWriter writer=new PrintWriter(this.file);
            writer.print(row);
            writer.close();

            updateRows();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //--------------------------------------- getAListFromFile() ----->get a list from a file
    public ArrayList<String> getListFromFile(){

        ArrayList<String> list=new ArrayList<String>();

        try(BufferedReader br=new BufferedReader(new FileReader(this.file))){

            while(br.ready()){
                list.add(br.readLine());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }


    //---------------------------------------getFromFile() ----->get a row from a file
    private String getFromFile(){

        String save="";

        try {

            Scanner myReader = new Scanner(this.file);
            while (myReader.hasNextLine()) {
                if(save==""){
                    save = myReader.nextLine();
                }else{
                    save = save + "\n" + myReader.nextLine();
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return save;
    }


    //---------------------------------------appendRow() ----->append a row to end of a file
    public void appendRow(String row){

        String lines=getFromFile();

        if(lines==""){
            lines=row;
        }else{

            lines=lines + "\n" + row;
        }
        setIntoFile(lines);
    }


    //--------------------------------------- updateRows() -----> count number of rows in a file
    private void updateRows(){
        int counter=0;
        try {
            Scanner scanner=new Scanner(this.file);

            while(scanner.hasNextLine()){
                scanner.nextLine();
                counter++;

            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        this.numberOfRows= counter;
    }

    //--------------------------------------- numberOfRows() -----> return number of rows in a file
    public int numberOfRows(){
        return this.numberOfRows;
    }

    //--------------------------------------- deleteRow() -----> delete a specified row from a file

    public void deleteRow(int index){

        if(index<=0 || index>this.numberOfRows ){
            return;
        }

        ArrayList<String> list=this.getListFromFile();
        String save="";

        for(int i=0;i<list.size();i++){
            if(i != index-1){
                save= save + list.get(i);
            }
        }

        setIntoFile(save);

    }

    //--------------------------------- replaceRow() -----> replace a row with another specified row from a file

    public void replaceRow(int index, String s){

        if(index<=0 || index>this.numberOfRows ){
            return;
        }

        ArrayList<String> list=this.getListFromFile();
        String save="";

        for(int i=0;i<list.size();i++){
            if( i != index-1 ){
                save = save + list.get(i);

            }else if( i == index-1 ){
                save = save + s + "\n";
            }
        }

        setIntoFile(save);
    }

    //--------------------------------- insertRow() -----> insert a row to a specified index from a file

    public void insertRow(int index, String s){

        if(index<=0 || index>this.numberOfRows ){
            return;
        }

        ArrayList<String> list=this.getListFromFile();
        String save="";

        for(int i=0;i<list.size();i++){
            if( i != index){
                save = save + list.get(i);

            }else if( i == index){
                save = save + s +"\n" + list.get(i);
            }
        }

        setIntoFile(save);

    }

    //--------------------------------- getRow() -----> get a specified row with an index from a file

    public String getRow(int index){

        if(index<=0 || index>this.numberOfRows ){
            return null;
        }

        ArrayList<String> list=this.getListFromFile();
        String save=new String();

        for(int i=0;i<list.size();i++){
            if( i == index-1){
                save =list.get(i);
            }
        }

        return save;

    }

}
