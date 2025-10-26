package com.example.salonmanagement.service.impl;

import com.example.salonmanagement.dto.BookingDTO;
import com.example.salonmanagement.entity.*;
import com.example.salonmanagement.repository.*;
import com.example.salonmanagement.service.BookingService;
import com.example.salonmanagement.util.BookingMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepo;
    private final CustomerRepository customerRepo;
    private final EmployeeRepository employeeRepo;
    private final ServiceRepository serviceRepo;

    @Override
    public List<BookingDTO> findAll(String keyword) {
        List<BookingEntity> list = (keyword == null || keyword.isEmpty())
                ? bookingRepo.findAll()
                : bookingRepo.search(keyword);
        return list.stream().map(BookingMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public BookingDTO findById(Long id) {
        return bookingRepo.findById(id)
                .map(BookingMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy lịch đặt"));
    }

    @Override
    public BookingDTO save(BookingDTO dto) {
        BookingEntity entity = new BookingEntity();
        entity.setBookingTime(dto.getBookingTime());
        entity.setStatus(dto.getStatus());
        entity.setNote(dto.getNote());
        entity.setCustomer(customerRepo.findById(dto.getCustomerId()).orElse(null));
        entity.setEmployee(employeeRepo.findById(dto.getEmployeeId()).orElse(null));
        entity.setService(serviceRepo.findById(dto.getServiceId()).orElse(null));
        return BookingMapper.toDTO(bookingRepo.save(entity));
    }

    @Override
    public BookingDTO update(Long id, BookingDTO dto) {
        BookingEntity entity = bookingRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy lịch đặt"));
        BookingMapper.updateEntity(entity, dto);
        entity.setCustomer(customerRepo.findById(dto.getCustomerId()).orElse(null));
        entity.setEmployee(employeeRepo.findById(dto.getEmployeeId()).orElse(null));
        entity.setService(serviceRepo.findById(dto.getServiceId()).orElse(null));
        return BookingMapper.toDTO(bookingRepo.save(entity));
    }

    @Override
    public void delete(Long id) {
        bookingRepo.deleteById(id);
    }
}
