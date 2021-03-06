package com.tobias.saul.explorecali.domain;

public enum Region {

	CENTRAL_COAST("Central Coast"), SOUTHERN_CALIFORNIA("Southern California"),
	NORTHERN_CALIFORNIA("Northern California"), VARIES("Varies");

	private String label;

	private Region(String label) {
		this.label = label;
	}

	public static Region findByLabel(String label) {
		for(Region r : Region.values()) {
			if(r.label.equalsIgnoreCase(label)) {
				return r;
			}
		}
		return null;
	}
	
	

}
