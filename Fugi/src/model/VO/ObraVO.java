package model.VO;


public class ObraVO {
    private Long idObra;
    private String titulo;
    private String genero;
    private String ano;
    private AutorVO autor;
    private String estado;

    public void setIdObra(Long idObra){
        if(idObra >= 0) 
            this.idObra = idObra; 
    }
 
    public Long getIdObra(){
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

    public void setAno(String ano){
        if(ano != null) 
            this.ano = ano;  
    }

    public String getAno(){
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

	public void setIdAutor(long long1) {
		autor.setIdAutor(long1);
	}
	
	public Long getIdAutor() {
		return autor.getIdAutor();
	}
}
