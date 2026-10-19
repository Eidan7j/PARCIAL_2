package edu.parcial_II.Contexto4;
// Importa la interfaz que ambos van a implementar
import edu.parcial_II.Contexto3.ProcesadorPago;
import edu.parcial_II.Contexto3.StripeAdapter;


//Clase que implementa la interfaz ProcesarPago
    public class PasarelaCobroReal implements ProcesadorPago {

        private ProcesadorPago adaptadorInternacional;

        public PasarelaCobroReal() {
            // La lógica final es enviar el cobro al adaptador de EE. UU.
            this.adaptadorInternacional = new StripeAdapter();
        }

        @Override
        public void cobrarEnPesos(String usuario, double montoCOP) {
            System.out.println(">> [Pasarela Local] Procesando petición en el objeto real...");
            // Ejecuta la lógica verdadera
            adaptadorInternacional.cobrarEnPesos(usuario, montoCOP);
        }
    }

