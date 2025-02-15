/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package g_project;

import static g_project.Database.getConnection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Mortooo.x
 */
public class Dramatists extends Database {

    private Integer id;
    private String band_name;
    private String addrees;
    private String phone;
    private String account_name;
    private String account_number;
    private String proof_identity;
    private String notes;

    public Dramatists() {
    }

    public Dramatists(Integer id) {
        this.id = id;
    }

    public Dramatists(Integer id, String band_name, String addrees, String phone, String accountName, String accountNumber, String proofIdentity, String notes) {
        this.id = id;
        this.band_name = band_name;
        this.addrees = addrees;
        this.phone = phone;
        this.account_name = accountName;
        this.account_number = accountNumber;
        this.proof_identity = proofIdentity;
        this.notes = notes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBand_name() {
        return band_name;
    }

    public void setBand_name(String bandName) {
        this.band_name = bandName;
    }

    public String getAddrees() {
        return addrees;
    }

    public void setAddrees(String addrees) {
        this.addrees = addrees;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAccount_name() {
        return account_name;
    }

    public void setAccount_name(String accountName) {
        this.account_number = accountName;
    }

    public String getAccount_number() {
        return account_number;
    }

    public void setAccount_number(String accountNumber) {
        this.account_number = accountNumber;
    }

    public String getProof_identity() {
        return proof_identity;
    }

    public void setProofIdentity(String proofIdentity) {
        this.proof_identity = proofIdentity;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
    
    public List<Dramatists> getAll() throws SQLException {

        String sql = "SELECT * FROM `dramatists` ;";

        List<Dramatists> list = new ArrayList<Dramatists>();

        con = getConnection();
        pre = con.prepareStatement(sql);
        resultSet = pre.executeQuery();

        while (resultSet.next()) {

            Dramatists dramatists = new Dramatists(resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7),
                    resultSet.getString(8)
            );

            list.add(dramatists);
        }

        resultSet.close();
        pre.close();
        con.close();

        return list;
    }
    
    
    public void add() throws SQLException {
        con = getConnection();
        pre = con.prepareStatement("INSERT INTO `volunteers`(`band_name`, `addrees`, `phone`, `account_name`, `account_number`, `proof_identity`, `notes`) VALUES (?,?,?,?,?,?,?)");

        pre.setString(1, band_name);
        pre.setString(2, addrees);
        pre.setString(3, phone);
        pre.setString(4, account_name);
        pre.setString(5, account_number);
        pre.setString(6, proof_identity);
        pre.setString(8, notes);

        pre.executeUpdate();

        pre.close();
        con.close();

    }

    public void remove() throws SQLException {
        con = getConnection();

        pre = con.prepareStatement("DELETE FROM `dramatists` WHERE id=?");

        pre.setInt(1, id);
        pre.executeUpdate();

        pre.close();
        con.close();

    }

    public void update() throws SQLException {
        con = getConnection();
        pre = con.prepareStatement("UPDATE `dramatists` SET `band_name`=?,`addrees`=?,`phone`=?,`account_name`=?,`account_number`=?,`proof_identity`=?,`notes`=? WHERE id=?;");

        pre.setString(1, band_name);
        pre.setString(2, addrees);
        pre.setString(3, phone);
        pre.setString(4, account_name);
        pre.setString(5, account_number);
        pre.setString(6, proof_identity);
        pre.setString(7, notes);
        pre.setInt(8, id);

        pre.executeUpdate();

        pre.close();
        con.close();

    }

}
