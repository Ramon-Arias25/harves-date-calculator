package com.calculator.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.calculator.entity.SowingCalendar;
/**
 * @author ramon.arias
 * date: 08/06/2021
 * current version: 1
 */
public interface ISowingCalendarRepository extends JpaRepository<SowingCalendar, Integer>{

}
