package edu.parcial_II.Contexto1_2;


    public class DecoradorManejoFragil extends ProductoDecorador {
        public DecoradorManejoFragil(ComponenteProductoComposite productoEnvuelto) {
            super(productoEnvuelto);
        }

        @Override
        public double calcularPrecio() {
            // Suma 25.000 fijos
            return super.calcularPrecio() + 25000;
        }

        @Override
        public void mostrarDetalle() {
            super.mostrarDetalle();
            System.out.println("   + [Extra] Manejo Prioritario Frágil ($25000.0)");
        }
    }

