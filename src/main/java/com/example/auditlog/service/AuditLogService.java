package com.example.auditlog.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.auditlog.dto.AuditLogRequest;
import com.example.auditlog.entity.AuditLog;
import com.example.auditlog.repository.AuditLogRepository;

@Service
public class AuditLogService {

    @Autowired
    private AuditLogRepository repository;

    public AuditLog save(AuditLogRequest request) {

        AuditLog log = new AuditLog();
        log.setUserId(request.getUserId());
        log.setActionType(request.getActionType());
        log.setModuleName(request.getModuleName());
        log.setTimestamp(LocalDateTime.now());

        return repository.save(log);
    }

    public List<AuditLog> getAll() {
        return repository.findAll(
            Sort.by(Sort.Direction.DESC, "timestamp")
        );
    }

    public List<AuditLog> search(String userId, LocalDate start, LocalDate end) {

        if (userId != null && start != null && end != null) {
            return repository.findByUserIdAndTimestampBetween(
                    userId,
                    start.atStartOfDay(),
                    end.atTime(23, 59, 59));
        }

        if (userId != null) {
            return repository.findByUserId(userId);
        }

        return getAll();
    }
}