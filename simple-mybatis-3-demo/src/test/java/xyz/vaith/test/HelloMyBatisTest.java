package xyz.vaith.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import xyz.vaith.bean.User;

import javax.annotation.Resource;
import java.io.InputStream;

public class HelloMyBatisTest {

    @Test
    public void createMyBatis() throws Exception {
        System.out.println("hello my batis");

        //RIBFS
        String resource = "mybatis/mybatis-config.xml";
        InputStream is = Resources.getResourceAsStream(resource);
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(is);
        SqlSession session = factory.openSession();
        User user = session.selectOne("UserMapper.selectedUserById", 1);
        System.out.println(user);
    }
}