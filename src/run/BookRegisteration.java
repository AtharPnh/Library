package run;

import commons.Book;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import manager.BooksManager;

import java.io.IOException;

public class BookRegisteration {

    @FXML
    private Button btnDone;

    @FXML
    private Button btnVerify;

    @FXML
    private Label lblregistration;

    @FXML
    private TextField txtAuthor;

    @FXML
    private TextField txtID;

    @FXML
    private TextField txtPublisher;

    @FXML
    private TextField txtPages;

    @FXML
    private TextField txtYear;

    @FXML
    private TextField txtSubject;

    @FXML
    private TextField txtTitle;

    @FXML
    void pressDone(ActionEvent event) {

        if(txtAuthor.getText().equals("") || txtID.getText().equals("") ||
           txtPublisher.getText().equals("") || txtTitle.getText().equals("") ||
           txtSubject.getText().equals("") || txtYear.getText().equals("")
           || txtPages.getText().equals("")){

            Alert alert=new Alert(Alert.AlertType.WARNING);
            alert.setTitle("هشدار !!!");
            alert.setContentText("لطفا همه ی قسمت ها را پر کنید.");
            alert.showAndWait();

        }else{

             /* set the book's properties that user inputs in the
            registration form.

             */

            Book book=new Book();

            book.setAuthor(txtAuthor.getText());
            book.setPages(txtPages.getText());
            book.setYear(txtYear.getText());
            book.setPublisher(txtPublisher.getText());
            book.setId(txtID.getText());
            book.setName(txtTitle.getText());
            book.setSubject(txtSubject.getText());

            /*
                insert the book into members file
             */

            BooksManager manager=new BooksManager();
            manager.insert(book);

            /*
            send a massage to user for add book to file
             */

            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("ثبت اطلاعات !!!");
            alert.setContentText("کتاب مورد نظر ذخیره شد.");
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

}
