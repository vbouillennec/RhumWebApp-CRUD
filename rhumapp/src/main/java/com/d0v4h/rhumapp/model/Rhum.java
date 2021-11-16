package com.d0v4h.rhumapp.model;

import lombok.Data;

@Data
public class Rhum {

	private Integer id;

	private String rhumName;

	private String alcDeg;

	private String origin;

	public Integer getId() {
		return id;
	}

	public String getRhumName() {
		return rhumName;
	}

	public String getAlcDeg() {
		return alcDeg;
	}

	public String getOrigin() {
		return origin;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setRhumName(String rhumName) {
		this.rhumName = rhumName;
	}

	public void setAlcDeg(String alcDeg) {
		this.alcDeg = alcDeg;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}
}
