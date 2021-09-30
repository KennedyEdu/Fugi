package src.model.DAO;

import java.util.List;

import src.model.VO.ObraVO;

public interface ObraInterDAO {
    public void inserir(ObraVO obraVo);

    public void removerById(ObraVO obraVo);

    public void editar(ObraVO obraVo);

    public List<ObraVO> listar();
}
