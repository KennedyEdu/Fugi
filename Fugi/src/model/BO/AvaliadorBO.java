package model.BO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DAO.AvaliadorDAO;
import model.VO.AvaliaObraVO;
import model.VO.AvaliadorVO;
import model.VO.ObraVO;
import model.VO.UsuarioVO;


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
        
		List<AvaliadorVO> avaliadores = new ArrayList<AvaliadorVO>();
        AvaliadorDAO dao = new AvaliadorDAO();
		ResultSet rs = dao.listar();
        try{            
        	while(rs.next()){
                AvaliadorVO vo = new AvaliadorVO();
                vo.setNome(rs.getString("nome"));
                vo.setCPF(rs.getString("cpf"));
                vo.setEmail(rs.getString("email"));
                vo.setSenha(rs.getString("senha"));
                vo.setNivel(rs.getInt("nivel"));
                vo.setEndereco(rs.getString("endereco"));
                vo.setIdAvaliador(rs.getLong("id_avaliador"));
                vo.setIdUsuario(rs.getLong("id_avaliador_usuario"));
                
                avaliadores.add(vo);
        	}
            return avaliadores;

        } catch (Exception exc){
            throw new Exception("Banco de dados vazio");
    
        }
	}	
	
	public Long idUsuarioAvaliador(AvaliadorVO usu) throws Exception {
        Long id = null;
        try {
        	List<AvaliadorVO> avaliadores = listarAvaliadores();
  
        	for ( int index = 0; index < avaliadores.size(); index++) {
        		if (usu.getIdAvaliador() == avaliadores.get(index).getIdAvaliador()){ 	
        			id = avaliadores.get(index).getIdUsuario();
        		}
        		}
        	
      }catch(SQLException erro) {
            erro.printStackTrace();
        };
        return id;
    }
	
	public Long idAvaliador(UsuarioVO usu) throws Exception {
        Long id = null;
        try {
        	List<AvaliadorVO> avaliadores = listarAvaliadores();
  
        	for ( int index = 0; index < avaliadores.size(); index++) {
        		if (usu.getIdUsuario() == avaliadores.get(index).getIdUsuario()){ 	
        			id = avaliadores.get(index).getIdAvaliador();
        		}
        		}
        	
      }catch(SQLException erro) {
            erro.printStackTrace();
        };
        return id;
  }
	
    public List<AvaliadorVO> listarAvaliadoresNome(AvaliadorVO aval) throws Exception {
        
		List<AvaliadorVO> avaliadores = new ArrayList<AvaliadorVO>();
        AvaliadorDAO dao = new AvaliadorDAO();
		ResultSet rs = dao.listar();
        try{            
        	while(rs.next()){
                AvaliadorVO vo = new AvaliadorVO();
                vo.setNome(rs.getString("nome"));
                vo.setCPF(rs.getString("cpf"));
                vo.setEmail(rs.getString("email"));
                vo.setSenha(rs.getString("senha"));
                vo.setNivel(rs.getInt("nivel"));
                vo.setEndereco(rs.getString("endereco"));
                vo.setIdAvaliador(rs.getLong("id_avaliador"));
                vo.setIdUsuario(rs.getLong("id_avaliador_usuario"));
                
                	if (aval.getNome().equals(vo.getNome())){ 	
                		  avaliadores.add(vo);
                		}
                }
            return avaliadores;

        } catch (Exception exc){
            throw new Exception("Banco de dados vazio");
    
        }
	}	
    
 public List<AvaliadorVO> listarAvaliadoresObra(ObraVO obra) throws Exception {
        
		List<AvaliadorVO> avaliadores = new ArrayList<AvaliadorVO>();
        AvaliadorDAO dao = new AvaliadorDAO();
		ResultSet rs = dao.listar();
        AvaliaObraBO avaliação  = new AvaliaObraBO();
        List<AvaliaObraVO> avalia = avaliação.listarAvaliacoes();
		try{            
        	while(rs.next()){
                AvaliadorVO vo = new AvaliadorVO();
                vo.setNome(rs.getString("nome"));
                vo.setCPF(rs.getString("cpf"));
                vo.setEmail(rs.getString("email"));
                vo.setSenha(rs.getString("senha"));
                vo.setNivel(rs.getInt("nivel"));
                vo.setEndereco(rs.getString("endereco"));
                vo.setIdAvaliador(rs.getLong("id_avaliador"));
                vo.setIdUsuario(rs.getLong("id_avaliador_usuario"));
                
	               for ( int index = 0; index < avalia.size(); index++) 
	               { if((vo.getIdAvaliador()  == avalia.get(index).getIdAvaliador()) && (obra.getIdObra() == avalia.get(index).getIdObra())) {
	                  avaliadores.add(vo);
	               }
                }
        	}
            return avaliadores;

        } catch (Exception exc){
            throw new Exception("Banco de dados vazio");
    
        }
	}	
}