package com.calculator.entity;
import org.springframework.stereotype.Component;

@Component
public class ResEntity {

	private String mensaje;

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
}