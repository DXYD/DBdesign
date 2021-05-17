在执行SQL时MyBatis会自动通过对象中的属性给SQL中参数赋值，它会自动将Java类型转换成数据库的类型。而一旦传入的是null它就无法准确判断这个类型应该是什么，就有可能将类型转换错误，从而报错。
要解决这个问题，需要针对这些可能为空的字段，手动指定其转换时用到的类型。
一般情况下，我们没有必要按个字段去识别/判断它是否可以为空，而是将所有的字段都当做可以为空，全部手动设置转换类型。
```
<insert id="save"  
        parameterType="com.xxx.entity.xxx">  
        insert into cost values(  
            cost_seq.nextval,  
            #{name,jdbcType=VARCHAR},  
            #{base_duration,jdbcType=INTEGER},  
            #{base_cost,jdbcType=DOUBLE},  
            #{unit_cost,jdbcType=DOUBLE},  
            #{status,jdbcType=CHAR},  
            #{descr,jdbcType=VARCHAR},  
            #{creatime,jdbcType=TIMESTAMP},  
            #{startime,jdbcType=TIMESTAMP},  
            #{cost_type,jdbcType=CHAR}  
        )  
</insert>  
```
其他数据类型参照下图

https://img-blog.csdn.net/20180310125417541?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMzQxMjI4MjI=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70


在映射文件中：

<mapper namespace="com.baizhi.dao.EmpDAO">
 <insert id="insert" parameterType="com.baizhi.entity.Emp">
        INSERT into user VALUES (#{id},#{name},#{age})
    </insert>
</mapper>
1
2
3
4
5
把你想要设置的属性加上jdbcType,等号右边根据你的实体类的属性来写，例如：把属性name设为空值

<mapper namespace="com.baizhi.dao.EmpDAO">
 <insert id="insert" parameterType="com.baizhi.entity.Emp">
        INSERT into user VALUES (#{id},#{name,jdbcType=VARCHAR},#{age})
    </insert>
</mapper>
1
2
3
4
5
测试方法：写一个测试类

 @Test
    public void testInsert(){
        SqlSession session = MybatisUtil.getSqlSession();
        EmpDAO empDAO = session.getMapper(EmpDAO.class);
        empDAO.insert(new Emp("111",null,11));
        session.commit();
        MybatisUtil.closeSession(session);
    }
————————————————
版权声明：本文为CSDN博主「qq_29926003」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/qq_29926003/article/details/106273282