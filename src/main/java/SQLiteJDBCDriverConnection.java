import java.sql.*;

public class SQLiteJDBCDriverConnection {
    public static Connection getConnect()throws SQLException, ClassNotFoundException{

        String url = "jdbc:sqlite:NetworkDB.db";
        Connection connection = DriverManager.getConnection(url);;
        System.out.println("Connect to database");
        return connection;

    }
    public boolean checkUserPassword(String user,String password){
        Connection connection = null;
        try {
            connection = getConnect();
            String query = "SELECT * FROM USER WHERE username = '" + user + "'AND password = '" + password + "';";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String pass = resultSet.getString(2);
                if (password.equals(pass)) {
                    connection.close();
                    return true;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;


    }
    public int getBalance(String user){
        Connection connection = null;
        try {
            connection = getConnect();
            String query = "SELECT * FROM USER WHERE username = '" + user + "';";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            int balance = resultSet.getInt(3);
            return balance;


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }



}
