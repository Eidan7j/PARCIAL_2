package edu.parcial_II.Contexto3;

// la interface aqui actua como un contrato que e le asigna a la clase que se desea implementar
public interface ProcesadorPago {

        // El método estándar de la tienda colombiana segun el contexto 3 sera tomada como
        void cobrarEnPesos(String usuario, double montoCOP);
    }

