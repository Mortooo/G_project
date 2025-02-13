package g_project;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Users extends Database {

    private Integer id;
    private String userName;
    private String password;

    public static Users currentUser = new Users();

    public void setAsCurrentUser() {
        Users.currentUser = this;
    }

    public static void setCurrentUser(Users currentUser) {
        Users.currentUser = currentUser;
    }

    public Users() {
    }

    public Users(Integer id) {
        this.id = id;
    }

    public Users(Integer id, String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    //=============================================================================================================
    public List<Users> getAll() throws SQLException {
        List<Users> list = new ArrayList<Users>();

        con = getConnection();
        pre = con.prepareStatement("SELECT * FROM `users` ;");
        resultSet = pre.executeQuery();

        while (resultSet.next()) {
            Users user = new Users(resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3));
            list.add(user);
        }

        resultSet.close();
        pre.close();
        con.close();

        return list;
    }

    public void add() throws SQLException {
        con = getConnection();
        pre = con.prepareStatement("INSERT INTO `users`(`user_name`, `password`, `account_type`) VALUES (?,?,?)");

        pre.setString(1, userName);
        pre.setString(2, password);
        pre.executeUpdate();

        pre.close();
        con.close();

    }

    public void remove() throws SQLException {
        con = getConnection();
        pre = con.prepareStatement("DELETE FROM `users` WHERE id=?");

        pre.setInt(1, id);
        pre.executeUpdate();

        pre.close();
        con.close();

    }

    public void update() throws SQLException {
        con = getConnection();
        pre = con.prepareStatement("UPDATE `users` SET `user_name`=?,`password`=?,`account_type`=? WHERE id = ?;");

        pre.setString(1, userName);
        pre.setString(2, password);
        pre.setInt(4, id);

        pre.executeUpdate();

        pre.close();
        con.close();

    }

    public boolean isExist() throws SQLException {

        boolean result = false;

        con = getConnection();
        pre = con.prepareStatement("SELECT * FROM users WHERE user_name=? AND password=?;");
        pre.setString(1, userName);
        pre.setString(2, password);
        resultSet = pre.executeQuery();

        if (resultSet.next()) {

            Users user = new Users(resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3));

            user.setAsCurrentUser();

            result = true;

        }

        return result;
    }
    
     public void SaveToDB(List<Users> Users) throws SQLException {
        con = getConnection();
        String sql = "DELETE  FROM users;";
        pre = con.prepareStatement(sql);
        pre.executeUpdate();
        
          sql = "ALTER TABLE users AUTO_INCREMENT = 1;";
        pre = con.prepareStatement(sql);
        pre.executeUpdate();

        sql = "INSERT INTO `users`( `user_name`, `password`, `account_type`) VALUES (?,?,?);";
        pre = con.prepareStatement(sql);
        for (Users User1 : Users) {
            pre.setString(1, User1.getUserName());
            pre.setString(2, User1.getPassword());

            pre.executeUpdate();
        }

        pre.close();
        con.close();

    }

}
