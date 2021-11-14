package model.BO;

import java.util.List;

import model.VO.AvaliaObraVO;

public interface AvaliaObraInterBO {
    public abstract void adicionarAvaliacao(AvaliaObraVO ovo) throws Exception;

    public abstract void excluirAvaliacao(AvaliaObraVO ovo) throws Exception;

    public abstract void editarAvaliacao(AvaliaObraVO ovo) throws Exception;

    public abstract List<AvaliaObraVO> listarAvaliacoes() throws Exception;
}