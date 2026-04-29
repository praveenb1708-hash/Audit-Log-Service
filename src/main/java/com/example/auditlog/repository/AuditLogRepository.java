package com.example.auditlog.repository;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.auditlog.entity.AuditLog;

public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {
	  List<AuditLog> findByUserId(String userId);

	  List<AuditLog> findByUserIdAndTimestampBetween(
	      String userId,
	      LocalDateTime start,
	      LocalDateTime end);
	}