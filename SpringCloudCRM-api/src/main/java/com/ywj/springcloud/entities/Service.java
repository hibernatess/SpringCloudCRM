package com.ywj.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Service {
    private Integer svr_id;
    private String svr_type;
    private String svr_title;
    private String svr_cust_no;
    private String svr_cust_name;
    private String svr_status;
    private String svr_request;
    private String svr_create_id;
    private String svr_create_by;
    private String svr_create_date;
    private String svr_due_id;
    private String svr_due_to;
    private String svr_due_date;
    private String svr_deal;
    private String svr_deal_id;
    private String svr_deal_by;
    private String svr_deal_date;
    private String svr_result;
    private String svr_satisfy;
}
