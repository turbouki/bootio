package com.example.bootio.app.repository;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class DataRepository {
    private DataSource dataSource;
    private final static Log logger = LogFactory.getLog(DataRepository.class);

    //@Autowired
    private DataRepository (DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<?> findAll() {
        Connection connection = DataSourceUtils.getConnection(dataSource);
        String selectSql = "select sales_month\n" +
                ",sales\n" +
                "from retail_sales\n" +
                "where kind_of_business = 'Retail and food services sales, total'\n" +
                "order by 1;";
        try {
            PreparedStatement ps = connection.prepareStatement(selectSql);
            ResultSet rs  =  ps.executeQuery();
            List<Map<String, String>> data = new ArrayList<>();

            while(rs.next()) {
                Map<String, String> map = new HashMap<>();
                String salesMonth = rs.getString("sales_month");
                String sales = rs.getString("sales");
                map.put("salesMonth", salesMonth);
                map.put("sales", sales);
                data.add(map);
            }
            return  data;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

}
