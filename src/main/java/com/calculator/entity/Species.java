package com.calculator.entity;

import org.springframework.stereotype.Component;
/**
 * @author ramon.arias
 * date: 03/06/2021
 * current version: 1.2
 */
@Component
public class Species {
	private int id;
	private float width;
	private float high;

	public int getid() {
		return id;
	}

	public void settid(int id) {
		this.id = id;
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getHigh() {
		return high;
	}

	public void setHigh(float high) {
		this.high = high;
	}

}
