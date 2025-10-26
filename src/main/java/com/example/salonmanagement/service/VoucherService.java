package com.example.salonmanagement.service;

import com.example.salonmanagement.dto.VoucherDTO;
import java.util.List;

public interface VoucherService {
    List<VoucherDTO> findAllActive();
}
