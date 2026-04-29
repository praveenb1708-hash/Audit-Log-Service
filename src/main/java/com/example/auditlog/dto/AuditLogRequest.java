package com.example.auditlog.dto;

import jakarta.validation.constraints.NotBlank;

public class AuditLogRequest {

    @NotBlank
    private String userId;

    @NotBlank
    private String actionType;

    @NotBlank
    private String moduleName;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }
}