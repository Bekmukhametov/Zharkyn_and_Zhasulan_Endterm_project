package kz.iitu.lab2.controller;

import kz.iitu.lab2.entity.DriverLicense;
import kz.iitu.lab2.service.DataManagementService;
import kz.iitu.lab2.service.DriverLicenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/licenses")
@RequiredArgsConstructor
public class DriverLicenseController {
    private final DriverLicenseService driverLicenseService;
    private final DataManagementService dataManagementService;

    @PostMapping("/{accountId}")
    public ResponseEntity<String> addDriverLicense(@RequestBody DriverLicense license, @PathVariable Long accountId) {
        dataManagementService.addDriverLicense(license, accountId);
        return ResponseEntity.ok("Driver license added successfully");
    }

    @DeleteMapping("/{licenseId}")
    public ResponseEntity<String> deleteDriverLicense(@PathVariable Long licenseId) {
        driverLicenseService.deleteById(licenseId);
        return ResponseEntity.ok("Driver license deleted successfully");
    }
}

