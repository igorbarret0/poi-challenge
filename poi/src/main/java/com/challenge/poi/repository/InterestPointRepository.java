package com.challenge.poi.repository;

import com.challenge.poi.entity.InterestPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterestPointRepository extends JpaRepository<InterestPoint, Long> {

    @Query("""
            SELECT p FROM InterestPoint p
            WHERE (p.x >= :xMin AND p.x <= :xMax AND p.y >= :yMin AND p.y <= :yMax)
            """)
    List<InterestPoint> findNearMe(@Param("xMin") long xMin,
                                   @Param("xMax") long xMax,
                                   @Param("yMin") long yMin,
                                   @Param("yMax") long yMax);

}
