package com.calculator.entity;

import org.springframework.stereotype.Component;

@Component
public class Species {
	private String name;
	private float width;
	private float high;

	public String getName() {
		return name.toLowerCase();
	}

	public void setName(String name) {
		this.name = name;
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
