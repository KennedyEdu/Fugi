package src.model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

import src.model.VO.adminVO;

public class adminDAO extends baseDAO{
    
    public void inserir(adminVO adminvo) {

        conectar = getConnection();
        String sql = "insert into admin (nome,cpf,email,senha,nivel,endereco) values (?, ?, ?, ?, ?, ?)";
        PreparedStatement ptst;
        try{
            ptst = conectar.prepareStatement(sql);
            ptst.setString(1, adminvo.getNome());
            ptst.setString(2, adminvo.getCPF());
            ptst.setString(3, adminvo.getEmail());
            ptst.setString(4, adminvo.getSenha());
            ptst.setInt(5, adminvo.getNivel());
            ptst.setString(6, adminvo.getEndereco());

            ptst.execute();
        }catch(SQLException erro) {
            erro.printStackTrace();
        }
    }

    public void removerById(adminVO adminvo) {
        conectar = getConnection();
        String sql = "delete from admin where id_admin = ?";
        PreparedStatement ptst;
        try{
            ptst = conectar.prepareStatement(sql);
            ptst.setInt(1, adminvo.getIdAdm());
            ptst.executeUpdate();
        }catch(SQLException erro) {
            erro.printStackTrace();
        }
    }

    public void editar(adminVO adminVo) {
        conectar = getConnection();
        String sql = "UPDATE admin SET (nome, cpf, email, senha, nivel, endereco) = (?, ?, ?, ?, ?, ?) WHERE id_admin= ?";
        PreparedStatement ptst;
        try { 
            ptst = conectar.prepareStatement(sql);
            ptst.setString(1, adminVo.getNome());
            ptst.setString(2, adminVo.getCPF());
            ptst.setString(3, adminVo.getEmail());
            ptst.setString(4, adminVo.getSenha());
            ptst.setInt(5, adminVo.getNivel());
            ptst.setString(6, adminVo.getEndereco());
            ptst.setInt(7, adminVo.getIdAdm());
            ptst.executeUpdate();
        }catch(SQLException erro) {
            erro.printStackTrace();
        }
    }

    public List<adminVO> listar() {
        conectar = getConnection();
        String sql = "select * from admin";
    
        Statement st;
        ResultSet rs;
    
        List<adminVO> admins = new ArrayList<adminVO>();
    
        try {
            st = conectar.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                adminVO vo = new adminVO();
                vo.setNome(rs.getString("nome"));
                vo.setCPF(rs.getString("cpf"));
                vo.setEmail(rs.getString("email"));
                vo.setSenha(rs.getString("senha"));
                vo.setNivel(rs.getInt("nivel"));
                vo.setEndereco(rs.getString("endereco"));
                
                admins.add(vo);
            }
        }catch(SQLException erro) {
            erro.printStackTrace();
        }
        return admins;
    }
}
