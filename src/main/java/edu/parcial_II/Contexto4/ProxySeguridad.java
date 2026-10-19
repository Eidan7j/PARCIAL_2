package edu.parcial_II.Contexto4;

// Importa la interfaz que ambos van a implementar
import edu.parcial_II.Contexto3.ProcesadorPago;

    // Rol: Proxy. Implementa la interfaz.
    public class ProxySeguridad implements ProcesadorPago {

        // Tiene una referencia al Objeto Real
        private PasarelaCobroReal objetoReal;

        public ProxySeguridad() {
            // Instancia el objeto real
            this.objetoReal = new PasarelaCobroReal();
        }

        @Override
        public void cobrarEnPesos(String usuario, double montoCOP) {
            System.out.println("\n[PROXY] Evaluando requisitos para el usuario: " + usuario);

            // 1. REQUISITO: Evalúa si es usuario bloqueado
            if (usuario.equals("BLOQUEADO")) {
                System.out.println("[ALERTA] Rechazo. Usuario bloqueado.");
                return; // No pasa al objeto real
            }

            // 2. REQUISITO: Evalúa el tope de dinero
            if (!usuario.equals("cliente_vip") && montoCOP > 5000000) {
                System.out.println("[ALERTA] Rechazo. Excede el límite de 5.000.000 COP.");
                return; // No pasa al objeto real
            }

            // 3. PASA AL OBJETO REAL
            System.out.println("[AUDITORÍA: Transacción aprobada para " + usuario + "]");
            objetoReal.cobrarEnPesos(usuario, montoCOP);
        }
    }

