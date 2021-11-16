package com.d0v4h.rhumapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="rhum")
public class Rhum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "rhum_name")
    private String rhumName;
    
    @Column(name = "alc_deg")
    private String alcDeg;
    
    @Column(name = "origin")
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

	public void setAlcDeg(String aclDeg) {
		this.alcDeg = aclDeg;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}
}