/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package g_project;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mortooo.x
 */
public class Volunteers extends Database {

    private Integer id;
    private String name;
    private String addrees;
    private String phone;
    private String account_name;
    private String account_number;
    private String proof_identity;
    private String calss;
    private String note;

    public Volunteers() {
    }

    public Volunteers(Integer id) {
        this.id = id;
    }

    public Volunteers(Integer id, String name, String addrees, String phone, String account_name, String account_number, String proofIdentity, String calss, String note) {
        this.id = id;
        this.name = name;
        this.addrees = addrees;
        this.phone = phone;
        this.account_name = account_name;
        this.account_number = account_number;
        this.proof_identity = proofIdentity;
        this.calss = calss;
        this.note = note;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        this.account_name = accountName;
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

    public void setProof_identity(String proofIdentity) {
        this.proof_identity = proofIdentity;
    }

    public String getCalss() {
        return calss;
    }

    public void setCalss(String calss) {
        this.calss = calss;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public List<Volunteers> getAll() throws SQLException {

        String sql = "SELECT * FROM `volunteers` ;";

        List<Volunteers> list = new ArrayList<Volunteers>();

        con = getConnection();
        pre = con.prepareStatement(sql);
        resultSet = pre.executeQuery();

        while (resultSet.next()) {

            Volunteers volunteer = new Volunteers(resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7),
                    resultSet.getString(8),
                    resultSet.getString(9)
            );

            list.add(volunteer);
        }

        resultSet.close();
        pre.close();
        con.close();

        return list;
    }

    public void add() throws SQLException {
        con = getConnection();
        pre = con.prepareStatement("INSERT INTO `volunteers`(`name`, `addrees`, `phone`, `account_name`, `account_number`, `proof_identity`, `calss`, `note`) VALUES (?,?,?,?,?,?,?,?)");

        pre.setString(1, name);
        pre.setString(2, addrees);
        pre.setString(3, phone);
        pre.setString(4, account_name);
        pre.setString(5, account_number);
        pre.setString(6, proof_identity);
        pre.setString(7, calss);
        pre.setString(8, note);

        pre.executeUpdate();

        pre.close();
        con.close();

    }

    public void remove() throws SQLException {
        con = getConnection();

        pre = con.prepareStatement("DELETE FROM `volunteers` WHERE id=?");

        pre.setInt(1, id);
        pre.executeUpdate();

        pre.close();
        con.close();

    }

    public void update() throws SQLException {
        con = getConnection();
        pre = con.prepareStatement("UPDATE `volunteers` SET `name`=?,`addrees`=?,`phone`=?,`account_name`=?,`account_number`=?,`proof_identity`=?,`calss`=?,`note`=? WHERE id=?;");

        pre.setString(1, name);
        pre.setString(2, addrees);
        pre.setString(3, phone);
        pre.setString(4, account_name);
        pre.setString(5, account_number);
        pre.setString(6, proof_identity);
        pre.setString(7, calss);
        pre.setString(8, note);
        pre.setInt(9, id);

        pre.executeUpdate();

        pre.close();
        con.close();

    }

    public List<Volunteers> search(String cat,String txt) throws SQLException {
     
        String catogry=switch (cat) {
            case "الاسم" ->"name";
            case "العنوان"->"addrees";
            case "الملاحظات"->"note";
            case "الفئة"->"calss";
            default ->"";
        };

        
        
        String sql = "SELECT * FROM `volunteers` WHERE `"+catogry+"` LIKE '%"+txt+"%';";

        List<Volunteers> list = new ArrayList<Volunteers>();

        con = getConnection();
        pre = con.prepareStatement(sql);
        resultSet = pre.executeQuery();

        while (resultSet.next()) {

            Volunteers volunteer = new Volunteers(resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7),
                    resultSet.getString(8),
                    resultSet.getString(9)
            );

            list.add(volunteer);
        }

        resultSet.close();
        pre.close();
        con.close();

        return list;
    }
    
    
    public List<Volunteers> getVoluntByActivity(String ActivityID) throws SQLException {
     
//        String sql = "SELECT * FROM `volunteers` WHERE `"+catogry+"` LIKE '%"+txt+"%';";
        String sql = "SELECT volunteers.id , `name`, `addrees`, `phone`, `account_name`, `account_number`, `proof_identity`, `calss`, `note` "
                + "FROM `volunteers`JOIN activites_volunteer on activites_volunteer.volunteer = volunteers.id AND activites_volunteer.activites = "+ActivityID+";";

        List<Volunteers> list = new ArrayList<Volunteers>();

        con = getConnection();
        pre = con.prepareStatement(sql);
        resultSet = pre.executeQuery();

        while (resultSet.next()) {

            Volunteers volunteer = new Volunteers(resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7),
                    resultSet.getString(8),
                    resultSet.getString(9)
            );

            list.add(volunteer);
        }

        resultSet.close();
        pre.close();
        con.close();

        return list;
    }
    
    
    
    

}
