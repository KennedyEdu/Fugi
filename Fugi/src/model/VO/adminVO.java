package VO;

public class adminVO {

    private String nome;
    private String endereco;
    private String cPF;
    private String email;
    private String senha; 
    private int iDADM;
    private int nivel;
    
    
    public void setNome(String nomeUser){
        if (nomeUser == null || nomeUser == ''){
            
        } else{ this.nome = nomeUser;
        }
    
    }
    public String getNome(){
        if (this.nome == null || this.nome == ''){
            
        } else{ return this.nome;
        }
    } 

    public void setEndereco(String enderecoUser){
        if (enderecoUser == null || enderecoUser == ''){
            
        } else{ this.endereco = enderecoUser;
        }
    }

    public String getEndereco(){
        if (this.endereco == null || this.endereco == ''){
            
        } else{return this.endereco;
        } 
    } 

    public void setCPF(String cPFUser){
        if (cPFUser == null || cPFUser == ''){
            
        } else{ this.cPF = cPFUser;
        }
    } 
  
    public String getCPF(){
        if (this.cPF == null || this.cPF == ''){
           
        } else{ return this.cPF;
    } 

    public void setEmail(String emailUser){
        if (emailUser == null || emailUser == ''){
            
        } else{ this.email = emailUser;
        }
    }

    public String getEmail(){
        if (this.email == null || this.email == ''){
            
        } else{ return this.email;
        }
    } 

    public void setSenha(String senhaUser){
        if (senhaUser == null || senhaUser == ''){
            
        } else{ this.senha = senhaUser;
    }

    public String getSenha(){
        if (this.senhar == null || this.senha == ''){
            
        } else{ return this.senha;
    } 

    public void setIDADM(int iDADMUser){
        if (iDADMUser == null){
            
        } else{ this.iDADM = iDADMUser;
    } 
    public int getIDADM(){
        if (this.iDADM == null){
            
        } else return this.iDADM;
    } 
    
    public void setNivel (int nivelUser){
        if (nivelUser == null){
            
        } else this.nivel = nivelUser;
    }
    
    public int getNivel (){
        if (this.nivel == null){
            
        } else return this.nivel;
    }
}
