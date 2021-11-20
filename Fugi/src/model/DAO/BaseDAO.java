package model.DAO;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class BaseDAO<VO> implements BaseInterDAO <VO> {
    Connection conectar = null;
    
    String url = "jdbc:mariadb://localhost:3306/fugieditora";
    String user = "root";
    String password = "root";

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
    
    public abstract void inserir (VO entity) throws SQLException;
    public abstract void atualizar (VO entity) throws SQLException;
    public abstract  void deletar (VO entity) throws SQLException;
    
    public abstract ResultSet listar() throws SQLException;
}