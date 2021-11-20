package model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import model.VO.AutorVO;
import model.VO.UsuarioVO;

public class AutorDAO extends UsuarioDAO<AutorVO>{
    
	@Override
    public void inserir(AutorVO VO) throws SQLException{
		super.inserir(VO);
        conectar = getConnection();
        String sql = "insert into autor (id_autor_usuario) values (?)";
       
        UsuarioVO uservo = new UsuarioVO();
        UsuarioDAO<UsuarioVO> dao = new UsuarioDAO<UsuarioVO>();
		ResultSet rs = dao.listar();
        try{            
        	while(rs.next()){
    		   
                uservo.setIdUsuario(rs.getLong("id"));
        	}
        	  PreparedStatement ptst;
              ptst = conectar.prepareStatement(sql);
              ptst.setLong(1, uservo.getIdUsuario());
              ptst.execute();
            } catch(SQLException erro) {
	            erro.printStackTrace();
	        }
		
    }

    public void removerById(AutorVO autorvo) throws SQLException{
    	conectar = getConnection();
        String sql = "delete from autor where id_autor = ?";
        PreparedStatement ptst;
        ptst = conectar.prepareStatement(sql);
        ptst.setLong(1, autorvo.getIdAutor());
        ptst.executeUpdate();
        super.deletar(autorvo);
    }

    public void editar(AutorVO autorVo)throws SQLException {
     super.atualizar(autorVo);
    }

    public ResultSet listar() throws SQLException{
        conectar = getConnection();
        String sql = "select * from autor left join usuario on autor.id_autor_usuario = usuario.usuario.id";
    
        Statement st;
        ResultSet rs;
    
        st = conectar.createStatement();
        rs = st.executeQuery(sql);
        return rs;
        }
}