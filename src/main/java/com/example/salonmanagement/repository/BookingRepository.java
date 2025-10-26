package com.example.salonmanagement.repository;

import com.example.salonmanagement.entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookingRepository extends JpaRepository<BookingEntity, Long> {
    @Query("SELECT b FROM BookingEntity b WHERE LOWER(b.customer.name) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<BookingEntity> search(String keyword);
}
