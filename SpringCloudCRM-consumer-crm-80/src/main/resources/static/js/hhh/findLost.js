layui.use(['form', 'layedit', 'laydate','table'], function() {
    var table = layui.table;
    var $ = layui.$;
    var form = layui.form
        , layer = layui.layer
        , layedit = layui.layedit
        , laydate = layui.laydate;


    table.render({
        elem: '#test'
        , url: 'findlost'
        , title: '客户流失表'
        , cols: [[
            {field: 'lst_id', title: '编号', width: '10%', edit: 'text'}
            , {field: 'lst_lost_date', title: '年份', width: '20%', edit: 'text'}
            , {field: 'lst_cust_name', title: '客户', width: '20%', edit: 'text'}
            , {field: 'lst_cust_manager_name', title: '客户经理', width: '20%', edit: 'text'}
            , {field: 'lst_reason', title: '流失原因', width: '30%', edit: 'text'}
        ]]
        , page: true
        , id: "testReload"
        ,  limit: 10
        , limits: [10, 20, 30]
    });
    var $ = layui.$, active = {
        reload: function () {
            //多个条件的查询
            var lst_cust_name=$('#lst_cust_name').val();
            var lst_cust_manager_name=$("#lst_cust_manager_name").val();
            // 执行重载
            table.reload('testReload', {
                where: {
                    lst_cust_name: lst_cust_name,
                    lst_cust_manager_name: lst_cust_manager_name,
                },
                page: {
                    curr: 1
                    // 重新从第 1 页开始
                }
            });
        }
    };
    /**
     * 点击查询按钮触发的事件
     */
    $('#btn').on('click', function () {
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    });


})