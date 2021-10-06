package src.model.BO;

import java.util.List;

import src.model.DAO.AvaliadorDAO;
import src.model.VO.AvaliadorVO;

public class AvaliadorBO extends AvaliadorDAO implements AvaliadorInterBO {

    public void adicionarAvaliador(AvaliadorVO avo) throws Exception{
        try{
            inserir(avo);
        }catch(Exception exc){
            throw new Exception("Os unicos valores que podem ser nulos são o ID e o Nivel.");
        }
    }

    public void excluirAvaliador(AvaliadorVO alvo) throws Exception {
        try{
            removerById(alvo);
        } catch(Exception exc){
            throw new Exception("O Id do Avaliador não está no banco de dados");
        }
    }

    public void editarAvaliador(AvaliadorVO alvo) throws Exception {
        try{
            editar(alvo);
        } catch (Exception exc){
            throw new Exception("Não pode existir valor nulo");
        }
    }
   
    public List<AvaliadorVO> listarAvaliadores() throws Exception {
        
        try{            
            List<AvaliadorVO>  list = listar();
            return list;

        } catch (Exception exc){
            throw new Exception("Banco de dados vazio");
        }
        
    }
}
