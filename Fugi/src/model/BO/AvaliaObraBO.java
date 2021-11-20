package model.BO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.DAO.AvaliaObraDAO;
import model.VO.AvaliaObraVO;

public class AvaliaObraBO extends AvaliaObraDAO implements AvaliaObraInterBO{

    @Override
    public void adicionarAvaliacao(AvaliaObraVO ovo) throws Exception{
        try{
            inserir(ovo);
        }catch(Exception exc){
            throw new Exception("O unico valor que pode ser nulo � o ID.");
        }
    }

    @Override
    public void excluirAvaliacao(AvaliaObraVO ovo) throws Exception {
        try{
            deletar(ovo);
        } catch(Exception exc){
            throw new Exception("O Id da Avalia��o n�o est� no banco de dados");
        }
    }

    @Override
    public void editarAvaliacao(AvaliaObraVO ovo) throws Exception {
        try{
            atualizar(ovo);
        } catch (Exception exc){
            throw new Exception("N�o pode existir valor nulo");
        }
    }
   
    @Override
    public List<AvaliaObraVO> listarAvaliacoes() throws Exception {
    	List<AvaliaObraVO> avalia��es = new ArrayList<AvaliaObraVO>();
        AvaliaObraDAO dao = new AvaliaObraDAO();
		ResultSet rs = dao.listar();
        try{            
        	while(rs.next()){
                AvaliaObraVO vo = new AvaliaObraVO();
                vo.setIdAutor(rs.getLong("id_avaliaobra_autor"));
                vo.setIdObra(rs.getLong("id_avaliaobra_obra"));
                vo.setIdAvaliador(rs.getLong("id_avaliaobra_avaliador"));
                avalia��es.add(vo);
        	}
            return avalia��es;

        } catch (Exception exc){
            throw new Exception("Banco de dados vazio");
    
        }
        
    }
}
