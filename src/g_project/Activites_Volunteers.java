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
public class Activites_Volunteers extends Database {

    private Integer id;
    private Integer activities;
    private Integer volunteer;

    public Activites_Volunteers() {
    }

    public Activites_Volunteers(Integer id) {
        this.id = id;
    }

    public Activites_Volunteers(Integer id, Integer activities, Integer volunteer) {
        this.id = id;
        this.activities = activities;
        this.volunteer = volunteer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getActivities() {
        return activities;
    }

    public void setActivities(Integer activities) {
        this.activities = activities;
    }

    public Integer getVolunteer() {
        return volunteer;
    }

    public void setVolunteer(Integer volunteer) {
        this.volunteer = volunteer;
    }

    // Method to get all activities_volunteer records from the database
    public List<Activites_Volunteers> getAll() throws SQLException {
        String sql = "SELECT * FROM `activities_volunteer`;";
        List<Activites_Volunteers> list = new ArrayList<>();

        con = getConnection();
        pre = con.prepareStatement(sql);
        resultSet = pre.executeQuery();

        while (resultSet.next()) {
            Activites_Volunteers record = new Activites_Volunteers(
                    resultSet.getInt("id"),
                    resultSet.getInt("activities"),
                    resultSet.getInt("volunteer")
            );
            list.add(record);
        }

        resultSet.close();
        pre.close();
        con.close();

        return list;
    }

    // Method to add a new activities_volunteer record to the database
    public void add() throws SQLException {
        con = getConnection();
        pre = con.prepareStatement("INSERT INTO `activities_volunteer`(`activities`, `volunteer`) VALUES (?,?)");

        pre.setInt(1, activities);
        pre.setInt(2, volunteer);

        pre.executeUpdate();

        pre.close();
        con.close();
    }

    // Method to remove an activities_volunteer record from the database
    public void remove() throws SQLException {
        con = getConnection();
        pre = con.prepareStatement("DELETE FROM `activities_volunteer` WHERE id=?");
        pre.setInt(1, id);
        pre.executeUpdate();

        pre.close();
        con.close();
    }

    // Method to update an activities_volunteer record in the database
    public void update() throws SQLException {
        con = getConnection();
        pre = con.prepareStatement("UPDATE `activities_volunteer` SET `activities`=?, `volunteer`=? WHERE id=?");

        pre.setInt(1, activities);
        pre.setInt(2, volunteer);
        pre.setInt(3, id);

        pre.executeUpdate();

        pre.close();
        con.close();
    }

    // Method to search for activities_volunteer records based on a category and search text
    public List<Activites_Volunteers> search(String category, String searchText) throws SQLException {
        String column = switch (category) {
            case "activities" -> "activities";
            case "volunteer" -> "volunteer";
            default -> "";
        };

        String sql = "SELECT * FROM `activities_volunteer` WHERE `" + column + "` LIKE ?;";
        List<Activites_Volunteers> list = new ArrayList<>();

        con = getConnection();
        pre = con.prepareStatement(sql);
        pre.setString(1, "%" + searchText + "%");
        resultSet = pre.executeQuery();

        while (resultSet.next()) {
            Activites_Volunteers record = new Activites_Volunteers(
                    resultSet.getInt("id"),
                    resultSet.getInt("activities"),
                    resultSet.getInt("volunteer")
            );
            list.add(record);
        }

        resultSet.close();
        pre.close();
        con.close();

        return list;
    }
}