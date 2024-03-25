package br.com.cesul.springcesulapi.controller;


import br.com.cesul.springcesulapi.entidade.Aluno;
import br.com.cesul.springcesulapi.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;


    @PostMapping
    public void criarAluno(@RequestBody Aluno aluno) {
        alunoRepository.save(aluno);
    }

    @GetMapping("/{id}")
    public Aluno carregarAluno(@PathVariable String id) {

        Aluno aluno = alunoRepository.findById(Integer.parseInt(id)).get();

        return aluno;
    }

    @GetMapping
    public List<Aluno> listarAlunos() {
        List<Aluno> alunos = new ArrayList<>();
        alunoRepository.findAll().forEach(alunos::add);

        return alunos;
    }

    @DeleteMapping("/{id}")
    public void deletarAluno(@PathVariable String id) {
        alunoRepository.deleteById(Integer.parseInt(id));
    }

    @PutMapping("/{id}")
    public void atualizarAluno(@PathVariable String id, @RequestBody Aluno aluno) {
        aluno.setId(Integer.parseInt(id));
        alunoRepository.save(aluno);
    }

}
