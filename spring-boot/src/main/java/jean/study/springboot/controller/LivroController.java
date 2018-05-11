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
     * @param titulo
     * @param escritor
     * @param editora
     * @return 
     */
    @GetMapping
    public List<LivroVo> consultarLivros(
           @RequestParam(name = "titulo", required = false, defaultValue = "") String titulo,
           @RequestParam(name = "escritor", required = false, defaultValue = "") String escritor,
           @RequestParam(name = "editora", required = false, defaultValue = "") String editora) {
                
        return livroService.consultar(titulo, escritor, editora);        
    }
    
    @PostMapping("/{id}")
    public void alterarLivro(@PathVariable long id, @RequestBody @Valid LivroVo livroVo){
        livroService.atualizar(livroVo, id);
    }
    
    @DeleteMapping("/{id}")
    public void excluirLivro(@PathVariable long id) {
        livroService.excluir(id);
    }
}
