package model.BO;

import java.util.List;

import model.DAO.AvaliadorDAO;
import model.VO.AvaliadorVO;


public class AvaliadorBO extends AvaliadorDAO implements AvaliadorInterBO {
	
	@Override
    public void adicionarAvaliador(AvaliadorVO avo) throws Exception{
        try{
            inserir(avo);
        }catch(Exception exc){
            throw new Exception("Os unicos valores que podem ser nulos são o ID e o Nivel.");
        }
    }

	@Override
    public void excluirAvaliador(AvaliadorVO alvo) throws Exception {
        try{
            removerById(alvo);
        } catch(Exception exc){
            throw new Exception("O Id do Avaliador não está no banco de dados");
        }
    }

	@Override
    public void editarAvaliador(AvaliadorVO alvo) throws Exception {
        try{
            editar(alvo);
        } catch (Exception exc){
            throw new Exception("Não pode existir valor nulo");
        }
    }
   
	@Override
    public List<AvaliadorVO> listarAvaliadores() throws Exception {
        
        try{            
            List<AvaliadorVO>  list = listar();
            return list;

        } catch (Exception exc){
            throw new Exception("Banco de dados vazio");
        }
        
    }
}
