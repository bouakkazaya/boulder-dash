package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/*
 Classe d'object d'accès aux données.
*/
public class Dao {
/*
	URL de connection. 
*/
    private final static String url = "jdbc:mysql://localhost:3306/boulderdash?autoReconnect=true&useSSL=false";
/*
	Nom d'utilisateur
*/
    private final static String user = "root";
    /**
     * password
     * */
    private final static String passwd = "secret";
    /**
     * Connection attribut
     * */
    private static Connection connection = null;
    private static Dao dao = null;


    /**
     * Dao.Dao Constructor. He create Connection
     * */
    private Dao(){
        try {
            connection = DriverManager.getConnection(url, user, passwd);
        } catch (SQLException e) {
            System.err.println("PLEASE VERIFY THE PARAMETERS CONNECTION !");
            e.printStackTrace();
        }
    }

    /**
     * Allow to access DAO instance to take connection.
     * @return Dao instance
     * */
    public static Dao getInstance(){
        if(dao == null){
            synchronized(Dao.class){
                if(dao == null)
                    dao = new Dao();
            }
        }
        return dao;
    }

    /**
     * Allow to access instance Instance
     * @return Connection instance
     * */
    public Connection getConnection(){
        return connection;
    }
}
