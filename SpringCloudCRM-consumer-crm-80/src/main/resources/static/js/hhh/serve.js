layui.use(['form', 'layedit', 'laydate','table'], function() {
    var table = layui.table;
    var $ = layui.$;
    var form = layui.form
        , layer = layui.layer
        , layedit = layui.layedit
        , laydate = layui.laydate;

    //年选择器
    laydate.render({
        elem: '#test2'
        ,type: 'year'
    });

    table.render({
        elem: '#test'
        , url: 'findServe'
        , title: '服务表'
        , cols: [[
            {field: 'dict_item', title: '编号', width: '10%', edit: 'text'}
            , {field: 'dict_value', title: '条目', width: '50%', edit: 'text'}
            , {field: 'sum', title: '服务数量', width: '40%', edit: 'text'}
        ]]
        , page: true
        , id: "testReload"
        ,  limit: 10
        , limits: [10, 20, 30]
    });
    var $ = layui.$, active = {
        reload: function () {
            //多个条件的查询
            var svr_create_date=$('#test2').val();
            // 执行重载
            table.reload('testReload', {
                where: {
                    svr_create_date: svr_create_date,
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