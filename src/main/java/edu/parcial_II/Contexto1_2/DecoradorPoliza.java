package edu.parcial_II.Contexto1_2;


    public class DecoradorPoliza extends ProductoDecorador {
        public DecoradorPoliza(ComponenteProductoComposite productoEnvuelto) {
            super(productoEnvuelto);
        }

        @Override
        public double calcularPrecio() {
            // Incrementa el valor en un 10%
            return super.calcularPrecio() * 1.10;
        }

        @Override
        public void mostrarDetalle() {
            super.mostrarDetalle();
            System.out.println("   + [Extra] Póliza de Garantía Extendida (10%)");
        }
    }
