package com.kob.botrunningsystem.service;

public interface BotRunningService {

    /**
     *
     * @param userId
     * @param botCode【bot代码】
     * @param input 【地图信息、两个玩家走过的格子...】
     * @return
     */
    String addBot(Integer userId, String  botCode, String input);
}
