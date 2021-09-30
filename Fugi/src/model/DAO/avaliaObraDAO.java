package src.model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

import src.model.VO.AvaliaObraVO;

public class avaliaObraDAO extends BaseDAO implements avaliaObraInterDAO{
    
    public void inserir(AvaliaObraVO avaliaObraVo) {

        conectar = getConnection();
        String sql = "insert into avalia_obra (id_avalia,obra,autor,avaliador,estado) values (?, ?, ?, ?, ?)";
        PreparedStatement ptst;
        try{
            ptst = conectar.prepareStatement(sql);
            ptst.setInt(1, avaliaObraVo.getIdAvalia());
            ptst.setInt(2, avaliaObraVo.getObra().getIdObra());
            ptst.setInt(3, avaliaObraVo.getAutor().getIdAutor());
            ptst.setInt(4, avaliaObraVo.getAvaliador().getIdAvaliador());
            ptst.setString(5, avaliaObraVo.getEstado());

            ptst.execute();
        }catch(SQLException erro) {
            erro.printStackTrace();
        }
    }

    public void removerById(AvaliaObraVO avaliaObraVo) {
        conectar = getConnection();
        String sql = "delete from avalia_obra where id_avalia = ?";
        PreparedStatement ptst;
        try{
            ptst = conectar.prepareStatement(sql);
            ptst.setInt(1, avaliaObraVo.getIdAvalia());
            ptst.executeUpdate();
        }catch(SQLException erro) {
            erro.printStackTrace();
        }
    }

    public void editar(AvaliaObraVO avaliaObraVo) {
        conectar = getConnection();
        String sql = "UPDATE avalia_obra SET (id_avalia,obra,autor,avaliador,estado) = (?, ?, ?, ?, ?) WHERE id_avalia= ?";
        PreparedStatement ptst;
        try { 
            ptst = conectar.prepareStatement(sql);
            ptst.setInt(1, avaliaObraVo.getIdAvalia());
            ptst.setInt(2, avaliaObraVo.getObra().getIdObra());
            ptst.setInt(3, avaliaObraVo.getAutor().getIdAutor());
            ptst.setInt(4, avaliaObraVo.getAvaliador().getIdAvaliador());
            ptst.setString(5, avaliaObraVo.getEstado());

            ptst.executeUpdate();
        }catch(SQLException erro) {
            erro.printStackTrace();
        }
    }

    public List<AvaliaObraVO> listar() {
        conectar = getConnection();
        String sql = "select id_avalia, estado from avalia_obra";
    
        Statement st;
        ResultSet rs;
    
        List<AvaliaObraVO> avaliacoes = new ArrayList<AvaliaObraVO>();
    
        try {
            st = conectar.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                AvaliaObraVO vo = new AvaliaObraVO();
                vo.setIdAvalia(rs.getInt("id_avalia"));
                vo.setEstado(rs.getString("estado"));
                
                avaliacoes.add(vo);
            }
        }catch(SQLException erro) {
            erro.printStackTrace();
        }
        return avaliacoes;
    }
}
