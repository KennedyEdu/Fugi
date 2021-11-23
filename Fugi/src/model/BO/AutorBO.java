package model.BO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DAO.AutorDAO;
import model.VO.AutorVO;
import model.VO.ObraVO;
import model.VO.UsuarioVO;

public class AutorBO extends AutorDAO implements AutorInterBO {

	@Override
    public void adicionarAutor(AutorVO avo) throws Exception{
        try{
            inserir(avo);
        }catch(Exception exc){
            throw new Exception("Os unicos valores que podem ser nulos são o ID e o Nivel.");
        }
    }

	@Override
    public void excluirAutor(AutorVO avo) throws Exception {
        try{
            removerById(avo);
        } catch(Exception exc){
            throw new Exception("O Id do Autor não está no banco de dados");
        }
    }

	@Override
    public void editarAutor(AutorVO avo) throws Exception {
        try{
            editar(avo);
        } catch (Exception exc){
            throw new Exception("Não pode existir valor nulo");
        }
    }
   
	@Override
    public List<AutorVO> listarAutores() throws Exception {
		List<AutorVO> autors = new ArrayList<AutorVO>();
        AutorDAO dao = new AutorDAO();
		ResultSet rs = dao.listar();
        try{            
        	while(rs.next()){
                AutorVO vo = new AutorVO();
                vo.setNome(rs.getString("nome"));
                vo.setCPF(rs.getString("cpf"));
                vo.setEmail(rs.getString("email"));
                vo.setSenha(rs.getString("senha"));
                vo.setNivel(rs.getInt("nivel"));
                vo.setEndereco(rs.getString("endereco"));
                vo.setIdAutor(rs.getLong("id_autor"));
                vo.setIdUsuario(rs.getLong("id_autor_usuario"));
                
                autors.add(vo);
        	}
            return autors;

        } catch (Exception exc){
            throw new Exception("Banco de dados vazio");
        }
        
    }
	
	
	public Long idAutor(UsuarioVO usu) throws Exception {
        Long id = null;
        try {
        	List<AutorVO> autores = listarAutores();
  
        	for ( int index = 0; index < autores.size(); index++) {
        		if (usu.getIdUsuario() == autores.get(index).getIdUsuario()){ 	
        			id = autores.get(index).getIdAutor();
        		}
        		}
        	
      }catch(SQLException erro) {
            erro.printStackTrace();
        }; 
        return id;
    }
	
	
	public Long idUsuarioAutor(AutorVO usu) throws Exception {
        Long id = null;
        try {
        	List<AutorVO> autores = listarAutores();
  
        	for ( int index = 0; index < autores.size(); index++) {
        		if (usu.getIdAutor() == autores.get(index).getIdAutor()){ 	
        			id = autores.get(index).getIdUsuario();
        		}
        		}
        	
      }catch(SQLException erro) {
            erro.printStackTrace();
        };
        return id;
    }
	
	

	 public List<AutorVO> listarAutoresObra(ObraVO obra) throws Exception {
	        
			List<AutorVO> autores = new ArrayList<AutorVO>();
	        AutorDAO dao = new AutorDAO();
			ResultSet rs = dao.listar();
	        ObraBO obralist  = new ObraBO();
	        List<ObraVO> obras = obralist.listarObras();
			try{            
	        	while(rs.next()){
	        		 AutorVO vo = new AutorVO();
	                 vo.setNome(rs.getString("nome"));
	                 vo.setCPF(rs.getString("cpf"));
	                 vo.setEmail(rs.getString("email"));
	                 vo.setSenha(rs.getString("senha"));
	                 vo.setNivel(rs.getInt("nivel"));
	                 vo.setEndereco(rs.getString("endereco"));
	                 vo.setIdAutor(rs.getLong("id_autor"));
	                 vo.setIdUsuario(rs.getLong("id_autor_usuario"));
	        		
		               for ( int index = 0; index < obras.size(); index++) 
		               { if((vo.getIdAutor()  == obras.get(index).getIdAutor()) && (obra.getIdObra() == obras.get(index).getIdObra())) {
		                  autores.add(vo);
		               }
	                }
	        	}
	            return autores;

	        } catch (Exception exc){
	            throw new Exception("Banco de dados vazio");
	    
	        }
		}	
	   public List<AutorVO> listarAutoresNome(AutorVO aut) throws Exception {
	        
			List<AutorVO> autores = new ArrayList<AutorVO>();
	        AutorDAO dao = new AutorDAO();
			ResultSet rs = dao.listar();
	        try{            
	        	while(rs.next()){
	        		 AutorVO vo = new AutorVO();
	                 vo.setNome(rs.getString("nome"));
	                 vo.setCPF(rs.getString("cpf"));
	                 vo.setEmail(rs.getString("email"));
	                 vo.setSenha(rs.getString("senha"));
	                 vo.setNivel(rs.getInt("nivel"));
	                 vo.setEndereco(rs.getString("endereco"));
	                 vo.setIdAutor(rs.getLong("id_autor"));
	                 vo.setIdUsuario(rs.getLong("id_autor_usuario"));
	                
	                	if (aut.getNome().equals(vo.getNome())){ 	
	                		  autores.add(vo);
	                		}
	                }
	            return autores;

	        } catch (Exception exc){
	            throw new Exception("Banco de dados vazio");
	    
	        }
		}	

}
