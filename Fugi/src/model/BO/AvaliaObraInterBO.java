package src.model.BO;

import java.util.List;

import src.model.VO.AvaliaObraVO;

public interface AvaliaObraInterBO {
    public void adicionarAvaliacao(AvaliaObraVO ovo) throws Exception;

    public void excluirAvaliacao(AvaliaObraVO ovo) throws Exception;

    public void editarAvaliacao(AvaliaObraVO ovo) throws Exception;

    public List<AvaliaObraVO> listarAvaliacoes() throws Exception;
}
