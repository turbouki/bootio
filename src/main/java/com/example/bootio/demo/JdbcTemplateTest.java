package com.example.bootio.demo;


import com.example.bootio.app.model.Trade;
import org.springframework.beans.BeanUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.ServletRequestDataBinder;

import javax.sql.DataSource;
import javax.swing.tree.TreePath;
import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.Map;


public class JdbcTemplateTest {
    private ApplicationContext ctx = null;
    private JdbcTemplate template = null;
    private DataSource dataSource = null;

    public JdbcTemplateTest() {
        ctx = new ClassPathXmlApplicationContext ("datasources-beans.xml");
        dataSource = ctx.getBean("postgreSqlDataSource", DataSource.class);
        template = new JdbcTemplate(dataSource);
    }

    private static final  class TradeMapper implements RowMapper<Trade> {
        @Override
        public Trade mapRow(ResultSet rs, int rowNum) throws SQLException {
            Trade t = new Trade();

            t.setId(rs.getInt("id"));
            t.setQuantity(rs.getInt("quantity"));
            t.setAccount(rs.getString("account"));
            t.setSecurity(rs.getString("security"));
            t.setDirection(rs.getString("direction"));
            t.setStatus(rs.getString("status"));
            return t;
        }
    }

//    private static final  class TradeMapper2 implements RowMapper<Trade> {
//        @Override
//        public Trade mapRow(ResultSet rs, int rowNum) throws SQLException {
//            Class clz = Trade.class;
//            Field[] fields = clz.getDeclaredFields();
//            System.out.println(fields.length);
//
//
//            Trade t = new Trade();
//
//            for (Field f: fields) {
//
//            }
//
//            t.setId(rs.getInt("id"));
//            t.setQuantity(rs.getInt("quantity"));
//            t.setAccount(rs.getString("account"));
//            t.setSecurity(rs.getString("security"));
//            t.setDirection(rs.getString("direction"));
//            t.setStatus(rs.getString("status"));
//            return t;
//        }
//    }


    public int getUsrCount() {
        int numOfUsr = template.queryForObject("select count(*) from usr", Integer.class);
        return numOfUsr;
    }

    public int getUsrMaxId() {
        int maxId = template.queryForObject("select max(room_id) from meeting_room", Integer.class);
        return maxId;
    }

    public List<?> getUserList() {
        List <Map<String, Object>>list = template.queryForList("select * from usr");
        return list;
    }

    public Map<String, Object> getUsrAsMap() {
        Map<String, Object> usrAsMap = template.queryForMap("select * from usr where user_id = 'Go Damdeok'");
        System.out.println("Usr Map: " + usrAsMap);
        return usrAsMap;
    }

    public List<Map<String, Object>> getAllTrades() {
        List<Map<String, Object>> trades = template.queryForList("select * from trades");
        System.out.println("All Trades:" + trades);
        return trades;
    }

    public String getTradeStatus(int id) {
        String status = template.queryForObject("select STATUS from trades where id= ?",
                new Object[]{id}, String.class);
        return status;
    }

    public Trade getMappedTrade(int id) {
        Trade trade = template.queryForObject("select * from Trades where id = ?", new Object[]{id},
                new RowMapper<Trade>() {
                    @Override
                    public Trade mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Trade t = new Trade();

                        t.setId(rs.getInt("id"));
                        t.setQuantity(rs.getInt("quantity"));
                        t.setAccount(rs.getString("account"));
                        t.setSecurity(rs.getString("security"));
                        t.setDirection(rs.getString("direction"));
                        t.setStatus(rs.getString("status"));
                        return t;
                    }
                });
        return trade;
    }

    public List<Trade> getAllMappedTrades() {
        List<Trade> trades = template.query("select * from Trades", new TradeMapper());
        return trades;
    }

    private void insertTrade() {
        int rowsUpdated = template.update("insert into Trades values(?, ?, ?, ?, ?, ?)",
                61, "JSDATA", "REV", 5000000, "NEW", "SELL");
        System.out.println("Rows Updated:" + rowsUpdated);
    }

    private void updateTrade(String status, int id) {
        int rowsUpdated =
                template.update("update Trades set status=? wehre id=?", status, id);
        System.out.println("Rows Updated:" + rowsUpdated);
    }

    private void updateUsingTypes() {
        int rowsUpdated =
                template.update("update Trades set status=? wehre id=?", new Object[]{"UNKNOWN", 6}, new int[] {
                        Types.VARCHAR, Types.INTEGER
                });
        System.out.println("Rows Updated:" + rowsUpdated);
    }

    private void replayTradeUsingSP(List tradeIds) {
        template.update("call mrs.REPLAY_TRADES_SP(?), tradeIds");
    }

    public void createAndDropPersonTable() {
        try {
            template.execute("create table person2 (first_name varchar(50) not null, last_name varchar(50) not null)");
            template.execute("drop table person2");
            System.out.println("Table dropped");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        JdbcTemplateTest t = new JdbcTemplateTest();
        int numOfUsr = t.getUsrCount();
        System.out.println(numOfUsr);

        int maxId = t.getUsrMaxId();
        System.out.println(maxId);

        List<?> result = t.getUserList();
        for(int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }

        Map<String, Object> usrAsMap = t.getUsrAsMap();
        System.out.println(usrAsMap);

        t.getAllTrades();

        System.out.println(t.getTradeStatus(1));

        System.out.println(t.getMappedTrade(2));

        System.out.println(t.getAllMappedTrades());

        t.createAndDropPersonTable();
    }
}
