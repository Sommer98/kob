package com.kob.matchingsystem.service.impl;



public interface MatchingService {

    String addPlayer(Integer userId, Integer rating, Integer botId);
    String removePlayer(Integer userId);

}
