package edu.parcial_II.Contexto1_2;


    public class DecoradorEmpaque extends ProductoDecorador {
        public DecoradorEmpaque(ComponenteProductoComposite productoEnvuelto) {
            super(productoEnvuelto);
        }

        @Override
        public double calcularPrecio() {
            // Suma 15.000 fijos
            return super.calcularPrecio() + 15000;
        }

        @Override
        public void mostrarDetalle() {
            super.mostrarDetalle();
            System.out.println("   + [Extra] Empaque de Regalo Premium ($15000.0)");
        }
    }
