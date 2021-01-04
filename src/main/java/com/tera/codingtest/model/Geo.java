package com.tera.codingtest.model;

import javax.persistence.Embeddable;

@Embeddable
public class Geo {
	private int lat;
	private int lng;

	public int getLat() {
		return lat;
	}

	public void setLat(int lat) {
		this.lat = lat;
	}

	public int getLng() {
		return lng;
	}

	public void setLng(int lng) {
		this.lng = lng;
	}

}
