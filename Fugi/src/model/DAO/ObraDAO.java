package model.DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

import model.VO.ObraVO;

public class ObraDAO extends BaseDAO implements ObraInterDAO{
    
    public void inserir(ObraVO obraVo) {

        conectar = getConnection();
        String sql = "insert into obra (titulo,genero,ano,autor) values (?, ?, ?, ?)";
        PreparedStatement ptst;
        try{
            ptst = conectar.prepareStatement(sql);
            ptst.setString(1, obraVo.getTitulo());
            ptst.setString(2, obraVo.getGenero());
            ptst.setDate(3, (Date) obraVo.getAno());
            ptst.setInt(4, obraVo.getAutor().getIdAutor());

            ptst.execute();
        }catch(SQLException erro) {
            erro.printStackTrace();
        }
    }

    public void removerById(ObraVO obraVo) {
        conectar = getConnection();
        String sql = "delete from obra where id_obra = ?";
        PreparedStatement ptst;
        try{
            ptst = conectar.prepareStatement(sql);
            ptst.setInt(1, obraVo.getIdObra());
            ptst.executeUpdate();
        }catch(SQLException erro) {
            erro.printStackTrace();
        }
    }

    public void editar(ObraVO obraVo) {
        conectar = getConnection();
        String sql = "UPDATE obra SET (titulo,genero,ano,autor) = (?, ?, ?, ?) WHERE id_obra= ?";
        PreparedStatement ptst;
        try { 
            ptst = conectar.prepareStatement(sql);
            ptst.setString(1, obraVo.getTitulo());
            ptst.setString(2, obraVo.getGenero());
            ptst.setDate(3, (Date) obraVo.getAno());
            ptst.setInt(4, obraVo.getAutor().getIdAutor());
            ptst.executeUpdate();
        }catch(SQLException erro) {
            erro.printStackTrace();
        }
    }

    public List<ObraVO> listar() {
        conectar = getConnection();
        String sql = "select titulo, genero, ano from obra";
    
        Statement st;
        ResultSet rs;
    
        List<ObraVO> obras = new ArrayList<ObraVO>();
    
        try {
            st = conectar.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                ObraVO vo = new ObraVO();
                vo.setTitulo(rs.getString("titulo"));
                vo.setGenero(rs.getString("genero"));
                vo.setAno(rs.getDate("ano"));
                
                obras.add(vo); 
            }
        }catch(SQLException erro) {
            erro.printStackTrace();
        }
        return obras;
    }
} 
