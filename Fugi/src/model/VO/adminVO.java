package src.model.VO;

public class adminVO extends usuarioVO{

    private int idAdm;

    public void setIdAdm(int idadm){
        if(idadm >= 0)
            this.idAdm = idadm;
    }

    public int getIdAdm(){
        return this.idAdm;
    } 
}
