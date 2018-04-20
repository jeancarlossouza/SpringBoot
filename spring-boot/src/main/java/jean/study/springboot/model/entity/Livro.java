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

    @Column(name = "nome", unique = true)
    private String nome;
    
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

    public String getNome() {
        return nome;
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
    
}
