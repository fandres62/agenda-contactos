package com.agendacontactos.repositorio;

import com.agendacontactos.modelo.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactoRepositorio extends JpaRepository<Contacto, Integer> {

}
