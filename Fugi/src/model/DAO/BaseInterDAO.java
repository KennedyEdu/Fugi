package model.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface BaseInterDAO <VO>{
    public Connection getConnection();
    
    public void inserir (VO entity) throws SQLException;
    public void atualizar (VO entity) throws SQLException;
    public void deletar (VO entity) throws SQLException;
    
    public ResultSet listar() throws SQLException;
}