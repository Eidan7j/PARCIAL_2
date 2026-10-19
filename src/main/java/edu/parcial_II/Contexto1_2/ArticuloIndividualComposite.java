package edu.parcial_II.Contexto1_2;

//elemento hoja que nos da la logica cuando en el bucle mostrarDetalle de
//la clase compuesto llamada ComboCompuestoComposite se realiza una entrada de un producto un solo articulo
// hay entra y ejecuta esta logica de esta clase hoja
public class ArticuloIndividualComposite implements ComponenteProductoComposite {

    //atributos basicos
    private String nombre;
    private double precio;

    //constructor que toma la instancea y sus atributos
    public ArticuloIndividualComposite(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    //con los atributos de la instancea al entrar a esta clase el objeto como
    //articulo ejecuta su metodo base sin logica de mostrarPrecio
    //solo llamando su atributo de la instancea precio
    @Override
    public double calcularPrecio() {
        return this.precio;
    }

    //lo mismo que en el metodo anterior entra la instancea del articulo unico
    //y se evalua en este metodo en donde su unica funcion es mostrar el nombre y su precio
    //cuya informacion la contiene sus atributos
    @Override
    public void mostrarDetalle() {
        System.out.println(" - " + nombre + " ($" + precio + ")");
    }
}

