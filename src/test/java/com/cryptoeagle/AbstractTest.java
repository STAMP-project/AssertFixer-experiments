package com.cryptoeagle;


import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring/spring-app.xml","/spring/spring-db.xml", "/spring/spring-mvc.xml","/spring/spring-security.xml"})
@WebAppConfiguration
@ActiveProfiles({"Jpa","PostgreSQL"})
@Sql({"classpath:/db/init.sql","classpath:/db/populate.sql"})
@Ignore
public class AbstractTest {

}
