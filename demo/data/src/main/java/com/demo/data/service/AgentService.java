package com.demo.data.service;

import com.demo.data.domain.Agent;
import com.demo.data.exception.B2BDBException;
import com.demo.data.repository.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Sawyer on 2017/1/23.
 */
@Component
public class AgentService {

    @Autowired
    AgentRepository agentRepository;

    /**
     * 保存
     * Created by Sawyer on 2017/1/23.
     */
    public Agent save(Agent agent) throws B2BDBException {
        try {
            return agentRepository.save(agent);
        } catch (Exception ex) {
            throw new B2BDBException(String.format("代理商保存失败：{accountId:%s, agentName:%s } ", agent.getAccount().getAccountId(), agent.getName()));
        }
    }
}
