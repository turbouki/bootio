package com.example.bootio.app.repository;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

//@RequiredArgsConstructor
@Component("retailRepository")
public class RetailRepository {

    private final JdbcTemplate jdbcTemplate;

    private RetailRepository (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    private final static Log logger = LogFactory.getLog(RetailRepository.class);
    public List<?> findAll() {
        String sql = "select date_part('year', sales_month) as sales_year\n" +
                ",sum(case when kind_of_business = 'Women''s clothing stores'\n" +
                "  then sales\n" +
                "  end) as women_sales\n" +
                ",sum(case when kind_of_business = 'Men''s clothing stores'\n" +
                "  then sales\n" +
                "  end) as men_sales\n" +
                "from retail_sales\n" +
                "where kind_of_business in ('Men''s clothing stores'\n" +
                ", 'Women''s clothing stores')\n" +
                "group by 1\n" +
                "order by 1\n";
        System.out.println(jdbcTemplate);
        return jdbcTemplate.queryForList(sql);
    }
}
