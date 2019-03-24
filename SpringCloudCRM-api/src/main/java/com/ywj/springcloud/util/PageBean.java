package com.ywj.springcloud.util;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;


public class PageBean {

    private int page = 1;// 页码

    private int rows = 10;// 页大小

    private int total = 0;// 总记录数

    private boolean pagination = true;// 是否分页
    private String url;
    private Map<String, String[]> parameterMap;//所有参数集合

    /**
     * @param request
     * @return void
     * @Title: setPageBean
     * @Description: (初始化对象的方法)
     */
    public void setPageBean(HttpServletRequest request) {
        this.page = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));
        this.rows = request.getParameter("limit") == null ? 5 : Integer.parseInt(request.getParameter("limit"));
        // 只有jsp页面上填写pagination=false才是不分页
        this.setPagination(!"false".equals(request.getParameter("pagination")));
        this.setParameterMap(request.getParameterMap());
        this.setUrl(request.getRequestURL().toString());
    }

    /**
     * @return int
     * @Title: getMaxPages
     * @Description: (最大页码数)
     */
    public int getMaxPages() {
        return this.total % this.rows == 0 ? this.total / this.rows : this.total / this.rows + 1;
    }

    /**
     * @return int
     * @Title: getNextPages
     * @Description: (下一页页码)
     */
    public int getNextPages() {
        return this.page < getMaxPages() ? this.page + 1 : getMaxPages();
    }

    /**
     * @return int
     * @Title: getUpPages
     * @Description: (上一页)
     */
    public int getUpPages() {
        return this.page - 1 > 0 ? this.page - 1 : 1;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Map<String, String[]> getParameterMap() {
        return parameterMap;
    }

    public void setParameterMap(Map<String, String[]> parameterMap) {
        this.parameterMap = parameterMap;
    }

    public PageBean() {
        super();
        // TODO Auto-generated constructor stub
    }

    public PageBean(int page, int rows, int total, boolean pagination) {
        super();
        this.page = page;
        this.rows = rows;
        this.total = total;
        this.pagination = pagination;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setTotal(String total) {
        this.total = Integer.parseInt(total);
    }

    public boolean isPagination() {
        return pagination;
    }

    public void setPagination(boolean pagination) {
        this.pagination = pagination;
    }

    /**
     * 获得起始记录的下标
     *
     * @return
     */
    public int getStartIndex() {
        return (this.page - 1) * this.rows;
    }

    @Override
    public String toString() {
        return "PageBean [page=" + page + ", rows=" + rows + ", total=" + total + ", pagination=" + pagination + "]";
    }
}
