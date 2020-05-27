package com.tobias.saul.explorecali.controller;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tobias.saul.explorecali.domain.Tour;
import com.tobias.saul.explorecali.domain.TourRating;
import com.tobias.saul.explorecali.domain.TourRatingPk;
import com.tobias.saul.explorecali.dto.TourRatingDto;
import com.tobias.saul.explorecali.repository.TourRatingRepository;
import com.tobias.saul.explorecali.repository.TourRepository;

@RestController
@RequestMapping("/tours/{tourId}/ratings")
public class TourRatingController {

	private final TourRatingRepository tourRatingRepository;
	private final TourRepository tourRepository;

	public TourRatingController(TourRatingRepository tourRatingRepository, TourRepository tourRepository) {
		this.tourRatingRepository = tourRatingRepository;
		this.tourRepository = tourRepository;
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public TourRating createTourRating(@PathVariable("tourId") Long tourId, @RequestBody @Validated TourRatingDto tourRatingDto) {
		Tour tour = verifyTour(tourId);
		return tourRatingRepository.save(
				new TourRating(new TourRatingPk(tour, tourRatingDto.getCustomerId()), tourRatingDto.getScore(), tourRatingDto.getComment(), tourRatingDto.getCustomerId()));
	}

	private Tour verifyTour(long tourId) {
		return tourRepository.findById(tourId)
				.orElseThrow(() -> new NoSuchElementException("Tour [" + "] does not exist"));

	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(NoSuchElementException.class)
	public String return400(NoSuchElementException ne) {
		return ne.getMessage();
	}

}
