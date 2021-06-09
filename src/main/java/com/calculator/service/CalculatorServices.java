package com.calculator.service;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.calculator.entity.ResEntity;
import com.calculator.entity.SowingCalendar;
import com.calculator.entity.Species;
import com.calculator.entity.SpeciesEntity;
import com.calculator.repositories.ISowingCalendarRepository;

/**
 * @author ramon.arias 
 * date: 03/06/2021 
 * current version: 1.2
 */
@Service
public class CalculatorServices {
	@Autowired
	ISowingCalendarRepository sowingCalendarRepository;

	/**
	 * Valida si el objeto Specie existe en la base de datos, 
	 * Valida que la especie sea apta para la siembra, 
	 * Calcula la cantidad de plantines y 
	 * llama al metodo privado harvesDateCalculator(int dayCount) que calcula la fecha de cosecha
	 * llama al metodo privado canItBeSown(String sowingCalendar) que valida si la especie es apta para sembrar
	 * 
	 * @param objeto de tipo Species
	 * @return ResponseEntity con la respuesta que no sea una especie listada o que
	 *         no sea apta para la siembra o la respuesta solicitada
	 */
	
	public ResponseEntity<?> calculator(Species species) {
		ResEntity resEntity = new ResEntity();
		SpeciesEntity speciesEntity = new SpeciesEntity();
		Optional<SowingCalendar> optionalSowingCalendar = sowingCalendarRepository.findById(species.getid());
		if (optionalSowingCalendar.isPresent()) {
			SowingCalendar sowingCalendar = optionalSowingCalendar.get();
			if (canItBeSown(sowingCalendar.getSeedTime())) {
				speciesEntity.setSpecies(sowingCalendar.getSpecies());
				speciesEntity.setHarvestDate(harvesDateCalculator(sowingCalendar.getDayCount()));
				speciesEntity.setPossibleSeedlings(((species.getHigh() * 100) / sowingCalendar.getDistance())
						* ((species.getWidth() * 100) / sowingCalendar.getDistance()));
				return ResponseEntity.ok(speciesEntity);
			} else {
				resEntity.setMensaje("La especie consultada No es apta para la siembra");
				return ResponseEntity.ok(resEntity);
			}
		} else {
			resEntity.setMensaje("No se encontraron datos de dicha especie");
			return ResponseEntity.ok(resEntity);
		}
	}

	/**
	 * Calcula la fecha en la que se cosechara la especie sumandole a la fecha
	 * actual el dayCount de la especie correspondiente
	 * 
	 * @param dayCount (dias a sumar actual) de tipo int
	 * @return objeto de tipo String que expresa la fecha en la que terminara la
	 *         siembra
	 */
	public String harvesDateCalculator(int dayCount) {
		Calendar day = Calendar.getInstance();
		day.add(Calendar.DAY_OF_YEAR, dayCount);
		return "la fecha estimada de la cosecha seria: " + new SimpleDateFormat("dd/MM/yyyy").format(day.getTime());
	}
	/**
	 * Valida si en el mes actual es posible sembrar la Specie consultada,
	 * conviendo el String sowingCalendar en un arreglo para recorrerlo 
	 * y compararlo con el mes en curso
	 * @param sowingCalendar de tipo String
	 * @return boolean dependiendo si el mes en curso esta en el Strin sowingCalendar
	 */
	private boolean canItBeSown(String sowingCalendar) {
		String[] seedTime = sowingCalendar.split("-", 12);
		int day = Calendar.getInstance().get(Calendar.MONTH) + 1;
		return Arrays.asList(seedTime).contains(String.valueOf(day));
	}
}
