package com.patjab.Dao;

import com.patjab.Entity.Teudoongie;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TeudoongieRowMapper implements RowMapper {

    @Override
    public Teudoongie mapRow(ResultSet rs, int line) throws SQLException {
        Teudoongie teudoongie = new Teudoongie(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getInt("birthYear")
        );
        return teudoongie;
    }
}
