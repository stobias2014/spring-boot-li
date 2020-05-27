package com.tobias.saul.explorecali.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.tobias.saul.explorecali.domain.TourRating;

public class TourRatingDto {
	
	@Min(value = 0)
	@Max(value = 5)
	private Integer score;
	
	@Size(max = 255)
	private String comment;
	
	@NotNull
	private Long customerId;
	
	public TourRatingDto(Integer score, String comment, Long customerId) {
		this.score = score;
		this.comment = comment;
		this.customerId = customerId;
	}
	public TourRatingDto(TourRating tourRating) {
		this.score = tourRating.getScore();
		this.comment = tourRating.getComment();
		this.customerId = tourRating.getTourRatingPk().getCustomerId();
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	
	

}
