package com.mtt.springSecurity.Controller;

import com.mtt.springSecurity.Service.PessoaService;
import com.mtt.springSecurity.models.PessoaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {
    @Autowired
    private PessoaService pessoaService;

    @GetMapping("/{id}")
    public ResponseEntity<PessoaModel> buscarPorId(@PathVariable Long id){
        try {
        PessoaModel pessoaModel = pessoaService.buscarPorId(id);
        return ResponseEntity.ok().body(pessoaModel);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<PessoaModel> criarPessoa(@RequestBody PessoaModel model){
        PessoaModel pessoaModel = pessoaService.criarPessoa(model);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(pessoaModel.getId()).toUri();
        return ResponseEntity.created(uri).body(pessoaModel);
    }
}
