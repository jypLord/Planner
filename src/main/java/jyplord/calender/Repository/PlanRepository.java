package jyplord.calender.Repository;

import jyplord.calender.Entity.PlanEntity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface PlanRepository extends JpaRepository<PlanEntity, Long> {
    Page<PlanEntity> findByUserID(String userID, Pageable page) ;
}
