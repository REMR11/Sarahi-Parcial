/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package banco_v1;

import banco_v1.Cuenta;
import banco_v1.Banco;
import java.util.List;

/**
 *
 * @author UFG
 * Clase que representa una transacción, con métodos para realizar transferencias y pagos de servicios.
 */
public class Transaccion {

    /**
     * Constructor de la clase Transaccion, no hace nada en este caso.
     */
    public Transaccion() {
    }

    /**
     * Realiza una transferencia entre dos cuentas.
     * 
     * @param cuentaOrigen número de cuenta origen
     * @param cuentaDestino número de cuenta destino
     * @param monto monto a transferir
     * @param cuentas lista de cuentas del banco
     */
    static void Transferencia(int cuentaOrigen, int cuentaDestino, double monto, List<Cuenta> cuentas) {
        try {
            for (Cuenta cuenta : cuentas) {
                if (cuenta.getCuenta() == cuentaOrigen) {
                    if (cuenta.getSaldo() >= monto) {
                        for (Cuenta cuenta2 : cuentas) {
                            if (cuenta2.getCuenta() == cuentaDestino) {
                                cuenta2.setSaldo(cuenta2.getSaldo() + monto);
                                cuenta.setSaldo(cuenta.getSaldo() - monto);
                                System.out.print("Transaccion realizada exitosamente\n");
                            } else {
                                System.out.print("La cuenta de destino no existe\n");
                            }
                        }
                    } else {
                        System.out.print("La cuenta de origen no tiene los fondos suficientes\n");
                    }
                } else {
                    System.out.print("La cuenta de origen no existe o esta mal escrita, intente nuevamente\n");
                }
            }
        } catch (Exception e) {
            System.out.println("Error: No se pudo realizar la transferencia.");
        }
    }
}