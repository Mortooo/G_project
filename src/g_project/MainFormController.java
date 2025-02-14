/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package g_project;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
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
    private TableView<Volunteers> volunteer_table;
    @FXML
    private TableColumn<?, ?> v_col_notes;
    @FXML
    private TableColumn<?, ?> v_col_class;
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
    Volunteers volunteers = new Volunteers();
    @FXML
    private TableColumn<?, ?> v_col_proof_identitiy;
    @FXML
    private Button v_newV_btn;
    @FXML
    private Button v_saveU_btn;
    @FXML
    private Button v_clear;
    @FXML
    private TextField v_id_txtf;
    @FXML
    private TextField v_name_txtf;
    @FXML
    private TextArea v_note_txtf;
    @FXML
    private TextField v_address_txtf;
    @FXML
    private TextField v_phone_txtf;
    @FXML
    private TextField v_account_number_txtf;
    @FXML
    private TextField v_account_name_txtf;
    @FXML
    private TextField v_class_txtf;
    @FXML
    private Button v_selectFile_btn;
    @FXML
    private Label v_path_lable;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            v_col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
            v_col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
            v_col_adress.setCellValueFactory(new PropertyValueFactory<>("addrees"));
            v_col_phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
            v_account_name.setCellValueFactory(new PropertyValueFactory<>("account_name"));
            v_col_account_number.setCellValueFactory(new PropertyValueFactory<>("account_number"));
            v_col_proof_identitiy.setCellValueFactory(new PropertyValueFactory<>("proof_identity"));
            v_col_class.setCellValueFactory(new PropertyValueFactory<>("class"));
            v_col_notes.setCellValueFactory(new PropertyValueFactory<>("note"));

            showdata();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void showdata() throws SQLException {
        ObservableList<Volunteers> list = FXCollections.observableArrayList(volunteers.getAll());
        volunteer_table.setItems(list);

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
    private void v_handelBtn(ActionEvent event) throws IOException, SQLException {

        if (event.getSource().equals(add_volunteer_btn)) {

            hideCurrentAPane();
            add_voluntee_pan.setVisible(true);

        } else if (event.getSource().equals(v_clear)) {

            v_account_name_txtf.setText("");
            v_account_number_txtf.setText("");
            v_address_txtf.setText("");
            v_phone_txtf.setText("");
            v_class_txtf.setText("");
            v_note_txtf.setText("");
            v_path_lable.setText("");
            v_name_txtf.setText("");

        } else if (event.getSource().equals(v_selectFile_btn)) {
            
            FileChooser chooser = new FileChooser();

            File selectedFile = chooser.showOpenDialog(null);

            v_path_lable.setText(selectedFile.getPath());

        } else if (event.getSource().equals(v_saveU_btn)) {
            
            Volunteers volunteer=getUserInput();
            
            
            if(volunteer!=null)// if the user fill the form
            if(volunteer.getId()==null){// if the id_txtf is empty that mean the user want to add new voulnteer
                
//                System.out.println("add new volunteer");
                volunteer.add();
            }else{// updare vounteer
                
            }

        } else {

        }
    }

    @FXML
    private void openFile(MouseEvent event) throws IOException {


        try {
        File file = new File(v_path_lable.getText());

            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(file); // Open the file with the default application
            } else {
                System.err.println("Desktop is not supported on this platform.");
            }
        } catch (Exception e) {
            
                            new Alert(Alert.AlertType.ERROR, e.getMessage()).showAndWait();

        }


    }
    
    private Volunteers getUserInput() throws IOException {

        Volunteers volunteer = null;

        if ( v_name_txtf.getText().equals("") || v_address_txtf.getText().equals("") ||v_phone_txtf.getText().equals("")||
                v_account_name_txtf.getText().equals("")||v_account_number_txtf.getText().equals("")||v_path_lable.getText().equals("مسار الملف")||v_class_txtf.getText().equals("")||v_note_txtf.getText().equals("")) {
            new Alert(Alert.AlertType.ERROR, "الرجاء ادخال البيانات").showAndWait();

        } else {
            volunteer = new Volunteers();
//            volunteer.setId(Integer.parseInt(v_id_txtf.getText()));
            volunteer.setName(v_name_txtf.getText());
            volunteer.setAddrees(v_address_txtf.getText());
            volunteer.setPhone(v_phone_txtf.getText());
            volunteer.setAccount_name(v_account_name_txtf.getText());
            volunteer.setAccount_number(v_account_number_txtf.getText());
            volunteer.setProof_identity(Files.readAllBytes(Paths.get(v_path_lable.getText())));
            volunteer.setCalss(v_class_txtf.getText());
            volunteer.setNote(v_note_txtf.getText());
           
            
           

        }

        return volunteer;

    }

}
