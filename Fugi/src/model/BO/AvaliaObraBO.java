package model.BO;

import java.util.List;

import model.DAO.AvaliaObraDAO;

import model.VO.AvaliaObraVO;

public class AvaliaObraBO extends AvaliaObraDAO implements AvaliaObraInterBO{

    @Override
    public void adicionarAvaliacao(AvaliaObraVO ovo) throws Exception{
        try{
            inserir(ovo);
        }catch(Exception exc){
            throw new Exception("O unico valor que pode ser nulo é o ID.");
        }
    }

    @Override
    public void excluirAvaliacao(AvaliaObraVO ovo) throws Exception {
        try{
            removerById(ovo);
        } catch(Exception exc){
            throw new Exception("O Id da Avaliação não está no banco de dados");
        }
    }

    @Override
    public void editarAvaliacao(AvaliaObraVO ovo) throws Exception {
        try{
            editar(ovo);
        } catch (Exception exc){
            throw new Exception("Não pode existir valor nulo");
        }
    }
   
    @Override
    public List<AvaliaObraVO> listarAvaliacoes() throws Exception {
        try{            
            List<AvaliaObraVO>  list = listar();
            return list;

        } catch (Exception exc){
            throw new Exception("Banco de dados vazio");
        }
        
    }
}
