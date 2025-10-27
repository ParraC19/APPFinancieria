package com.example.AplicacionFinancieraAPI.Repositories;

import com.example.AplicacionFinancieraAPI.Models.Deuda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDeudaRepository extends JpaRepository<Deuda, Integer> {

    List<Deuda> findByUsuarioId(Integer id);
    List<Deuda> findByTransaccionId(Integer id);

}
