package src.model.DAO;

import java.util.List;

import src.model.VO.AutorVO;

public interface AutorInterDAO {
    public void removerById(AutorVO autorvo);

    public void editar(AutorVO autorVo);

    public List<AutorVO> listar();
}
