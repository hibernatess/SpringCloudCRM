layui.use(['form', 'layedit', 'laydate','table'], function() {
    var table = layui.table;
    var $ = layui.$;
    var form = layui.form
        , layer = layui.layer
        , layedit = layui.layedit
        , laydate = layui.laydate;


    //渲染时间选择器
    laydate.render({
        elem: '#odr_date'
        , format: 'yyyy年MM月dd日'
    });

    table.render({
        elem: '#test'
        , url: 'findContribution'
        , title: '客户贡献服务表'
        , cols: [[
            {field: 'odr_id', title: '编号', width: '10%', edit: 'text'}
            , {field: 'odr_cust_name', title: '客户名称', width: '50%', edit: 'text'}
            , {field: 'price', title: '订单金额', width: '40%', edit: 'text'}
        ]]
        , page: true
        , id: "testReload"
        , limit: 10
        , limits: [10, 20, 30]
    });
    var $ = layui.$, active = {
        reload: function () {
            //多个条件的查询
            var odr_cust_name=$('#odr_cust_name').val();
            var odr_date=$("#odr_date").val();
            // 执行重载
            table.reload('testReload', {
                where: {
                    odr_cust_name: odr_cust_name,
                    odr_date: odr_date,
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