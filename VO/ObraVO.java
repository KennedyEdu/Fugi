SSpackage VO;

public class ObraVO {
    private int IDObra;
    private String título;
    private String genero;
    private Date ano;
    private AutorVO autor;
    private String status;

    public int getIDObra(){
        return this.IDObra;
    }

    public void setTítulo(String tituloBOOK){
        this.título = tituloBOOK;
    }

    public String getTítulo(){
        return this.título;
    } 

    public void setGenero(String generoBOOK){
        this.genero = generoBOOK;
    }

    public String getGenero(){
        return this.genero;
    }

    public void setAno(String anoBOOK){
        this.ano = anoBOOK;
    }

    public Date getAno(){
        return this.ano;
    }

    public void setAutor(String autorBOOK){
        this.autor = autorBOOK;
    }

    public AutorVO getAutor(){
        return this.autor;
    }

    public void setStatus(String statusBOOK){
        this.status = statusBOOK;
    }

    public String getStatus(){
        return this.status;
    }
}