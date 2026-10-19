package edu.parcial_II;

// Imports del Composite y Decorator
import edu.parcial_II.Contexto1_2.*;
// Import de la Fachada
import edu.parcial_II.Contexto5.ShopMasterFacade;

public class Main {
    public static void main(String[] args) {
        // Instanciamos el punto de entrada simplificado (Facade)
        ShopMasterFacade tiendaFacade = new ShopMasterFacade();


        // =========================================================================
        // CASO DE PRUEBA 1: Compra Exitosa Completa
        // =========================================================================
        System.out.println("**************************************************");
        System.out.println("   EJECUTANDO CASO DE PRUEBA 1 (COMPRA EXITOSA)");
        System.out.println("**************************************************");

        // 1. Armamos el sub-combo (Kit de Limpieza)
        ComponenteProductoComposite alcohol = new ArticuloIndividualComposite("Líquido Limpiador", 25000);
        ComponenteProductoComposite pano = new ArticuloIndividualComposite("Paño Microfibra", 15000);
        ComboCompuestoComposite kitLimpieza = new ComboCompuestoComposite("Kit de Limpieza");
        kitLimpieza.agregarProducto(alcohol);
        kitLimpieza.agregarProducto(pano);

        // 2. Armamos el combo principal
        ComponenteProductoComposite monitor = new ArticuloIndividualComposite("Monitor Gamer", 800000);
        ComponenteProductoComposite teclado = new ArticuloIndividualComposite("Teclado Mecánico", 200000);
        ComboCompuestoComposite comboSetupGamer = new ComboCompuestoComposite("Combo Setup Gamer");
        comboSetupGamer.agregarProducto(monitor);
        comboSetupGamer.agregarProducto(teclado);
        comboSetupGamer.agregarProducto(kitLimpieza);

        // 3. Aplicamos Decoradores (Empaque de regalo y Póliza)
        ComponenteProductoComposite caso1ConEmpaque = new DecoradorEmpaque(comboSetupGamer);
        ComponenteProductoComposite caso1Final = new DecoradorPoliza(caso1ConEmpaque);

        // 4. Ejecutamos mediante el Facade para usuario VIP
        tiendaFacade.ejecutarCompraRapida(caso1Final, "cliente_vip");


        // =========================================================================
        // CASO DE PRUEBA 2: Rechazo por Tope de Dinero (> $5.000.000 COP)
        // =========================================================================
        System.out.println("**************************************************");
        System.out.println("   EJECUTANDO CASO DE PRUEBA 2 (RECHAZO POR TOPE)");
        System.out.println("**************************************************");

        // 1. Producto costoso de $6.000.000
        ComponenteProductoComposite servidor = new ArticuloIndividualComposite("Servidor Empresarial", 6000000);

        // 2. Le agregamos el extra de Manejo Prioritario Frágil ($25.000)
        ComponenteProductoComposite servidorConManejo = new DecoradorManejoFragil(servidor);

        // 3. Intentamos procesar con usuario normal (El Proxy debe bloquearlo)
        tiendaFacade.ejecutarCompraRapida(servidorConManejo, "usuario_normal");


        // =========================================================================
        // CASO DE PRUEBA 3: Rechazo por Usuario Reportado ("BLOQUEADO")
        // =========================================================================
        System.out.println("**************************************************");
        System.out.println("   EJECUTANDO CASO DE PRUEBA 3 (USUARIOS BLOQUEADOS)");
        System.out.println("**************************************************");

        // 1. Producto económico de $150.000
        ComponenteProductoComposite mouse = new ArticuloIndividualComposite("Mouse Ergonómico", 150000);

        // 2. Intentamos procesar enviando la palabra "BLOQUEADO" como usuario
        tiendaFacade.ejecutarCompraRapida(mouse, "BLOQUEADO");
    }
}