package run;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ManagerPage {

    @FXML
    private Button btnAddBook;

    @FXML
    private Button btnAddMember;

    @FXML
    private Button btnBookList;

    @FXML
    private Button btnDeleteBook;

    @FXML
    private Button btnDeleteMember;

    @FXML
    private Button btnEditBook;

    @FXML
    private Button btnEditMember;

    @FXML
    private Button btnMembersList;

    @FXML
    private Button btnExit;

    @FXML
    private Label lblName;

    @FXML
    private Label lblPanel;

    @FXML
    void pressBtnAddBook(ActionEvent event) throws IOException {

        Stage stage=(Stage) btnAddBook.getScene().getWindow();
        stage.close();

        Stage primaryStage=new Stage();
        AnchorPane root=(AnchorPane) FXMLLoader.load(getClass().getResource("BookRegisteration.fxml"));

        Scene scene=new Scene(root, 447, 415);

        primaryStage.setScene(scene);
        primaryStage.show();

    }

    @FXML
    void pressBtnAddMember(ActionEvent event) throws IOException {
        Stage stage=(Stage) btnAddMember.getScene().getWindow();
        stage.close();

        Stage primaryStage=new Stage();
        AnchorPane root=(AnchorPane) FXMLLoader.load(getClass().getResource("Registration.fxml"));

        Scene scene=new Scene(root, 447, 415);

        primaryStage.setScene(scene);
        primaryStage.show();

    }

    @FXML
    void pressBtnBookList(ActionEvent event) throws IOException {


            Stage stage=(Stage) btnBookList.getScene().getWindow();
            stage.close();

            Stage primaryStage=new Stage();
            AnchorPane root=(AnchorPane) FXMLLoader.load(getClass().getResource("Informations.fxml"));

            Scene scene=new Scene(root, 700, 515);

            primaryStage.setScene(scene);
            primaryStage.show();

    }

    @FXML
    void pressBtnMembersList(ActionEvent event) throws IOException {

        Stage stage=(Stage) btnBookList.getScene().getWindow();
        stage.close();

        Stage primaryStage=new Stage();
        AnchorPane root=(AnchorPane) FXMLLoader.load(getClass().getResource("Informations.fxml"));

        Scene scene=new Scene(root, 700, 515);

        primaryStage.setScene(scene);
        primaryStage.show();

    }

    @FXML
    void pressBtnDeleteBook(ActionEvent event) throws IOException {

        Stage stage=(Stage) btnDeleteBook.getScene().getWindow();
        stage.close();

        Stage primaryStage=new Stage();
        AnchorPane root=(AnchorPane) FXMLLoader.load(getClass().getResource("DeleteBook.fxml"));

        Scene scene=new Scene(root, 417, 232);

        primaryStage.setScene(scene);
        primaryStage.show();

    }

    @FXML
    void pressBtnDeleteMember(ActionEvent event) throws IOException {

        Stage stage=(Stage) btnDeleteMember.getScene().getWindow();
        stage.close();

        Stage primaryStage=new Stage();
        AnchorPane root=(AnchorPane) FXMLLoader.load(getClass().getResource("DeleteMember.fxml"));

        Scene scene=new Scene(root, 417, 232);

        primaryStage.setScene(scene);
        primaryStage.show();

    }

    @FXML
    void pressBtnEditBook(ActionEvent event) throws IOException {

        Stage stage=(Stage) btnEditBook.getScene().getWindow();
        stage.close();

        Stage primaryStage=new Stage();
        AnchorPane root=(AnchorPane) FXMLLoader.load(getClass().getResource("EditBookForm.fxml"));

        Scene scene=new Scene(root, 448, 475);

        primaryStage.setScene(scene);
        primaryStage.show();

    }

    @FXML
    void pressBtnEditMember(ActionEvent event) throws IOException {

        Stage stage=(Stage) btnEditMember.getScene().getWindow();
        stage.close();

        Stage primaryStage=new Stage();
        AnchorPane root=(AnchorPane) FXMLLoader.load(getClass().getResource("EditMemberForm.fxml"));

        Scene scene=new Scene(root, 448, 475);

        primaryStage.setScene(scene);
        primaryStage.show();

    }

    @FXML
    void pressBtnExit(ActionEvent event) {
        Platform.exit();
    }



}
