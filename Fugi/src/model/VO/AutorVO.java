package model.VO;

public class AutorVO extends UsuarioVO {

    private long idAutor;

    public void setIdAutor(Long idAutor){
        if(idAutor >= 0)
            this.idAutor = idAutor;
    }

    public long getIdAutor(){
        return this.idAutor;
    } 
}