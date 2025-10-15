package com.wecp.progressive.controller;

import com.wecp.progressive.entity.Match;
import com.wecp.progressive.exception.NoMatchesFoundException;
import com.wecp.progressive.service.MatchService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/match")
public class MatchController {

    @Autowired
    private MatchService matchService;

    // @ExceptionHandler(SQLException.class)
    // public ResponseEntity<Void> handleSQLException(SQLException sqlEx)
    // {
    //     return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    // }

    @GetMapping
    public ResponseEntity<List<Match>> getAllMatches() 
    {
        try
        {
            return new ResponseEntity<>(matchService.getAllMatches(), HttpStatus.OK);
        }
        catch(SQLException sqlEx)
        {
            sqlEx.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{matchId}")
    public ResponseEntity<Match> getMatchById(@PathVariable int matchId) 
    {
        try
        {
            return new ResponseEntity<>(matchService.getMatchById(matchId), HttpStatus.OK);
        }
        catch(SQLException sqlEx)
        {
            sqlEx.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping()
    public ResponseEntity<Integer> addMatch(@RequestBody Match match) 
    {
        try
        {
            return new ResponseEntity<>(matchService.addMatch(match), HttpStatus.CREATED);
        }
        catch(SQLException sqlEx)
        {
            sqlEx.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{matchId}")
    public ResponseEntity<Void> updateMatch(@PathVariable int matchId, @RequestBody Match match) 
    {
        try
        {
            matchService.updateMatch(match);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch(SQLException sqlEx)
        {
            sqlEx.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{matchId}")
    public ResponseEntity<Void> deleteMatch(@PathVariable int matchId) 
    {
        try
        {
            matchService.deleteMatch(matchId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch(SQLException sqlEx)
        {
            sqlEx.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Match>> getAllMatchesByStatus(@PathVariable String status) 
    {
        try
        {
            return new ResponseEntity<>(matchService.getAllMatchesByStatus(status), HttpStatus.OK);
        }
        catch(NoMatchesFoundException nomfEx)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        catch(SQLException sqlEx)
        {
            sqlEx.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
