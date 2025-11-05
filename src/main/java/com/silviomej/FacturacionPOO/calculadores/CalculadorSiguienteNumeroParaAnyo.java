package com.silviomej.FacturacionPOO.calculadores;

import javax.persistence.*;
import org.openxava.calculators.*;
import org.openxava.jpa.XPersistence;
import lombok.*;

public class CalculadorSiguienteNumeroParaAnyo implements ICalculator{
    @Getter @Setter
            int anyo;

    public Object calculate() throws Exception{
    Query query = XPersistence.getManager()
            .createQuery("select max(f.numero) from Factura f where f.anyo = :anyo");
    // Esta consulta devuelve el numero de factura maximo del anio indicado

    query.setParameter("anyo", anyo);
    Integer ultimoNumero = (Integer) query.getSingleResult();
    return ultimoNumero == null ? 1 : ultimoNumero + 1;
    }
}