package model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.DAO.BaseDAO;
import model.VO.UsuarioVO;

public class UsuarioDAO <VO extends UsuarioVO> extends BaseDAO <VO>   {

	@Override
	public void inserir(VO vo) throws SQLException {
		 conectar = getConnection();
	        String sql = "insert into usuario (nome,endereco,cpf,email,senha,nivel) values (?, ?, ?, ?, ?, ?)";
	        PreparedStatement ptst;
	        try{
	            ptst = conectar.prepareStatement(sql);
	            ptst.setString(1, vo.getNome());
	            ptst.setString(2, vo.getEndereco());
	            ptst.setString(3, vo.getCPF());
	            ptst.setString(4, vo.getEmail());
	            ptst.setString(5, vo.getSenha());
	            ptst.setInt(6, vo.getNivel());

	            
	            int affectedRows = ptst.executeUpdate();

	            if (affectedRows == 0){
	                throw new SQLException("A inserção falhou. Nenhuma linha foi alterada.");
	            }

	            ResultSet generatedKeys = ptst.getGeneratedKeys();

	            if(generatedKeys.next()){ 
	                vo.setIdUsuario(generatedKeys.getLong(1));
	            } else{
	                throw new SQLException("A inserção falhou. nenhum id foi retornado.");
	            }
	        }catch(SQLException erro) {
	            erro.printStackTrace();
	        }
		
	}

	@Override
	public void atualizar(VO vo) throws SQLException {
	      conectar = getConnection();
	        String sql = "UPDATE usuario SET (nome, cpf, email, senha, endereco) = (?, ?, ?, ?, ?) WHERE id= ?";
	        PreparedStatement ptst;
	        try { 
	            ptst = conectar.prepareStatement(sql);
	            ptst.setString(1, vo.getNome());
	            ptst.setString(2, vo.getCPF());
	            ptst.setString(3, vo.getEmail());
	            ptst.setString(4, vo.getSenha());
	            ptst.setString(5, vo.getEndereco());
	            ptst.executeUpdate();
	        }catch(SQLException erro) {
	            erro.printStackTrace();
	        }
		
	}

	@Override
	public void deletar(VO vo) throws SQLException {
    	conectar = getConnection();
        String sql = "delete from usuario where id= ?";
        PreparedStatement ptst;
        try{
            ptst = conectar.prepareStatement(sql);
            ptst.setLong(1, vo.getIdUsuario());
            ptst.executeUpdate();
        }catch(SQLException erro) {
            erro.printStackTrace();
        }
		
	}

	@Override
	public ResultSet listar() throws SQLException {
		    conectar = getConnection();
	        String sql = "select * from usuario";
	    
	        Statement st;
	        ResultSet rs;
	    
	        st = conectar.createStatement();
	        rs = st.executeQuery(sql);
	        return rs;
	       
	}
   
	
}

