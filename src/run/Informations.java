package run;

import fileManager.TxtFileManager;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;

public class Informations {

    @FXML
    private Button btnExit;

    @FXML
    private ListView<String> lvBooks;

    @FXML
    private ListView<String> lvMembers;

    @FXML
    private TextField txtBooksList;

    @FXML
    private TextField txtMembersList;

    @FXML
    private TextField txtWelcome;

    final ObservableList<String> List = FXCollections.observableArrayList();

    final ObservableList<String> List2 = FXCollections.observableArrayList();

    @FXML
    void pressBtnExit(ActionEvent event) {

        Platform.exit();
    }

    @FXML
    void selectTxtBooksList(MouseEvent event) {

        lvMembers.setVisible(false);
        lvBooks.setVisible(true);

        TxtFileManager fm=new TxtFileManager("Books.txt");

        ArrayList<String> sm= fm.getListFromFile();

        for(int i=0;i<sm.size();i++){

            List2.add(sm.get(i));
        }

        lvBooks.setItems(List2);
    }


    @FXML
    void selectTxtMembersList(MouseEvent event) {

        lvMembers.setVisible(true);
        lvBooks.setVisible(false);

        TxtFileManager fm=new TxtFileManager("Members.txt");

        ArrayList<String> sm= fm.getListFromFile();

        for(int i=0;i<sm.size();i++){

            List.add(sm.get(i));
        }

        lvMembers.setItems(List);

    }

}




