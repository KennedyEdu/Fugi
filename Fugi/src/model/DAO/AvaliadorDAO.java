package model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.VO.AvaliadorVO;
import model.VO.UsuarioVO;

public class AvaliadorDAO extends UsuarioDAO<AvaliadorVO>{
    
	@Override
    public void inserir(AvaliadorVO VO) throws SQLException{
		super.inserir(VO);
        conectar = getConnection();
        String sql = "insert into avaliador (id_avaliador_usuario) values (?)";
       
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

    public void removerById(AvaliadorVO avarvo) throws SQLException{
    	conectar = getConnection();
        String sql = "delete from avaliador where id_avaliador = ?";
        PreparedStatement ptst;
        ptst = conectar.prepareStatement(sql);
        ptst.setLong(1, avarvo.getIdAvaliador());
        ptst.executeUpdate();
        super.deletar(avarvo);
    }

    public void editar(AvaliadorVO avaliadorVo)throws SQLException {
     super.atualizar(avaliadorVo);
    }

    public ResultSet listar() throws SQLException{
        conectar = getConnection();
        String sql = "select * from avaliador left join usuario on avaliador.id_avaliador_usuario = usuario.usuario.id";
    
        Statement st;
        ResultSet rs;
    
        st = conectar.createStatement();
        rs = st.executeQuery(sql);
        return rs;
        }
}