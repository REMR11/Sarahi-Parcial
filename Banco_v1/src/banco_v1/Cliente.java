/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package banco_v1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author UFG
 */
public class Cliente {
	private String nombre;
	private int cuenta;

	public Cliente(String nombre, int cuenta) {
		this.nombre = nombre;
		this.cuenta = cuenta;
	}

	// getters y setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCuenta() {
		return cuenta;
	}

	public void setCuenta(int cuenta) {
		this.cuenta = cuenta;
	}

}
