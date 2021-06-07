package com.calculator.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.calculator.entity.ResEntity;
import com.calculator.entity.SowingCalendar;
import com.calculator.entity.Species;
import com.calculator.entity.SpeciesEntity;
/**
 * @author ramon.arias
 * date: 03/06/2021
 * current version: 1
 */
@Service
public class CalculatorServices {

	List<SowingCalendar> calendar = new ArrayList<>();
	/**
	 * El constructor crea en memoria el calendario para comparar las especies
	 */
	public CalculatorServices() {
		super();
		calendar.add(new SowingCalendar("acelga", 20,new ArrayList<Integer>(Arrays.asList(2, 3, 4, 5, 6, 8, 9, 10, 11, 12)), 80));
		calendar.add(new SowingCalendar("ajo", 15, new ArrayList<Integer>(Arrays.asList(3, 4, 5)), 270));
		calendar.add(new SowingCalendar("epio", 25, new ArrayList<Integer>(Arrays.asList(1, 2, 3, 9, 10, 11, 12)), 150));
		calendar.add(new SowingCalendar("esparragos", 30, new ArrayList<Integer>(Arrays.asList(8, 9)), 1825));
		calendar.add(new SowingCalendar("espinacas", 10, new ArrayList<Integer>(Arrays.asList(2, 3, 4, 5, 6)), 90));
		calendar.add(new SowingCalendar("lechuga", 20, new ArrayList<Integer>(Arrays.asList(8, 9, 10, 11, 12)), 90));
		calendar.add(new SowingCalendar("papa", 30, new ArrayList<Integer>(Arrays.asList(1, 2, 8, 9)), 150));
		calendar.add(new SowingCalendar("pimiento", 45, new ArrayList<Integer>(Arrays.asList(9)), 200));
		calendar.add(new SowingCalendar("rabanito", 5,new ArrayList<Integer>(Arrays.asList(2, 3, 4, 5, 6, 9, 10, 11, 12)), 40));
		calendar.add(new SowingCalendar("remolacha", 10,new ArrayList<Integer>(Arrays.asList(3, 4, 5, 6, 8, 9, 10, 11, 12)), 130));
	}
	/**
	 * Valida si el objeto Specie existe en el calendario,
	 * Valida que la especie sea apta para la siembra,
	 * Calcula la cantidad de plantines y llama al metodo 
	 * que calcula la fecha de cosecha
	 * @param objeto de tipo Species
	 * @return ResponseEntity con la respuesta que no sea una especie listada 
	 * o que no sea apta para la siembra o la respuesta solicitada
	 */
	public ResponseEntity<?>calculator ( Species species) {
		ResEntity resEntity = new ResEntity();
		SpeciesEntity speciesEntity = new SpeciesEntity();
		SowingCalendar calendarToCalc = calendar.stream().collect(Collectors.toMap(x -> x.getSpecies(), x -> x)).get(species.getName());
		if (exists(species.getName()) ) {
			if (calendarToCalc.getSeedTime().contains(Calendar.getInstance().get(Calendar.MONTH) + 1)) {				
				speciesEntity.setSpecies(species.getName());
				speciesEntity.setPossibleSeedlings(((species.getHigh() * 100)/ calendarToCalc.getDistance()) * ((species.getWidth() * 100) / calendarToCalc.getDistance()));
				speciesEntity.setHarvestDate(harvesDateCalculator(calendarToCalc.getDayCount()));
				return ResponseEntity.ok(speciesEntity);
			}else {
				resEntity.setMensaje("La especie consultada No es apta para la siembra");
				return ResponseEntity.ok(resEntity);				
			}
		} else {
			resEntity.setMensaje("No se encontraron datos de dicha especie");
			return ResponseEntity.ok(resEntity);
		}
	}
	/**
	 * compara si la especie enviada al metodo calcular existe en la lista calendar de tipo SowingCalendar que rellena el constructor
	 * @param objeto de tipo String con el nombre de la especie a comprobar
	 * @return true si existe en  la lista calendar de tipo SowingCalendar 
	 * @return false si no existe en  la lista calendar de tipo SowingCalendar 
	 */
	private boolean exists(String speciesName) {
		SowingCalendar sowingCalendar = calendar.stream().filter(x -> x.getSpecies().equals(speciesName))
				.findAny()
				.orElse(null);
		return sowingCalendar != null ? speciesName
				.equals(sowingCalendar .getSpecies()):false;
	}
	/**
	 * calcula la fecha en la que se cosechara la especie sumandole a la fecha actual el dayCount de la especie correspondiente
	 * @param dayCount (dias a sumar actual) de tipo int
	 * @return objeto de tipo String que expresa la fecha en la que terminara la siembra
	 */	
	private String harvesDateCalculator(int dayCount) {
		Calendar day = Calendar.getInstance();
		day.add(Calendar.DAY_OF_YEAR, dayCount);
		return "la fecha estimada de la cosecha seria: " + new SimpleDateFormat("dd/MM/yyyy").format(day.getTime());
	}
}
