package br.com.mfsdevsystem.onetoone_unidirecional;

/**
 *
 * @author Marcelino
 */
public class Pessoa {
    private int id;
    private String nome;
    // mapeamento endereco
    private Endereco endereco;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    
}
