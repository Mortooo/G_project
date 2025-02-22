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
public class Activities extends Database {

    private Integer id;
    private String name;
    private String donor;
    private String notes;
    private String location;

    public Activities() {
    }

    public Activities(Integer id) {
        this.id = id;
    }

    public Activities(Integer id, String name, String donor, String notes, String location) {
        this.id = id;
        this.name = name;
        this.donor = donor;
        this.notes = notes;
        this.location = location;
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

    public String getDonor() {
        return donor;
    }

    public void setDonor(String donor) {
        this.donor = donor;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    // Method to get all activities from the database
    public List<Activities> getAll() throws SQLException {
        String sql = "SELECT * FROM `activities`;";
        List<Activities> list = new ArrayList<>();

        con = getConnection();
        pre = con.prepareStatement(sql);
        resultSet = pre.executeQuery();

        while (resultSet.next()) {
            Activities activity = new Activities(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("donor"),
                    resultSet.getString("notes"),
                    resultSet.getString("location")
            );
            list.add(activity);
        }

        resultSet.close();
        pre.close();
        con.close();

        return list;
    }

    // Method to add a new activity to the database
    public void add() throws SQLException {
        con = getConnection();
        pre = con.prepareStatement("INSERT INTO `activities`(`name`, `donor`, `notes`, `location`) VALUES (?,?,?,?)");

        pre.setString(1, name);
        pre.setString(2, donor);
        pre.setString(3, notes);
        pre.setString(4, location);

        pre.executeUpdate();

        pre.close();
        con.close();
    }

    // Method to remove an activity from the database
    public void remove() throws SQLException {
        con = getConnection();
        pre = con.prepareStatement("DELETE FROM `activities` WHERE id=?");
        pre.setInt(1, id);
        pre.executeUpdate();

        pre.close();
        con.close();
    }

    // Method to update an activity in the database
    public void update() throws SQLException {
        con = getConnection();
        pre = con.prepareStatement("UPDATE `activities` SET `name`=?, `donor`=?, `notes`=?, `location`=? WHERE id=?");

        pre.setString(1, name);
        pre.setString(2, donor);
        pre.setString(3, notes);
        pre.setString(4, location);
        pre.setInt(5, id);

        pre.executeUpdate();

        pre.close();
        con.close();
    }

    // Method to search for activities based on a category and search text
    public List<Activities> search(String category, String searchText) throws SQLException {
        String column = switch (category) {
            case "الاسم" -> "name";
            case "المانح" -> "donor";
            default -> "";
        };

        String sql = "SELECT * FROM `activities` WHERE `" + column + "` LIKE ?;";
        List<Activities> list = new ArrayList<>();

        con = getConnection();
        pre = con.prepareStatement(sql);
        pre.setString(1, "%" + searchText + "%");
        resultSet = pre.executeQuery();

        while (resultSet.next()) {
            Activities activity = new Activities(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("donor"),
                    resultSet.getString("notes"),
                    resultSet.getString("location")
            );
            list.add(activity);
        }

        resultSet.close();
        pre.close();
        con.close();

        return list;
    }
}