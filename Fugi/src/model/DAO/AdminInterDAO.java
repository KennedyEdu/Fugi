package src.model.DAO;

import java.util.List;

import src.model.VO.AdminVO;

public interface AdminInterDAO {
    public void removerById(AdminVO adminvo);

    public void editar(AdminVO adminVo);

    public List<AdminVO> listar();
}
