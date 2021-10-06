package src.model.BO;

import java.util.List;

import src.model.VO.AutorVO;

public interface AutorInterBO {
    public void adicionarAutor(AutorVO avo) throws Exception;
    
    public void excluirAutor(AutorVO avo) throws Exception;

    public void editarAutor(AutorVO avo) throws Exception;

    public List<AutorVO> listarAutores() throws Exception;
}
