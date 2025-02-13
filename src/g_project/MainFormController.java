/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package g_project;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Mortooo.x
 */
public class MainFormController implements Initializable {

    @FXML
    private AnchorPane pane_view;
    @FXML
    private AnchorPane volunteers_pan;
    @FXML
    private AnchorPane dashboard;
    @FXML
    private AnchorPane add_voluntee_pan;
    @FXML
    private Button logout_btn;
    @FXML
    private Button dashboard_btn;
    @FXML
    private Button vlounteers_btn;
    @FXML
    private Button add_volunteer_btn;
    @FXML
    private Button update_volunteer_btn;
    @FXML
    private Button delete_volunteer_btn;
    @FXML
    private TextField v_search_txtf;
    @FXML
    private Button v_search_btn;
    @FXML
    private ComboBox<?> v_chombox;
    @FXML
    private TableView<?> volunteer_table;
    @FXML
    private TableColumn<?, ?> v_col_notes;
    @FXML
    private TableColumn<?, ?> v_col_class;
    @FXML
    private TableColumn<?, ?> v_col_prrof_identitiy;
    @FXML
    private TableColumn<?, ?> v_account_name;
    @FXML
    private TableColumn<?, ?> v_col_account_number;
    @FXML
    private TableColumn<?, ?> v_col_phone;
    @FXML
    private TableColumn<?, ?> v_col_adress;
    @FXML
    private TableColumn<?, ?> v_col_name;
    @FXML
    private TableColumn<?, ?> v_col_id;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void handel_btns(ActionEvent event) throws IOException {

        if (event.getSource().equals(logout_btn)) {// if the user logout 

            logout_btn.getScene().getWindow().hide();// hide the main form

            //show log in form 
            Stage stage = new Stage();
            Parent parent = FXMLLoader.load(getClass().getResource("LoginForm.fxml"));
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.show();

        } else if (event.getSource().equals(dashboard_btn)) {

            hideCurrentAPane();
            dashboard.setVisible(true);

        } else if (event.getSource().equals(vlounteers_btn)) {

            hideCurrentAPane();
            volunteers_pan.setVisible(true);

        } else {

        }

    }

    public void hideCurrentAPane() {//hide the current anchor pane 

        for (Node child : ((javafx.scene.Parent) pane_view).getChildrenUnmodifiable()) {
            if (child instanceof AnchorPane) {
                child.setVisible(false);
            }

        }
    }

    @FXML
    private void v_handelBtn(ActionEvent event) {
        
        if (event.getSource().equals(add_volunteer_btn)) {

            hideCurrentAPane();
            add_voluntee_pan.setVisible(true);

        }
    }

}
