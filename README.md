# Audit Log Service

## Overview

Audit Log Service is a backend application developed using Java and Spring Boot to monitor, record, and retrieve important user and system activities within an application.

In modern software systems, tracking user actions is essential for security, accountability, debugging, and operational transparency. This project provides a centralized service that captures audit events such as logins, logouts, data creation, updates, deletions, and other module-level activities.

**Each audit record stores the following details:**

**User ID** – identifies which user performed the action.
**Action Type** – describes the operation performed (LOGIN, LOGOUT, CREATE, UPDATE, DELETE, etc.)
**Module Name** – indicates the application module where the activity occurred (AUTH, EMPLOYEE, PAYROLL, REPORTS, etc.)
**Timestamp** – records the exact date and time of the event.


**Each log stores:**

* User ID
* Action Type
* Module Name
* Timestamp

## Features

* Create audit logs
* Retrieve all logs
* Filter logs by User ID
* Filter logs by date range
* Sorting by latest timestamp
* Input validation
* Exception handling
* Layered architecture (Controller, Service, Repository, Entity)

## Technologies Used

* Java
* Spring Boot
* Spring Data JPA
* H2 Database 
* Maven

## Project Structure
src/main/java/com/example/auditlog/
controller/
service/
repository/
entity/
dto/
exception/
## How to Run

1. Import project into Eclipse IDE 
2. Run `AuditLogApplication.java`

## Base URL
http://localhost:8080

## API Endpoints

### Create Log
POST /api/logs
http://localhost:8080/api/logs

**Request Body**:

json
{
  "userId":"1",
  "actionType":"LOGIN",
  "moduleName":"AUTH"
}
### Get All Logs

GET /api/logs
http://localhost:8080/api/logs

### Search by User ID

GET /api/logs/search?userId=101
http://localhost:8080/api/logs/search?userId=101
### Search by User ID + Date Range

GET /api/logs/search?userId=101&start=2026-04-01&end=2026-04-28

