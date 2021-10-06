package src.model.BO;

import java.util.List;

import src.model.VO.AvaliadorVO;

public interface AvaliadorInterBO {
    public void adicionarAvaliador(AvaliadorVO alvo) throws Exception;
    
    public void excluirAvaliador(AvaliadorVO alvo) throws Exception;

    public void editarAvaliador(AvaliadorVO alvo) throws Exception;

    public List<AvaliadorVO> listarAvaliadores() throws Exception;
}
