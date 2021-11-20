package model.BO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.DAO.AdminDAO;
import model.VO.AdminVO;


public class AdminBO extends AdminDAO implements AdminInterBO {

	@Override
    public void adicionarAdmin(AdminVO advo) throws Exception{
        try{
            inserir(advo);
        }catch(Exception exc){
            throw new Exception("Os unicos valores que podem ser nulos são o ID e o Nivel.");
        }
    }

	@Override
    public void excluirAdmin(AdminVO advo) throws Exception {
        try{
            removerById(advo);
        } catch(Exception exc){
            throw new Exception("O Id do Administrador não está no banco de dados");
        }
    }

	@Override
    public void editarAdmin(AdminVO advo) throws Exception {
        try{
            editar(advo);
        } catch (Exception exc){
            throw new Exception("Não pode existir valor nulo");
        }
    }
   
	@Override
    public List<AdminVO> listarAdmins() throws Exception {
		List<AdminVO> admin = new ArrayList<AdminVO>();
        AdminDAO dao = new AdminDAO();
		ResultSet rs = dao.listar();
        try{            
        	while(rs.next()){
                AdminVO vo = new AdminVO();
                vo.setNome(rs.getString("nome"));
                vo.setCPF(rs.getString("cpf"));
                vo.setEmail(rs.getString("email"));
                vo.setSenha(rs.getString("senha"));
                vo.setNivel(rs.getInt("nivel"));
                vo.setEndereco(rs.getString("endereco"));
                vo.setIdAdm(rs.getLong("id_adm"));
                vo.setIdUsuario(rs.getLong("id_adm_usuario"));
                admin.add(vo);
        	}
            return admin;

        } catch (Exception exc){
            throw new Exception("Banco de dados vazio");
        }        
    }
}