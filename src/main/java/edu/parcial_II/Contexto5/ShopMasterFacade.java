package edu.parcial_II.Contexto5;


// Importamos el componente de productos y la barrera de seguridad
import edu.parcial_II.Contexto1_2.ComponenteProductoComposite;
import edu.parcial_II.Contexto3.ProcesadorPago;
import edu.parcial_II.Contexto4.ProxySeguridad;

    // Rol: Facade (Fachada). Simplifica el proceso de compra ocultando la complejidad al Main.
    public class ShopMasterFacade {

        // Mantiene una referencia al punto de entrada de pagos (el Proxy)
        private ProcesadorPago barreraSeguridad;

        public ShopMasterFacade() {
            // La fachada inicializa internamente los subsistemas requeridos
            this.barreraSeguridad = new ProxySeguridad();
        }

        // Método de alto nivel de "Un Solo Clic" exigido por el enunciado
        public void ejecutarCompraRapida(ComponenteProductoComposite pedido, String usuario) {
            System.out.println("==================================================");
            System.out.println(">>> SHOPMASTER: PROCESANDO COMPRA RÁPIDA <<<");
            System.out.println("==================================================");

            // 1. Muestra el desglose del pedido (Árbol y Decoradores)
            System.out.println("\n[DETALLE DEL PEDIDO]");
            pedido.mostrarDetalle();

            // 2. Obtiene el costo total calculado
            double totalCOP = pedido.calcularPrecio();
            System.out.println("\nTotal Calculado (COP): $" + totalCOP);

            // 3. Envía el cobro a través de la barrera de seguridad
            System.out.println("\n[PROCESANDO PAGO Y AUDITORÍA]");
            barreraSeguridad.cobrarEnPesos(usuario, totalCOP);

            System.out.println("==================================================\n");
        }
}
