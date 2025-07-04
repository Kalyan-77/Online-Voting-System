# 🗳️ Online Voting System (JDBC + PostgreSQL)

A simple Java-based CLI application for voting, using **JDBC** and **PostgreSQL**.  
Users can:
- ✅ Add new candidates
- 🗳️ Vote for existing candidates
- 📋 View all candidates and their vote counts

---

## 📂 Project Structure

src/
└── main/
    └── java/
        └── org/
            └── example/
                ├── DB/
                │   └── DBConnection.java         # Database connection utility
                ├── DAO/
                │   └── CandidateDAO.java         # Handles DB operations
                ├── Model/
                │   └── Candidate.java            # Candidate data class
                └── Main.java                     # Main CLI logic (menu, I/O)


---

## 🧰 Tech Stack

- Java 8+  
- JDBC (Java Database Connectivity)  
- PostgreSQL  
- IntelliJ IDEA or VS Code (recommended)

---
