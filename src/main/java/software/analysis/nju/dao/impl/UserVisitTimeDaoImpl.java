package software.analysis.nju.dao.impl;

import redis.clients.jedis.ShardedJedis;
import software.analysis.nju.bean.UserVisitTimeBean;
import software.analysis.nju.conf.JedisPoolManager;
import software.analysis.nju.constant.SparkProperties;
import software.analysis.nju.dao.BaseDao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wang Han on 2017/6/20 16:40.
 * E-mail address is wanghan0501@vip.qq.com.
 * Copyright © 2017 Wang Han. SCU. All Rights Reserved.
 */
public class UserVisitTimeDaoImpl extends BaseDao {

    @Override
    public void add(List<Object> objectList) {
        boolean isFirstVisit = true;
        String key = null;
        ShardedJedis jedis = JedisPoolManager.getResource();
        List<String> times = new ArrayList<>();

        for (Object o : objectList) {
            UserVisitTimeBean userVisitTimeBean = (UserVisitTimeBean) o;
            if (isFirstVisit) {
                key = String.valueOf(userVisitTimeBean.getShopId()) + "||"
                    + userVisitTimeBean.getMac();
                isFirstVisit = false;
            }
            times.add(String.valueOf(userVisitTimeBean.getVisitTime()));
        }
        jedis.rpush(key, times.toArray(new String[0]));
        jedis.close();
    }
    @Override
    public Object get(String key) {
        return null;
    }

    @Override
    public List<Object> get(List<String> keys) {
        return null;
    }

    public long getStayTime(int shopId, String mac) {
        ShardedJedis jedis = JedisPoolManager.getResource();
        String key = shopId + "||" + mac;
        String firstVisitTime = jedis.lindex(key, 0);
        Long len = jedis.llen(key);
        String LastVisitTime = jedis.lindex(key, len - 1);
        jedis.close();
        if (firstVisitTime == null) {
            return SparkProperties.DEFAULT_FIRST_VISIT_TIME;
        } else {
            return Long.valueOf(LastVisitTime) - Long.valueOf(firstVisitTime);
        }
    }
}
