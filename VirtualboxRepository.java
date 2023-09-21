package com.atividaden1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.repository;

import com.atividaden1.enity.Virtualbox;

@Repository
public interface VirtualboxRespository extends JpaRepository<Virtualbox, Integer> {

    public boolean existsByClient(String client);

    public List<Virtualbox> findByClient(String client);

    @Query("select max(s.id) from Virtualbox s")
    public Integer findMaxId();
}