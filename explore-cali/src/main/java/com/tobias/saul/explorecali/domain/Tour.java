package com.tobias.saul.explorecali.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Tour {
	
	@Id
	@GeneratedValue
	private Long tourId;
	@Column
	private String title;
	@Column(length = 2000)
	private String description;
	@Column(length = 2000)
	private String blurb;
	@Column
	private Integer price;
	@Column
	private String duration;
	@Column(length = 2000)
	private String bullets;
	@Column
	private String keywords;
	@ManyToOne
	private TourPackage tourPackage;
	@Column
	@Enumerated
	private Difficulty difficulty;
	@Column
	@Enumerated
	private Region region;
	
	public Tour(String title, String description, String blurb, Integer price, String duration,
			String bullets, String keywords, TourPackage tourPackage, Difficulty difficulty, Region region) {
		super();
		this.title = title;
		this.description = description;
		this.blurb = blurb;
		this.price = price;
		this.duration = duration;
		this.bullets = bullets;
		this.keywords = keywords;
		this.tourPackage = tourPackage;
		this.difficulty = difficulty;
		this.region = region;
	}

	public Tour() {}
	
	public Long getTourId() {
		return tourId;
	}
	public void setTourId(Long tourId) {
		this.tourId = tourId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBlurb() {
		return blurb;
	}
	public void setBlurb(String blurb) {
		this.blurb = blurb;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getBullets() {
		return bullets;
	}
	public void setBullets(String bullets) {
		this.bullets = bullets;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public TourPackage getTourPackage() {
		return tourPackage;
	}
	public void setTourPackage(TourPackage tourPackage) {
		this.tourPackage = tourPackage;
	}
	public Difficulty getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
	}
	public Region getRegion() {
		return region;
	}
	public void setRegion(Region region) {
		this.region = region;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((blurb == null) ? 0 : blurb.hashCode());
		result = prime * result + ((bullets == null) ? 0 : bullets.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((difficulty == null) ? 0 : difficulty.hashCode());
		result = prime * result + ((duration == null) ? 0 : duration.hashCode());
		result = prime * result + ((keywords == null) ? 0 : keywords.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((region == null) ? 0 : region.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((tourId == null) ? 0 : tourId.hashCode());
		result = prime * result + ((tourPackage == null) ? 0 : tourPackage.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tour other = (Tour) obj;
		if (blurb == null) {
			if (other.blurb != null)
				return false;
		} else if (!blurb.equals(other.blurb))
			return false;
		if (bullets == null) {
			if (other.bullets != null)
				return false;
		} else if (!bullets.equals(other.bullets))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (difficulty != other.difficulty)
			return false;
		if (duration == null) {
			if (other.duration != null)
				return false;
		} else if (!duration.equals(other.duration))
			return false;
		if (keywords == null) {
			if (other.keywords != null)
				return false;
		} else if (!keywords.equals(other.keywords))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (region != other.region)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (tourId == null) {
			if (other.tourId != null)
				return false;
		} else if (!tourId.equals(other.tourId))
			return false;
		if (tourPackage == null) {
			if (other.tourPackage != null)
				return false;
		} else if (!tourPackage.equals(other.tourPackage))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Tour [tourId=" + tourId + ", title=" + title + ", description=" + description + ", blurb=" + blurb
				+ ", price=" + price + ", duration=" + duration + ", bullets=" + bullets + ", keywords=" + keywords
				+ ", tourPackage=" + tourPackage + ", difficulty=" + difficulty + ", region=" + region + "]";
	}
	
	
	
	
	
}
