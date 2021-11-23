package model.VO;


public class AvaliaObraVO extends ObraVO {
    private Long idAvalia;
    private ObraVO obra;
    private AvaliadorVO avaliador;

    
    public Long getIdObra(){
    	return obra.getIdObra();
    }
    
    public Long getIdAvaliador(){
        return avaliador.getIdAvaliador();    	    	
    }
    
    public void setObra(ObraVO obra){
        if(obra != null)
            this.obra = obra;
    }

    public ObraVO getObra(){
        return this.obra;
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

	public void setIdObra(long long2) {
		this.obra.setIdObra(long2);
	}
	public void setIdAvaliador(long long3) {
		this.avaliador.setIdAvaliador(long3);
	}
}