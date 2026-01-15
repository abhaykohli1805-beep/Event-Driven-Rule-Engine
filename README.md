# Event-Driven Rule Engine (Java + Spring Boot)

A modular, event-driven rule engine built using **Java** and **Spring Boot**, designed to evaluate time-based rules over incoming system events and trigger automated actions.  
The project demonstrates **clean backend architecture**, **event processing**, and **real-world rule evaluation logic**, along with a minimal UI for live simulation.

---

# Key Features

- Event-driven rule evaluation
- Time-window based rule processing
- Modular engine design (engine-core as reusable library)
- REST API adapter using Spring Boot
- Simple UI for live event simulation
- Clean separation of concerns (engine vs API vs UI)


### Modules
- **engine-core**  
  Pure Java library containing rule engine logic, event models, and rule definitions.

- **backend-api**  
  Spring Boot application exposing REST endpoints and serving the UI.

---

##  How It Works

1. Events are sent to the backend via REST API or UI.
2. Events are stored in memory with timestamps.
3. Rules evaluate events within defined time windows.
4. When a rule condition is satisfied, an action is triggered.
5. Results are logged in real time.

---

##  Example Rules Implemented

###  Login Failure Detection
- If a user fails login **3 times within 60 seconds**
- Action: user is flagged as blocked

###  High CPU Usage Detection
- If a service reports high CPU **twice within 2 minutes**
- Action: alert is generated

---

##  REST API Endpoints

| Method | Endpoint | Description |
|------|---------|-------------|
| POST | `/events/login-failed` | Simulate a login failure |
| POST | `/events/cpu-high` | Simulate high CPU usage |

---

##  UI Demo

Access the UI at:http://localhost:8081

The UI allows triggering events with a single click.

---

##  Tech Stack

- Java 17
- Spring Boot
- Maven
- REST APIs
- HTML / JavaScript

---

##  Why This Project?

This project showcases:
- Backend system design
- Event-driven architecture
- Rule-based decision systems
- Clean modular Java development
- API-first design with UI integration

---

## 👤 Author

**Abhay Kohli**  
Software Developer | Backend & Data-Oriented Systems


