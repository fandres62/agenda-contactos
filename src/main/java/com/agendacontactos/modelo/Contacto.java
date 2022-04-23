package com.agendacontactos.modelo;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Contacto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //IDENTITY:sea auto incrementable
    private Integer id;

    //blan:  no permita datos en blaco
    @NotBlank(message = "Debe ingresar su nombre")
    private String nombre;

    @NotBlank(message = "Debe ingresar # celular")
    private String celular;

    //Empty: para q no este vacio
    @NotEmpty(message = "Debe ingresar su email")
    @Email //q lleve el formato email
    private String email;

    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)//le indico el formato de fecha
    @Past //le indico q solo acepte fechas registro q hayan nacido en el pasado, no en el presente ni el futuro
    @NotNull(message = "Debe ingresar su fecha de nacmiento") //no permita datos nulos
    private LocalDate fechaNacimiento;

    private LocalDateTime fechaRegistro;

    //fechaRegistro: con este metodo me ayuda persistir la fecha siempre
    //cuando se cree un objeto le voy asigar por defecto la fecha y hora de hoy
    @PrePersist
    public void asignarFechaRegistro() {
        fechaRegistro = LocalDateTime.now();
    }

    public Contacto() {
    }

    public Contacto(Integer id, String nombre, String celular, String email, LocalDate fechaNacimiento, LocalDateTime fechaRegistro) {
        this.id = id;
        this.nombre = nombre;
        this.celular = celular;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}
