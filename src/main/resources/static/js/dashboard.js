// === Hiệu ứng đếm số tăng dần + hiển thị KPI ===
document.addEventListener("DOMContentLoaded", function () {

    // 1️⃣ Count-Up Animation
    function animateCountUp(element, target, duration = 2000) {
        let start = 0;
        const increment = target / (duration / 16);
        const timer = setInterval(() => {
            start += increment;
            if (start >= target) {
                start = target;
                clearInterval(timer);
            }
            // Hiển thị định dạng số với dấu phẩy
            element.textContent = Math.floor(start).toLocaleString('vi-VN');
        }, 16);
    }

    // Áp dụng Count-Up
    document.querySelectorAll(".count").forEach(counter => {
        const value = parseInt(counter.dataset.value);
        animateCountUp(counter, value, 1800);
    });

    // 2️⃣ Hiển thị KPI (+/- %)
    document.querySelectorAll(".kpi").forEach(kpi => {
        const change = parseFloat(kpi.dataset.change);
        if (change > 0) {
            kpi.classList.add("positive");
            kpi.innerHTML = `+${change}% 📈`;
        } else if (change < 0) {
            kpi.classList.add("negative");
            kpi.innerHTML = `${change}% 📉`;
        } else {
            kpi.classList.add("neutral");
            kpi.innerHTML = `0%`;
        }
    });

    // 3️⃣ Biểu đồ mẫu (hiển thị khung sẵn)
    const createChart = (id, type, data, color) => {
        const ctx = document.getElementById(id);
        if (!ctx) return;
        new Chart(ctx, {
            type: type,
            data: data,
            options: {
                responsive: true,
                animation: { duration: 1200, easing: 'easeOutQuart' },
                plugins: { legend: { display: false } },
                scales: { y: { beginAtZero: true } }
            }
        });
    };

    // === Các biểu đồ demo có sẵn ===
    createChart("revenueChart", "bar", {
        labels: ["Th1", "Th2", "Th3", "Th4", "Th5", "Th6"],
        datasets: [{
            label: "Doanh thu (triệu ₫)",
            data: [12, 15, 20, 18, 22, 25],
            backgroundColor: "rgba(54, 162, 235, 0.6)"
        }]
    });

    createChart("memberPieChart", "pie", {
        labels: ["Thường", "VIP", "Vàng", "Bạch Kim"],
        datasets: [{
            data: [40, 25, 20, 15],
            backgroundColor: [
                "rgba(255,99,132,0.7)",
                "rgba(54,162,235,0.7)",
                "rgba(255,206,86,0.7)",
                "rgba(75,192,192,0.7)"
            ]
        }]
    });

    createChart("bookingLineChart", "line", {
        labels: ["1", "5", "10", "15", "20", "25", "30"],
        datasets: [{
            label: "Số lượng Booking",
            data: [3, 4, 6, 8, 5, 7, 9],
            borderColor: "rgba(75,192,192,1)",
            backgroundColor: "rgba(75,192,192,0.2)",
            fill: true,
            tension: 0.3
        }]
    });

    createChart("topServiceChart", "bar", {
        labels: ["Cắt tóc", "Nhuộm", "Massage", "Gội đầu", "Làm móng"],
        datasets: [{
            label: "Doanh thu (triệu ₫)",
            data: [50, 45, 30, 25, 20],
            backgroundColor: "#FF9F40"
        }]
    });

    createChart("topEmployeeChart", "bar", {
        labels: ["Ngọc", "Minh", "Tuấn", "Hà", "Phương"],
        datasets: [{
            label: "Lượt đặt",
            data: [30, 25, 28, 22, 18],
            backgroundColor: "#9966FF"
        }]
    });

    createChart("topBookedServiceChart", "bar", {
        labels: ["Cắt tóc", "Gội đầu", "Làm móng", "Massage", "Nhuộm"],
        datasets: [{
            label: "Lượt đặt",
            data: [120, 90, 75, 60, 55],
            backgroundColor: "#4BC0C0"
        }]
    });

});
