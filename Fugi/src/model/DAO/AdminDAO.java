package model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

import model.VO.AdminVO;
import model.VO.Usuario;

public class AdminDAO extends BaseDAO implements UsuarioInterDAO, AdminInterDAO{
    
    public void inserir(Usuario usuario) {

        conectar = getConnection();
        String sql = "insert into admin (nome,cpf,email,senha,nivel,endereco) values (?, ?, ?, ?, ?, ?)";
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

    public void removerById(AdminVO adminvo) {
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

    public void editar(AdminVO adminVo) {
        conectar = getConnection();
        String sql = "UPDATE admin SET (nome, cpf, email, senha, endereco) = ( ?, ?, ?, ?, ?) WHERE id_admin= ?";
        PreparedStatement ptst;
        try { 
            ptst = conectar.prepareStatement(sql);
            ptst.setString(1, adminVo.getNome());
            ptst.setString(2, adminVo.getCPF());
            ptst.setString(3, adminVo.getEmail());
            ptst.setString(4, adminVo.getSenha());
            ptst.setString(5, adminVo.getEndereco());
            ptst.setInt(6, adminVo.getIdAdm());
            ptst.executeUpdate();
        }catch(SQLException erro) {
            erro.printStackTrace();
        }
    }

    public List<AdminVO> listar() {
        conectar = getConnection();
        String sql = "select * from admin";
    
        Statement st;
        ResultSet rs;
    
        List<AdminVO> admins = new ArrayList<AdminVO>();
    
        try {
            st = conectar.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                AdminVO vo = new AdminVO();
                vo.setIdAdm(rs.getInt("id_admin"));
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