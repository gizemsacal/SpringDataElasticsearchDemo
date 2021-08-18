package com.example.springdataelasticsearchdemo.controller;

import com.example.springdataelasticsearchdemo.model.Driver;
import com.example.springdataelasticsearchdemo.service.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//RestEndPoints sınıfımız Rest API çağırımları için kullanılacak
// endpointleri barındırıyor. GET, POST, PUT ve DELETE HTTP metotları
// ile gelen istekleri servis kısmına iletecek endpointlerimiz yer alıyor.


@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class DriverController {


    private DriverService driverService;

    @RequestMapping(method = RequestMethod.GET, value = "/drivers")
    public ResponseEntity<List<Driver>> allDrivers() {

        List<Driver> allDrivers = driverService.allDrivers();

        return new ResponseEntity<List<Driver>>(allDrivers, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/drivers")

    public ResponseEntity<String> postDriver(@RequestBody Driver driver) {

        driverService.saveDriver(driver);
        return new ResponseEntity<String>("Kayıt İşlemi Başarılı", HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/drivers/{id}")

    public ResponseEntity<String> putDriver(@PathVariable("id") String id, @RequestBody Driver driverForUpdate) {

        driverService.updateDriver(id, driverForUpdate);

        return new ResponseEntity<String>("Güncelleme İşlemi Başarılı", HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/drivers/{id}")
    public ResponseEntity<String> deleteDriver(@PathVariable("id") String id) {
        driverService.deleteDriver(id);
        return new ResponseEntity<String>("Silme İşlemi Başarılı", HttpStatus.OK);
    }
}