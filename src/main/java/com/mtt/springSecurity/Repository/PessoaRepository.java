package com.mtt.springSecurity.Repository;

import com.mtt.springSecurity.models.PessoaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<PessoaModel, Long> {
}
