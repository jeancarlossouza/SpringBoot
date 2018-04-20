package jean.study.springboot.vo;

public class LivroVo {

    private Long id;

    private String nome;
    
    private String editora;
    
    private String escritor;

    public Long getId() {
        return id;
    }
        
    public String getNome() {
        return nome;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getEscritor() {
        return escritor;
    }

    public void setEscritor(String escritor) {
        this.escritor = escritor;
    }

    @Override
    public String toString() {
        return "LivroVo{" +
            "id=" + id +
            ", nome='" + nome + '\'' +
            ", editora='" + editora + '\'' +
            ", escritor='" + escritor +'\'' +
            '}';
    }
}
