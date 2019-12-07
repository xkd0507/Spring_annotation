package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;

/**
 * 数据库连接的配置文件
 */
@PropertySource("jdbcConfig.properties")
public class JdbcConfig {

    /**
     * 读取jdbcConfig.properties文件，需要用到一个新的注解@PropertySource
     */
    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;


    /**
     * 用于创建一个QueryRunner对象
     *    默认是单例模式,需要添加@Scope注解表明多例
     * @param dataSource
     * @return
     */
    @Bean(name = "runner")
    @Scope(value = "prototype")
    public QueryRunner createQueryRunner(DataSource dataSource){
        return new QueryRunner(dataSource);
    }

    /**
     * 创建数据源对象
     * @return
     */
    @Bean(name = "dataSource")
    public DataSource createDataSource(){
        try{
            ComboPooledDataSource dataSource = new ComboPooledDataSource();
            dataSource.setDriverClass(driver);
            dataSource.setJdbcUrl(url);
            dataSource.setUser(username);
            dataSource.setPassword(password);
            return dataSource;
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }
}
