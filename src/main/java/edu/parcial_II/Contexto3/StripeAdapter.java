package edu.parcial_II.Contexto3;

    // SE ENCARGARA DE ADAPATAR con la interface a la clase que se ensesita traducir.
    public class StripeAdapter implements ProcesadorPago {

        // Contiene una instancia de la clase externa que va a adaptar
        private StripeUsa pasarelaStripe;

        // Clave de comercio simulada pensando que exige StripeUSA
        private final String MERCHANT_KEY = "SECRET_KEY_SHOPMASTER_123";

        //constructor
        public StripeAdapter() {
            this.pasarelaStripe = new StripeUsa();
        }

        // El sistema llama a este método creyendo que es un cobro normal en pesos...
        @Override
        public void cobrarEnPesos(String usuario, double montoCOP) {

            // 1. Traducimos los datos: Convertimos pesos a dólares (1 USD = 4.000 COP)
            double montoDolares = montoCOP / 4000.0;

            System.out.println("-> [Adapter] Interceptando cobro...");
            System.out.println("-> [Adapter] Convirtiendo COP a USD (Tasa 1 = 4000 US)");
            System.out.println("-> [Adapter] " + montoCOP + " COP = " + montoDolares + " USD");

            // Simular un email para el cliente
            String emailSimulado = usuario.toLowerCase() + "@mail.com";

            // 2. Ejecutamos la acción en el objeto adaptado (pasarela gringa)
            pasarelaStripe.chargeInDollars(montoDolares, emailSimulado, MERCHANT_KEY);
        }
    }
