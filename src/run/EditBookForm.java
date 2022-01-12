package run;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import manager.BooksManager;

import java.io.IOException;

public class EditBookForm {

    @FXML
    private Button btnDone;

    @FXML
    private Button btnSearch;

    @FXML
    private Button btnVerify;

    @FXML
    private Label lblMessage;

    @FXML
    private Label lblMessage1;

    @FXML
    private Label lblregistration;

    @FXML
    private TextField txtAuthor;

    @FXML
    private TextField txtID;

    @FXML
    private TextField txtPages;

    @FXML
    private TextField txtPublisher;

    @FXML
    private TextField txtSubject;

    @FXML
    private TextField txtTitle;

    @FXML
    private TextField txtYear;

    @FXML
    void pressDone(ActionEvent event) {

        BooksManager manager=new BooksManager();

        String name=txtTitle.getText();
        String id=txtID.getText();
        String subject=txtSubject.getText();
        String author=txtAuthor.getText();
        String publisher=txtPublisher.getText();
        String year=txtYear.getText();
        String pages=txtPages.getText();

        manager.updateBook(name,id,publisher,year,pages,author,subject);

        if(txtAuthor.getText().equals("") || txtID.getText().equals("") ||
                txtPublisher.getText().equals("") || txtTitle.getText().equals("") ||
                txtSubject.getText().equals("") || txtYear.getText().equals("")
                || txtPages.getText().equals("")) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("هشدار !!!");
            alert.setContentText("لطفا همه ی قسمت ها را پر کنید.");
            alert.showAndWait();
        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("تغییرات مورد نظر ثبت شد");
            alert.showAndWait();
        }
    }

    @FXML
    void pressVerify(ActionEvent event) throws IOException {

        Stage stage=(Stage) btnVerify.getScene().getWindow();
        stage.close();

        Stage primaryStage=new Stage();
        AnchorPane root=(AnchorPane) FXMLLoader.load(getClass().getResource("ManagerPage.fxml"));

        Scene scene=new Scene(root, 611, 290);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    void pressSearch(ActionEvent event) {

        String name=txtTitle.getText();

        BooksManager manager=new BooksManager();

        boolean find=manager.searchBookByName(name);

        if(find==true){
            lblMessage.setVisible(true);
            lblMessage1.setVisible(false);
        }else{
            lblMessage.setVisible(false);
            lblMessage1.setVisible(true);
        }

    }

}


