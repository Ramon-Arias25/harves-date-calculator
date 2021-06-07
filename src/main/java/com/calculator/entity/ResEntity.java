package com.calculator.entity;
import org.springframework.stereotype.Component;
/**
 * @author ramon.arias
 * date: 03/06/2021
 * current version: 1
 */
@Component
public class ResEntity {

	private String mensaje;

	public ResEntity() {
		super();
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
}