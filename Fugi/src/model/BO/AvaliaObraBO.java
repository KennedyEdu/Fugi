package src.model.BO;

import java.util.List;

import src.model.DAO.avaliaObraDAO;

import src.model.VO.AvaliaObraVO;

public class AvaliaObraBO extends avaliaObraDAO implements AvaliaObraInterBO{

    public void adicionarAvaliacao(AvaliaObraVO ovo) throws Exception{
        try{
            inserir(ovo);
        }catch(Exception exc){
            throw new Exception("O unico valor que pode ser nulo é o ID.");
        }
    }

    public void excluirAvaliacao(AvaliaObraVO ovo) throws Exception {
        try{
            removerById(ovo);
        } catch(Exception exc){
            throw new Exception("O Id da Avaliação não está no banco de dados");
        }
    }

    public void editarAvaliacao(AvaliaObraVO ovo) throws Exception {
        try{
            editar(ovo);
        } catch (Exception exc){
            throw new Exception("Não pode existir valor nulo");
        }
    }
   
    public List<AvaliaObraVO> listarAvaliacoes() throws Exception {
        try{            
            List<AvaliaObraVO>  list = listar();
            return list;

        } catch (Exception exc){
            throw new Exception("Banco de dados vazio");
        }
        
    }
}
