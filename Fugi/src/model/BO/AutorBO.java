package model.BO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.DAO.AutorDAO;
import model.VO.AutorVO;

public class AutorBO extends AutorDAO implements AutorInterBO {

	@Override
    public void adicionarAutor(AutorVO avo) throws Exception{
        try{
            inserir(avo);
        }catch(Exception exc){
            throw new Exception("Os unicos valores que podem ser nulos são o ID e o Nivel.");
        }
    }

	@Override
    public void excluirAutor(AutorVO avo) throws Exception {
        try{
            removerById(avo);
        } catch(Exception exc){
            throw new Exception("O Id do Autor não está no banco de dados");
        }
    }

	@Override
    public void editarAutor(AutorVO avo) throws Exception {
        try{
            editar(avo);
        } catch (Exception exc){
            throw new Exception("Não pode existir valor nulo");
        }
    }
   
	@Override
    public List<AutorVO> listarAutores() throws Exception {
		List<AutorVO> autors = new ArrayList<AutorVO>();
        AutorDAO dao = new AutorDAO();
		ResultSet rs = dao.listar();
        try{            
        	while(rs.next()){
                AutorVO vo = new AutorVO();
                vo.setNome(rs.getString("nome"));
                vo.setCPF(rs.getString("cpf"));
                vo.setEmail(rs.getString("email"));
                vo.setSenha(rs.getString("senha"));
                vo.setNivel(rs.getInt("nivel"));
                vo.setEndereco(rs.getString("endereco"));
                vo.setIdAutor(rs.getLong("id_autor"));
                vo.setIdUsuario(rs.getLong("id_autor_usuario"));
                
                autors.add(vo);
        	}
            return autors;

        } catch (Exception exc){
            throw new Exception("Banco de dados vazio");
        }
        
    }
}