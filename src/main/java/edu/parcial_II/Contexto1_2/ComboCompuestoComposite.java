package edu.parcial_II.Contexto1_2;

import java.util.ArrayList;
import java.util.List;

//Clase compuesto donde encontramos la logica de de añadir y mostrar detalle de un combo y un articulo
//impleenta la interface para utilizar sus metodos

//no se creo comboSorpresa como contenedor por que deduci que comboCompuesto se comporta igual a una cajs sorpresa
//para evitar redundancea solo cree este combo compuesto

        public class ComboCompuestoComposite implements ComponenteProductoComposite {

            //atributo nombre de un combo
            private String nombre;

            //esta lista de tipo interface llamada subProductos se creara nueva para poder
            //guardar los articulos por unidad
            private List<ComponenteProductoComposite> subProductos;

            // 1. Agregamos los atributos para simular los extras
            private boolean incluyeEmpaque = false;
            private boolean incluyePoliza = false;

            //CONSTRUCTOR QUE tomara la instancea del main
            public ComboCompuestoComposite(String nombre) {
                this.nombre = nombre;
                this.subProductos = new ArrayList<>();
            }

            //metodo del patron q se encarga de anidar articulos en combos en eeste contexto
            public void agregarProducto(ComponenteProductoComposite componente) {
                subProductos.add(componente);
            }

            // 2. Setters para activar los extras segun el contexto de prueba con
            //las polizas y el empaque

            public void setIncluyeEmpaque(boolean incluyeEmpaque) {
                this.incluyeEmpaque = incluyeEmpaque;
            }

            public void setIncluyePoliza(boolean incluyePoliza) {
                this.incluyePoliza = incluyePoliza;
            }


            //metodo logico ya para calcular el precio de varios articulos para definirlo
            //aa este combo de articulos
            @Override
            public double calcularPrecio() {
                double AcumuladorUno = 0;
                for (ComponenteProductoComposite componente : subProductos) {
                    AcumuladorUno += componente.calcularPrecio();
                }
                return AcumuladorUno;
            }


            //metodo ya con logica grande donde se encargara despues de anidar los paquetes entrantes por la instanceas
            //del main con los articulos de la clase articulo individual (clase hoja) mostrando el detalle especifico
            //como en los ejemplos de el profesor la hoja seria los archivos especificos en este caso son los articulos unitarios
            //y el combo son las carpetasA
            @Override
            public void mostrarDetalle() {
                System.out.println("+ Paquete: " + nombre);
                // El bucle sigue existiendo porque es parte del patrón llamar a los hijos
                for (ComponenteProductoComposite componente : subProductos) {
                    componente.mostrarDetalle();
                }
            }
        }



