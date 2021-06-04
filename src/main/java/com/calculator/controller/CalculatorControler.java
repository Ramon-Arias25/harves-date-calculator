package com.calculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.calculator.entity.ResEntity;
import com.calculator.entity.SpeciesEntity;
import com.calculator.model.Species;
import com.calculator.service.CalculatorServices;

@CrossOrigin
@RestController
public class CalculatorControler {

	@Autowired
	private SpeciesEntity speciesEntity;

	@Autowired
	private ResEntity responseMessage;

	@GetMapping("/test")
	public String saludo() {
		new CalculatorServices().imprimir();
		return "hola ola";
	}
	@PostMapping("/calculador")
	public ResponseEntity<?> calculador(@RequestBody() Species species) {
		if (species.getHigh() < 0 || species.getWidth() < 0) {
			this.responseMessage.setMensaje("Los datos ingresados son incorrectos");
			return ResponseEntity.ok(this.responseMessage);
		}
		if (!new CalculatorServices().validateSowingDate(species)) {
			this.responseMessage.setMensaje("La especie consultada es apta para la siembra");
			return ResponseEntity.ok(this.responseMessage);
		}
		if (!new CalculatorServices().exists(species)) {
			this.responseMessage.setMensaje("No se encontraron datos de dicha especie");
			return ResponseEntity.ok(this.responseMessage);
		}
			speciesEntity.setSpecies(species.getName());
			speciesEntity.setPossibleSeedlings(new CalculatorServices().totalToSow(species));
			speciesEntity.setHarvestDate(new CalculatorServices().harvesDateCalculator(species));
			return ResponseEntity.ok(speciesEntity);
	}
}