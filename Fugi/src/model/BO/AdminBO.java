package model.BO;

import java.util.List;

import model.DAO.AdminDAO;
import model.VO.AdminVO;

public class AdminBO extends AdminDAO implements AdminInterBO {

	@Override
    public void adicionarAdmin(AdminVO advo) throws Exception{
        try{
            inserir(advo);
        }catch(Exception exc){
            throw new Exception("Os unicos valores que podem ser nulos s�o o ID e o Nivel.");
        }
    }

	@Override
    public void excluirAdmin(AdminVO advo) throws Exception {
        try{
            removerById(advo);
        } catch(Exception exc){
            throw new Exception("O Id do Administrador n�o est� no banco de dados");
        }
    }

	@Override
    public void editarAdmin(AdminVO advo) throws Exception {
        try{
            editar(advo);
        } catch (Exception exc){
            throw new Exception("N�o pode existir valor nulo");
        }
    }
   
	@Override
    public List<AdminVO> listarAdmins() throws Exception {
        
        try{            
            List<AdminVO>  list = listar();
            return list;

        } catch (Exception exc){
            throw new Exception("Banco de dados vazio");
        }
        
    }
}