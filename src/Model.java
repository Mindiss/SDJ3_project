import java.io.Serializable;
import java.rmi.RemoteException;
import java.sql.*;
import java.util.ArrayList;

public class Model {

    private ArrayList<String> products;
    DatabaseMetaData md;

    public Model() throws Exception {
        md = conn.getMetaData();
    }

    public String getRowByIDFromDatabase(int id) throws Exception {
        String row = "NULL";
        String sql = ("SELECT * FROM products WHERE product_id = (SELECT product_id FROM products WHERE product_id = " + id + ")");
        ResultSet rs = st.executeQuery(sql);
        int product_id = 0;
        String name = "NULL";
        String type = "NULL";
        while (rs.next()) {
            product_id = rs.getInt("product_id");
            name = rs.getString("name");
            type = rs.getString("type");
            row = product_id + " " + name + " " + type;
        }
        return row;
    }

    public ArrayList<String> getAllProductsFromDatabase() throws Exception {
        products = new ArrayList<>();
        String sql = ("SELECT * FROM products");
        ResultSet rs = st.executeQuery(sql);
        int product_id = 0;
        String name = "NULL";
        String type = "NULL";
        while (rs.next()) {
            product_id = rs.getInt("product_id");
            name = rs.getString("name");
            type = rs.getString("type");
            products.add(product_id + " " + name + " " + type);
        }
        return products;
    }
    static Connection conn;

    static Statement st;

    static {
        try {
            // Step 1: Load the JDBC driver.
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Loaded.");
            // Step 2: Establish the connection to the database.
            String url = "jdbc:mysql://localhost:3306/sdj3_schema";

            conn = DriverManager.getConnection(url, "root", "");
            System.out.println("Connected to DATABASE.");

            st = conn.createStatement();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            e.printStackTrace();
            System.exit(0);
        }
    }
    public void addProductToList(int id, String name, String type) throws Exception, RemoteException{
        products = new ArrayList<String>();
        products.add(id + " " + name + " " + type );
    }
    public ArrayList<String> getAllProducts(){
        return products;
    }

}