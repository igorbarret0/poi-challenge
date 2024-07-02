package com.challenge.poi.entity.dtos;

import com.challenge.poi.entity.InterestPoint;

public record CreateInterestPoint(
        String name,
        Long x,
        Long y
) {

    public InterestPoint toEntity(CreateInterestPoint request) {
        return new InterestPoint(request.name, request.x, request.y);
    }

}
