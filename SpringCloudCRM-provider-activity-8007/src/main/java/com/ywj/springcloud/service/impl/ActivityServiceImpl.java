package com.ywj.springcloud.service.impl;


import com.ywj.springcloud.entities.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ywj.springcloud.mapper.ActivityMapper;
import com.ywj.springcloud.service.ActivityService;

import java.util.List;
import java.util.Map;

@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityMapper activiatyMapper;

    @Override
    public List<Map<String, Object>> findActiviyMultiple(String atv_cust_no) {
        return activiatyMapper.findActivityMultiple(atv_cust_no);
    }

    @Override
    public int addActiviy(Activity activiy) {
        return activiatyMapper.addActivity(activiy);
    }

    @Override
    public int deleteActivity(Integer atv_id) {
        return activiatyMapper.deleteActivity(atv_id);
    }

    @Override
    public int updateActivity(Activity activity) {
        return activiatyMapper.updateActivity(activity);
    }
}
