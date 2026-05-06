package com.mtt.springSecurity.Service;

import com.mtt.springSecurity.Repository.PessoaRepository;
import com.mtt.springSecurity.models.PessoaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;

    public PessoaModel criarPessoa(PessoaModel model){
        return pessoaRepository.save(model);
    }

    public List<PessoaModel> findAll(){
        return pessoaRepository.findAll();
    }

    public PessoaModel buscarPorId(Long id){
        return pessoaRepository.findById(id).get();
    }
}
