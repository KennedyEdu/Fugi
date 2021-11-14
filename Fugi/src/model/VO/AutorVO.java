package model.VO;

public class AutorVO extends Usuario {

    private int idAutor;

    public void setIdAutor(int idAutor){
        if(idAutor >= 0)
            this.idAutor = idAutor;
    }

    public int getIdAutor(){
        return this.idAutor;
    } 
}