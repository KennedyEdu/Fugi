package model.VO;

public class AdminVO extends Usuario{

    private int idAdm;

    public void setIdAdm(int idAdm){
        if(idAdm >= 0)
            this.idAdm = idAdm;
    }

    public int getIdAdm(){
        return this.idAdm;
    } 
}