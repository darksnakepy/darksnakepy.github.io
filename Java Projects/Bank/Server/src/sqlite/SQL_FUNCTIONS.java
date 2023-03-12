package sqlite;
import java.sql.*;

public class SQL_FUNCTIONS {
    static Connection connection = null;
    static String db_path = "jdbc:sqlite:C:\\Users\\darksnake\\Desktop\\school\\darksnakepy.github.io\\Java Projects\\Bank\\Server\\src\\sqlite\\bank.db";

    // works
    public static boolean connectionHandle() {
        try {
            connection = DriverManager.getConnection(db_path);
            createNewTable();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // works
    public static void createNewTable() {

        // preparing SQL statement to create a new table
        String table = "CREATE TABLE IF NOT EXISTS bank (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	user text NOT NULL,\n"
                + " password text NOT NULL,\n"
                + "	balance double,\n"
                + "	movement_list text \n"
                + ");";

        try{
            Statement statement = connection.createStatement();
            statement.execute(table);
        }catch(SQLException e){
        }
    }

    // works (TO FIX: balance and movement list can't be null)

    public String register(String name, String password, double balance, String movement_list){
        String insert_data = "INSERT INTO bank(user,password, balance, movement_list) VALUES(?,?,?,?)";
        try{
            PreparedStatement statement = connection.prepareStatement(insert_data);
            statement.setString(1, name);
            statement.setString(2, password);
            statement.setDouble(3, balance);
            statement.setString(4, movement_list);
            statement.executeUpdate();
            return "REGISTERED";
        }
        catch (SQLException e) {
            return e.getMessage();
        }
    }

    public static String insertMovement(String action, String user) {
        String insert_movement_ = "INSERT INTO bank(movement_list) VALUES (?)";
        try {
            PreparedStatement stat = connection.prepareStatement(insert_movement_);
            stat.setString(1, action);
            stat.executeUpdate();
            return "MOVEMENT_ADDED";
        } catch (SQLException e) {
            return e.getMessage();
        }
    }

    // works
    public static boolean login(String user, String password) throws SQLException {
        // String response = null;
        boolean logged = false;
        if(connectionHandle()){
            String login_str = "SELECT * FROM bank WHERE user = ? AND password = ?";
            PreparedStatement stat = connection.prepareStatement(login_str);
            stat.setString(1, user);
            stat.setString(2, password);
            ResultSet rs = stat.executeQuery();

            if(rs.next()){
                logged = true;

            }
            else{
                logged = false;
            }
        }
        return logged;
    }

    public static boolean deposit(double moneyInput, String username) throws SQLException {
        try {
            String sql_deposit = "UPDATE bank SET balance = balance + ? WHERE user = ? AND balance >= ?";
            PreparedStatement stat = connection.prepareStatement(sql_deposit);
            stat.setDouble(1, moneyInput);
            stat.setString(2, username);
            stat.setDouble(3, balance(username));
            int rows = stat.executeUpdate();
            if (rows > 0) {
                sql_deposit = "SELECT balance FROM bank WHERE user = ?";
                stat = connection.prepareStatement(sql_deposit);
                stat.setString(1, username);
                ResultSet rs = stat.executeQuery();
            }
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    //works
    public static String withdraw(double moneyInput, String username){
        try {
            String sql_withdraw = "UPDATE bank SET balance = balance - ? WHERE user = ? AND balance >= ?";
            PreparedStatement stat = connection.prepareStatement(sql_withdraw);
            stat.setDouble(1, moneyInput);
            stat.setString(2, username);
            stat.setDouble(3, balance(username));
            int rows = stat.executeUpdate();
            if (rows > 0) {
                sql_withdraw = "SELECT balance FROM bank WHERE user = ?";
                stat = connection.prepareStatement(sql_withdraw);
                stat.setString(1, username);
                ResultSet rs = stat.executeQuery();
            }
            return "WITHDRAW_SUCCESS";
        } catch (SQLException e) {
            return e.getMessage();
        }
    }


    // works
    public static Double balance(String user) {
        try {
            String balance_str = "SELECT balance FROM bank WHERE user = ?";
            PreparedStatement stat = connection.prepareStatement(balance_str);
            stat.setString(1, user);
            ResultSet rs = stat.executeQuery();
            double balance = rs.getDouble("balance");
            return balance;

        }catch(SQLException e) {
            return null;
        }
    }
}
