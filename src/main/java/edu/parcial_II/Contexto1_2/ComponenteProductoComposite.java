package edu.parcial_II.Contexto1_2;

    // Esta interfaz obliga a que tanto un artículo individual
// como un combo gigante respondan a los metodos dados
    public interface ComponenteProductoComposite {

        // metodo que nos da el precio del articulo o nos suma si es un combo
        // segun el contexto: anuciado que nos da a entender requerimeinto de permitir calcular
        //el precio total y mostrar el desglose completo de forma transparente sin importar cuántos
        //niveles de paquetes haya uno dentro de otro.
        double calcularPrecio();

        // Método para mostrar el patron o imprimir categorias y articulos dentro de ellas
        void mostrarDetalle();
    }

