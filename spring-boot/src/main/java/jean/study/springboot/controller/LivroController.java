package jean.study.springboot.controller;

import jean.study.springboot.service.LivroService;
import jean.study.springboot.vo.LivroVo;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Rest Controller para entidade Livro
 */
@RestController
@RequestMapping(value = "/rest/livros", produces = MediaType.APPLICATION_JSON_VALUE)
@ResponseBody
public class LivroController {

    private final LivroService livroService;

    /**
     * Metodo construtor
     * @param livroService
     */
    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    /**
     * Controller para inserção de livro
     * @param livroVo
     */
    @PostMapping
    public void inserirLivro(@RequestBody @Valid LivroVo livroVo) {
        livroService.inserir(livroVo);
    }

    /**
     * Metodo que retorna todos os livros cadastrados
     */
    @GetMapping
    public List<LivroVo> consultarLivros() {
        return livroService.consultarTodos();
    }
}
