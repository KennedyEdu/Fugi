package model.BO;

import java.util.List;

import model.VO.AvaliadorVO;

public interface AvaliadorInterBO {
    public abstract void adicionarAvaliador(AvaliadorVO alvo) throws Exception;
    
    public abstract void excluirAvaliador(AvaliadorVO alvo) throws Exception;

    public abstract void editarAvaliador(AvaliadorVO alvo) throws Exception;

    public abstract List<AvaliadorVO> listarAvaliadores() throws Exception;
}