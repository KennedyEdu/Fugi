package model.VO;

public class AdminVO extends UsuarioVO{

    private long idAdm;

    public void setIdAdm(long l){
        if(l >= 0)
            this.idAdm = l;
    }

    public long getIdAdm(){
        return this.idAdm;
    } 
}