package com.example.bootio.demo;


import com.example.bootio.app.model.Trade;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;


import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleJDBCInsertTest {
    private ApplicationContext ctx = null;
    private JdbcTemplate template = null;
    private DataSource dataSource = null;

    private SimpleJdbcInsert jdbcInsert = null;
    private SimpleJdbcCall jdbcCall = null;

    public SimpleJDBCInsertTest() {
        ctx = new ClassPathXmlApplicationContext("datasources-beans.xml");
        dataSource = (DataSource) ctx.getBean("postgreSqlDataSource");
        template = new JdbcTemplate(dataSource);
        jdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("TRADES").usingColumns("id", "account", "security", "quantity");
       // jdbcCall = new SimpleJdbcCall(dataSource).withFunctionName("BIG_TRADES");
       // jdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("BIG_TRADES");
    }

    private void insertTrade(Trade t) {
        Map tradeMap = new HashMap();
        tradeMap.put("id", t.getId());
        tradeMap.put("account", t.getAccount());
        tradeMap.put("security",t.getSecurity());
        tradeMap.put("quantity", t.getQuantity());

        jdbcInsert.execute(tradeMap);
    }

//    private Trade getBigTradeUsingSimpleJdbcCall(int quantity) {
//        SqlParameterSource inValues = new MapSqlParameterSource().addValue("quantity", quantity);
//
//        Map bigTrades = jdbcCall.execute(inValues);
//        System.out.println(bigTrades);
//        Trade t = new Trade();
//        t.setId((Integer)bigTrades.get("id"));
//        t.setAccount((String)bigTrades.get("account"));
//        t.setSecurity((String)bigTrades.get("security"));
//
//        return t;
//    }

//    public Trade getBigTradeUsingSimpleJdbcCall(int quantity) {
//        SqlParameterSource inValues = new MapSqlParameterSource().addValue(
//                "in_qty", quantity);
//        Map bigTrades = jdbcCall.execute(inValues);
//        Trade t = new Trade();
//        t.setId((Integer) bigTrades.get("id"));
//        t.setAccount((String) bigTrades.get("account"));
//        return t;
//
//    }

//    public List getBigTradesUsingSimpleJdbcCall(int quantity) {
//        SqlParameterSource inValues = new MapSqlParameterSource().addValue(
//                "in_qty", quantity);
//        jdbcCall = new SimpleJdbcCall(dataSource).withProcedureName(
//                "big_trades").returningResultSet("trades",
//                new BeanPropertyRowMapper<>()); // ParameterizedBeanPropertyRowMapper
//
//        Map bigTrades = jdbcCall.execute();
//        System.out.println(bigTrades);
//        return (List)bigTrades.get("trades");
//    }

    public List getBigTradesUsingSimpleJdbcCall(String quantity) {
        SqlParameterSource inValues = new MapSqlParameterSource().addValue(
                "quantity", quantity);
        jdbcCall = new SimpleJdbcCall(dataSource).withProcedureName(
                "big_trades").returningResultSet("trades",
                new ParameterizedBeanPropertyRowMapper());

        Map bigTrades = jdbcCall.execute(inValues);
        return null;
       // return (List)bigTrades.get("trades");

    }



    public static void main(String[] args) {
        SimpleJDBCInsertTest t = new SimpleJDBCInsertTest();
//        Trade trade = new Trade();
//        trade.setAccount("1234ZZZZ");;
//        trade.setSecurity("POSTS");
//        trade.setQuantity(100);
//        trade.setId(4321);
//        trade.setStatus("NEW");
//        t.insertTrade(trade);
        t.getBigTradesUsingSimpleJdbcCall("1000");

    }
}
