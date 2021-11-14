package model.BO;

import java.util.List;

import model.DAO.ObraDAO;

import model.VO.ObraVO;

public class ObraBO extends ObraDAO implements ObraInterBO {

	@Override
    public void adicionarObra(ObraVO ovo) throws Exception{
        try{
            inserir(ovo);
        }catch(Exception exc){
            throw new Exception("O unico valor que pode ser nulo é o ID.");
        }
    }

	@Override
    public void excluirObra(ObraVO ovo) throws Exception {
        try{
            removerById(ovo);
        } catch(Exception exc){
            throw new Exception("O Id da Obra não está no banco de dados");
        }
    }

	@Override
    public void editarObra(ObraVO ovo) throws Exception {
        try{
            editar(ovo);
        } catch (Exception exc){
            throw new Exception("Não pode existir valor nulo");
        }
    }
   
	@Override
    public List<ObraVO> listarObras() throws Exception {
        try{            
            List<ObraVO>  list = listar();
            return list;

        } catch (Exception exc){
            throw new Exception("Banco de dados vazio");
        }
        
    }
}
