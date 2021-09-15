package src.model.VO;

//Class abstrata
public class usuarioVO {
    private String nome;
    private String endereco;
    private String cpf;
    private String email;
    private String senha; 
    private int nivel;

    public void setNome(String nomeUser){
        if(nomeUser != null && nomeUser != "")
            this.nome = nomeUser;
    }

    public String getNome(){
        return this.nome;
    } 

    public void setEndereco(String enderecoUser){
        if(enderecoUser != null && enderecoUser != "")
            this.endereco = enderecoUser;
    }

    public String getEndereco(){
        return this.endereco;
    } 

    public void setCPF(String cpf){
        if(cpf != null && cpf != "")
            this.cpf = cpf;
    }

    public String getCPF(){
        return this.cpf;
    }

    public void setEmail(String email){
        if(email != null && email != "")
            this.email = email;
    }

    public String getEmail(){
        return this.email;
    } 

    public void setSenha(String senhaUser){
        if(senhaUser != null && senhaUser != "")
            this.senha = senhaUser;
    }

    public String getSenha(){
        return this.senha;
    }

    public void setNivel(int nivel){
        if(nivel >= 0)
            this.nivel = nivel;
    }

    public int getNivel(){
        return nivel;
    }
}
