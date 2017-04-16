package com.demo.data.repository;

import com.demo.data.domain.Agent;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Sawyer on 2017/1/19.
 */
public interface AgentRepository extends JpaRepository<Agent, Integer> {
}
