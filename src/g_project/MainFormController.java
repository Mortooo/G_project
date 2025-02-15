package g_project;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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
 * MainFormFXML Controller class
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
    private ComboBox<String> v_chombox;
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
    Dramatists dramisrc = new Dramatists();
    @FXML
    private TableColumn<?, ?> v_col_proof_identitiy;
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
    @FXML
    private Button dramistic_btn;
    @FXML
    private AnchorPane Dramsitic_pan;
    @FXML
    private TextField D_search_txtf;
    @FXML
    private ComboBox<String> D_chombox;
    @FXML
    private TableColumn<?, ?> D_col_id;
    @FXML
    private TableColumn<?, ?> D_col_bandName;
    @FXML
    private TableColumn<?, ?> d_col_adress;
    @FXML
    private TableColumn<?, ?> d_col_phone1;
    @FXML
    private TableColumn<?, ?> d_col_account_number;
    @FXML
    private TableColumn<?, ?> d_account_name;
    @FXML
    private TableColumn<?, ?> d_col_proof_identitiy;
    @FXML
    private TableColumn<?, ?> d_col_notes;
    @FXML
    private Button add_dramistic_btn;
    @FXML
    private Button update_dramistic_btn;
    @FXML
    private Button delete_dramistc_btn;
    @FXML
    private TableView<Dramatists> dramistc_table;
    @FXML
    private AnchorPane add_dramistic_pan;
    @FXML
    private TextField d_id_txtf;
    @FXML
    private TextField d_name_txtf;
    @FXML
    private TextArea d_note_txtf;
    @FXML
    private TextField d_address_txtf;
    @FXML
    private TextField d_phone_txtf;
    @FXML
    private TextField d_account_number_txtf;
    @FXML
    private TextField d_account_name_txtf;
    @FXML
    private Button d_selectFile_btn;
    @FXML
    private Label d_path_lable;
    @FXML
    private Button d_saveU_btn;
    @FXML
    private Button d_clear;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        initializeComboBoxs();//add data to chomboxs 
        initializeTablesColumns();//link the tables with their data
        // i will setup search functianly later 

        //restrict the values that accepted to numers 
        restrictNumericInput(v_phone_txtf, 10);
//        restrictNumericInput(D_phone_txtf, 10);
        restrictNumericInput(v_account_number_txtf, 16);
//        restrictNumericInput(d_account_number_txtf, 16);
        loadData();// this method retrieve data from database and insert it into tables

        search();// add lisnter to search txtf and table view 

    }

    private void initializeComboBoxs() {
        v_chombox.getItems().addAll("الملاحظات", "الفئة", "العنوان", "الاسم");
        D_chombox.getItems().addAll("العنوان", "الاسم");
    }

    private void initializeTablesColumns() {

        // voulnteers table
        v_col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        v_col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        v_col_adress.setCellValueFactory(new PropertyValueFactory<>("addrees"));
        v_col_phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        v_account_name.setCellValueFactory(new PropertyValueFactory<>("account_name"));
        v_col_account_number.setCellValueFactory(new PropertyValueFactory<>("account_number"));
        v_col_proof_identitiy.setCellValueFactory(new PropertyValueFactory<>("proof_identity"));
        v_col_class.setCellValueFactory(new PropertyValueFactory<>("calss"));
        v_col_notes.setCellValueFactory(new PropertyValueFactory<>("note"));
        //dramistcs table
        D_col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        D_col_bandName.setCellValueFactory(new PropertyValueFactory<>("band_name"));
        d_col_adress.setCellValueFactory(new PropertyValueFactory<>("addrees"));
        d_col_phone1.setCellValueFactory(new PropertyValueFactory<>("phone"));
        d_account_name.setCellValueFactory(new PropertyValueFactory<>("account_name"));
        d_col_account_number.setCellValueFactory(new PropertyValueFactory<>("account_number"));
        d_col_proof_identitiy.setCellValueFactory(new PropertyValueFactory<>("proof_identity"));
        d_col_notes.setCellValueFactory(new PropertyValueFactory<>("notes"));

    }

    private void restrictNumericInput(TextField field, int maxLength) {
        field.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d{0," + maxLength + "}")) {
                field.setText(oldValue);
            }
        });
    }

    private void loadData() {
        try {
            //volunteers table
            ObservableList<Volunteers> volunteersList = FXCollections.observableArrayList(volunteers.getAll());
            volunteer_table.setItems(volunteersList);
            // dramistic table 
            ObservableList<Dramatists> dramisticList = FXCollections.observableArrayList(dramisrc.getAll());
            dramistc_table.setItems(dramisticList);

        } catch (SQLException ex) {
            showAlert(AlertType.ERROR, "Database Error", ex.getMessage());
        }
    }

    /**
     * this method retreive data from data base and show it in volunteer table
     * view
     *
     * @throws SQLException
     */
    public void showdata() throws SQLException {
        ObservableList<Volunteers> list = FXCollections.observableArrayList(volunteers.getAll());
        volunteer_table.setItems(list);

    }

    @FXML
    private void handel_btns(ActionEvent event) throws IOException, SQLException {

        if (event.getSource().equals(logout_btn)) {// if the user logout 

            logout_btn.getScene().getWindow().hide();// hide the main form

            //show log in form 
            Stage stage = new Stage();
            Parent parent = FXMLLoader.load(getClass().getResource("LoginForm.fxml"));
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.show();

        } else if (event.getSource().equals(dashboard_btn)) {

            showPane(dashboard);

        } else if (event.getSource().equals(vlounteers_btn)) {

            showPane(volunteers_pan);
            loadData();
            clearField();

        } else if (event.getSource().equals(update_volunteer_btn)) {

            if (volunteer_table.getSelectionModel().getSelectedItem() == null) {// if the user did select item from the table
                new Alert(AlertType.ERROR, "الرجاء اختيار عنصر").showAndWait();
            } else {
                hideCurrentAPane();
                add_voluntee_pan.setVisible(true);

                Volunteers v = volunteer_table.getSelectionModel().getSelectedItem();
                v_id_txtf.setText(String.valueOf(v.getId()));
                v_name_txtf.setText(v.getName());
                v_address_txtf.setText(v.getAddrees());
                v_phone_txtf.setText(v.getPhone());
                v_account_name_txtf.setText(v.getAccount_name());
                v_account_number_txtf.setText(v.getAccount_number());
                v_path_lable.setText(v.getProof_identity());
                v_note_txtf.setText(v.getNote());
                v_class_txtf.setText(v.getCalss());
            }

        } else if (event.getSource().equals(dramistic_btn)) {

            showPane(Dramsitic_pan);

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

            showPane(add_voluntee_pan);

        } else if (event.getSource().equals(v_clear)) {

            v_account_name_txtf.setText("");
            v_account_number_txtf.setText("");
            v_address_txtf.setText("");
            v_phone_txtf.setText("");
            v_class_txtf.setText("");
            v_note_txtf.setText("");
            v_path_lable.setText("مسار الملف");
            v_name_txtf.setText("");

        } else if (event.getSource().equals(v_selectFile_btn)) {

            FileChooser chooser = new FileChooser();

            File selectedFile = chooser.showOpenDialog(null);
            try {
                v_path_lable.setText(selectedFile.getPath());
            } catch (Exception e) {
            }

        } else if (event.getSource().equals(v_saveU_btn)) {

            Volunteers volunteer = getUserInput();

            if (volunteer == null) {// if user fill the form 

                if (volunteer != null)// if the user fill the form
                {
                    if (volunteer.getId() == null) {// if the id_txtf is empty that mean the user want to add new voulnteer

                        volunteer.add();// insert data to database
                        clearField();
                        new Alert(AlertType.INFORMATION, "تمت اضافة المعزز بنجاح").showAndWait();

                    } else {// update vounteer

                        Volunteers v = getUserInput();
                        v.update();
//                    showdata();

                        new Alert(AlertType.INFORMATION, "تم تعديل بيانات المعزز بنجاح").showAndWait();
                        clearField();

                        hideCurrentAPane();
                        volunteers_pan.setVisible(true);

                        showdata();
                        volunteer_table.refresh();
                    }

                }
            }

        } else if (event.getSource().equals(delete_volunteer_btn)) {// delete volunteer

            Alert alert = new Alert(AlertType.CONFIRMATION);

            if (volunteer_table.getSelectionModel().getSelectedItem() == null) {// if the user did select item from the table
                new Alert(AlertType.ERROR, "الرجاء اختيار عنصر").showAndWait();
            } else {
                alert.setContentText("هل تريد حذف المعزز؟");
                alert.showAndWait().ifPresent(response -> {
                    if (response == ButtonType.OK) {
                        try {
                            volunteer_table.getSelectionModel().getSelectedItem().remove();
                            showData();

                        } catch (SQLException ex) {
                            Logger.getLogger(MainFormController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
            }

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

            if (v_name_txtf.getText().isEmpty() || v_address_txtf.getText().isEmpty() || v_phone_txtf.getText().isEmpty()
                || v_path_lable.getText().equals("مسار الملف")) {
            showAlert(AlertType.ERROR, "Error", "الرجاء ادخال البيانات");
            return null;
        }

        Volunteers volunteer = new Volunteers();
        if (!v_id_txtf.getText().isEmpty()) {
            volunteer.setId(Integer.parseInt(v_id_txtf.getText()));
        }
        volunteer.setName(v_name_txtf.getText());
        volunteer.setAddrees(v_address_txtf.getText());
        volunteer.setPhone(v_phone_txtf.getText());
        volunteer.setAccount_name(v_account_name_txtf.getText());
        volunteer.setAccount_number(v_account_number_txtf.getText());
        volunteer.setProof_identity(v_path_lable.getText());
        volunteer.setCalss(v_class_txtf.getText());
        volunteer.setNote(v_note_txtf.getText());

        return volunteer;
        
        
        
        
        
//        Volunteers volunteer = new Volunteers();
//        if (!v_id_txtf.getText().equals("")) {// if update volunteer data
//
//            volunteer.setId(Integer.parseInt(v_id_txtf.getText()));
//
//        }
//        //if new volunteer
//        if (v_name_txtf.getText().equals("") || v_address_txtf.getText().equals("") || v_phone_txtf.getText().equals("")
//                || v_path_lable.getText().equals("مسار الملف")) {
//            new Alert(Alert.AlertType.ERROR, "الرجاء ادخال البيانات").showAndWait();
//
//        } else {
//            volunteer.setName(v_name_txtf.getText());
//            volunteer.setAddrees(v_address_txtf.getText());
//            volunteer.setPhone(v_phone_txtf.getText());
//            volunteer.setAccount_name(v_account_name_txtf.getText());
//            volunteer.setAccount_number(v_account_number_txtf.getText());
//            volunteer.setProof_identity(v_path_lable.getText());
//            volunteer.setCalss(v_class_txtf.getText());
//            volunteer.setNote(v_note_txtf.getText());
//
//        }
//
//        return volunteer;

    }

    private void showData() throws SQLException {

        ObservableList<Volunteers> list = FXCollections.observableArrayList(volunteers.getAll());
        volunteer_table.setItems(list);
//        try {
//            col_productName.setCellValueFactory(new PropertyValueFactory<>("pName"));
//            col_unit.setCellValueFactory(new PropertyValueFactory<>("unit"));
//            col_price.setCellValueFactory(new PropertyValueFactory<>("price"));
//            col_quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
//
//            ObservableList<Products> p = FXCollections.observableArrayList(products.getAll());
//
//            table.setItems(p);
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }

    }

    public void numericOnly(final TextField field) {

        if (field.equals(v_phone_txtf)) {// if the user is editing phone number max number 10
            field.textProperty().addListener(new ChangeListener<String>() {

                @Override
                public void changed(
                        ObservableValue<? extends String> observable, String oldValue, String newValue) {
                    if (!newValue.matches("\\d{0,10}")) { // Allow up to 10 digits
                        field.setText(oldValue); // Revert to the previous value
                    }
                }
            });
        } else {// if the user id editing account number max 16
            field.textProperty().addListener(new ChangeListener<String>() {

                @Override
                public void changed(
                        ObservableValue<? extends String> observable, String oldValue, String newValue) {
                    if (!newValue.matches("\\d{0,16}")) { // Allow up to 10 digits
                        field.setText(oldValue); // Revert to the previous value
                    }
                }
            });
        }

    }

    public void clearField() {
        // clear voulnteers felids 
        v_account_name_txtf.setText("");
        v_account_number_txtf.setText("");
        v_address_txtf.setText("");
        v_phone_txtf.setText("");
        v_class_txtf.setText("");
        v_note_txtf.setText("");
        v_path_lable.setText("مسار الملف");
        v_name_txtf.setText("");
        v_id_txtf.setText("");
        //clear dramistics felids 
         d_account_name_txtf.setText("");
        d_account_number_txtf.setText("");
        d_address_txtf.setText("");
        d_phone_txtf.setText("");
        d_note_txtf.setText("");
        d_path_lable.setText("مسار الملف");
        d_name_txtf.setText("");
        d_id_txtf.setText("");
    }

    public void search() {
        // Wrap the observable list in a FilteredList
        FilteredList<Volunteers> filteredData = new FilteredList<>(volunteer_table.getItems(), p -> true);

        // Bind the FilteredList to the TableView
        SortedList<Volunteers> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(volunteer_table.comparatorProperty());
        volunteer_table.setItems(sortedData);

//        // Create a TextField for search
//        TextField searchField = new TextField();
//        searchField.setPromptText("Search by name...");
        // Add a listener to the search field
        v_search_txtf.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(person -> {
                // If the search field is empty, display all persons
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Convert the search query to lowercase for case-insensitive search
                String lowerCaseQuery = newValue.toLowerCase();
                if (v_chombox.getSelectionModel().getSelectedItem() != null) {
                    if (v_chombox.getSelectionModel().getSelectedItem().equals("الاسم")) {
                        // Check if the person's name contains the search query
                        if (person.getName().toLowerCase().contains(lowerCaseQuery)) {
                            return true; // Match found
                        }
                    } else if (v_chombox.getSelectionModel().getSelectedItem().equals("العنوان")) {
                        if (person.getAddrees().toLowerCase().contains(lowerCaseQuery)) {
                            return true; // Match found
                        }
                    } else if (v_chombox.getSelectionModel().getSelectedItem().equals("الفئة")) {
                        if (person.getCalss().toLowerCase().contains(lowerCaseQuery)) {
                            return true; // Match found
                        }
                    } else if (v_chombox.getSelectionModel().getSelectedItem().equals("الملاحظات")) {
                        if (person.getNote().toLowerCase().contains(lowerCaseQuery)) {
                            return true; // Match found
                        }
                    }
                } else {

                }

                return false; // No match
            });
        });
    }

    @FXML
    private void handelDramisticBtn(ActionEvent event) {

        if (event.getSource() == add_dramistic_btn) {

            showPane(add_dramistic_pan);

        } else if (event.getSource() == delete_dramistc_btn) {

        } else if (event.getSource() == update_dramistic_btn) {

            showPane(add_dramistic_pan);

        }
    }

    private void showAlert(AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void showPane(AnchorPane pane) {
        hideAllPanes();
        pane.setVisible(true);
    }

    private void hideAllPanes() {
        for (Node node : pane_view.getChildren()) {
            if (node instanceof AnchorPane) {
                node.setVisible(false);
            }
        }
    }
    
  
    
    

}
