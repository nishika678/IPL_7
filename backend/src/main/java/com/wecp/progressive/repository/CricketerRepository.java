package com.wecp.progressive.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wecp.progressive.entity.Cricketer;
import java.util.List;

@Repository
public interface CricketerRepository extends JpaRepository<Cricketer, Integer>
{
    public Cricketer findByCricketerId(int cricketerId);

    public List<Cricketer> findByTeam_TeamId(int teamId);

    public Long countByTeam_TeamId(int teamId);

    @Modifying
    @Transactional
    @Query("Delete from Cricketer c where c.teamId = :teamId")
    public Void deleteByTeamId(int teamId);
}
