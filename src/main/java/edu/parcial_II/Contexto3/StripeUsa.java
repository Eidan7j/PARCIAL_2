package edu.parcial_II.Contexto3;

//esta clase de representa la logica que segun
// el contexto 3 es una pasarela o un procesador de compras que funciona distinto y en ingles
// a comparacion de los procesos en colombia y es inmutable segun el contexto
//para entenderlo mejor segun el ejemplo del profesor con los tipos de texto este seria un tipo de texto que
// nesesita un adaptador para poder entender o asumir sus valores

public class StripeUsa {

        // Método que procesa en dólares y requiere parámetros distintos al sistema local colombiano que tiene la empresa

        public void chargeInDollars(double amountUSD, String customerEmail, String merchantKey) {
            System.out.println("====== StripeUSA Gateway ======");
            System.out.println("Processing payment for: " + customerEmail);
            System.out.println("Amount charged: $" + amountUSD + " USD");
            System.out.println("Status: SUCCESS");
            System.out.println("===============================");
        }
    }

