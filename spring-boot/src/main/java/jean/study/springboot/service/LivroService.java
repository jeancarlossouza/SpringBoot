package jean.study.springboot.service;

import jean.study.springboot.model.entity.Livro;
import jean.study.springboot.model.repository.LivroRepository;
import jean.study.springboot.vo.LivroVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.validation.ValidationException;

/**
 * Serviço para entidade Livro
 */
@Service
public class LivroService {

    private final LivroRepository livroRepository;

    /**
     * Metodo construtor
     *
     * @param livroRepository
     */
    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    /**
     * Metodo para inserir entidade livro
     *
     * @param livroVo
     */
    @Transactional
    public void inserir(@Valid LivroVo livroVo) {

        Livro livro = new Livro();
        livro.setTitulo(livroVo.getTitulo());
        livro.setEditora(livroVo.getEditora());
        livro.setEscritor(livroVo.getEscritor());

        if (livroRepository.findByTituloContaining(livroVo.getTitulo()) != null) {
            throw new ValidationException("Livro ja cadastrado!");
        }

        livroRepository.saveAndFlush(livro);
    }

    @Transactional(readOnly = true)
    public List<LivroVo> consultar(String titulo, String escritor, String editora) {

        if (titulo.isEmpty() && escritor.isEmpty() && editora.isEmpty()) {
            return consultarTodos();

        } else {

            List<LivroVo> lista = new ArrayList<>();
            lista.add(consultarLivro(titulo, escritor, editora));

            return lista;
        }
    }

    @Transactional(readOnly = true)
    private LivroVo consultarLivro(String titulo, String escritor, String editora) {
      
        Livro livro = new Livro();

        if (!titulo.isEmpty()) {
            livro = livroRepository.findByTituloContaining(titulo);
        } else if (!escritor.isEmpty()) {
            livro = livroRepository.findByEscritorContaining(escritor);
        } else if (!editora.isEmpty()) {
            livro = livroRepository.findByEditoraContaining(editora);
        }

        LivroVo livroVo = new LivroVo();
        livroVo.setId(livro.getId());
        livroVo.setTitulo(livro.getTitulo());
        livroVo.setEditora(livro.getEditora());
        livroVo.setEscritor(livro.getEscritor());

        return livroVo;
    }

    /**
     * Metodo que retorna todos os livros cadastrados
     *
     * @return
     */
    @Transactional(readOnly = true)
    public List<LivroVo> consultarTodos() {

        List<LivroVo> resultado = new ArrayList<>();

        List<Livro> livros = livroRepository.findAll();

        for (Livro livro : livros) {
            LivroVo livroVo = new LivroVo();
            livroVo.setId(livro.getId());
            livroVo.setTitulo(livro.getTitulo());
            livroVo.setId(livro.getId());
            livroVo.setEditora(livro.getEditora());
            livroVo.setEscritor(livro.getEscritor());
            resultado.add(livroVo);
        }

        resultado.forEach(System.out::println);
        return resultado;
    }

    @Transactional
    public void atualizar(@Valid LivroVo livroVo, long id) {

        Livro livro = new Livro();
        livro.setId(id);
        livro.setTitulo(livroVo.getTitulo());
        livro.setEditora(livroVo.getEditora());
        livro.setEscritor(livroVo.getEscritor());

        Optional<Livro> livroExist = livroRepository.findById(id);

        if (livroExist == null) {
            throw new ValidationException("Livro não encontrado!");
        }

        livroRepository.saveAndFlush(livro);
    }

    @Transactional
    public void excluir(@Valid long id) {
        if (livroRepository.findById(id) == null) {
            throw new ValidationException("Livro não encontrado!");
        }

        livroRepository.deleteById(id);
    }
}
