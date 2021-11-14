package model.DAO;

import java.util.List;

import model.VO.AvaliaObraVO;

public interface AvaliaObraInterDAO {
    public void inserir(AvaliaObraVO avaliaObraVo);

    public void removerById(AvaliaObraVO avaliaObraVo);

    public void editar(AvaliaObraVO avaliaObraVo);

    public List<AvaliaObraVO> listar();
}