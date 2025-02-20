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
public class Contracts extends Database {

    private Integer id;
    private String car_owner_name;
    private String address;
    private String car_license;
    private String driver_ID;
    private String witnesss_ID;
    private String phone;
    private String driver_license;

    public Contracts() {
    }

    public Contracts(Integer id) {
        this.id = id;
    }

    public Contracts(Integer id, String car_owner_name, String address, String car_license, String driver_ID, String witnesss_ID, String phone, String driver_license) {
        this.id = id;
        this.car_owner_name = car_owner_name;
        this.address = address;
        this.car_license = car_license;
        this.driver_ID = driver_ID;
        this.witnesss_ID = witnesss_ID;
        this.phone = phone;
        this.driver_license = driver_license;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCar_owner_name() {
        return car_owner_name;
    }

    public void setCar_owner_name(String car_owner_name) {
        this.car_owner_name = car_owner_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCar_license() {
        return car_license;
    }

    public void setCar_license(String car_license) {
        this.car_license = car_license;
    }

    public String getDriver_ID() {
        return driver_ID;
    }

    public void setDriver_ID(String driver_ID) {
        this.driver_ID = driver_ID;
    }

    public String getWitnesss_ID() {
        return witnesss_ID;
    }

    public void setWitnesss_ID(String witnesss_ID) {
        this.witnesss_ID = witnesss_ID;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDriver_license() {
        return driver_license;
    }

    public void setDriver_license(String driver_license) {
        this.driver_license = driver_license;
    }

    // Method to get all contracts from the database
    public List<Contracts> getAll() throws SQLException {
        String sql = "SELECT * FROM `contracts`;";
        List<Contracts> list = new ArrayList<>();

        con = getConnection();
        pre = con.prepareStatement(sql);
        resultSet = pre.executeQuery();

        while (resultSet.next()) {
            Contracts contract = new Contracts(
                    resultSet.getInt("id"),
                    resultSet.getString("car_owner_name"),
                    resultSet.getString("addrees"),
                    resultSet.getString("car_license"),
                    resultSet.getString("driver_ID"),
                    resultSet.getString("witnesss_ID"),
                    resultSet.getString("phone"),
                    resultSet.getString("driver_license")
            );
            list.add(contract);
        }

        resultSet.close();
        pre.close();
        con.close();

        return list;
    }

    // Method to add a new contract to the database
    public void add() throws SQLException {
        con = getConnection();
        pre = con.prepareStatement("INSERT INTO `contracts`(`car_owner_name`, `address`, `car_license`, `driver_ID`, `witnesss_ID`, `phone`, `driver_license`) VALUES (?,?,?,?,?,?,?)");

        pre.setString(1, car_owner_name);
        pre.setString(2, address);
        pre.setString(3, car_license);
        pre.setString(4, driver_ID);
        pre.setString(5, witnesss_ID);
        pre.setString(6, phone);
        pre.setString(7, driver_license);

        pre.executeUpdate();

        pre.close();
        con.close();
    }

    // Method to remove a contract from the database
    public void remove() throws SQLException {
        con = getConnection();
        pre = con.prepareStatement("DELETE FROM `contracts` WHERE id=?");
        pre.setInt(1, id);
        pre.executeUpdate();

        pre.close();
        con.close();
    }

    // Method to update a contract in the database
    public void update() throws SQLException {
        con = getConnection();
        pre = con.prepareStatement("UPDATE `contracts` SET `car_owner_name`=?, `address`=?, `car_license`=?, `driver_ID`=?, `witnesss_ID`=?, `phone`=?, `driver_license`=? WHERE id=?");

        pre.setString(1, car_owner_name);
        pre.setString(2, address);
        pre.setString(3, car_license);
        pre.setString(4, driver_ID);
        pre.setString(5, witnesss_ID);
        pre.setString(6, phone);
        pre.setString(7, driver_license);
        pre.setInt(8, id);

        pre.executeUpdate();

        pre.close();
        con.close();
    }

    // Method to search for contracts based on a category and search text
    public List<Contracts> search(String cat, String txt) throws SQLException {
        String category = switch (cat) {
            case "الاسم" -> "car_owner_name";
            case "العنوان" -> "addrees";
            default -> "";
        };

        String sql = "SELECT * FROM `contracts` WHERE `" + category +"` LIKE '%"+txt+"%';";
        List<Contracts> list = new ArrayList<>();
        System.out.println(sql);
        con = getConnection();
        pre = con.prepareStatement(sql);
        resultSet = pre.executeQuery();

        while (resultSet.next()) {
            Contracts contract = new Contracts(
                    resultSet.getInt("id"),
                    resultSet.getString("car_owner_name"),
                    resultSet.getString("addrees"),
                    resultSet.getString("car_license"),
                    resultSet.getString("driver_ID"),
                    resultSet.getString("witnesss_ID"),
                    resultSet.getString("phone"),
                    resultSet.getString("driver_license")
            );
            list.add(contract);
        }

        resultSet.close();
        pre.close();
        con.close();

        return list;
    }
}