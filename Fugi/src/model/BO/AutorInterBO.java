package model.BO;

import java.util.List;

import model.VO.AutorVO;

public interface AutorInterBO {
    public abstract void adicionarAutor(AutorVO avo) throws Exception;
    
    public abstract void excluirAutor(AutorVO avo) throws Exception;

    public abstract void editarAutor(AutorVO avo) throws Exception;

    public abstract List<AutorVO> listarAutores() throws Exception;
}
