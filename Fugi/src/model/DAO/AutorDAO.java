package model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

import model.VO.AutorVO;
import model.VO.Usuario;

public class AutorDAO extends BaseDAO implements UsuarioInterDAO, AutorInterDAO{
    
    public void inserir(Usuario usuario) {

        conectar = getConnection();
        String sql = "insert into autor (nome,cpf,email,senha,nivel,endereco) values (?, ?, ?, ?, ?, ?)";
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

    public void removerById(AutorVO autorvo) {
        conectar = getConnection();
        String sql = "delete from autor where id_autor = ?";
        PreparedStatement ptst;
        try{
            ptst = conectar.prepareStatement(sql);
            ptst.setInt(1, autorvo.getIdAutor());
            ptst.executeUpdate();
        }catch(SQLException erro) {
            erro.printStackTrace();
        }
    }

    public void editar(AutorVO autorVo) {
        conectar = getConnection();
        String sql = "UPDATE autor SET (nome, cpf, email, senha, endereco) = (?, ?, ?, ?, ?) WHERE id_autor= ?";
        PreparedStatement ptst;
        try { 
            ptst = conectar.prepareStatement(sql);
            ptst.setString(1, autorVo.getNome());
            ptst.setString(2, autorVo.getCPF());
            ptst.setString(3, autorVo.getEmail());
            ptst.setString(4, autorVo.getSenha());
            ptst.setString(5, autorVo.getEndereco());
            ptst.setInt(6, autorVo.getIdAutor());
            ptst.executeUpdate();
        }catch(SQLException erro) {
            erro.printStackTrace();
        }
    }

    public List<AutorVO> listar() {
        conectar = getConnection();
        String sql = "select * from autor";
    
        Statement st;
        ResultSet rs;
    
        List<AutorVO> autors = new ArrayList<AutorVO>();
    
        try {
            st = conectar.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                AutorVO vo = new AutorVO();
                vo.setNome(rs.getString("nome"));
                vo.setCPF(rs.getString("cpf"));
                vo.setEmail(rs.getString("email"));
                vo.setSenha(rs.getString("senha"));
                vo.setNivel(rs.getInt("nivel"));
                vo.setEndereco(rs.getString("endereco"));
                
                autors.add(vo);
            }
        }catch(SQLException erro) {
            erro.printStackTrace();
        }
        return autors;
    }
}