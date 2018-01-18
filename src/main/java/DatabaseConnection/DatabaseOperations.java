package DatabaseConnection;

import modal.User;

import java.sql.*;

public class DatabaseOperations {

    public  DatabaseOperations(){
    }



    public User login (String userName, String userPassword) {
        Connection con = Connections.getInstance().getCon();
        User user = new User();
        String query = "Select * From user Where userName='" + userName + "' and userPassword='" + userPassword + "'";

        try {

            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                user.setUserName(resultSet.getString(2));
                user.setUserPassword(resultSet.getString(3));
                user.setUserFirstName(resultSet.getString(4));
                user.setUserLastName(resultSet.getString(5));
                user.setUserEmail(resultSet.getString(6));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void Insert( User user){
        Connection con = Connections.getInstance().getCon();
        String query="Insert Into user (userName,userFirstName,userLastName,userPassword,userEmail) Values(?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement=con.prepareStatement(query);
            preparedStatement.setString(1,user.getUserName());
            preparedStatement.setString(2,user.getUserFirstName());
            preparedStatement.setString(3,user.getUserLastName());
            preparedStatement.setString(5,user.getUserEmail());
            preparedStatement.setString(4,user.getUserPassword());
            preparedStatement.execute();

            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Connections.getInstance().closeCon();
    }

}
