package com.example.salonmanagement.service;

import com.example.salonmanagement.dto.BookingDTO;

import java.util.List;

public interface BookingService {
    List<BookingDTO> findAll(String keyword);
    BookingDTO findById(Long id);
    BookingDTO save(BookingDTO dto);
    BookingDTO update(Long id, BookingDTO dto);
    void delete(Long id);
}
