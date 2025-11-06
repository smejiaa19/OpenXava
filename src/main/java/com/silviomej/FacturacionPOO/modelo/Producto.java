package com.silviomej.FacturacionPOO.modelo;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.DescriptionsList;
import org.openxava.annotations.Files;
import org.openxava.annotations.Money;
import org.openxava.annotations.TextArea;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity @Getter
@Setter
public class Producto {
    @Id
    @Column(length=9)
    int numero;

    @Column(length=50)
    String descripcion;

    @Money
    BigDecimal precio;

    @Files
    @Column(length=32)
    String imagen;

    @TextArea
    String comentarios;

    @ManyToOne(fetch=FetchType.LAZY)
    @DescriptionsList
    Autor autor;

    @ManyToOne(
            fetch = FetchType.LAZY,
            optional=true)
    @DescriptionsList
    Categoria categoria;

}
