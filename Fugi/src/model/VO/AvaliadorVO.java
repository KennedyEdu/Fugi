package model.VO;

public class AvaliadorVO extends UsuarioVO {
    private long idAvaliador;

    public void setIdAvaliador(Long idAvaliador){
        if(idAvaliador >= 0)
            this.idAvaliador = idAvaliador;
    }

    public long getIdAvaliador(){
        return this.idAvaliador;
    }
}