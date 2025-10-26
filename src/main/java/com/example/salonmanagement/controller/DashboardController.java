package com.example.salonmanagement.controller;

import com.example.salonmanagement.entity.PaymentEntity;
import com.example.salonmanagement.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.time.*;
import java.util.*;
import java.util.stream.Collectors;

@Controller
public class DashboardController {

    @Autowired private CustomerRepository customerRepository;
    @Autowired private BookingRepository bookingRepository;
    @Autowired private PaymentRepository paymentRepository;
    @Autowired private ServiceRepository serviceRepository;
    @Autowired private EmployeeRepository employeeRepository;
    @Autowired private PromotionRepository promotionRepository;

    @GetMapping({"/", "/index", "/dashboard"})
    public String showDashboard(Model model) {

        // ✅ Tổng số lượng
        model.addAttribute("totalCustomers", customerRepository.count());
        model.addAttribute("totalBookings", bookingRepository.count());
        model.addAttribute("totalServices", serviceRepository.count());
        model.addAttribute("totalEmployees", employeeRepository.count());
        model.addAttribute("totalPromotions", promotionRepository.count());

        // ✅ Tổng doanh thu
        double totalRevenue = paymentRepository.findAll().stream()
                .map(PaymentEntity::getAmount)
                .filter(Objects::nonNull)
                .mapToDouble(BigDecimal::doubleValue)
                .sum();
        model.addAttribute("totalRevenue", totalRevenue);

        // ✅ Doanh thu hôm nay
        LocalDate today = LocalDate.now();
        double todayRevenue = paymentRepository.findAll().stream()
                .filter(p -> p.getPaymentDate() != null)
                .filter(p -> p.getPaymentDate().toLocalDate().isEqual(today))
                .map(PaymentEntity::getAmount)
                .filter(Objects::nonNull)
                .mapToDouble(BigDecimal::doubleValue)
                .sum();
        model.addAttribute("todayRevenue", todayRevenue);

        // ✅ Doanh thu tháng này
        YearMonth currentMonth = YearMonth.now();
        double monthRevenue = paymentRepository.findAll().stream()
                .filter(p -> p.getPaymentDate() != null)
                .filter(p -> YearMonth.from(p.getPaymentDate().toLocalDate()).equals(currentMonth))
                .map(PaymentEntity::getAmount)
                .filter(Objects::nonNull)
                .mapToDouble(BigDecimal::doubleValue)
                .sum();
        model.addAttribute("monthRevenue", monthRevenue);

        // ✅ Doanh thu theo tháng (cho biểu đồ cột)
        Map<Integer, Double> revenueByMonth = paymentRepository.findAll().stream()
                .filter(p -> p.getPaymentDate() != null && p.getAmount() != null)
                .collect(Collectors.groupingBy(
                        p -> p.getPaymentDate().getMonthValue(),
                        Collectors.summingDouble(p -> p.getAmount().doubleValue())
                ));

        List<String> months = Arrays.asList("1","2","3","4","5","6","7","8","9","10","11","12");
        List<Double> revenues = months.stream()
                .map(m -> revenueByMonth.getOrDefault(Integer.parseInt(m), 0.0))
                .collect(Collectors.toList());
        model.addAttribute("months", months);
        model.addAttribute("revenues", revenues);

        // ✅ Khách hàng theo loại (nếu có cột memberType trong CustomerEntity)
        try {
            Map<String, Long> memberStats = customerRepository.findAll().stream()
                    .collect(Collectors.groupingBy(c -> Optional.ofNullable(c.getMemberType()).orElse("Khác"), Collectors.counting()));

            model.addAttribute("memberTypes", new ArrayList<>(memberStats.keySet()));
            model.addAttribute("memberCounts", new ArrayList<>(memberStats.values()));
        } catch (Exception e) {
            model.addAttribute("memberTypes", List.of());
            model.addAttribute("memberCounts", List.of());
        }

        // ✅ Booking theo ngày (đếm số lượng booking trong tháng này)
        Map<Integer, Long> bookingCountByDay = bookingRepository.findAll().stream()
                .filter(b -> b.getBookingTime() != null)
                .filter(b -> YearMonth.from(b.getBookingTime().toLocalDate()).equals(currentMonth))
                .collect(Collectors.groupingBy(
                        b -> b.getBookingTime().getDayOfMonth(),
                        Collectors.counting()
                ));

        List<Integer> bookingDays = new ArrayList<>(bookingCountByDay.keySet());
        Collections.sort(bookingDays);
        List<Long> bookingCounts = bookingDays.stream()
                .map(day -> bookingCountByDay.getOrDefault(day, 0L))
                .collect(Collectors.toList());
        model.addAttribute("bookingDays", bookingDays);
        model.addAttribute("bookingCounts", bookingCounts);

        // ✅ Top 5 dịch vụ có doanh thu cao
        Map<String, Double> serviceRevenue = paymentRepository.findAll().stream()
                .filter(p -> p.getBooking() != null && p.getBooking().getService() != null)
                .collect(Collectors.groupingBy(
                        p -> p.getBooking().getService().getName(),
                        Collectors.summingDouble(p -> p.getAmount().doubleValue())
                ));

        List<Map.Entry<String, Double>> topServices = serviceRevenue.entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .limit(5)
                .collect(Collectors.toList());

        model.addAttribute("topServiceNames", topServices.stream().map(Map.Entry::getKey).toList());
        model.addAttribute("topServiceRevenue", topServices.stream().map(Map.Entry::getValue).toList());

        // ✅ Top nhân viên có nhiều booking
        Map<String, Long> employeeBookings = bookingRepository.findAll().stream()
                .filter(b -> b.getEmployee() != null)
                .collect(Collectors.groupingBy(b -> b.getEmployee().getName(), Collectors.counting()));

        List<Map.Entry<String, Long>> topEmployees = employeeBookings.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .collect(Collectors.toList());

        model.addAttribute("topEmployeeNames", topEmployees.stream().map(Map.Entry::getKey).toList());
        model.addAttribute("topEmployeeBookings", topEmployees.stream().map(Map.Entry::getValue).toList());

        // ✅ Dịch vụ được đặt nhiều nhất
        Map<String, Long> serviceBookingCount = bookingRepository.findAll().stream()
                .filter(b -> b.getService() != null)
                .collect(Collectors.groupingBy(b -> b.getService().getName(), Collectors.counting()));

        List<Map.Entry<String, Long>> topBookedServices = serviceBookingCount.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .collect(Collectors.toList());

        model.addAttribute("topBookedServices", topBookedServices.stream().map(Map.Entry::getKey).toList());
        model.addAttribute("topBookedCounts", topBookedServices.stream().map(Map.Entry::getValue).toList());

        model.addAttribute("pageTitle", "Dashboard - Salon Management");
        return "index";
    }
}
