// ✅ Dữ liệu được Thymeleaf inject trực tiếp từ index.html
const months = typeof monthsData !== "undefined" ? monthsData : [];
const revenues = typeof revenuesData !== "undefined" ? revenuesData : [];
const memberTypes = typeof memberTypesData !== "undefined" ? memberTypesData : [];
const memberCounts = typeof memberCountsData !== "undefined" ? memberCountsData : [];
const bookingDays = typeof bookingDaysData !== "undefined" ? bookingDaysData : [];
const bookingCounts = typeof bookingCountsData !== "undefined" ? bookingCountsData : [];
const topServiceNames = typeof topServiceNamesData !== "undefined" ? topServiceNamesData : [];
const topServiceRevenue = typeof topServiceRevenueData !== "undefined" ? topServiceRevenueData : [];
const topEmployeeNames = typeof topEmployeeNamesData !== "undefined" ? topEmployeeNamesData : [];
const topEmployeeBookings = typeof topEmployeeBookingsData !== "undefined" ? topEmployeeBookingsData : [];
const topBookedServices = typeof topBookedServicesData !== "undefined" ? topBookedServicesData : [];
const topBookedCounts = typeof topBookedCountsData !== "undefined" ? topBookedCountsData : [];

// ✅ Biểu đồ Doanh thu theo tháng
if (document.getElementById('revenueChart')) {
    new Chart(document.getElementById('revenueChart'), {
        type: 'bar',
        data: {
            labels: months.map(m => 'Th' + m),
            datasets: [{
                label: 'Doanh thu (VNĐ)',
                data: revenues,
                borderWidth: 1,
                backgroundColor: 'rgba(54, 162, 235, 0.6)',
                borderColor: 'rgba(54, 162, 235, 1)'
            }]
        },
        options: {
            responsive: true,
            plugins: {
                legend: { display: false },
                tooltip: {
                    callbacks: {
                        label: ctx => ctx.raw.toLocaleString() + ' ₫'
                    }
                }
            },
            scales: {
                y: { beginAtZero: true, ticks: { callback: val => val.toLocaleString() } }
            }
        }
    });
}

// ✅ Biểu đồ Khách hàng theo loại
if (document.getElementById('memberPieChart')) {
    new Chart(document.getElementById('memberPieChart'), {
        type: 'pie',
        data: {
            labels: memberTypes,
            datasets: [{
                data: memberCounts,
                backgroundColor: ['#36A2EB', '#FF6384', '#FFCE56', '#4BC0C0']
            }]
        },
        options: {
            plugins: { legend: { position: 'bottom' } }
        }
    });
}

// ✅ Booking theo ngày
if (document.getElementById('bookingLineChart')) {
    new Chart(document.getElementById('bookingLineChart'), {
        type: 'line',
        data: {
            labels: bookingDays.map(d => 'Ngày ' + d),
            datasets: [{
                label: 'Số booking',
                data: bookingCounts,
                fill: true,
                borderColor: '#0d6efd',
                backgroundColor: 'rgba(13,110,253,0.1)',
                tension: 0.3
            }]
        },
        options: {
            responsive: true,
            plugins: { legend: { display: false } }
        }
    });
}

// ✅ Top 5 dịch vụ doanh thu cao
if (document.getElementById('topServiceChart')) {
    new Chart(document.getElementById('topServiceChart'), {
        type: 'bar',
        data: {
            labels: topServiceNames,
            datasets: [{
                label: 'Doanh thu (VNĐ)',
                data: topServiceRevenue,
                backgroundColor: 'rgba(255, 159, 64, 0.6)',
                borderColor: 'rgba(255, 159, 64, 1)',
                borderWidth: 1
            }]
        },
        options: {
            plugins: { legend: { display: false } },
            scales: { y: { beginAtZero: true } }
        }
    });
}

// ✅ Top nhân viên nhiều booking
if (document.getElementById('topEmployeeChart')) {
    new Chart(document.getElementById('topEmployeeChart'), {
        type: 'bar',
        data: {
            labels: topEmployeeNames,
            datasets: [{
                label: 'Số booking',
                data: topEmployeeBookings,
                backgroundColor: 'rgba(153, 102, 255, 0.6)',
                borderColor: 'rgba(153, 102, 255, 1)',
                borderWidth: 1
            }]
        },
        options: { plugins: { legend: { display: false } } }
    });
}

// ✅ Dịch vụ được đặt nhiều
if (document.getElementById('topBookedServiceChart')) {
    new Chart(document.getElementById('topBookedServiceChart'), {
        type: 'bar',
        data: {
            labels: topBookedServices,
            datasets: [{
                label: 'Số lần đặt',
                data: topBookedCounts,
                backgroundColor: 'rgba(75, 192, 192, 0.6)',
                borderColor: 'rgba(75, 192, 192, 1)',
                borderWidth: 1
            }]
        },
        options: { plugins: { legend: { display: false } } }
    });
}
