package VO;

public class ObraVO {
    private int IDObra;
    private String título;
    private String genero;
    private Date ano;
    private AutorVO autor;
    private String status;

    public void setIDObra(idBOOK){
        if(idBOOK >= 0) {
            this.IDObra = idBOOK; 
        }
    }

    public int getIDObra(){
        return this.IDObra;
    }

    public void setTítulo(String tituloBOOK){
        if(tituloBOOK != null && tituloBOOK != "") {
            this.título = tituloBOOK;
        }
    }

    public String getTítulo(){
        return this.título;
    } 

    public void setGenero(String generoBOOK){
        if(generoBOOK != null && generoBOOK != "") { 
            this.genero = generoBOOK;
        }
    }

    public String getGenero(){
        return this.genero;
    }

    public void setAno(String anoBOOK){
        if(anoBOOK != null && anoBOOK != "") { 
            this.ano = anoBOOK;
        }
    }

    public Date getAno(){
        return this.ano;
    }

    public void setAutor(String autorBOOK){
        if(autorBOOK != null && autorBOOK != "") { 
            this.autor = autorBOOK; 
        }
    }

    public AutorVO getAutor(){
        return this.autor;
    }

    public void setStatus(String statusBOOK){
        if(tituloBOOK != null && tituloBOOK != "") { 
            this.status = statusBOOK;
        }
    }

    public String getStatus(){
        return this.status; 
    }
}
