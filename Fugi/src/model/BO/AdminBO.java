package src.model.BO;

import java.util.List;

import src.model.DAO.AdminDAO;
import src.model.VO.AdminVO;

public class AdminBO extends AdminDAO implements AdminInterBO {

    public void adicionarAdmin(AdminVO advo) throws Exception{
        try{
            inserir(advo);
        }catch(Exception exc){
            throw new Exception("Os unicos valores que podem ser nulos são o ID e o Nivel.");
        }
    }

    public void excluirAdmin(AdminVO advo) throws Exception {
        try{
            removerById(advo);
        } catch(Exception exc){
            throw new Exception("O Id do Administrador não está no banco de dados");
        }
    }

    public void editarAdmin(AdminVO advo) throws Exception {
        try{
            editar(advo);
        } catch (Exception exc){
            throw new Exception("Não pode existir valor nulo");
        }
    }
   
    public List<AdminVO> listarAdmins() throws Exception {
        
        try{            
            List<AdminVO>  list = listar();
            return list;

        } catch (Exception exc){
            throw new Exception("Banco de dados vazio");
        }
        
    }
}

