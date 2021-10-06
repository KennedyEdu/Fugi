package src.model.BO;

import java.util.List;

import src.model.VO.AdminVO;

public interface AdminInterBO {
    public void adicionarAdmin(AdminVO advo) throws Exception;
    
    public void excluirAdmin(AdminVO advo) throws Exception;

    public void editarAdmin(AdminVO advo) throws Exception;

    public List<AdminVO> listarAdmins() throws Exception;
}
