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
public class Partners extends Database {

    private Integer id;
    private String name;
    private String address;
    private String activity_type;
    private String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Partners() {
    }

    public Partners(Integer id) {
        this.id = id;
    }

    public Partners(Integer id, String name, String address, String activity_type,String phone) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.activity_type = activity_type;
        this.phone=phone;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getActivity_type() {
        return activity_type;
    }

    public void setActivity_type(String activity_type) {
        this.activity_type = activity_type;
    }

    // Method to get all partners from the database
    public List<Partners> getAll() throws SQLException {
        String sql = "SELECT * FROM `partners`;";
        List<Partners> list = new ArrayList<>();

        con = getConnection();
        pre = con.prepareStatement(sql);
        resultSet = pre.executeQuery();

        while (resultSet.next()) {
            Partners partner = new Partners(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("addrees"),
                    resultSet.getString("activity_type"),
                    resultSet.getString("phone")
            );
            list.add(partner);
        }

        resultSet.close();
        pre.close();
        con.close();

        return list;
    }

    // Method to add a new partner to the database
    public void add() throws SQLException {
        con = getConnection();
        pre = con.prepareStatement("INSERT INTO `partners`(`name`, `addrees`, `activity_type`,phone) VALUES (?,?,?,?)");

        pre.setString(1, name);
        pre.setString(2, address);
        pre.setString(3, activity_type);
        pre.setString(4, phone);

        pre.executeUpdate();

        pre.close();
        con.close();
    }

    // Method to remove a partner from the database
    public void remove() throws SQLException {
        con = getConnection();
        pre = con.prepareStatement("DELETE FROM `partners` WHERE id=?");
        pre.setInt(1, id);
        pre.executeUpdate();

        pre.close();
        con.close();
    }

    // Method to update a partner in the database
    public void update() throws SQLException {
        con = getConnection();
        pre = con.prepareStatement("UPDATE `partners` SET `name`=?, `addrees`=?, `activity_type`=?,phone=? WHERE id=?");

        pre.setString(1, name);
        pre.setString(2, address);
        pre.setString(3, activity_type);
        pre.setString(4, phone);
        pre.setInt(5, id);

        pre.executeUpdate();

        pre.close();
        con.close();
    }

    // Method to search for partners based on a category and search text
    public List<Partners> search(String category, String searchText) throws SQLException {
        String column = switch (category) {
            case "الاسم" -> "name";
            case "نوع النشاط" -> "activity_type";
            default -> "";
        };

        String sql = "SELECT * FROM `partners` WHERE `" + column + "` LIKE ?;";
        List<Partners> list = new ArrayList<>();

        con = getConnection();
        pre = con.prepareStatement(sql);
        pre.setString(1, "%" + searchText + "%");
        resultSet = pre.executeQuery();

        while (resultSet.next()) {
            Partners partner = new Partners(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("addrees"),
                    resultSet.getString("activity_type"),
                    resultSet.getString("phone")
            );
            list.add(partner);
        }

        resultSet.close();
        pre.close();
        con.close();

        return list;
    }
}