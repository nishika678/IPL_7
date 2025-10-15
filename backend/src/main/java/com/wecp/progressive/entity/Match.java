package com.wecp.progressive.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "matches")
public class Match 
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int matchId;
    private int firstTeamId;
    private int secondTeamId;
    @Temporal(TemporalType.DATE)
    private Date matchDate;
    private String venue;
    private String result;
    private String status;
    private int winnerTeamId;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JsonIgnore
    private Team team;

    @OneToMany(mappedBy = "match",  cascade = CascadeType.ALL)
    @JsonIgnore
    private List<TicketBooking> ticketBookings = new ArrayList<TicketBooking>();

    // public Match() {
    // }

    // public Match(int firstTeamId, int secondTeamId, Date matchDate, String venue, String result, String status,
    //         int winnerTeamId) {
    //     this.firstTeamId = firstTeamId;
    //     this.secondTeamId = secondTeamId;
    //     this.matchDate = matchDate;
    //     this.venue = venue;
    //     this.result = result;
    //     this.status = status;
    //     this.winnerTeamId = winnerTeamId;
    // }



    // public Match(int matchId, int firstTeamId, int secondTeamId, Date matchDate, String venue, String result,
    //         String status, int winnerTeamId) {
    //     this.matchId = matchId;
    //     this.firstTeamId = firstTeamId;
    //     this.secondTeamId = secondTeamId;
    //     this.matchDate = matchDate;
    //     this.venue = venue;
    //     this.result = result;
    //     this.status = status;
    //     this.winnerTeamId = winnerTeamId;
    // }

    // public Match(int firstTeamId, int secondTeamId, Date matchDate, String venue, String result, String status,
    //         int winnerTeamId, Team team, List<TicketBooking> ticketBookings) {
    //     this.firstTeamId = firstTeamId;
    //     this.secondTeamId = secondTeamId;
    //     this.matchDate = matchDate;
    //     this.venue = venue;
    //     this.result = result;
    //     this.status = status;
    //     this.winnerTeamId = winnerTeamId;
    //     this.team = team;
    //     this.ticketBookings = ticketBookings;
    // }

    // public Match(int matchId, int firstTeamId, int secondTeamId, Date matchDate, String venue, String result,
    //         String status, int winnerTeamId, Team team, List<TicketBooking> ticketBookings) {
    //     this.matchId = matchId;
    //     this.firstTeamId = firstTeamId;
    //     this.secondTeamId = secondTeamId;
    //     this.matchDate = matchDate;
    //     this.venue = venue;
    //     this.result = result;
    //     this.status = status;
    //     this.winnerTeamId = winnerTeamId;
    //     this.team = team;
    //     this.ticketBookings = ticketBookings;
    // }

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public int getFirstTeamId() {
        return firstTeamId;
    }

    public void setFirstTeamId(int firstTeamId) {
        this.firstTeamId = firstTeamId;
    }

    public int getSecondTeamId() {
        return secondTeamId;
    }

    public void setSecondTeamId(int secondTeamId) {
        this.secondTeamId = secondTeamId;
    }

    public Date getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(Date matchDate) {
        this.matchDate = matchDate;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getWinnerTeamId() {
        return winnerTeamId;
    }

    public void setWinnerTeamId(int winnerTeamId) {
        this.winnerTeamId = winnerTeamId;
    }

    // public List<TicketBooking> getTicketBookings() {
    //     return ticketBookings;
    // }

    // public void setTicketBookings(List<TicketBooking> ticketBookings) {
    //     this.ticketBookings = ticketBookings;
    // }

    // public Team getTeam() {
    //     return team;
    // }

    // public void setTeam(Team team) {
    //     this.team = team;
    // }

}