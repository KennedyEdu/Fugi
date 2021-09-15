package src.model.VO;

public class autorVO extends usuarioVO {

    private int idAutor;

    public void setIdAutor(int idAutor){
        if(idAutor >= 0)
            this.idAutor = idAutor;
    }

    public int getIdAuthor(){
        return this.idAutor;
    } 
}
