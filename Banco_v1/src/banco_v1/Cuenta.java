/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package banco_v1;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author UFG
 */
public class Cuenta{

    /*static void Depositar(int cuentaDestino, double monto, List<Cuenta> cuentas) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
    private int cuenta;
    private double saldo;
     Scanner scanner = new Scanner(System.in);
    
    /**
     * @param cuenta
     * @param saldo
     */
    public Cuenta(int cuenta, double saldo){
        this.cuenta = cuenta;
        this.saldo = saldo;
       
    }

 /*   Cuenta(int cuenta, double saldo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    */
    
    // getters y setters
    /**
     * @return Cuenta
     */
    public int getCuenta() {
        return cuenta;
    }

    /**
     * @param cuenta
     */
    public void setCuenta(int cuenta) {
        this.cuenta = cuenta;
    }
    
    /**
     * @return
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * @param saldo
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    //metodos funcionales
    /**
     * Deposita un monto en una cuenta específica.
     * 
     * @param cuentaDestino número de cuenta destino
     * @param monto monto a depositar
     * @param cuentas lista de cuentas
     */
    static void Depositar(int cuentaDestino, double monto, List<Cuenta> cuentas) {
        try {
            Scanner scanner = new Scanner(System.in);
            for (Cuenta cuent : cuentas) {
                if (cuent.getCuenta() == cuentaDestino) {
                    if (monto >= 4999) {
                        System.out.print("¿Cual es el origen de este dinero?"); 
                        String origen = scanner.next();
                        cuent.setSaldo(cuent.getSaldo() + monto);
                        System.out.print("El valor del depósito es: "+monto+"\n Nuevo saldo: "+cuent.getSaldo()+"\n Origen del dinero: "+origen+"\n"); 
                    } else {
                        cuent.setSaldo(cuent.getSaldo() + monto);
                    }
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: El monto ingresado no es válido.");
        } catch (Exception e) {
            System.out.println("Error: No se pudo realizar el depósito.");
        }
    }

    /**
     * Retira un monto de una cuenta específica.
     * 
     * @param cuenta número de cuenta origen
     * @param monto monto a retirar
     * @param cuentas lista de cuentas
     */
    static void Retirar(int cuenta, double monto, List<Cuenta> cuentas) {
        try {
            Scanner scanner = new Scanner(System.in);
            for (Cuenta cuent : cuentas) {
                if (cuent.getCuenta() == cuenta) {
                    if (cuent.getSaldo() >= monto) {
                        System.out.print("¿Que denominacion de billetes le gustaria para este retiro"); 
                        String denominacion = scanner.next();
                        cuent.setSaldo(cuent.getSaldo() - monto);
                        System.out.print("Nuevo saldo: "+cuent.getSaldo());
                    } else {
                        System.out.print("La cuenta de origen no tiene los fondos suficientes ");
                    }
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: El monto ingresado no es válido.");
        } catch (Exception e) {
            System.out.println("Error: No se pudo realizar el retiro.");
        }
    }

    /**
     * Realiza un pago de servicios.
     * 
     * @param cuenta número de cuenta
     * @param monto monto a pagar
     */
    public void realizarPagoServicios(int cuenta, double monto) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("¿Qué servicio desea pagar? (luz, agua, etc.): ");
            String servicio = sc.nextLine();

            if (monto <= saldo) {
                saldo -= monto;
                System.out.println("Pago de " + servicio + " realizado.");
                System.out.println("Saldo actual: $" + saldo);
            } else {
                System.out.println("Saldo insuficiente para realizar el pago.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: El monto ingresado no es válido.");
        } catch (Exception e) {
            System.out.println("Error: No se pudo realizar el pago.");
        }
    }

    /**
     * Verifica la información de una cuenta específica.
     * 
     * @param cuenta número de cuenta
     * @param cuentas lista de cuentas
     * @param clientes lista de clientes
     */
    static void VerificarS(int cuenta, List<Cuenta> cuentas, List<Cliente> clientes) {
        try {
            for (Cuenta cuent : cuentas) {
                if (cuent.getCuenta() == cuenta) {
                    for (Cliente cli : clientes) {
                        if (cli.getCuenta() == cuenta) {
                            System.out.print("--- DETALLE DE LA CUENTA ----- \n");
                            System.out.print( "Cuenta: "+cuent.getCuenta()+" \n"
                                    + "Cliente:  "+cli.getNombre()+" \n"
                            + "Saldo actual "+cuent.getSaldo()+" \n");
                        }
                    }     
                }
            }
        } catch (Exception e) {
            System.out.println("Error: No se pudo verificar la información de la cuenta.");
        }
    }    
}
