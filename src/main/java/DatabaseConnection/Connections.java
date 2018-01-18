package DatabaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connections {

    private static Connections instance=null;
    private final String USERNAME="admin";
    private final String PASSWORD="admin";
    private final String CONNSTRING="jdbc:mysql://localhost/ilk";

    static Connection con=null;

    private Connections(){
    }

    public static Connections getInstance(){
        if (instance==null){
            instance=new Connections();
        }
        return instance;
    }

    private boolean openCon() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection(CONNSTRING, USERNAME, PASSWORD);
        }catch (SQLException  exception) {
            exception.printStackTrace();
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return true;
    }

    public  Connection getCon() {

        if(con==null){
            if(openCon()){
                System.out.println("Connection opened");
                return con;
            }else {
                return null;
            }
        }
        return con;
    }
    public void closeCon(){
        System.out.println("Closing connection");
        try {
            con.close();
        }catch (SQLException exception){
            exception.printStackTrace();
        }
        con=null;
    }

}


