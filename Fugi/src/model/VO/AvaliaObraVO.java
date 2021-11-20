package model.VO;


public class AvaliaObraVO {
    private Long idAvalia;
    private ObraVO obra;
    private AutorVO autor;
    private AvaliadorVO avaliador;
    private String estado;

    public void setObra(ObraVO obra){
        if(obra != null)
            this.obra = obra;
    }

    public ObraVO getObra(){
        return this.obra;
    }

    public void setAutor(AutorVO autor){
        if(autor != null)
            this.autor = autor;
    }

    public AutorVO getAutor(){
        return this.autor;
    }

    public void setAvaliador(AvaliadorVO avaliador){
        if(avaliador != null)
            this.avaliador = avaliador;
    }

    public AvaliadorVO getAvaliador(){
        return this.avaliador;
    }
 
    public void setIdAvalia(Long idAvalia){
        if(idAvalia >= 0)
            this.idAvalia = idAvalia;
    }

    public Long getIdAvalia(){
        return this.idAvalia;
    }

    public void setEstado(String estado){
        if(estado != null && !(estado.equals("")))
            this.estado = estado;
    }

    public String getEstado(){
        return this.estado;
    }

	public void setIdAutor(long long1) {
		autor.setIdAutor(long1);
	}
	public void setIdObra(long long2) {
		obra.setIdObra(long2);
	}
	public void setIdAvaliador(long long3) {
		avaliador.setIdAvaliador(long3);
	}
}