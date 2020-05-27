package com.tobias.saul.explorecali.controller;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
				new TourRating(new TourRatingPk(tour, tourRatingDto.getCustomerId()), tourRatingDto.getScore(), tourRatingDto.getComment()));
	}
	
	@GetMapping
	public List<TourRatingDto> getAllTourRatingsForTour(@PathVariable("tourId") Long tourId) {
		verifyTour(tourId);
		return tourRatingRepository.findByTourRatingPkTourTourId(tourId).stream()
				.map(tourRating -> new TourRatingDto(tourRating.getScore(), tourRating.getComment(), tourRating.getTourRatingPk().getCustomerId())).collect(Collectors.toList());
	}
	
	@GetMapping("/average")
	public Map<String, Double> getAverage(@PathVariable("tourId") Long tourId) {
		verifyTour(tourId);
		return Map.of("average", tourRatingRepository.findByTourRatingPkTourTourId(tourId).stream()
				.mapToInt(TourRating::getScore).average()
				.orElseThrow(() -> new NoSuchElementException("Tour has no rating")));
				
	}
	
	@PutMapping
	public TourRatingDto updateWithPut(@PathVariable("tourId") Long tourId, @RequestBody @Validated TourRatingDto tourRatingDto) {
		TourRating tourRating = verifyTourRating(tourId, tourRatingDto.getCustomerId());
		tourRating.setScore(tourRatingDto.getScore());
		tourRating.setComment(tourRatingDto.getComment());
		return new TourRatingDto(tourRatingRepository.save(tourRating));
		
	}
	
	@PatchMapping
	
	public TourRatingDto updateWithPatch(@PathVariable("tourId") Long tourId, @RequestBody @Validated TourRatingDto tourRatingDto) {
		TourRating tourRating = verifyTourRating(tourId, tourRatingDto.getCustomerId());
		if(tourRating.getScore() != null) {
			tourRating.setScore(tourRatingDto.getScore());
		}
		if(tourRating.getComment() != null) {
			tourRating.setComment(tourRatingDto.getComment());
		}
		return new TourRatingDto(tourRatingRepository.save(tourRating));
	}
	
	@DeleteMapping("/{customerId}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("tourId") Long tourId, @PathVariable("customerId") Long customerId) {
		TourRating tourRating = verifyTourRating(tourId, customerId);
		tourRatingRepository.delete(tourRating);
		
	}

	private TourRating verifyTourRating(Long tourId, Long customerId) {
		return tourRatingRepository.findByTourRatingPkTourTourIdAndTourRatingPkCustomerId(tourId, customerId)
				.orElseThrow(() -> new NoSuchElementException("Tour Rating does not exist"));
	}

	private Tour verifyTour(long tourId) {
		return tourRepository.findById(tourId)
				.orElseThrow(() -> new NoSuchElementException("Tour [" + tourId + "] does not exist"));

	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(NoSuchElementException.class)
	public String return400(NoSuchElementException ne) {
		return ne.getMessage();
	}

}
