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
                + "	balance real,\n"
                + "	movement_list text \n"
                + ");";

        try{
            Statement statement = connection.createStatement();
            statement.execute(table);
            System.out.println("Table Created");
        }catch(SQLException e){
            System.out.println("Error " + e);
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
            System.out.println(e.getMessage());
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
    public static String login(String user, String password) throws SQLException {
        String response = null;
        if(connectionHandle()){
            String login_str = "SELECT * FROM bank WHERE user = ? AND password = ?";
            PreparedStatement stat = connection.prepareStatement(login_str);
            stat.setString(1, user);
            stat.setString(2, password);
            ResultSet rs = stat.executeQuery();

            if(rs.next()){
                response = "SUCCESS_LOGIN";
                System.out.println("USER EXISTS");
            }
            else{
                response = "FAILED_LOGIN";
                System.out.println("USER doesnt exist");
            }
        }
        return response;
    }

    public static String deposit(String moneyInput, String username) throws SQLException {
        try {
            String sql_deposit = "UPDATE bank SET balance = balance - ? WHERE username = ? AND balance >= ?";
            PreparedStatement stat = connection.prepareStatement(sql_deposit);
            stat.setDouble(1, Double.parseDouble(moneyInput));
            stat.setString(2, username);
            int rows = stat.executeUpdate();
            if (rows > 0) {
                sql_deposit = "SELECT balance FROM bank WHERE username = ?";
                stat = connection.prepareStatement(sql_deposit);
                stat.setString(1, username);
                ResultSet rs = stat.executeQuery();
            }
            return "DEPOSIT_SUCCESS";
        } catch (SQLException e) {
            return e.getMessage();
        }
    }

    public static String withdraw(String moneyInput, String username){
        try {
            String sql_withdraw = "UPDATE bank SET balance = balance - ? WHERE username = ? AND balance >= ?";
            PreparedStatement stat = connection.prepareStatement(sql_withdraw);
            stat.setDouble(1, Double.parseDouble(moneyInput));
            stat.setString(2, username);
            int rows = stat.executeUpdate();
            if (rows > 0) {
                sql_withdraw = "SELECT balance FROM bank WHERE username = ?";
                stat = connection.prepareStatement(sql_withdraw);
                stat.setString(1, username);
                ResultSet rs = stat.executeQuery();
            }
            return "WITHDRAW_SUCCESS";
        } catch (SQLException e) {
            return e.getMessage();
        }
    }

    public static String balance(String user) {
        try {
            String balance_str = "SELECT balance FROM bank WHERE username = ?";
            Statement stat = connection.createStatement();
            ResultSet rs = stat.executeQuery(balance_str);
            return rs.getString("balance");
        }catch(SQLException e) {
            return "Error"+e;
        }
    }
}
