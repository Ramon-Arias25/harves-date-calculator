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

@Service
public class CalculatorServices {

	List<SowingCalendar> calendar = new ArrayList<>();

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
				resEntity.setMensaje("La especie consultada es apta para la siembra");
				return ResponseEntity.ok(resEntity);				
			}
		} else {
			resEntity.setMensaje("No se encontraron datos de dicha especie");
			return ResponseEntity.ok(resEntity);
		}
	}
	
	private boolean exists(String speciesName) {
		SowingCalendar sowingCalendar = calendar.stream().filter(x -> x.getSpecies().equals(speciesName))
				.findAny()
				.orElse(null);
		return sowingCalendar != null ? speciesName
				.equals(sowingCalendar .getSpecies()):false;
	}
	
	private String harvesDateCalculator(int dayCount) {
		Calendar day = Calendar.getInstance();
		day.add(Calendar.DAY_OF_YEAR, dayCount);
		return "la fecha estimada de la cosecha seria: " + new SimpleDateFormat("dd/MM/yyyy").format(day.getTime());
	}
}
