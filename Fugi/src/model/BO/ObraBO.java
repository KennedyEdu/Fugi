package model.BO;

import java.sql.ResultSet;
import java.util.ArrayList;
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
            deletar(ovo);
        } catch(Exception exc){
            throw new Exception("O Id da Obra não está no banco de dados");
        }
    }

	@Override
    public void editarObra(ObraVO ovo) throws Exception {
        try{
            atualizar(ovo);
        } catch (Exception exc){
            throw new Exception("Não pode existir valor nulo");
        }
    }
   
	@Override
    public List<ObraVO> listarObras() throws Exception {
		 
			List<ObraVO> obras = new ArrayList<ObraVO>();
	        ObraDAO dao = new ObraDAO();
			ResultSet rs = dao.listar();
	        try{            
	        	while(rs.next()){
	                ObraVO vo = new ObraVO();
	                vo.setTitulo(rs.getString("titulo"));
	                vo.setGenero(rs.getString("genero"));
	                vo.setAno(rs.getDate("ano"));
	                vo.setEstado(rs.getString("estado"));
	                vo.setIdObra(rs.getLong("id_obra"));
	                vo.setIdAutor(rs.getLong("id_obra_autor"));
	                
	                obras.add(vo);
	        	}
	            return obras;
	        } catch (Exception exc){
	            throw new Exception("Banco de dados vazio");		    
		        
	        }
			
	}	
}
