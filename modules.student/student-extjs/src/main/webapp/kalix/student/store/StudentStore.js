/**
 * 学生数据仓库
 *
 * @author
 * @version 1.0.0
 */
Ext.define('kalix.app.student.store.StudentStore', {
    extend: 'kalix.store.BaseStore',
    model: 'kalix.app.student.model.StudentModel',
    alias: 'store.studentStore',
    xtype: 'studentStore',
    storeId: "studentStore",
    proxyUrl: '/kalix/camel/rest/students'
});