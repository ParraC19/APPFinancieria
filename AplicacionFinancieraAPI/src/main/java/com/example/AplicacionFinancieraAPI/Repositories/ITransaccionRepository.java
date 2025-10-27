package com.example.AplicacionFinancieraAPI.Repositories;

import com.example.AplicacionFinancieraAPI.Models.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITransaccionRepository extends JpaRepository<Transaccion,Integer> {

    List<Transaccion> findByUsuarioId(Integer id);

}
