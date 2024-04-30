/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package banco_v1;

import java.util.List;
import banco_v1.Cuenta;
import banco_v1.Transaccion;
import java.util.ArrayList;

/**
 *
 * @author UFG
 */
/**
 * Clase que representa un banco, con métodos para registrar clientes, realizar transferencias, depósitos, retiros y verificar saldos.
 */
public class Banco {
    /**
     * Lista de clientes del banco.
     */
    public List<Cliente> clientes;
    /**
     * Lista de cuentas del banco.
     */
    public List<Cuenta> cuentas;
    
    /**
     * Constructor de la clase Banco, inicializa las listas de clientes y cuentas.
     */
    public Banco() {
        this.cuentas = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }
    
    /**
     * Registra un nuevo cliente y su cuenta en el banco.
     * 
     * @param cuenta cuenta del cliente
     * @param cliente información del cliente
     */
    public void RegistrarCliente(Cuenta cuenta, Cliente cliente) {
        try {
            cuentas.add(cuenta);
            clientes.add(cliente);
        } catch (Exception e) {
            System.out.println("Error: No se pudo registrar el cliente.");
        }
    }
    
    /**
     * Realiza una transferencia entre dos cuentas.
     * 
     * @param cuentaOrigen número de cuenta origen
     * @param cuentaDestino número de cuenta destino
     * @param monto monto a transferir
     */
    public void RealizarTransferencia(int cuentaOrigen, int cuentaDestino, double monto) {
        try {
            Transaccion.Transferencia(cuentaOrigen, cuentaDestino, monto, cuentas);
        } catch (Exception e) {
            System.out.println("Error: No se pudo realizar la transferencia.");
        }
    }
    
    /**
     * Realiza un depósito en una cuenta específica.
     * 
     * @param cuentaDestino número de cuenta destino
     * @param monto monto a depositar
     */
    public void Deposito(int cuentaDestino, double monto) {
        try {
            Cuenta.Depositar(cuentaDestino, monto, cuentas);
        } catch (Exception e) {
            System.out.println("Error: No se pudo realizar el depósito.");
        }
    }
    
    /**
     * Realiza un retiro de una cuenta específica.
     * 
     * @param cuentaDestino número de cuenta origen
     * @param monto monto a retirar
     */
    public void Retiro(int cuentaDestino, double monto) {
        try {
            Cuenta.Retirar(cuentaDestino, monto, cuentas);
        } catch (Exception e) {
            System.out.println("Error: No se pudo realizar el retiro.");
        }
    }
    
    /**
     * Verifica el saldo de una cuenta específica.
     * 
     * @param cuentaDestino número de cuenta
     */
    public void VerificarSaldo(int cuentaDestino) {
        try {
            Cuenta.VerificarS(cuentaDestino, cuentas, clientes);
        } catch (Exception e) {
            System.out.println("Error: No se pudo verificar el saldo.");
        }
    }
    
    /**
     * Realiza un pago de servicios.
     * 
     * @param cuentaDestino número de cuenta
     */
    public void realizarPagoServicios(int cuentaDestino) {
        try {
            Cuenta.VerificarS(cuentaDestino, cuentas, clientes);
        } catch (Exception e) {
            System.out.println("Error: No se pudo realizar el pago de servicios.");
        }
    }
    
    /**
     * Verifica todos los productos (cuentas) del banco.
     */
    public void verificarTodosProductos() {
        try {
            for (Cuenta cuenta : cuentas) {
                System.out.print( "cuenta: "+cuenta.getCuenta()+" "
                        + "saldo "+cuenta.getSaldo()+" \n");
            }
        } catch (Exception e) {
            System.out.println("Error: No se pudo verificar los productos.");
        }
    }
}
