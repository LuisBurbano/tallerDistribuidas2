package com.taller.taller.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Entity
@Table(name = "asignaturas")
public class Asignatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre no puede estar vacío.")
    @Size(max = 63, min = 2, message = "El nombre debe tener entre 2 y 63 caracteres.")
    private String nombre;

    @NotBlank(message = "El código no puede estar vacío.")
    @Size(max = 10, message = "El código debe tener como máximo 10 caracteres.")
    private String codigo;

    @Min(value = 1, message = "Los créditos deben ser al menos 1.")
    @Max(value = 10, message = "Los créditos no pueden ser mayores a 10.")
    private int creditos;

    @NotNull(message = "La fecha no puede ser nula.")
    @PastOrPresent(message = "La fecha debe ser hoy o una fecha pasada.")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fecha;

    public Asignatura() {
    }

    public Asignatura(String nombre, String codigo, int creditos, LocalDate fecha) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.creditos = creditos;
        this.fecha = fecha;
    }

    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
