package com.ywj.springcloud.service;

import com.ywj.springcloud.entities.Activity;

import java.util.List;
import java.util.Map;

public interface ActivityService {
    /**
     * 多条件查看交往记录
     */
    List<Map<String,Object>> findActiviyMultiple(String atv_cust_no);

    /**
     *增加交往记录
     * @param activiy
     * @return
     */
    int addActiviy(Activity activiy);

    /**
     *删除交往记录
     * @param chc_id
     * @return
     */
    int deleteActivity(Integer atv_id);

    /**
     * 编辑交往记录
     * @param activity
     * @return
     */
    int updateActivity(Activity activity);

}