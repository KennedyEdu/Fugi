package model.BO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.DAO.AvaliadorDAO;
import model.VO.AvaliadorVO;


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
}
