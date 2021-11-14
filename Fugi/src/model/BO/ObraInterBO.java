package model.BO;

import java.util.List;

import model.VO.ObraVO;

public interface ObraInterBO {
    public abstract void adicionarObra(ObraVO ovo) throws Exception;

    public abstract void excluirObra(ObraVO ovo) throws Exception;

    public abstract void editarObra(ObraVO ovo) throws Exception;

    public abstract List<ObraVO> listarObras() throws Exception;
}