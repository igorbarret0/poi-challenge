package com.challenge.poi.controller;

import com.challenge.poi.entity.InterestPoint;
import com.challenge.poi.entity.dtos.CreateInterestPoint;
import com.challenge.poi.service.InterestPointService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/points-of-interests")
public class InterestPointController {

    public InterestPointService poiService;

    public InterestPointController(InterestPointService service) {
        this.poiService = service;
    }

    @PostMapping
    public ResponseEntity<Void> createPoi(@RequestBody CreateInterestPoint request) {

        poiService.createPoi(request);

        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Page<InterestPoint>> listPoi(@RequestParam(name = "page", defaultValue = "0") Integer page,
                                                       @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {

        var body = poiService.listPoi(page, pageSize);

        return ResponseEntity.ok(body);
    }

    @GetMapping("/near-me")
    public ResponseEntity<List<InterestPoint>> listNearMePoi(@RequestParam(name = "x") Long x,
                                              @RequestParam(name = "y") Long y,
                                              @RequestParam(name = "dmax") Long dmax) {


        List<InterestPoint> response = poiService.listNearMePoi(x, y, dmax);

        return ResponseEntity.ok(response);

    }

}
