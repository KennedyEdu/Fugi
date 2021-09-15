package src.model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

import src.model.VO.avaliadorVO;

public class avaliadorDAO extends baseDAO{
    
    public void inserir(avaliadorVO avaliadorvo) {

        conectar = getConnection();
        String sql = "insert into avaliador (nome,cpf,email,senha,nivel,endereco) values (?, ?, ?, ?, ?, ?)";
        PreparedStatement ptst;
        try{
            ptst = conectar.prepareStatement(sql);
            ptst.setString(1, avaliadorvo.getNome());
            ptst.setString(2, avaliadorvo.getCPF());
            ptst.setString(3, avaliadorvo.getEmail());
            ptst.setString(4, avaliadorvo.getSenha());
            ptst.setInt(5, avaliadorvo.getNivel());
            ptst.setString(6, avaliadorvo.getEndereco());

            ptst.execute();
        }catch(SQLException erro) {
            erro.printStackTrace();
        }
    }

    public void removerById(avaliadorVO avaliadorvo) {
        conectar = getConnection();
        String sql = "delete from avaliador where id_avaliador = ?";
        PreparedStatement ptst;
        try{
            ptst = conectar.prepareStatement(sql);
            ptst.setInt(1, avaliadorvo.getIDAvaliador());
            ptst.executeUpdate();
        }catch(SQLException erro) {
            erro.printStackTrace();
        }
    }

    public void editar(avaliadorVO avaliadorVo) {
        conectar = getConnection();
        String sql = "UPDATE avaliador SET (nome, cpf, email, senha, nivel, endereco) = (?, ?, ?, ?, ?, ?) WHERE id_avaliador= ?";
        PreparedStatement ptst;
        try { 
            ptst = conectar.prepareStatement(sql);
            ptst.setString(1, avaliadorVo.getNome());
            ptst.setString(2, avaliadorVo.getCPF());
            ptst.setString(3, avaliadorVo.getEmail());
            ptst.setString(4, avaliadorVo.getSenha());
            ptst.setInt(5, avaliadorVo.getNivel());
            ptst.setString(6, avaliadorVo.getEndereco());
            ptst.setInt(7, avaliadorVo.getIDAvaliador());
            ptst.executeUpdate();
        }catch(SQLException erro) {
            erro.printStackTrace();
        }
    }

    public List<avaliadorVO> listar() {
        conectar = getConnection();
        String sql = "select * from avaliador";
    
        Statement st;
        ResultSet rs;
    
        List<avaliadorVO> avaliadors = new ArrayList<avaliadorVO>();
    
        try {
            st = conectar.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                avaliadorVO vo = new avaliadorVO();
                vo.setNome(rs.getString("nome"));
                vo.setCPF(rs.getString("cpf"));
                vo.setEmail(rs.getString("email"));
                vo.setSenha(rs.getString("senha"));
                vo.setNivel(rs.getInt("nivel"));
                vo.setEndereco(rs.getString("endereco"));
                
                avaliadors.add(vo);
            }
        }catch(SQLException erro) {
            erro.printStackTrace();
        }
        return avaliadors;
    }
}
