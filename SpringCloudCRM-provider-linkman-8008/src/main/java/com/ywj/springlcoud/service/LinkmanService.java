package com.ywj.springlcoud.service;


import com.ywj.springcloud.entities.Linkman;

import java.util.List;
import java.util.Map;

public interface LinkmanService {
    /**
     * 多条件查看联系人
     */
    List<Map<String,Object>> findLinkmanMultiple(String lkm_cust_no);

    /**
     *增加联系人
     * @param linkman
     * @return
     */
    int addLinkman(Linkman linkman);

    /**
     *删除联系人
     * @param lkm_id
     * @return
     */
    int deleteLinkman(Integer lkm_id);

    /**
     * 编辑联系人
     * @param linkman
     * @return
     */
    int updateLinkman(Linkman linkman);

}
