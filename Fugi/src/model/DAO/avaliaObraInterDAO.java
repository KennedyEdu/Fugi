package src.model.DAO;

import java.util.List;

import src.model.VO.AvaliaObraVO;

public interface avaliaObraInterDAO {
    public void inserir(AvaliaObraVO avaliaObraVo);

    public void removerById(AvaliaObraVO avaliaObraVo);

    public void editar(AvaliaObraVO avaliaObraVo);

    public List<AvaliaObraVO> listar();
}
