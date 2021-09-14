package VO;

public class avaliadorVO {
    private int iDUsuario;
    private String nome;
    private String endereco;
    private String cPF;
    private String email;
    private String senha; 
    private int iDAvaliador;

    public int getIDusuario(){
        return this.iDUsuario;
    }   
    
    public void setNome(String nomeUser){
        this.nome = nomeUser;
    }

    public String getNome(){
        return this.nome;
    } 

    public void setEndereco(String enderecoUser){
        this.endereco = enderecoUser;
    }

    public String getEndereco(){
        return this.endereco;
    } 

    public String getCPF(){
        return this.cPF;
    } 

    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){
        return this.email;
    } 

    public void setSenha(String senhaUser){
        this.senha = senhaUser;
    }

    public String getSenha(){
        return this.senha;
    } 

    public int getIDAvaliador(){
        return this.iDAvaliador;
    }
}
