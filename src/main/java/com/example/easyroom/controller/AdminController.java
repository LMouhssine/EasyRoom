package com.example.easyroom.controller;

import com.example.easyroom.model.Admin;
import com.example.easyroom.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/admins")
public class AdminController {
    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping
    public ResponseEntity<Admin> creerAdmin(@RequestBody Admin admin) {
        return ResponseEntity.ok(adminService.creerAdmin(admin));
    }

    @GetMapping
    public ResponseEntity<List<Admin>> getTousLesAdmins() {
        return ResponseEntity.ok(adminService.getTousLesAdmins());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Admin> getAdminParId(@PathVariable Long id) {
        return ResponseEntity.ok(adminService.getAdminParId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Admin> modifierAdmin(@PathVariable Long id, @RequestBody Admin admin) {
        return ResponseEntity.ok(adminService.modifierAdmin(id, admin));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerAdmin(@PathVariable Long id) {
        adminService.supprimerAdmin(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Admin> getAdminParEmail(@PathVariable String email) {
        return ResponseEntity.ok(adminService.getAdminParEmail(email));
    }

    @GetMapping("/recherche/{terme}")
    public ResponseEntity<List<Admin>> rechercherAdmins(@PathVariable String terme) {
        return ResponseEntity.ok(adminService.rechercherAdmins(terme));
    }
}