package com.ackodrive.controller;

import com.ackodrive.model.Car;
import com.ackodrive.model.TestDriveBooking;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    private List<Car> cars = new ArrayList<>();
    private List<TestDriveBooking> bookings = new ArrayList<>();

    public CarController() {
        // Sample Data
        cars.add(new Car(1L, "Tata Nexon", "₹8.5L", "17 kmpl", "Petrol"));
        cars.add(new Car(2L, "Hyundai Creta", "₹11L", "16 kmpl", "Diesel"));
        cars.add(new Car(3L, "Maruti Swift", "₹6.5L", "22 kmpl", "Petrol"));
    }

    // Get all cars
    @GetMapping
    public List<Car> getAllCars() {
        return cars;
    }

    // Compare two cars by ID
    @GetMapping("/compare")
    public List<Car> compareCars(@RequestParam Long car1, @RequestParam Long car2) {
        return cars.stream()
                .filter(c -> c.getId().equals(car1) || c.getId().equals(car2))
                .toList();
    }

    // Book a test drive
    @PostMapping("/book-test-drive")
    public TestDriveBooking bookTestDrive(@RequestParam String name,
                                          @RequestParam String phone,
                                          @RequestParam Long carId,
                                          @RequestParam String date) {
        Car car = cars.stream().filter(c -> c.getId().equals(carId)).findFirst().orElse(null);
        if (car == null) throw new RuntimeException("Car not found");

        TestDriveBooking booking = new TestDriveBooking(
                (long) (bookings.size() + 1),
                name,
                phone,
                car,
                LocalDate.parse(date)
        );
        bookings.add(booking);
        return booking;
    }

    // View all bookings
    @GetMapping("/bookings")
    public List<TestDriveBooking> getBookings() {
        return bookings;
    }
}