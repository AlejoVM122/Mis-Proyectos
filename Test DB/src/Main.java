import javax.xml.transform.Result;
import java.sql.*;

public class Main {

    public static final String DB_NAME = "test2.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:C:\\databases\\test2.db" + DB_NAME ;

    public static final String TABLE_CONTACTS = "alejandro";
    public static final String COLUM_NAME = "name";
    public static final String COLUM_PHONE = "phone";
    public static void main(String[] args) {


    try (Connection conn = DriverManager.getConnection(CONNECTION_STRING);
     Statement statement = conn.createStatement()){
     statement.execute("DROP TABLE IF EXISTS" + TABLE_CONTACTS);
     statement.execute("CERATE TABLE IF NOT EXISTS"+ TABLE_CONTACTS+
             " (" + COLUM_NAME + " Text, "+
             COLUM_PHONE + "integer"+
     ")" );

statement.execute("INSERT INTO"+ TABLE_CONTACTS +
        " ("+ COLUM_NAME + ", "+COLUM_PHONE+  ")"+  "VALUES('JUANDA',3143844499)");



    ResultSet result = statement.executeQuery("SELECT * FROM alejandro" );
    while (result.next()){
            System.out.println("name " + " " + result.getString("name")+ "phone: "+ result.getInt( "phone"));
        }

}catch (SQLException e){
    System.err.println("something is wrong in this aplication : "+ e.getMessage());
}

    }
}