package org.example.DAO;

import org.example.DB.DBConnection;
import org.example.Model.Candidate;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CandidateDAO {

    public void addCandidate(Candidate candidate) {
        String SQL = "INSERT INTO candidates(name, party) VALUES (?, ?)";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, candidate.getName());
            pstmt.setString(2, candidate.getParty());

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        candidate.setCandidateId(rs.getInt(1));
                        System.out.println("Candidate added successfully with ID: " + candidate.getCandidateId());
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Error adding Candidate: " + e.getMessage());
        } finally {
            closeResources(conn, pstmt, null);
        }
    }

    public boolean voteForCandidate(String name) {
        String SQL = "UPDATE candidates SET vote_count = vote_count + 1 WHERE name = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, name);

            int rowsUpdated = pstmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            System.err.println("Error voting for candidate: " + e.getMessage());
            return false;
        } finally {
            closeResources(conn, pstmt, null);
        }
    }

    public List<Candidate> displayAllCandidates() {
        String SQL = "SELECT * FROM candidates ORDER BY candidate_id";
        List<Candidate> candidates = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = DBConnection.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                Candidate candidate = new Candidate(
                        rs.getInt("candidate_id"),
                        rs.getString("name"),
                        rs.getString("party"),
                        rs.getInt("vote_count")
                );
                candidates.add(candidate);
            }
        } catch (SQLException e) {
            System.out.println("Error getting all candidates: " + e.getMessage());
        } finally {
            closeResources(conn, stmt, rs);
        }

        return candidates;
    }

    private void closeResources(Connection conn, Statement stmt, ResultSet rs) {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            DBConnection.closeConnection(conn);
        } catch (SQLException e) {
            System.out.println("Error closing resources: " + e.getMessage());
        }
    }
}
