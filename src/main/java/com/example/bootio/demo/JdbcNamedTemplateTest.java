package com.example.bootio.demo;

import com.example.bootio.app.model.Trade;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ParameterizedPreparedStatementSetter;
import org.springframework.jdbc.core.namedparam.*;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JdbcNamedTemplateTest {
    private ApplicationContext ctx = null;
    private NamedParameterJdbcTemplate namedTemplate = null;

    private JdbcTemplate template = null;
    private DataSource dataSource = null;

    public JdbcNamedTemplateTest() {
        ctx = new ClassPathXmlApplicationContext("datasources-beans.xml");
        dataSource = ctx.getBean("postgreSqlDataSource", DataSource.class);
        template = new JdbcTemplate(dataSource);
        namedTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public int getTradesCount(String s, String a) {
        Map bindValues = new HashMap();
        bindValues.put("status", s);
        bindValues.put("account", a);
        int numOfTrades = namedTemplate.queryForObject ("select  count(*) from TRADES where account=:account and status=:status", bindValues, Integer.class);
        System.out.println("Number of Trades: " + numOfTrades);
        return numOfTrades;
    }
    public int getTradesCountUsingSqlParameterSource(String s, String a) {
        SqlParameterSource bindValues =
                new MapSqlParameterSource().addValue("status", s).addValue("account", a);
        int numOfTrades = namedTemplate.queryForObject("select  count(*) from TRADES where account=:account and status=:status", bindValues, Integer.class);
        return numOfTrades;
    }

    public int getTradesCountUsingBeanSqlParameterSource(Trade t) {
        SqlParameterSource bindValues = new BeanPropertySqlParameterSource(t);
        int numberOfTrades = namedTemplate.queryForObject("select  count(*) from TRADES where account=:account and status=:status", bindValues, Integer.class);
        return numberOfTrades;
    }

    private int[] insertTradesList(final List<Trade> trades) {
        SqlParameterSource[] tradeList = SqlParameterSourceUtils.createBatch(trades.toArray());
        int[] updatesCount = namedTemplate.batchUpdate("insert into TRADES values (:id,:account,:security,:quantity,:status,:direction)", tradeList);
        return updatesCount;
    }

    private int[] insertTrades(final List<Trade> trades) {
        int[] updatesCount = template.batchUpdate("insert into TRADES values(?,?,?,?,?,?)", new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Trade t = trades.get(i);
                ps.setInt(1, t.getId());
                ps.setString(2, t.getAccount());
                ps.setString(3, t.getSecurity());
                ps.setInt(4, t.getQuantity());
                ps.setString(5, t.getStatus());
                ps.setString(6, t.getDirection());
            }

            @Override
            public int getBatchSize() {
                return 10;
            }
        });
        return updatesCount;
    }

    private int[][] insertTradesInBatches(final List<Trade> trades, int batchSize) {
        int [][] updateCount = template.batchUpdate(
                "insert into Trades values(?,?,?,?,?,?)",
                trades,
                batchSize,
                new ParameterizedPreparedStatementSetter<Trade>() {
                    @Override
                    public void setValues(PreparedStatement ps, Trade t) throws SQLException {
                        ps.setInt(1, t.getId());
                        ps.setString(2, t.getAccount());
                        ps.setString(3, t.getSecurity());
                        ps.setInt(4, t.getQuantity());
                        ps.setString(5, t.getStatus());
                        ps.setString(6, t.getDirection());
                    }
                });
        return  updateCount;
    }

    public List<Trade> createTrades() {
        List<Trade> trades = new ArrayList<Trade>();
        Trade t = null;
        for (int i = 10; i < 100; i++) {
            t = new Trade();
            t.setId(i);
            t.setAccount("ABC" + i);
            t.setSecurity("SEC" + i + "XXX");
            t.setQuantity(i * 1 * 100);
            t.setDirection("BUY");
            t.setStatus("NEW");
            trades.add(t);
        }
        return trades;
    }



    public static void main(String[] args) {
        JdbcNamedTemplateTest t = new JdbcNamedTemplateTest();

        System.out.println(t.getTradesCount("NEW", "456BBBA"));
        System.out.println(t.getTradesCountUsingSqlParameterSource("NEW", "456BBBA"));
        Trade trade = new Trade();
        trade.setAccount("1234AAA");;
        trade.setId(1234);
        trade.setStatus("NEW");
        System.out.println(t.getTradesCountUsingBeanSqlParameterSource(trade));
        //int [] updatesCount = t.insertTradesList(t.createTrades());

        //int[] updatesCount2 = t.insertTrades(t.createTrades());

        int[][] updates = t.insertTradesInBatches(t.createTrades(),10);
        for(int i = 0; i < updates.length; i ++){
            for(int j = 0; j < updates.length; j ++){
                System.out.println("Element: "+i+","+j+","+updates[i][j]);
            }
        }
    }
}
