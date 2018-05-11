package jean.study.springboot.vo;

public class LivroVo {

    private Long id;

    private String titulo;
    
    private String editora;
    
    private String escritor;

    public Long getId() {
        return id;
    }
        
    public String getTitulo() {
        return titulo;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
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
            ", titulo='" + titulo + '\'' +
            ", editora='" + editora + '\'' +
            ", escritor='" + escritor +'\'' +
            '}';
    }
}
