package com.silviomej.FacturacionPOO.modelo;

import com.silviomej.FacturacionPOO.calculadores.CalculadorSiguienteNumeroParaAnyo;
import lombok.Getter;
import lombok.Setter;
import java.time.*;
import java.util.Collection;

import org.hibernate.annotations.GenericGenerator;
import org.openxava.annotations.*;
import org.openxava.calculators.CurrentLocalDateCalculator;
import org.openxava.calculators.CurrentYearCalculator;

import javax.persistence.*;

@Entity @Getter @Setter
@View(members=
        "anyo, numero, fecha;" +
                "cliente;" +
                "detalles;" +
                "observaciones;"
)
public class Factura {
    @Id
    @GeneratedValue(generator="system-uuid")
    @Hidden
    @GenericGenerator(name="system-uuid", strategy="uuid")
    @Column(length=32)
    String oid;

    @Column(length=4)
    @DefaultValueCalculator(CurrentYearCalculator.class)
    int anyo;


    @Required
    @DefaultValueCalculator(CurrentLocalDateCalculator.class)
    LocalDate fecha;

    @TextArea
    String observaciones;

    @Column(length=6)
    @DefaultValueCalculator(value= CalculadorSiguienteNumeroParaAnyo.class, properties=@PropertyValue(name="anyo"))
    int numero;
    // PropertyValue se usa para decir que el valor de la propiedad anyo en la factura actual se movera a la propiedad
    // Anyo del calculador antes de hacer el calculo.

    @ManyToOne(fetch=FetchType.LAZY, optional=false)
            @ReferenceView("Simple")
    Cliente cliente;

    @ElementCollection
            @ListProperties("producto.numero, producto.descripcion, cantidad")
    Collection<Detalle> detalles;
}
