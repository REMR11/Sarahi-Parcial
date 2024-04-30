/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package banco_v1;

import banco_v1.Banco;
import java.util.Scanner;
import banco_v1.Cuenta;


/**
 *
 * @author UFG
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Banco banco = new Banco();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            //inventario.verificarTodosProductos();
            System.out.println("--Sistema Bancario--");
            System.out.println("1. Agregar cuenta");
            System.out.println("2. Realizar transferencia");
            System.out.println("3. Realizar deposito");
            System.out.println("4. Realizar retiro");
            System.out.println("5. Verificar saldo");
            System.out.println("6. Pago de Servicios");
            System.out.println("7. Salir");
            System.out.print("Ingrese una opción: ");
            
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    // Agregar cuenta
                    agregarCuenta(scanner, banco);
                    break;
                case 2:
                    // Hacer transferencia
                    realizarTransferencia(scanner, banco);
                    break;
                case 3:
                  
                    realizarAbono(scanner, banco);
                    break;
                case 4:
                    //Realizar abono o deposito
                    realizarRetiro(scanner, banco);
                    break;
                case 5:
                    // Verificacion de saldo en la cuenta
                    verificarSaldo(scanner, banco);
                    break;
                case 6:
                    // Realizar pago de servicios
                    realizarPagoServicio(scanner, banco);
                    break;
                case 7:
                    System.out.println("Gracias por usar el Sistema de bancario. ¡Hasta luego!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
            
            
        }
        
    }
    
    //Agregar cuenta
     private static void agregarCuenta(Scanner scanner, Banco banco) {
        System.out.print("Ingrese el numero de cuenta: ");
        int cuenta = scanner.nextInt();
        System.out.print("Ingrese el nombre del cliente: ");
        String nombre = scanner.next();
        System.out.print("Ingrese el saldo: ");
        double saldo = scanner.nextDouble();
      
        
        banco.RegistrarCliente(new Cuenta(cuenta,saldo),new Cliente(nombre,cuenta));
        
    }
     //Realizar transferencia
     private static void realizarTransferencia(Scanner scanner, Banco banco) {
        System.out.print("Ingrese el numero de cuenta de origen: ");
        int cuenta1 = scanner.nextInt();
        System.out.print("Ingrese el numero de cuenta de destino: ");
        int cuenta2 = scanner.nextInt();
        System.out.print("Ingrese el monto a tranferir: ");
        double saldo = scanner.nextDouble();
        
        banco.RealizarTransferencia(cuenta1,cuenta2,saldo);
        
       
    }
     //Realizar abono o deposito
         private static void realizarAbono(Scanner scanner, Banco banco) {
             System.out.print("Ingrese el numero de cuenta: ");
            int cuenta = scanner.nextInt();
            System.out.print("Ingrese el monto a depositar: ");
            double saldo = scanner.nextDouble();
            banco.Deposito(cuenta, saldo);     
            System.out.print("Deposito realizado exitosamente:\n ");
         }
         
         
         private static void realizarRetiro(Scanner scanner, Banco banco) {
             System.out.print("Ingrese el numero de cuenta: ");
            int cuenta = scanner.nextInt();
            System.out.print("Ingrese el monto a retirar: ");
            double saldo = scanner.nextDouble();
            banco.Retiro(cuenta, saldo);   
            System.out.print("Retiro realizado con exito \n ");
         }
         
         private static void verificarSaldo(Scanner scanner, Banco banco) {
             System.out.print("Ingrese el numero de cuenta: ");
            int cuenta = scanner.nextInt();
            
            banco.VerificarSaldo(cuenta);         
            
         }
         
         private static void realizarPagoServicio(Scanner scanner, Banco banco) {
             System.out.print("Ingrese el numero de cuenta: ");
            int cuenta = scanner.nextInt();
            System.out.print("Ingrese el monto a abonar: ");
            double saldo = scanner.nextDouble();
            banco.Deposito(cuenta, saldo);     
            System.out.print("Abono realizado exitosamente: ");
         }
    
}
