package com.challenge.poi.service;

import com.challenge.poi.entity.InterestPoint;
import com.challenge.poi.entity.dtos.CreateInterestPoint;
import com.challenge.poi.repository.InterestPointRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InterestPointService {

    private InterestPointRepository poiRepository;

    public InterestPointService(InterestPointRepository repository) {
        this.poiRepository = repository;
    }

    public InterestPoint createPoi(CreateInterestPoint request) {

        return poiRepository.save(request.toEntity(request));

    }

    public Page<InterestPoint> listPoi(Integer page, Integer pageSize) {

        var body = poiRepository.findAll(PageRequest.of(page, pageSize));

        return body;
    }

    public List<InterestPoint> listNearMePoi(Long x, Long y, Long dmax) {

        var xMin = x - dmax;
        var xMax = x + dmax;
        var yMin = y - dmax;
        var yMax = y + dmax;

        List<InterestPoint> listPoi = poiRepository.findNearMe(xMin, xMax, yMin, yMax)
                .stream()
                .filter(p -> distanceBetweenTwoPoints(x, y, p.getX(), p.getY()) <= dmax)
                .toList();



        return listPoi;
    }

    private Double distanceBetweenTwoPoints(long x1, long y1, long x2, long y2) {

        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

}
