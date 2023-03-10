package sqlite;
import java.sql.*;

class SQL_FUNCTIONS {
    static Connection connection = null;
    static String db_path = "jdbc:sqlite:C:\\BankDATA\bank.sql";

    public static boolean connectionHandle() {
        try {
            connection = DriverManager.getConnection(db_path);
            createNewTable();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally {
            try{
                if(connection!=null){
                    connection.close();
                }
            }catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void createNewTable() {

        // preparing SQL statement to create a new table
        String table = "CREATE TABLE IF NOT EXISTS bank (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	user text NOT NULL,\n"
                + " password text NOT NULL,\n"
                + "	balance real NOT NULL,\n"
                + "	movement_list text NOT NULL \n"
                + ");";

        try{
            Statement statement = connection.createStatement();
            statement.execute(table);
            System.out.println("Table Created");
        }catch(SQLException e){
            System.out.println("Error " + e);
        }
    }

    public void insertData(String name, String password){
        String insert_data = "INSERT INTO bank(user,password) VALUES(?,?)";
        try{
            PreparedStatement statement = connection.prepareStatement(insert_data);
            statement.setString(1, name);
            statement.setString(2, password);
            statement.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void insertMovement(String action) {
        String insert_movement_ = "INSERT INTO bank(movement_list) VALUES (?)";
        try {
            PreparedStatement stat = connection.prepareStatement(insert_movement_);
            stat.setString(1, action);
            stat.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void login(String user, String password) throws SQLException {
        if(connectionHandle()){
            String login_str = "SELECT * FROM bank WHERE username = ? AND password = ?";
            PreparedStatement stat = connection.prepareStatement(login_str);
            stat.setString(1, user);
            stat.setString(2, password);
            ResultSet rs = stat.executeQuery();

            if(rs.next()){
                System.out.println("SUCCESS");
            }
            else{
                System.out.println("FAIL");
            }
        }
    }

    public static void deposit(String moneyInput, String username) throws SQLException {
        try {
            String sql_deposit = "UPDATE bank SET balance = balance - ? WHERE USERNAME = ? AND BALANCE >= ?";
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
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void withdraw(String moneyInput, String username){
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
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String balance(String user) {
        try {
            String balance_str = "SELECT balance FROM BANK WHERE USERNAME = ?";
            Statement stat = connection.createStatement();
            ResultSet rs = stat.executeQuery(balance_str);
            return rs.getString("balance");
        }catch(SQLException e) {
            return "Error"+e;
        }
    }
}
