package jean.study.springboot.model.entity;

import javax.persistence.*;

/**
 * Entidade Livro
 */
@Entity
@Table(name = "tbl_livro")
public class Livro {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Long id ;

    @Column(name = "titulo", unique = true)
    private String titulo;
    
    @Column(name = "editora")
    private String editora;
    
    @Column(name = "escritor")
    private String escritor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
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
    
}
