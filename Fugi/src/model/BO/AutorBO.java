package src.model.BO;

import java.util.List;

import src.model.DAO.AutorDAO;
import src.model.VO.AutorVO;

public class AutorBO extends AutorDAO implements AutorInterBO {

    public void adicionarAutor(AutorVO avo) throws Exception{
        try{
            inserir(avo);
        }catch(Exception exc){
            throw new Exception("Os unicos valores que podem ser nulos são o ID e o Nivel.");
        }
    }

    public void excluirAutor(AutorVO avo) throws Exception {
        try{
            removerById(avo);
        } catch(Exception exc){
            throw new Exception("O Id do Autor não está no banco de dados");
        }
    }

    public void editarAutor(AutorVO avo) throws Exception {
        try{
            editar(avo);
        } catch (Exception exc){
            throw new Exception("Não pode existir valor nulo");
        }
    }
   
    public List<AutorVO> listarAutores() throws Exception {
        
        try{            
            List<AutorVO>  list = listar();
            return list;

        } catch (Exception exc){
            throw new Exception("Banco de dados vazio");
        }
        
    }
}
