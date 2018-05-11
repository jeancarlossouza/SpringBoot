package jean.study.springboot.model.repository;

import jean.study.springboot.model.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositório JPA para entidade Livro
 */
public interface LivroRepository extends JpaRepository<Livro, Long> {

    Livro findByTituloContaining(String titulo);
    
    Livro findByEscritorContaining(String autor);
    
    Livro findByEditoraContaining(String editora);
        
}
