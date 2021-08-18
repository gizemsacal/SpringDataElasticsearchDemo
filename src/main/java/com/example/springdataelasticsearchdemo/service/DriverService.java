package com.example.springdataelasticsearchdemo.service;

import com.example.springdataelasticsearchdemo.model.Driver;
import com.example.springdataelasticsearchdemo.repository.DriverRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class DriverService {

    private DriverRepository driverRepository;

    public List<Driver> allDrivers() {
        List<Driver> allDrivers = new ArrayList<Driver>();

        driverRepository.findAll().forEach(driver -> {
            allDrivers.add(driver);
        });

        return allDrivers;
    }

    public void saveDriver(Driver driver) {
        driverRepository.save(driver);
    }

    public void updateDriver(String key, Driver driverForUpdate) {
        driverRepository.findById(key).ifPresentOrElse(driver -> {
            driver.setName(driverForUpdate.getName());
            driver.setSurname(driverForUpdate.getSurname());
            driver.setTeam(driverForUpdate.getTeam());
            driverRepository.save(driver);
        }, () -> {
            throw new RuntimeException("No Record With This Id!");
        });
    }

    public void deleteDriver(String key) {
        driverRepository.findById(key).ifPresentOrElse(driver -> {
            driverRepository.delete(driver);
        }, () -> {
            throw new RuntimeException("No Record With This Id!");
        });
    }
}
