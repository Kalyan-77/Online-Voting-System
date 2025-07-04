package org.example.Model;

public class Candidate {
    private int candidate_id;
    private String name;
    private String party;
    private int vote_count;

    public Candidate(String name, String party) {
        this.name = name;
        this.party = party;
    }

    public Candidate(int candidate_id, String name, String party, int vote_count) {
        this.candidate_id= candidate_id;
        this.name = name;
        this.party = party;
        this.vote_count = vote_count;
    }

    public int getCandidateId() {
        return candidate_id;
    }

    public void setCandidateId(int candidate_id) {
        candidate_id = candidate_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        this.party = party;
    }

    public int getVoteCount() {
        return vote_count;
    }

    public void setVoteCount(int voteCount) {
        this.vote_count = voteCount;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "CandidateId=" + candidate_id +
                ", name='" + name + '\'' +
                ", party='" + party + '\'' +
                ", voteCount=" + vote_count +
                '}';
    }
}
