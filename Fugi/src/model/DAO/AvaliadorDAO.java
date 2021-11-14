package model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

import model.VO.AvaliadorVO;
import model.VO.Usuario;

public class AvaliadorDAO extends BaseDAO implements UsuarioInterDAO, AvaliadorInterDAO{
    
    public void inserir(Usuario usuario) {

        conectar = getConnection();
        String sql = "insert into avaliador (nome,cpf,email,senha,nivel,endereco) values (?, ?, ?, ?, ?, ?)";
        PreparedStatement ptst;
        try{
            ptst = conectar.prepareStatement(sql);
            ptst.setString(1, usuario.getNome());
            ptst.setString(2, usuario.getCPF());
            ptst.setString(3, usuario.getEmail());
            ptst.setString(4, usuario.getSenha());
            ptst.setInt(5, usuario.getNivel());
            ptst.setString(6, usuario.getEndereco());

            ptst.execute();
        }catch(SQLException erro) {
            erro.printStackTrace();
        }
    }

    public void removerById(AvaliadorVO avaliadorvo) {
        conectar = getConnection();
        String sql = "delete from avaliador where id_avaliador = ?";
        PreparedStatement ptst;
        try{
            ptst = conectar.prepareStatement(sql);
            ptst.setInt(1, avaliadorvo.getIdAvaliador());
            ptst.executeUpdate();
        }catch(SQLException erro) {
            erro.printStackTrace();
        }
    }

    public void editar(AvaliadorVO avaliadorVo) {
        conectar = getConnection();
        String sql = "UPDATE avaliador SET (nome, cpf, email, senha, endereco) = (?, ?, ?, ?, ?) WHERE id_avaliador= ?";
        PreparedStatement ptst;
        try { 
            ptst = conectar.prepareStatement(sql);
            ptst.setString(1, avaliadorVo.getNome());
            ptst.setString(2, avaliadorVo.getCPF());
            ptst.setString(3, avaliadorVo.getEmail());
            ptst.setString(4, avaliadorVo.getSenha());
            ptst.setString(5, avaliadorVo.getEndereco());
            ptst.setInt(6, avaliadorVo.getIdAvaliador());
            ptst.executeUpdate();
        }catch(SQLException erro) {
            erro.printStackTrace();
        }
    }

    public List<AvaliadorVO> listar() {
        conectar = getConnection();
        String sql = "select * from avaliador";
    
        Statement st;
        ResultSet rs;
    
        List<AvaliadorVO> avaliadors = new ArrayList<AvaliadorVO>();
    
        try {
            st = conectar.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                AvaliadorVO vo = new AvaliadorVO();
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