package model.DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import model.VO.ObraVO;

public class ObraDAO extends BaseDAO<ObraVO>{
    
    public void inserir(ObraVO obraVo) {

        conectar = getConnection();
        String sql = "insert into obra (titulo,genero,ano, id_obra_autor, estado) values (?, ?, ?, ?, ?)";
        PreparedStatement ptst;
        try{
            ptst = conectar.prepareStatement(sql);
            ptst.setString(1, obraVo.getTitulo());
            ptst.setString(2, obraVo.getGenero());
            ptst.setDate(3, (Date) obraVo.getAno());
            ptst.setLong(4, obraVo.getAutor().getIdAutor());
            ptst.setString(5, obraVo.getEstado());

            ptst.execute();
        }catch(SQLException erro) {
            erro.printStackTrace();
        }
    }


	@Override
	public ResultSet listar() throws SQLException {
	    conectar = getConnection();
        String sql = "select * from obra";
    
        Statement st;
        ResultSet rs;
    
        st = conectar.createStatement();
        rs = st.executeQuery(sql);
        return rs;
	}

	@Override
	public void atualizar(ObraVO entity) throws SQLException {
        conectar = getConnection();
        String sql = "UPDATE obra SET  (titulo,genero,ano, id_obra_autor, estado) = (?, ?, ?, ?, ?) WHERE id_obra= ?";
        PreparedStatement ptst;
        try { 
            ptst = conectar.prepareStatement(sql);
            ptst.setString(1, entity.getTitulo());
            ptst.setString(2, entity.getGenero());
            ptst.setDate(3, (Date) entity.getAno());
            ptst.setLong(4, entity.getAutor().getIdAutor());
            ptst.setString(5, entity.getEstado());
            ptst.executeUpdate();
        }catch(SQLException erro) {
            erro.printStackTrace();
        }
		
	}

	@Override
	public void deletar(ObraVO entity) throws SQLException {
    	conectar = getConnection();
        String sql = "delete from obra where id_obra= ?";
        PreparedStatement ptst;
        try{
            ptst = conectar.prepareStatement(sql);
            ptst.setLong(1, entity.getIdObra());
            ptst.executeUpdate();
        }catch(SQLException erro) {
            erro.printStackTrace();
        }
	}
} 
