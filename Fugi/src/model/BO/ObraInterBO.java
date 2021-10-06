package src.model.BO;

import java.util.List;

import src.model.VO.ObraVO;

public interface ObraInterBO {
    public void adicionarObra(ObraVO ovo) throws Exception;

    public void excluirObra(ObraVO ovo) throws Exception;

    public void editarObra(ObraVO ovo) throws Exception;

    public List<ObraVO> listarObras() throws Exception;
}
