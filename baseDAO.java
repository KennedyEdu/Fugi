package src.model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class baseDAO {
    Connection conectar = null;
    
    String url = "jdbc:mariadb://localhost:3306";
    String user = "daniel_2357";
    String password = "123";

    public Connection getConnection(){
        if(conectar == null) {
            try{
                conectar = DriverManager.getConnection(url, user, password);
            }catch(SQLException erro) {
                erro.printStackTrace();
            }
            return conectar;

        } else return conectar;
    }
}
