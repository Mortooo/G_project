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
    private Button contracts_btn;
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
    Contracts contracts = new Contracts();
    Partners partners = new Partners();
    Activities activites = new Activities();
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
    @FXML
    private AnchorPane contracts_pan;
    @FXML
    private AnchorPane add_contracts_pan;
    @FXML
    private Button v_search_btn2;
    @FXML
    private Button d_search_btn;
    @FXML
    private TextField C_search_txtf;
    @FXML
    private ComboBox<String> C_chombox;
    @FXML
    private TableView<Contracts> contracts_table;
    @FXML
    private Button add_contract_btn;
    @FXML
    private Button update_contracts_btn;
    @FXML
    private Button delete_contracts_btn;
    @FXML
    private TableColumn<?, ?> c_col_id;
    @FXML
    private TableColumn<?, ?> c_col_car_owner_name;
    @FXML
    private TableColumn<?, ?> c_col_adress;
    @FXML
    private TableColumn<?, ?> c_col_car_license;
    @FXML
    private TableColumn<?, ?> c_col_driver_license;
    @FXML
    private TableColumn<?, ?> c_col_driver_id;
    @FXML
    private TableColumn<?, ?> c_col_witness;
    @FXML
    private TableColumn<?, ?> c_col_phone;
    @FXML
    private Button c_search_btn;
    @FXML
    private Button c_saveU_btn;
    @FXML
    private Button c_clear;
    @FXML
    private TextField c_phone_txtf;
    @FXML
    private TextField c_id_txtf;
    @FXML
    private TextField c_car_owner_name_txtf;
    @FXML
    private TextField c_address_txtf;
    @FXML
    private Label c_carL_lable;
    @FXML
    private Label c_driverL_lable;
    @FXML
    private Label c_driver_ID_lable;
    @FXML
    private Label c_witness_lable;
    @FXML
    private Button c_selectCarL_btn;
    @FXML
    private Button c_selectDriverL_btn;
    @FXML
    private Button c_selectDriverID_btn;
    @FXML
    private Button c_selectWitness_btn;
    @FXML
    private AnchorPane partners_pan;
    @FXML
    private TextField p_search_txtf;
    @FXML
    private ComboBox<String> p_chombox;
    @FXML
    private TableView<Partners> partners_table;
    @FXML
    private TableColumn<?, ?> p_col_id;
    @FXML
    private TableColumn<?, ?> p_col_adress;
    @FXML
    private Button add_partners_btn;
    @FXML
    private Button update_partners_btn;
    @FXML
    private Button delete_parrtners_btn;
    @FXML
    private AnchorPane add_partners_pan;
    @FXML
    private TextField p_phone_txtf;
    @FXML
    private TextField p_id_txtf;
    @FXML
    private TextField p_name_txtf;
    @FXML
    private TextField p_address_txtf;
    @FXML
    private Button p_saveU_btn;
    @FXML
    private Button p_clear;
    @FXML
    private TextField p_activityType_txtf;
    @FXML
    private TableColumn<?, ?> p_col_name;
    @FXML
    private TableColumn<?, ?> p_col_phone;
    @FXML
    private TableColumn<?, ?> p_col_activityType;
    @FXML
    private Button p_search_btn;
    @FXML
    private Button partners_btn;
    @FXML
    private AnchorPane activites_pan;
    @FXML
    private TextField a_search_txtf;
    @FXML
    private ComboBox<String> a_chombox;
    @FXML
    private TableView<Activities> activites_table;
    @FXML
    private TableColumn<?, ?> a_col_id;
    @FXML
    private TableColumn<?, ?> a_col_name;
    @FXML
    private TableColumn<?, ?> a_col_donor;
    @FXML
    private TableColumn<?, ?> a_col_notes;
    @FXML
    private TableColumn<?, ?> a_col_location;
    @FXML
    private Button add_activite_btn;
    @FXML
    private Button update_activite_btn;
    @FXML
    private Button delete_activite_btn;
    @FXML
    private Button a_search_btn;
    @FXML
    private AnchorPane add_activite_pan;
    @FXML
    private TextField a_location_txtf;
    @FXML
    private TextField a_id_txtf;
    @FXML
    private TextField a_name_txtf;
    @FXML
    private TextField a_donor_txtf;
    @FXML
    private Button a_saveU_btn;
    @FXML
    private Button a_clear;
    @FXML
    private TextArea a_notes_txtA;
    @FXML
    private Button activites_btn;
    @FXML
    private Button add_volnToActivity_btn;
    @FXML
    private Button display_volun_btn;
    @FXML
    private AnchorPane Lvolunteers_pan;
    @FXML
    private TextField L_search_txtf;
    @FXML
    private ComboBox<String> L_chombox;
    @FXML
    private TableView<Volunteers> Lvolunteer_table;
    @FXML
    private TableColumn<?, ?> L_col_id;
    @FXML
    private TableColumn<?, ?> L_col_name;
    @FXML
    private TableColumn<?, ?> L_col_adress;
    @FXML
    private TableColumn<?, ?> L_col_phone;
    @FXML
    private TableColumn<?, ?> L_col_account_number;
    @FXML
    private TableColumn<?, ?> L_account_name;
    @FXML
    private TableColumn<?, ?> L_col_proof_identitiy;
    @FXML
    private TableColumn<?, ?> L_col_class;
    @FXML
    private TableColumn<?, ?> L_col_notes;
    @FXML
    private Button add_volunActivity_btn;
    @FXML
    private Button delete_voluActivity_btn;
    @FXML
    private Button L_search_btn;
    @FXML
    private Button L_back_btn;

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
        restrictNumericInput(d_phone_txtf, 10);
        restrictNumericInput(c_phone_txtf, 10);
        restrictNumericInput(p_phone_txtf, 10);
        restrictNumericInput(v_account_number_txtf, 16);
        restrictNumericInput(d_account_number_txtf, 16);
        loadData();// this method retrieve data from database and insert it into tables

    }

    private void initializeComboBoxs() {
        v_chombox.getItems().addAll("الملاحظات", "الفئة", "العنوان", "الاسم");
        D_chombox.getItems().addAll("العنوان", "الاسم");
        C_chombox.getItems().addAll("العنوان", "الاسم");
        p_chombox.getItems().addAll("نوع النشاط", "الاسم");
        a_chombox.getItems().addAll("المانح", "الاسم");
        L_chombox.getItems().addAll("الملاحظات", "الفئة", "العنوان", "الاسم");

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
        //Contracts table
        c_col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        c_col_car_owner_name.setCellValueFactory(new PropertyValueFactory<>("car_owner_name"));
        c_col_adress.setCellValueFactory(new PropertyValueFactory<>("address"));
        c_col_car_license.setCellValueFactory(new PropertyValueFactory<>("car_license"));
        c_col_driver_license.setCellValueFactory(new PropertyValueFactory<>("driver_license"));
        c_col_driver_id.setCellValueFactory(new PropertyValueFactory<>("driver_ID"));
        c_col_witness.setCellValueFactory(new PropertyValueFactory<>("witnesss_ID"));
        c_col_phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        // partners table
        p_col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        p_col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        p_col_adress.setCellValueFactory(new PropertyValueFactory<>("address"));
        p_col_activityType.setCellValueFactory(new PropertyValueFactory<>("activity_type"));
        p_col_phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        // activities table
        a_col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        a_col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        a_col_donor.setCellValueFactory(new PropertyValueFactory<>("donor"));
        a_col_notes.setCellValueFactory(new PropertyValueFactory<>("notes"));
        a_col_location.setCellValueFactory(new PropertyValueFactory<>("location"));
        // volunteer Display by Activity
        L_col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        L_col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        L_col_adress.setCellValueFactory(new PropertyValueFactory<>("addrees"));
        L_col_phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        L_account_name.setCellValueFactory(new PropertyValueFactory<>("account_name"));
        L_col_account_number.setCellValueFactory(new PropertyValueFactory<>("account_number"));
        L_col_proof_identitiy.setCellValueFactory(new PropertyValueFactory<>("proof_identity"));
        L_col_class.setCellValueFactory(new PropertyValueFactory<>("calss"));
        L_col_notes.setCellValueFactory(new PropertyValueFactory<>("note"));

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
            // contracts table
            ObservableList<Contracts> contractsList = FXCollections.observableArrayList(contracts.getAll());
            contracts_table.setItems(contractsList);
            // partners table
            ObservableList<Partners> partnersList = FXCollections.observableArrayList(partners.getAll());
            partners_table.setItems(partnersList);
            // activities table
            ObservableList<Activities> activitiesList = FXCollections.observableArrayList(activites.getAll());
            activites_table.setItems(activitiesList);

        } catch (SQLException ex) {
            System.out.println(ex.toString());
            showAlert(AlertType.ERROR, "Database Error", ex.getMessage());
        }
    }

    @FXML
    private void handel_btns(ActionEvent event) throws IOException, SQLException {
        // disable these btns to prevent erro
        add_volunActivity_btn.setDisable(true);
        delete_voluActivity_btn.setDisable(true);
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
                showPane(add_voluntee_pan);

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
            loadData();
            clearField();

        } else if (event.getSource().equals(contracts_btn)) {

            showPane(contracts_pan);
            loadData();
            clearField();

        } else if (event.getSource().equals(partners_btn)) {

            showPane(partners_pan);
            loadData();
            clearField();

        } else if (event.getSource().equals(activites_btn)) {
            showPane(activites_pan);
            loadData();
            clearField();

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

            Volunteers volunteer = (Volunteers) getUserInput(v_saveU_btn);

            if (volunteer != null)// if the user fill the form
            {
                if (volunteer.getId() == null) {// if the id_txtf is empty that mean the user want to add new voulnteer

                    volunteer.add();// insert data to database
                    clearField();
                    new Alert(AlertType.INFORMATION, "تمت اضافة المعزز بنجاح").showAndWait();

                } else {// update vounteer

                    Volunteers v = (Volunteers) getUserInput(v_saveU_btn);
                    v.update();

                    new Alert(AlertType.INFORMATION, "تم تعديل بيانات المعزز بنجاح").showAndWait();
                    clearField();

                    showPane(volunteers_pan);
                    loadData();
                    volunteer_table.refresh();
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
                            loadData();
                        } catch (SQLException ex) {
                            Logger.getLogger(MainFormController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
            }

        } else if (event.getSource().equals(v_search_btn2)) {

            // if the user didn`t select catorgry or the search text
            if (v_search_txtf.getText().isEmpty() || v_chombox.getSelectionModel().isEmpty()) {

                showAlert(AlertType.ERROR, "خطأ", "الرجاء اخيتار عناصر البحث ");
            } else {
                search(v_search_btn2, v_chombox.getSelectionModel().getSelectedItem());
            }
        }
    }

    @FXML
    private void openFile(MouseEvent event) throws IOException {
        try {
            File file;

            if (!Desktop.isDesktopSupported()) {
                System.err.println("Desktop is not supported on this platform.");
            }

            if (event.getSource() == v_path_lable) {
                Desktop.getDesktop().open(file = new File(v_path_lable.getText())); // Open the file with the default application
            } else if (event.getSource() == d_path_lable) {
                Desktop.getDesktop().open(file = new File(d_path_lable.getText())); // Open the file with the default application
            } else if (event.getSource() == c_carL_lable) {
                Desktop.getDesktop().open(file = new File(c_carL_lable.getText())); // Open the file with the default application
            } else if (event.getSource() == c_driverL_lable) {
                Desktop.getDesktop().open(file = new File(c_driverL_lable.getText())); // Open the file with the default application
            } else if (event.getSource() == c_driver_ID_lable) {
                Desktop.getDesktop().open(file = new File(c_driver_ID_lable.getText())); // Open the file with the default application
            } else if (event.getSource() == c_witness_lable) {
                Desktop.getDesktop().open(file = new File(c_witness_lable.getText())); // Open the file with the default application

            }

        } catch (Exception e) {

            new Alert(Alert.AlertType.ERROR, e.getMessage()).showAndWait();

        }

    }

    private Object getUserInput(Button button) throws IOException {

        if (button == v_saveU_btn) {// if the user want to get volunteer data

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

        } else if (button == d_saveU_btn) {// if the user want to add dramistic 

            if (d_name_txtf.getText().isEmpty() || d_address_txtf.getText().isEmpty() || d_phone_txtf.getText().isEmpty()
                    || d_path_lable.getText().equals("مسار الملف")) {
                showAlert(AlertType.ERROR, "Error", "الرجاء ادخال البيانات");
                return null;
            }

            Dramatists dramatists = new Dramatists();
            if (!d_id_txtf.getText().isEmpty()) {
                dramatists.setId(Integer.parseInt(d_id_txtf.getText()));
            }
            dramatists.setBand_name(d_name_txtf.getText());
            dramatists.setAddrees(d_address_txtf.getText());
            dramatists.setPhone(d_phone_txtf.getText());
            dramatists.setAccount_name(d_account_name_txtf.getText());
            dramatists.setAccount_number(d_account_number_txtf.getText());
            dramatists.setProofIdentity(d_path_lable.getText());
            dramatists.setNotes(d_note_txtf.getText());

            return dramatists;
        } else if (button == c_saveU_btn) {// if the user want to add contract

            if (c_car_owner_name_txtf.getText().isEmpty() || c_address_txtf.getText().isEmpty() || c_phone_txtf.getText().isEmpty()) {
                showAlert(AlertType.ERROR, "Error", "الرجاء ادخال البيانات ");
                return null;
            }

            Contracts contract = new Contracts();
            if (!c_id_txtf.getText().isEmpty()) {
                contract.setId(Integer.parseInt(c_id_txtf.getText()));
            }

            contract.setCar_owner_name(c_car_owner_name_txtf.getText());
            contract.setAddress(c_address_txtf.getText());
            contract.setCar_license(c_carL_lable.getText());
            contract.setDriver_ID(c_driver_ID_lable.getText());
            contract.setWitnesss_ID(c_witness_lable.getText());
            contract.setPhone(c_phone_txtf.getText());
            contract.setDriver_license(c_driver_ID_lable.getText());

            return contract;

        } else if (button == p_saveU_btn) {// if the user want to add partners

            if (p_name_txtf.getText().isEmpty() || p_address_txtf.getText().isEmpty() || p_phone_txtf.getText().isEmpty() || p_activityType_txtf.getText().isEmpty()) {
                showAlert(AlertType.ERROR, "Error", "الرجاء ادخال البيانات ");
                return null;
            }

            Partners partner = new Partners();
            if (!p_id_txtf.getText().isEmpty()) {
                partner.setId(Integer.parseInt(p_id_txtf.getText()));
            }

            partner.setName(p_name_txtf.getText());
            partner.setAddress(p_address_txtf.getText());
            partner.setPhone(p_phone_txtf.getText());
            partner.setActivity_type(p_activityType_txtf.getText());

            return partner;

        } else if (button == a_saveU_btn) {

            if (a_name_txtf.getText().isEmpty() || a_donor_txtf.getText().isEmpty() || a_notes_txtA.getText().isEmpty()
                    || a_location_txtf.getText().isEmpty()) {
                showAlert(AlertType.ERROR, "Error", "الرجاء ادخال البيانات");
                return null;
            }

            Activities activity = new Activities();
            if (!a_id_txtf.getText().isEmpty()) {
                activity.setId(Integer.parseInt(a_id_txtf.getText()));
            }

            activity.setName(a_name_txtf.getText());
            activity.setDonor(a_donor_txtf.getText());
            activity.setNotes(a_notes_txtA.getText());
            activity.setLocation(a_location_txtf.getText());

            return activity;

        }

        return null;
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
        // clear contracts felids
        c_car_owner_name_txtf.setText("");
        c_address_txtf.setText("");
        c_carL_lable.setText("مسار الملف");
        c_driver_ID_lable.setText("مسار الملف");
        c_witness_lable.setText("مسار الملف");
        c_phone_txtf.setText("");
        c_driverL_lable.setText("مسار الملف");
        // clear partners felids
        p_name_txtf.setText("");
        p_address_txtf.setText("");
        p_activityType_txtf.setText("");
        p_phone_txtf.setText("");
        p_id_txtf.setText("");
    }

    public void search(Button btnType, String searchCat) throws SQLException {

        if (btnType == v_search_btn2) {// if the user want to search in volunteers 
            ObservableList<Volunteers> volunteersList = FXCollections.observableArrayList(volunteers.search(searchCat, v_search_txtf.getText()));
            volunteer_table.setItems(volunteersList);
        } else if (btnType == d_search_btn) {// if the user want to search in dramactic 
            ObservableList<Dramatists> dramatisticList = FXCollections.observableArrayList(dramisrc.search(searchCat, D_search_txtf.getText()));
            dramistc_table.setItems(dramatisticList);
        } else if (btnType == c_search_btn) {// if the user want to search in contracts
            ObservableList<Contracts> contractsList = FXCollections.observableArrayList(contracts.search(searchCat, C_search_txtf.getText()));
            contracts_table.setItems(contractsList);
        } else if (btnType == p_search_btn) {// if the user want to search in partners
            ObservableList<Partners> partnersList = FXCollections.observableArrayList(partners.search(searchCat, p_search_txtf.getText()));
            partners_table.setItems(partnersList);
        } else if (btnType == a_search_btn) {
            ObservableList<Activities> activitesList = FXCollections.observableArrayList(activites.search(searchCat, a_search_txtf.getText()));
            activites_table.setItems(activitesList);
        }

    }

    @FXML
    private void handelDramisticBtn(ActionEvent event) throws IOException, SQLException {

        if (event.getSource() == add_dramistic_btn) {

            showPane(add_dramistic_pan);
            loadData();

        } else if (event.getSource() == delete_dramistc_btn) {

            Alert alert = new Alert(AlertType.CONFIRMATION);

            if (dramistc_table.getSelectionModel().getSelectedItem() == null) {// if the user did select item from the table
                new Alert(AlertType.ERROR, "الرجاء اختيار عنصر").showAndWait();
            } else {
                alert.setContentText("هل تريد حذف المعزز؟");
                alert.showAndWait().ifPresent(response -> {
                    if (response == ButtonType.OK) {
                        try {
                            dramistc_table.getSelectionModel().getSelectedItem().remove();
                            loadData();
                        } catch (SQLException ex) {
                            Logger.getLogger(MainFormController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
            }

        } else if (event.getSource() == update_dramistic_btn) {

            if (dramistc_table.getSelectionModel().getSelectedItem() == null) {// if the user did select item from the table
                new Alert(AlertType.ERROR, "الرجاء اختيار عنصر").showAndWait();
            } else {

                Dramatists d = dramistc_table.getSelectionModel().getSelectedItem();
                d_id_txtf.setText(String.valueOf(d.getId()));
                d_name_txtf.setText(d.getBand_name());
                d_address_txtf.setText(d.getAddrees());
                d_phone_txtf.setText(d.getPhone());
                d_account_name_txtf.setText(d.getAccount_name());
                d_account_number_txtf.setText(d.getAccount_number());
                d_path_lable.setText(d.getProof_identity());
                d_note_txtf.setText(d.getNotes());

            }
            showPane(add_dramistic_pan);

        } else if (event.getSource() == d_saveU_btn) {

            Dramatists dramatists = (Dramatists) getUserInput(d_saveU_btn);

            if (dramatists != null)// if the user fill the form
            {
                if (dramatists.getId() == null) {// if the id_txtf is empty that mean the user want to add new voulnteer
                    dramatists.add();// insert data to database
                    clearField();
                    new Alert(AlertType.INFORMATION, "تمت اضافة الفرقة بنجاح").showAndWait();

                } else {// update vounteer

                    Dramatists d = (Dramatists) getUserInput(d_saveU_btn);
                    d.update();

                    new Alert(AlertType.INFORMATION, "تم تعديل بيانات الفرقة بنجاح").showAndWait();
                    clearField();

                    showPane(Dramsitic_pan);

                    loadData();
                    dramistc_table.refresh();
                }

            }

        } else if (event.getSource() == d_selectFile_btn) {

            FileChooser chooser = new FileChooser();

            File selectedFile = chooser.showOpenDialog(null);
            try {
                d_path_lable.setText(selectedFile.getPath());
            } catch (Exception e) {

            }

        } else if (event.getSource() == d_clear) {

            clearField();

        } else if (event.getSource() == d_search_btn) {
            // if the user didn`t select catorgry or the search text
            if (D_search_txtf.getText().isEmpty() || D_chombox.getSelectionModel().isEmpty()) {

                showAlert(AlertType.ERROR, "خطأ", "الرجاء اخيتار عناصر البحث ");
            } else {
                search(d_search_btn, D_chombox.getSelectionModel().getSelectedItem());

            }

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

    @FXML
    private void handelContractsBtn(ActionEvent event) throws SQLException, IOException {
        if (event.getSource() == c_search_btn) {
            // if the user didn`t select catorgry or the search text
            if (C_search_txtf.getText().isEmpty() || C_chombox.getSelectionModel().isEmpty()) {

                showAlert(AlertType.ERROR, "خطأ", "الرجاء اخيتار عناصر البحث ");
            } else {
                search(c_search_btn, C_chombox.getSelectionModel().getSelectedItem());

            }

        } else if (event.getSource() == add_contract_btn) {

            showPane(add_contracts_pan);

        } else if (event.getSource() == delete_contracts_btn) {

            Alert alert = new Alert(AlertType.CONFIRMATION);

            if (contracts_table.getSelectionModel().getSelectedItem() == null) {// if the user did select item from the table
                new Alert(AlertType.ERROR, "الرجاء اختيار عنصر").showAndWait();
            } else {
                alert.setContentText("هل تريد حذف المتعاقد؟");
                alert.showAndWait().ifPresent(response -> {
                    if (response == ButtonType.OK) {
                        try {
                            contracts_table.getSelectionModel().getSelectedItem().remove();
                            loadData();
                        } catch (SQLException ex) {
                            Logger.getLogger(MainFormController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
            }

        } else if (event.getSource() == update_contracts_btn) {

            if (contracts_table.getSelectionModel().getSelectedItem() == null) {// if the user did select item from the table
                new Alert(AlertType.ERROR, "الرجاء اختيار عنصر ").showAndWait();

            } else {
                Contracts c = contracts_table.getSelectionModel().getSelectedItem();

                c_id_txtf.setText(String.valueOf(c.getId()));
                c_car_owner_name_txtf.setText(c.getCar_owner_name());
                c_address_txtf.setText(c.getAddress());
                c_carL_lable.setText(c.getCar_license());
                c_driver_ID_lable.setText(c.getDriver_ID());
                c_driverL_lable.setText(c.getWitnesss_ID());
                c_phone_txtf.setText(c.getPhone());
                c_witness_lable.setText(c.getDriver_license());

                showPane(add_contracts_pan);

            }

        } else if (event.getSource() == c_clear) {
            clearField();
        } else if (event.getSource() == c_saveU_btn) {
            Contracts contracts = (Contracts) getUserInput(c_saveU_btn);

            if (contracts != null) {
                if (contracts.getId() == null) {
                    contracts.add();
                    clearField();
                    new Alert(AlertType.INFORMATION, "تمت اضافة المتعاقد بنجاح").showAndWait();
                } else {
                    contracts.update();
                    new Alert(AlertType.INFORMATION, "تم تعديل بيانات المتعاقد بنجاح").showAndWait();
                    clearField();
                    showPane(contracts_pan);
                    loadData();
                    contracts_table.refresh();
                }
            }

        } else if (event.getSource() == c_selectCarL_btn) {
            FileChooser chooser = new FileChooser();

            File selectedFile = chooser.showOpenDialog(null);
            try {
                c_carL_lable.setText(selectedFile.getPath());
            } catch (Exception e) {
            }

        } else if (event.getSource() == c_selectDriverL_btn) {
            FileChooser chooser = new FileChooser();

            File selectedFile = chooser.showOpenDialog(null);
            try {
                c_driverL_lable.setText(selectedFile.getPath());
            } catch (Exception e) {
            }
        } else if (event.getSource() == c_selectWitness_btn) {
            FileChooser chooser = new FileChooser();

            File selectedFile = chooser.showOpenDialog(null);
            try {
                c_witness_lable.setText(selectedFile.getPath());
            } catch (Exception e) {
            }

        } else if (event.getSource() == c_selectDriverID_btn) {
            FileChooser chooser = new FileChooser();

            File selectedFile = chooser.showOpenDialog(null);
            try {
                c_driver_ID_lable.setText(selectedFile.getPath());
            } catch (Exception e) {
            }
        }

    }

    @FXML
    private void handelPartnersBtn(ActionEvent event) throws IOException, SQLException {
        if (event.getSource() == p_search_btn) {
            // if the user didn`t select catorgry or the search text
            if (p_search_txtf.getText().isEmpty() || p_chombox.getSelectionModel().isEmpty()) {

                showAlert(AlertType.ERROR, "خطأ", "الرجاء اختيار عناصر البحث  ");
            } else {
                search(p_search_btn, p_chombox.getSelectionModel().getSelectedItem());

            }
        } else if (event.getSource() == add_partners_btn) {
            showPane(add_partners_pan);

        } else if (event.getSource() == delete_parrtners_btn) {

            Alert alert = new Alert(AlertType.CONFIRMATION);

            if (partners_table.getSelectionModel().getSelectedItem() == null) {// if the user did select item from the table
                new Alert(AlertType.ERROR, "الرجاء اختيار عنصر").showAndWait();
            } else {
                alert.setContentText("هل تريد حذف المتعاقد؟");
                alert.showAndWait().ifPresent(response -> {
                    if (response == ButtonType.OK) {
                        try {
                            partners_table.getSelectionModel().getSelectedItem().remove();
                            loadData();
                        } catch (SQLException ex) {
                            Logger.getLogger(MainFormController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
            }

        } else if (event.getSource() == update_partners_btn) {
            if (partners_table.getSelectionModel().getSelectedItem() == null) {// if the user did select item from the table
                new Alert(AlertType.ERROR, "الرجاء اختيار عنصر").showAndWait();

            } else {
                Partners p = partners_table.getSelectionModel().getSelectedItem();

                p_id_txtf.setText(String.valueOf(p.getId()));
                p_name_txtf.setText(p.getName());
                p_address_txtf.setText(p.getAddress());
                p_phone_txtf.setText(p.getPhone());
                p_activityType_txtf.setText(p.getActivity_type());

                showPane(add_partners_pan);

            }

        } else if (event.getSource() == p_clear) {
            clearField();

        } else if (event.getSource() == p_saveU_btn) {

            Partners partner = (Partners) getUserInput(p_saveU_btn);

            if (partner != null) {
                if (partner.getId() == null) {
                    partner.add();
                    clearField();
                    new Alert(AlertType.INFORMATION, "تمت اضافة الشريك بنجاح").showAndWait();
                } else {
                    partner.update();
                    new Alert(AlertType.INFORMATION, "تم تعديل بيانات الشريك بنجاح").showAndWait();
                    clearField();
                    showPane(partners_pan);
                    loadData();
                    partners_table.refresh();
                }
            }
        }
    }

    @FXML
    private void handelActivitesBtn(ActionEvent event) throws SQLException, IOException {
        if (event.getSource() == a_search_btn) {
            // if the user didn't select category or the search text
            if (a_search_txtf.getText().isEmpty() || a_chombox.getSelectionModel().isEmpty()) {
                showAlert(AlertType.ERROR, "خطأ", "الرجاء اختيار عناصر البحث");
            } else {
                search(a_search_btn, a_chombox.getSelectionModel().getSelectedItem());
            }
        } else if (event.getSource() == add_activite_btn) {
            showPane(add_activite_pan);
        } else if (event.getSource() == delete_activite_btn) {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            if (activites_table.getSelectionModel().getSelectedItem() == null) {
                new Alert(AlertType.ERROR, "الرجاء اختيار عنصر").showAndWait();
            } else {
                alert.setContentText("هل تريد حذف النشاط؟");
                alert.showAndWait().ifPresent(response -> {
                    if (response == ButtonType.OK) {
                        try {
                            activites_table.getSelectionModel().getSelectedItem().remove();
                            loadData();
                        } catch (SQLException ex) {
                            Logger.getLogger(MainFormController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
            }
        } else if (event.getSource() == update_activite_btn) {
            if (activites_table.getSelectionModel().getSelectedItem() == null) {
                new Alert(AlertType.ERROR, "الرجاء اختيار عنصر").showAndWait();
            } else {
                Activities a = activites_table.getSelectionModel().getSelectedItem();
                a_id_txtf.setText(String.valueOf(a.getId()));
                a_name_txtf.setText(a.getName());
                a_donor_txtf.setText(a.getDonor());
                a_location_txtf.setText(a.getLocation());
                a_notes_txtA.setText(a.getNotes());
                showPane(add_activite_pan);
            }
        } else if (event.getSource() == a_clear) {
            clearActivityFields();
        } else if (event.getSource() == a_saveU_btn) {
            Activities activity = (Activities) getUserInput(a_saveU_btn);
            if (activity != null) {
                if (activity.getId() == null) {
                    activity.add();
                    clearActivityFields();
                    new Alert(AlertType.INFORMATION, "تمت إضافة النشاط بنجاح").showAndWait();
                } else {
                    activity.update();
                    new Alert(AlertType.INFORMATION, "تم تعديل بيانات النشاط بنجاح").showAndWait();
                    clearActivityFields();
                    showPane(activites_pan);
                    loadData();
                    activites_table.refresh();
                }
            }
        } else if (event.getSource() == L_back_btn) {

            add_volunActivity_btn.setDisable(true);
            delete_voluActivity_btn.setDisable(true);
            showPane(activites_pan);

        } else if (event.getSource() == add_volunActivity_btn) {
            
            int activityID = activites_table.getSelectionModel().getSelectedItem().getId();

        } else if (event.getSource() == add_volnToActivity_btn) {// this btn show volunteer pan

            add_volunActivity_btn.setDisable(false);
            showPane(Lvolunteers_pan);

        } else if (event.getSource() == display_volun_btn) {

            if (activites_table.getSelectionModel().getSelectedItem() == null) {

                showAlert(AlertType.ERROR, "error", "الرجاء اختبار العنصر ");

            } else {
                Integer activityID = activites_table.getSelectionModel().getSelectedItem().getId();
                ObservableList<Volunteers> volunteersList = FXCollections.observableArrayList(volunteers.getVoluntByActivity(String.valueOf(activityID)));
                Lvolunteer_table.setItems(volunteersList);
                delete_voluActivity_btn.setDisable(false);
                showPane(Lvolunteers_pan);
            }

        } else if (event.getSource() == delete_voluActivity_btn) {

        }
    }

    private void clearActivityFields() {
        a_id_txtf.setText("");
        a_name_txtf.setText("");
        a_donor_txtf.setText("");
        a_location_txtf.setText("");
        a_notes_txtA.setText("");
    }
}
