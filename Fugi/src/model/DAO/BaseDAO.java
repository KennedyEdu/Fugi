package model.DAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class BaseDAO implements BaseInterDAO {
    Connection conectar = null;
    
    String url = "jdbc:postgresql://localhost:5432/Daniel_BD";
    String user = "postgres";
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