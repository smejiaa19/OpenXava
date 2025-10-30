package com.silviomej.FacturacionPOO.modelo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity @Getter
@Setter
public class Producto {
    @Id
    @Column(length=9)
    int numero;

    @Column(length=50)
    String descripcion;
}
