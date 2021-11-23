package model.BO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.DAO.ObraDAO;
import model.VO.AutorVO;
import model.VO.AvaliaObraVO;
import model.VO.AvaliadorVO;
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
            throw new Exception("O Id da Obra não está no banco de dados");
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
	                vo.setAno(rs.getString("ano"));
	                vo.setEstado(rs.getString("estado"));
	                vo.setIdObra(rs.getLong("id_obra"));
	                AutorVO autor = new AutorVO();
	                autor.setIdAutor(rs.getLong("id_obra_autor"));
	                vo.setAutor(autor);
	                
	                obras.add(vo);
	        	}
	            return obras;
	        } catch (Exception exc){
	            throw new Exception("Banco de dados vazio");		    
		        
	        }
			
	}	
	
	public ObraVO ObraCatch(Long id) throws Exception {
        ObraVO obra = new ObraVO();
        try {
        	List<ObraVO> Obras = listarObras();
  
        	for ( int index = 0; index < Obras.size(); index++) {
        		if (id == Obras.get(index).getIdObra()){ 	
        			obra = Obras.get(index);
        		}
        		}
        	
      }catch(SQLException erro) {
            erro.printStackTrace();
        };
        return obra;
    }

    public List<ObraVO> listarObrasAutor(AutorVO aut) throws Exception {
		 
			List<ObraVO> obras = new ArrayList<ObraVO>();
	        ObraDAO dao = new ObraDAO();
			ResultSet rs = dao.listar(); 
	        try{            
	        	while(rs.next()){
	                ObraVO vo = new ObraVO();
	                vo.setTitulo(rs.getString("titulo"));
	                vo.setGenero(rs.getString("genero"));
	                vo.setAno(rs.getString("ano"));
	                vo.setEstado(rs.getString("estado"));
	                vo.setIdObra(rs.getLong("id_obra"));
	                AutorVO autor = new AutorVO();
	                autor.setIdAutor(rs.getLong("id_obra_autor"));
	                vo.setAutor(autor);
	                if (aut.getIdAutor() == vo.getAutor().getIdAutor()) {    
	                obras.add(vo);
	               }
	        	}
	            return obras;
	        } catch (Exception exc){
	            throw new Exception("Banco de dados vazio");		    
		        
	        }
			
	}	
    
    public List<ObraVO> listarObrasAvaliador(AvaliadorVO avl) throws Exception {
		 
 			List<ObraVO> obras = new ArrayList<ObraVO>();
 	        ObraDAO dao = new ObraDAO();
 			ResultSet rs = dao.listar(); 
             AvaliaObraBO avaliação  = new AvaliaObraBO();
             List<AvaliaObraVO> avalia = avaliação.listarAvaliacoes();
 	        try{            
 	        	while(rs.next()){
 	                ObraVO vo = new ObraVO();
 	                vo.setTitulo(rs.getString("titulo"));
 	                vo.setGenero(rs.getString("genero"));
 	                vo.setAno(rs.getString("ano"));
 	                vo.setEstado(rs.getString("estado"));
 	                vo.setIdObra(rs.getLong("id_obra"));
 	                AutorVO autor = new AutorVO();
 	                autor.setIdAutor(rs.getLong("id_obra_autor"));
 	               
 	               for ( int index = 0; index < avalia.size(); index++) 
 	               { if((vo.getIdObra()  == avalia.get(index).getIdObra()) && (avl.getIdAvaliador()  == avalia.get(index).getIdAvaliador()))
 	                obras.add(vo);
 	               }
 	               
 	        	}
 	            return obras;
 	        } catch (Exception exc){
 	            throw new Exception("Banco de dados vazio");		    
 		        
 	        }
 			
 	}	

    public List<ObraVO> listarObrasTitulo(ObraVO ob) throws Exception {
		 
		List<ObraVO> obras = new ArrayList<ObraVO>();
        ObraDAO dao = new ObraDAO();
		ResultSet rs = dao.listar(); 
        try{            
        	while(rs.next()){
                ObraVO vo = new ObraVO();
                vo.setTitulo(rs.getString("titulo"));
                vo.setGenero(rs.getString("genero"));
                vo.setAno(rs.getString("ano"));
                vo.setEstado(rs.getString("estado"));
                vo.setIdObra(rs.getLong("id_obra"));
                AutorVO autor = new AutorVO();
                autor.setIdAutor(rs.getLong("id_obra_autor"));
                vo.setAutor(autor);
                if (ob.getTitulo().equals(vo.getTitulo())) {    
                   obras.add(vo);
               }
        	}
            return obras;
        } catch (Exception exc){
            throw new Exception("Banco de dados vazio");		    
	        
        }
        }	
    public List<ObraVO> listarObrasData(ObraVO ob) throws Exception {
		 
		List<ObraVO> obras = new ArrayList<ObraVO>();
        ObraDAO dao = new ObraDAO();
		ResultSet rs = dao.listar(); 
        try{            
        	while(rs.next()){
                ObraVO vo = new ObraVO();
                vo.setTitulo(rs.getString("titulo"));
                vo.setGenero(rs.getString("genero"));
                vo.setAno(rs.getString("ano"));
                vo.setEstado(rs.getString("estado"));
                vo.setIdObra(rs.getLong("id_obra"));
                AutorVO autor = new AutorVO();
                autor.setIdAutor(rs.getLong("id_obra_autor"));
                vo.setAutor(autor);
                if (ob.getAno().equals(vo.getAno())) {    
                   obras.add(vo);
               }
        	}
            return obras;
        } catch (Exception exc){
            throw new Exception("Banco de dados vazio");		    
	        
        }

    }
    
    public List<ObraVO> listarObrasStatus(ObraVO ob) throws Exception {
		 
		List<ObraVO> obras = new ArrayList<ObraVO>();
        ObraDAO dao = new ObraDAO();
		ResultSet rs = dao.listar(); 
        try{            
        	while(rs.next()){
                ObraVO vo = new ObraVO();
                vo.setTitulo(rs.getString("titulo"));
                vo.setGenero(rs.getString("genero"));
                vo.setAno(rs.getString("ano"));
                vo.setEstado(rs.getString("estado"));
                vo.setIdObra(rs.getLong("id_obra"));
                AutorVO autor = new AutorVO();
                autor.setIdAutor(rs.getLong("id_obra_autor"));
                vo.setAutor(autor);
                if (ob.getEstado().equals(vo.getEstado())) {    
                   obras.add(vo);
               }
        	}
            return obras;
        } catch (Exception exc){
            throw new Exception("Banco de dados vazio");		    
	        
        }
    }
        
        public List<ObraVO> listarObrasAutor(ObraVO ob) throws Exception {
   		 
    		List<ObraVO> obras = new ArrayList<ObraVO>();
            ObraDAO dao = new ObraDAO();
    		ResultSet rs = dao.listar(); 
            try{            
            	while(rs.next()){
                    ObraVO vo = new ObraVO();
                    vo.setTitulo(rs.getString("titulo"));
                    vo.setGenero(rs.getString("genero"));
                    vo.setAno(rs.getString("ano"));
                    vo.setEstado(rs.getString("estado"));
                    vo.setIdObra(rs.getLong("id_obra"));
                    AutorVO autor = new AutorVO();
                    autor.setIdAutor(rs.getLong("id_obra_autor"));
                    vo.setAutor(autor);
                    if (ob.getAutor().getIdAutor() == vo.getAutor().getIdAutor()) {    
                       obras.add(vo);
                   }
            	}
                return obras;
            } catch (Exception exc){
                throw new Exception("Banco de dados vazio");		    
    	        
            }

    }
        

        public List<ObraVO> listarObrasTituloAval(ObraVO obra, AvaliadorVO avl) throws Exception {
   		 
    			List<ObraVO> obras = new ArrayList<ObraVO>();
    	        ObraDAO dao = new ObraDAO();
    			ResultSet rs = dao.listar(); 
                AvaliaObraBO avaliação  = new AvaliaObraBO();
                List<AvaliaObraVO> avalia = avaliação.listarAvaliacoes();
    	        try{            
    	        	while(rs.next()){
    	                ObraVO vo = new ObraVO();
    	                vo.setTitulo(rs.getString("titulo"));
    	                vo.setGenero(rs.getString("genero"));
    	                vo.setAno(rs.getString("ano"));
    	                vo.setEstado(rs.getString("estado"));
    	                vo.setIdObra(rs.getLong("id_obra"));
    	                AutorVO autor = new AutorVO();
    	                autor.setIdAutor(rs.getLong("id_obra_autor"));
    	               
    	               for ( int index = 0; index < avalia.size(); index++) 
    	               { if((vo.getIdObra()  == avalia.get(index).getIdObra()) && (avl.getIdAvaliador()  == avalia.get(index).getIdAvaliador()) && (vo.getTitulo().equals(obra.getTitulo())))
    	                obras.add(vo);
    	               }
    	               
    	        	}
    	            return obras;
    	        } catch (Exception exc){
    	            throw new Exception("Banco de dados vazio");		    
    		        
    	        }
    			
    	}	
        
        public List<ObraVO> listarObrasDataAval(ObraVO obra, AvaliadorVO avl) throws Exception {
      		 
    			List<ObraVO> obras = new ArrayList<ObraVO>();
    	        ObraDAO dao = new ObraDAO();
    			ResultSet rs = dao.listar(); 
                AvaliaObraBO avaliação  = new AvaliaObraBO();
                List<AvaliaObraVO> avalia = avaliação.listarAvaliacoes();
    	        try{            
    	        	while(rs.next()){
    	                ObraVO vo = new ObraVO();
    	                vo.setTitulo(rs.getString("titulo"));
    	                vo.setGenero(rs.getString("genero"));
    	                vo.setAno(rs.getString("ano"));
    	                vo.setEstado(rs.getString("estado"));
    	                vo.setIdObra(rs.getLong("id_obra"));
    	                AutorVO autor = new AutorVO();
    	                autor.setIdAutor(rs.getLong("id_obra_autor"));
    	               
    	               for ( int index = 0; index < avalia.size(); index++) 
    	               { if((vo.getIdObra()  == avalia.get(index).getIdObra()) && (avl.getIdAvaliador()  == avalia.get(index).getIdAvaliador()) && (vo.getAno().equals(obra.getAno())))
    	                obras.add(vo);
    	               }
    	               
    	        	}
    	            return obras;
    	        } catch (Exception exc){
    	            throw new Exception("Banco de dados vazio");		    
    		        
    	        }
    			
    	}	

        public List<ObraVO> listarObrasStatusAval(ObraVO obra, AvaliadorVO avl) throws Exception {
      		 
    			List<ObraVO> obras = new ArrayList<ObraVO>();
    	        ObraDAO dao = new ObraDAO();
    			ResultSet rs = dao.listar(); 
                AvaliaObraBO avaliação  = new AvaliaObraBO();
                List<AvaliaObraVO> avalia = avaliação.listarAvaliacoes();
    	        try{            
    	        	while(rs.next()){
    	                ObraVO vo = new ObraVO();
    	                vo.setTitulo(rs.getString("titulo"));
    	                vo.setGenero(rs.getString("genero"));
    	                vo.setAno(rs.getString("ano"));
    	                vo.setEstado(rs.getString("estado"));
    	                vo.setIdObra(rs.getLong("id_obra"));
    	                AutorVO autor = new AutorVO();
    	                autor.setIdAutor(rs.getLong("id_obra_autor"));
    	               
    	               for ( int index = 0; index < avalia.size(); index++) 
    	               { if((vo.getIdObra()  == avalia.get(index).getIdObra()) && (avl.getIdAvaliador()  == avalia.get(index).getIdAvaliador()) && (vo.getEstado().equals(obra.getEstado())))
    	                obras.add(vo);
    	               }
    	               
    	        	}
    	            return obras;
    	        } catch (Exception exc){
    	            throw new Exception("Banco de dados vazio");		    
    		        
    	        }
    			
    	}	

        
        public List<ObraVO> listarObrasAutorAval( ObraVO obra, AvaliadorVO avl) throws Exception {
      		 
    			List<ObraVO> obras = new ArrayList<ObraVO>();
    	        ObraDAO dao = new ObraDAO();
    			ResultSet rs = dao.listar(); 
                AvaliaObraBO avaliação  = new AvaliaObraBO();
                List<AvaliaObraVO> avalia = avaliação.listarAvaliacoes();
    	        try{            
    	        	while(rs.next()){
    	                ObraVO vo = new ObraVO();
    	                vo.setTitulo(rs.getString("titulo"));
    	                vo.setGenero(rs.getString("genero"));
    	                vo.setAno(rs.getString("ano"));
    	                vo.setEstado(rs.getString("estado"));
    	                vo.setIdObra(rs.getLong("id_obra"));
    	                AutorVO autor = new AutorVO();
    	                autor.setIdAutor(rs.getLong("id_obra_autor"));
    	               
    	               for ( int index = 0; index < avalia.size(); index++) 
    	               { if((vo.getIdObra()  == avalia.get(index).getIdObra()) && (avl.getIdAvaliador()  == avalia.get(index).getIdAvaliador()) && (vo.getIdAutor() == obra.getIdAutor()))
    	                obras.add(vo);
    	               }
    	               
    	        	}
    	            return obras;
    	        } catch (Exception exc){
    	            throw new Exception("Banco de dados vazio");		    
    		        
    	        }
    			
    	}	


        public List<ObraVO> listarObrasTituloAutor(ObraVO obra, AutorVO aut) throws Exception {
   		 
    			List<ObraVO> obras = new ArrayList<ObraVO>();
    	        ObraDAO dao = new ObraDAO();
    			ResultSet rs = dao.listar(); 
    	        try{            
    	        	while(rs.next()){
    	                ObraVO vo = new ObraVO();
    	                vo.setTitulo(rs.getString("titulo"));
    	                vo.setGenero(rs.getString("genero"));
    	                vo.setAno(rs.getString("ano"));
    	                vo.setEstado(rs.getString("estado"));
    	                vo.setIdObra(rs.getLong("id_obra"));
    	                AutorVO autor = new AutorVO();
    	                autor.setIdAutor(rs.getLong("id_obra_autor"));
    	                vo.setAutor(autor);
     	               
    	                if(((vo.getAutor().getIdAutor())  == aut.getIdAutor())  && (vo.getTitulo().equals(obra.getTitulo())))
    	                {
    	                	obras.add(vo);
    	               }
    	               
    	        	}
    	            return obras;
    	        } catch (Exception exc){
    	            throw new Exception("Banco de dados vazio");		    
    		        
    	        }
    			
    	}	
        
        public List<ObraVO> listarObrasDataAutor(ObraVO obra, AutorVO aut) throws Exception {
      		 
    			List<ObraVO> obras = new ArrayList<ObraVO>();
    	        ObraDAO dao = new ObraDAO();
    			ResultSet rs = dao.listar(); 
    	        try{            
    	        	while(rs.next()){
    	                ObraVO vo = new ObraVO();
    	                vo.setTitulo(rs.getString("titulo"));
    	                vo.setGenero(rs.getString("genero"));
    	                vo.setAno(rs.getString("ano"));
    	                vo.setEstado(rs.getString("estado"));
    	                vo.setIdObra(rs.getLong("id_obra"));
    	                AutorVO autor = new AutorVO();
    	                autor.setIdAutor(rs.getLong("id_obra_autor"));
    	                vo.setAutor(autor);
    	               
    	                if(((vo.getAutor().getIdAutor())  == aut.getIdAutor())  && (vo.getAno().equals(obra.getAno())))
    	                {
    	                	obras.add(vo);
    	               }
    	               
    	        	}
    	            return obras;
    	        } catch (Exception exc){
    	            throw new Exception("Banco de dados vazio");		    
    		        
    	        }
    			
    	}	

        public List<ObraVO> listarObrasStatusAutor(ObraVO obra, AutorVO aut) throws Exception {
      		 
    			List<ObraVO> obras = new ArrayList<ObraVO>();
    	        ObraDAO dao = new ObraDAO();
    			ResultSet rs = dao.listar(); 

    	        try{            
    	        	while(rs.next()){
    	                ObraVO vo = new ObraVO();
    	                vo.setTitulo(rs.getString("titulo"));
    	                vo.setGenero(rs.getString("genero"));
    	                vo.setAno(rs.getString("ano"));
    	                vo.setEstado(rs.getString("estado"));
    	                vo.setIdObra(rs.getLong("id_obra"));
    	                AutorVO autor = new AutorVO();
    	                autor.setIdAutor(rs.getLong("id_obra_autor"));
    	                vo.setAutor(autor);
     	               
    	                if(((vo.getAutor().getIdAutor())  == aut.getIdAutor())  && (vo.getEstado().equals(obra.getEstado())))
    	                {
    	                	obras.add(vo);
    	               }
    	            }      
    	        	
    	            return obras;
    	        } catch (Exception exc){
    	            throw new Exception("Banco de dados vazio");		    
    		        
    	        }
    			
    	}	

}