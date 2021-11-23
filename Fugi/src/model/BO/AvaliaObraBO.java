package model.BO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DAO.AvaliaObraDAO;
import model.VO.AvaliaObraVO;
import model.VO.AvaliadorVO;
import model.VO.ObraVO;


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
        		ObraVO obra = new ObraVO();
        		AvaliadorVO avaliador = new AvaliadorVO();
                AvaliaObraVO vo = new AvaliaObraVO();
                vo.setObra(obra);
        		vo.setAvaliador(avaliador);
                vo.setIdObra(rs.getLong("id_avaliaobra_obra"));
                vo.setIdAvaliador(rs.getLong("id_avaliaobra_avaliador"));
                vo.setIdAvalia(rs.getLong("id_avaliaobra"));
               
                
                avalia��es.add(vo);
        	}
            return avalia��es;

        } catch (Exception exc){
            throw new Exception("Banco de dados vazio");
    
        }
    }
    
     
    
	public boolean Verificar(AvaliaObraVO avalia) throws Exception {
        boolean verifica��o = false;
        try {
        	List<AvaliaObraVO> avalia��es = listarAvaliacoes();
  
        	for ( int index = 0; index < avalia��es.size(); index++) {
        		if (avalia.getObra().getIdObra() == avalia��es.get(index).getObra().getIdObra()){ 	
        		   if (avalia.getAvaliador().getIdAvaliador() == avalia��es.get(index).getAvaliador().getIdAvaliador()) {
        		   verifica��o = true;
        		   }
        		   }
        		}
        	
      }catch(SQLException erro) {
            erro.printStackTrace();
        };
        return verifica��o;
    }
	
	public Long IDAvalia��o(AvaliaObraVO avalia) throws Exception {
        Long ID = null;
        try {
        	List<AvaliaObraVO> avalia��es = listarAvaliacoes();
  
        	for ( int index = 0; index < avalia��es.size(); index++) {
        		if (avalia.getObra().getIdObra() == avalia��es.get(index).getObra().getIdObra()){ 	
        		   if (avalia.getAvaliador().getIdAvaliador() == avalia��es.get(index).getAvaliador().getIdAvaliador()) {
        		   ID = avalia��es.get(index).getIdAvalia();
        		   }
        		   }
        		}
        	
      }catch(SQLException erro) {
            erro.printStackTrace();
        };
        return ID;
    }


}