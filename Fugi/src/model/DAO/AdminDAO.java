package model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.VO.AdminVO;

import model.VO.UsuarioVO;

public class AdminDAO extends UsuarioDAO<AdminVO>{
    
	@Override
    public void inserir(AdminVO VO) throws SQLException{
		super.inserir(VO);
        conectar = getConnection();
        String sql = "insert into admin (id_admin_usuario) values (?)";
       
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

    public void removerById(AdminVO adminvo) throws SQLException{
    	conectar = getConnection();
        String sql = "delete from admin where id_admin = ?";
        PreparedStatement ptst;
        ptst = conectar.prepareStatement(sql);
        ptst.setLong(1, adminvo.getIdAdm());
        ptst.executeUpdate();
        super.deletar(adminvo);
    }

    public void editar(AdminVO adminVo)throws SQLException {
     super.atualizar(adminVo);
    }

    public ResultSet listar() throws SQLException{
        conectar = getConnection();
        String sql = "select * from admin left join usuario on autor.id_admin_usuario = usuario.usuario.id";
    
        Statement st;
        ResultSet rs;
    
        st = conectar.createStatement();
        rs = st.executeQuery(sql);
        return rs;
        }
}