package com.calculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.calculator.entity.ResEntity;
import com.calculator.entity.Species;
import com.calculator.service.CalculatorServices;

@CrossOrigin
@RestController
public class CalculatorControler {

	@Autowired
	private ResEntity responseMessage;

	@GetMapping("/healtCheck")
	public String saludo() {
		return "harves-date-calculator-api";
	}

	@PostMapping("/calculador")
	public ResponseEntity<?> calculador(@RequestBody() Species species) {
		if (species.getHigh() < 0 || species.getWidth() < 0) {
			this.responseMessage.setMensaje("Los datos ingresados son incorrectos");
			return ResponseEntity.ok(this.responseMessage);
		}
		return new CalculatorServices().calculator(species);
	}
}