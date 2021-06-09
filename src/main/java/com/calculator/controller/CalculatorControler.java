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
/**
 * @author ramon.arias
 * date: 03/06/2021
 * current version: 1.2
 */
@CrossOrigin
@RestController
public class CalculatorControler {
	
	@Autowired
	private ResEntity responseMessage;
	
	@Autowired
	private CalculatorServices calculatorServices;

	@GetMapping("/healtCheck")
	public String healtCheck() {
		return "harves-date-calculator-api";
	}
	/**
	 * 
	 * Ejemplo de Request valido
	 * {
	 * 	"id": 9,  
	 * 	"width": 1, (metros)
	 * 	"high": 1 (metros)
	 * }
	 * @param request en formato json
	 */
	@PostMapping("/calculadorById")
	public ResponseEntity<?> calculador(@RequestBody() Species species) {
		if (species.getHigh() < 0 || species.getWidth() < 0) {
			responseMessage.setMensaje("Los datos ingresados son incorrectos");
			return ResponseEntity.ok(responseMessage);
		}
		return calculatorServices.calculator(species);
	}
}