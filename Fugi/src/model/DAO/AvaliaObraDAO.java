package model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.VO.AvaliaObraVO;

public class AvaliaObraDAO extends BaseDAO<AvaliaObraVO> {

    public void inserir(AvaliaObraVO avaliaObraVo) {

        conectar = getConnection();
        String sql = "insert into avaliaobra (id_avaliaobra_obra,id_avaliaobra_avaliador) values (?, ?)";
        PreparedStatement ptst;
        try{
            ptst = conectar.prepareStatement(sql);
            ptst.setLong(1, avaliaObraVo.getObra().getIdObra());
            ptst.setLong(2, avaliaObraVo.getAvaliador().getIdAvaliador());

            ptst.execute();
        }catch(SQLException erro) {
            erro.printStackTrace();
        }
    }



	@Override
	public ResultSet listar() throws SQLException {
	    conectar = getConnection();
        String sql = "select * from avaliaobra";
    
        Statement st;
        ResultSet rs;
    
        st = getConnection().prepareStatement(sql);
        rs = st.executeQuery(sql);
        return rs;
	}
	

	@Override
	public void atualizar(AvaliaObraVO entity) throws SQLException {
		 conectar = getConnection();
	        String sql = "UPDATE avaliaobra SET id_avaliaobra_obra = ?, id_avaliaobra_avaliador  = ? WHERE id_avaliaobra= ?";
	        PreparedStatement ptst;
	        try { 
	            ptst = conectar.prepareStatement(sql);
	            ptst.setLong(1, entity.getObra().getIdObra());
	            ptst.setLong(2, entity.getAvaliador().getIdAvaliador());
	            ptst.setLong(3, entity.getIdAvalia());
	            ptst.executeUpdate();
	        }catch(SQLException erro) {
	            erro.printStackTrace();
	        }
			
	}

	@Override
	public void deletar(AvaliaObraVO entity) throws SQLException {
	   	conectar = getConnection();
        String sql = "delete from avaliaobra where id_avaliaobra= ?";
        PreparedStatement ptst;
        try{
            ptst = conectar.prepareStatement(sql);
            ptst.setLong(1, entity.getIdAvalia());
            ptst.executeUpdate();
        }catch(SQLException erro) {
            erro.printStackTrace();
        }
		
	}


}
