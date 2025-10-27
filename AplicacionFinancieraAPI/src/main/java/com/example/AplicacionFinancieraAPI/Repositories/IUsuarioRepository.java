package com.example.AplicacionFinancieraAPI.Repositories;

import com.example.AplicacionFinancieraAPI.Models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario,Integer> {
}
