layui.use(['form', 'layedit', 'laydate','table'], function() {
    var table = layui.table;
    var $ = layui.$;
    var form = layui.form
        , layer = layui.layer
        , layedit = layui.layedit
        , laydate = layui.laydate;

    table.render({
        elem: '#test'
        , url: 'findConstitute'
        , title: '客户构成'
        , cols: [[
            {field: 'dict_item', title: '编号', width: '10%', edit: 'text'}
            , {field: 'dict_value', title: '等级', width: '50%', edit: 'text'}
            , {field: 'sum', title: '客户数量', width: '40%', edit: 'text'}
        ]]
        , page: true
        , id: "testReload"
        ,  limit: 10
        , limits: [10, 20, 30]
    });
    var $ = layui.$, active = {
        reload: function () {
            //多个条件的查询
            var type=$('#type').val();
            var typename=$("#type").find("option:selected").text();
            // 执行重载
            table.reload('testReload', {
                where: {
                    type: type,
                    typename: typename,
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