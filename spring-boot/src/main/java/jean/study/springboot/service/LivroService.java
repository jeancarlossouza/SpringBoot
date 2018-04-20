package jean.study.springboot.service;

import jean.study.springboot.model.entity.Livro;
import jean.study.springboot.model.repository.LivroRepository;
import jean.study.springboot.vo.LivroVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import javax.validation.ValidationException;

/**
 * Serviço para entidade Livro
 */
@Service
public class LivroService {

    private final LivroRepository livroRepository;

    /**
     * Metodo construtor
     * @param livroRepository
     */
    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    /**
     * Metodo para inserir entidade livro
     * @param livroVo
     */
    @Transactional
    public void inserir(@Valid LivroVo livroVo) {
                
        Livro livro = new Livro();
        livro.setNome(livroVo.getNome());
        livro.setEditora(livroVo.getEditora());
        livro.setEscritor(livroVo.getEscritor());
        
        if (livroRepository.findByNomeContaining(livroVo.getNome()) != null) {
            throw new ValidationException("Livro ja cadastrado!");
        }
                
        livroRepository.saveAndFlush(livro);
    }

    /**
     * Metodo que retorna todos os livros cadastrados
     */
    @Transactional(readOnly = true)
    public List<LivroVo> consultarTodos() {
        List<Livro> livros = livroRepository.findAll();

        List<LivroVo> resultado = new ArrayList<>();

        for (Livro livro : livros) {
            LivroVo livroVo = new LivroVo();
            livroVo.setId(livro.getId());
            livroVo.setNome(livro.getNome());
            livroVo.setId(livro.getId());
            livroVo.setEditora(livro.getEditora());
            livroVo.setEscritor(livro.getEscritor());
            resultado.add(livroVo);
        }

        resultado.forEach(System.out::println);
        return resultado;
    }
    
    @Transactional
    public void atualizarLivro(@Valid LivroVo livroVo, long id) {
                
        Livro livro = new Livro();
        livro.setId(id);
        livro.setNome(livroVo.getNome());
        livro.setEditora(livroVo.getEditora());
        livro.setEscritor(livroVo.getEscritor());
        
        if (livroRepository.findByNomeContaining(livroVo.getNome()) == null) {
            throw new ValidationException("Livro não encontrado!");
        }
                
        livroRepository.saveAndFlush(livro);
    }
}
