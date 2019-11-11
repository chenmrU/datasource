package com.cmr.datasource.filter;

import com.alibaba.druid.filter.FilterChain;
import com.alibaba.druid.filter.FilterEventAdapter;
import com.alibaba.druid.proxy.jdbc.ConnectionProxy;
import com.alibaba.druid.proxy.jdbc.PreparedStatementProxy;
import com.alibaba.druid.proxy.jdbc.StatementProxy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.Properties;

/**
 * @author chenmengrui
 * @Description: TODO
 * @date 2019/11/7 11:50
 */
@Slf4j
@Component
public class DataSourceConnectionLogFilter extends FilterEventAdapter {

    @Override
    public void connection_connectBefore(FilterChain chain, Properties info) {
        log.info("DataSourceConnectionLogFilter#connection_connectBefore");
    }

    @Override
    public void connection_connectAfter(ConnectionProxy connection) {
        log.info("DataSourceConnectionLogFilter#connection_connectAfter");
    }

    @Override
    public PreparedStatementProxy connection_prepareStatement(FilterChain chain, ConnectionProxy connection, String sql) throws SQLException {
        log.info(sql);
        return super.connection_prepareStatement(chain, connection, sql);
    }
}
