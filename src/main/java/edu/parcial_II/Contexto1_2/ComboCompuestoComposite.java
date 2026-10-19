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

            // 3. Sumamos los recargos si están activos
            double totalFinal = AcumuladorUno;
            //si es true el totalFinal se le suma 15000
            if (incluyeEmpaque) {
                totalFinal += 15000; // Precio fijo del empaque le doy ese precio como un empaque general por combo
            }
            //a el valor total se le multiplica por un 10% para sumarle de la poliza a el combo
            if (incluyePoliza) {
                totalFinal += (AcumuladorUno * 0.10);
            }

            return totalFinal;
        }


        //metodo ya con logica grande donde se encargara de anidar los paquetes entrantes por la instanceas
        //del main con los articulos de la clase articulo individual (clase hoja) mostrando el detalle especifico
        //como en los ejemplos de el profesor la hoja seria los archivos especificos en este caso son los articulos unitarios
        //y el combo son las carpetas
        @Override
        public void mostrarDetalle() {
            System.out.println("+ Paquete: " + nombre);
            // El bucle sigue existiendo porque es parte del patrón llamar a los hijos
            for (ComponenteProductoComposite componente : subProductos) {
                componente.mostrarDetalle();
            }
            // Mostramos en simulacion logica los recargos si se aplicaron al combo
            if (incluyeEmpaque) {
                System.out.println("   + [Extra] Empaque de Regalo ($15000.0)");
            }
            if (incluyePoliza) {
                double total= 0;
                for (ComponenteProductoComposite componente : subProductos) {
                    total += componente.calcularPrecio();
                }
                // a ell precio del combo o el articulo que se guarda en total le
                // Calculamos el 10% del precio
                double costoPoliza = total * 0.10;
                System.out.println("   + [Extra] Póliza de Garantía ($" + costoPoliza + ")");
            }


        }
    }

