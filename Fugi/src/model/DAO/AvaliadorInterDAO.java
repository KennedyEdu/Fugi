package src.model.DAO;

import java.util.List;

import src.model.VO.AvaliadorVO;

public interface AvaliadorInterDAO {
    public void removerById(AvaliadorVO avaliadorvo);

    public void editar(AvaliadorVO avaliadorVo);

    public List<AvaliadorVO> listar();
}
