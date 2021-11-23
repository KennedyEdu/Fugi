package model.BO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DAO.UsuarioDAO;
import model.VO.UsuarioVO;

public class AutenticarBO extends UsuarioDAO<UsuarioVO>{
	
	   public List<UsuarioVO> listarUsuarios() throws Exception {

			List<UsuarioVO> usuarios = new ArrayList<UsuarioVO>();
	        UsuarioDAO<UsuarioVO> dao = new UsuarioDAO<UsuarioVO>();
			ResultSet rs = dao.listar();
	        try{            
	        	while(rs.next()){
	    		    UsuarioVO vo = new UsuarioVO();
	                vo.setNome(rs.getString("nome"));
	                vo.setSenha(rs.getString("senha"));
	                vo.setEndereco(rs.getString("Endereco"));
	                vo.setCPF(rs.getString("cpf"));
	                vo.setEmail(rs.getString("email"));
	                vo.setNivel(rs.getInt("nivel"));
	                vo.setIdUsuario(rs.getLong("id"));
	                usuarios.add(vo);
	        	}
	            return usuarios;

	        } catch (Exception exc){
	            throw new Exception("Banco de dados vazio");
	        }
	        
	    }
	   
		public boolean autenticar(UsuarioVO usu) throws Exception {
	        boolean test = false;
	        try {
	        	List<UsuarioVO> usuarios = listarUsuarios();
	  
	        	for ( int index = 0; index < usuarios.size(); index++) {
	        		if (usu.getNome().equals(usuarios.get(index).getNome())){ 	
	        			if (usu.getSenha().equals(usuarios.get(index).getSenha())) {
	        			test = true;
	        		    }
	        		}
	        	}
	       			   
	      
	        }catch(SQLException erro) {
	            erro.printStackTrace();
	        };
	        return test;
	    }

		public UsuarioVO Identificar(UsuarioVO usu) throws Exception {
	        UsuarioVO usur = new UsuarioVO();
	        try {
	        	List<UsuarioVO> usuarios = listarUsuarios();
	  
	        	for ( int index = 0; index < usuarios.size(); index++) {
	        		if (usu.getNome().equals(usuarios.get(index).getNome())){ 	
	        			if (usu.getSenha().equals(usuarios.get(index).getSenha())) {
	        			
	        				usur = usuarios.get(index);
	        			}
	        		}
	        	}
	       			   
	      
	        }catch(SQLException erro) {
	            erro.printStackTrace();
	        };
	        return usur;
	    }

}


