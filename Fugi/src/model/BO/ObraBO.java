package src.model.BO;

import java.util.List;

import src.model.DAO.ObraDAO;

import src.model.VO.ObraVO;

public class ObraBO extends ObraDAO implements ObraInterBO {

    public void adicionarObra(ObraVO ovo) throws Exception{
        try{
            inserir(ovo);
        }catch(Exception exc){
            throw new Exception("O unico valor que pode ser nulo é o ID.");
        }
    }

    public void excluirObra(ObraVO ovo) throws Exception {
        try{
            removerById(ovo);
        } catch(Exception exc){
            throw new Exception("O Id da Obra não está no banco de dados");
        }
    }

    public void editarObra(ObraVO ovo) throws Exception {
        try{
            editar(ovo);
        } catch (Exception exc){
            throw new Exception("Não pode existir valor nulo");
        }
    }
   
    public List<ObraVO> listarObras() throws Exception {
        try{            
            List<ObraVO>  list = listar();
            return list;

        } catch (Exception exc){
            throw new Exception("Banco de dados vazio");
        }
        
    }
}
