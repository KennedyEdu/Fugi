package model.BO;

import java.util.List;

import model.VO.AdminVO;

public interface AdminInterBO {
    public abstract void adicionarAdmin(AdminVO advo) throws Exception;
    
    public  abstract void excluirAdmin(AdminVO advo) throws Exception;

    public  abstract void editarAdmin(AdminVO advo) throws Exception;

    public  abstract List<AdminVO> listarAdmins() throws Exception;
}