package src.model.VO;

public class AvaliadorVO extends Usuario {
    private int idAvaliador;

    public void setIdAvaliador(int idAvaliador){
        if(idAvaliador >= 0)
            this.idAvaliador = idAvaliador;
    }

    public int getIdAvaliador(){
        return this.idAvaliador;
    }
}
