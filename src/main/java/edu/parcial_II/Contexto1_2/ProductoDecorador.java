package edu.parcial_II.Contexto1_2;


    public abstract class ProductoDecorador implements ComponenteProductoComposite {
        protected ComponenteProductoComposite productoEnvuelto;

        public ProductoDecorador(ComponenteProductoComposite productoEnvuelto) {
            this.productoEnvuelto = productoEnvuelto;
        }

        @Override
        public double calcularPrecio() {
            return productoEnvuelto.calcularPrecio();
        }

        @Override
        public void mostrarDetalle() {
            productoEnvuelto.mostrarDetalle();
        }
    }

