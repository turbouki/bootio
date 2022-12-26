package com.example.bootio.app.repository;

import com.example.bootio.app.model.Retail;
import com.example.bootio.app.model.RetailInterface;
import com.example.bootio.app.model.RetailSales;
import com.example.bootio.app.model.Usr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaRetailRepository extends JpaRepository<RetailSales, Long> {

final String sql = "select " +
        " cast(date_part('year', sales_month) as int) as salesYear\n" +
        ",sum(case when kind_of_business = 'Women''s clothing stores'\n" +
        "  then sales\n" +
        "  end) as womenSales\n" +
        ",sum(case when kind_of_business = 'Men''s clothing stores'\n" +
        "  then sales\n" +
        "  end) as menSales\n" +
        "from retail_sales\n" +
        "where kind_of_business in ('Men''s clothing stores'\n" +
        ", 'Women''s clothing stores')\n" +
        "group by 1\n" +
        "order by 1\n";

    @Query(value=sql,  nativeQuery = true)
    List<RetailInterface> findAllWM();
}
