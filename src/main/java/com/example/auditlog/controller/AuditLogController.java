package com.example.auditlog.controller;

import com.example.auditlog.dto.AuditLogRequest;
import com.example.auditlog.entity.AuditLog;
import com.example.auditlog.service.AuditLogService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/logs")
public class AuditLogController {

    @Autowired
    private AuditLogService service;

    @PostMapping
    public AuditLog create(@Valid @RequestBody AuditLogRequest request) {
        return service.save(request);
    }

    @GetMapping
    public List<AuditLog> getAll() {
        return service.getAll();
    }

    @GetMapping("/search")
    public List<AuditLog> search(
            @RequestParam(required = false) String userId,
            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate start,

            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate end) {

        return service.search(userId, start, end);
    }
}