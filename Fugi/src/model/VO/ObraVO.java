package src.model.VO;

import java.util.Date;

public class ObraVO {
    private int idObra;
    private String titulo;
    private String genero;
    private Date ano;
    private AutorVO autor;
    private String estado;

    public void setIdObra(int idObra){
        if(idObra >= 0) 
            this.idObra = idObra; 
    }

    public int getIdObra(){
        return this.idObra;
    }

    public void setTitulo(String titulo){
        if(titulo != null && !(titulo.equals("")))
            this.titulo = titulo;
    }

    public String getTitulo(){
        return this.titulo;
    } 

    public void setGenero(String genero){
        if(genero != null && !(genero.equals("")))
            this.genero = genero;
    }

    public String getGenero(){
        return this.genero;
    }

    public void setAno(Date ano){
        if(ano != null) 
            this.ano = ano;  
    }

    public Date getAno(){
        return this.ano;
    }

    public void setAutor(AutorVO autor){
        if(autor != null) 
            this.autor = autor; 
    }

    public AutorVO getAutor(){
        return this.autor;
    }

    public void setEstado(String estado){
        if(titulo != null && !(titulo.equals("")))
            this.estado = estado;
    }

    public String getEstado(){
        return this.estado; 
    }
}