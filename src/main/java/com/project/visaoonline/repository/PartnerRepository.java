package com.project.visaoonline.repository;

import com.project.visaoonline.model.Partner;
import com.project.visaoonline.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface PartnerRepository extends JpaRepository<Partner, Long> {

    Optional<Partner> findById(Long id);


    @Query("SELECT stock " +
            "FROM Stock stock " +
            "WHERE stock.name = :name AND stock.date = :date AND stock.id <> :id")
    Optional<Stock> findByStockUpdate(String name, LocalDate date, Long id);

    @Query("SELECT partner " +
            "FROM Partner partner " +
            "WHERE partner.id = :id")
    Optional<List<Partner>> findByToday(Long id);
}
