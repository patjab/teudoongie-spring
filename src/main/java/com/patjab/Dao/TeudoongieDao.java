package com.patjab.Dao;

import com.patjab.Entity.Teudoongie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class TeudoongieDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Teudoongie> selectAll() {
        String sql = "SELECT ID, NAME, BIRTHYEAR FROM TEUDOONGIE";
        return this.jdbcTemplate.query(sql, new TeudoongieRowMapper());
    }

    public Teudoongie selectById(int id) {
        String sql = "SELECT ID, NAME, BIRTHYEAR FROM TEUDOONGIE WHERE ID = ?";
        return (Teudoongie) this.jdbcTemplate.queryForObject(sql, new Object[]{id}, new TeudoongieRowMapper());
    }

    public Teudoongie selectByName(String name) {
        String sql = "SELECT ID, NAME, BIRTHYEAR FROM TEUDOONGIE WHERE NAME = ?";
        return (Teudoongie) this.jdbcTemplate.queryForObject(sql, new Object[]{name}, new TeudoongieRowMapper());
    }

    public void deleteTeudoongieById(int id) {
        String sql = "DELETE FROM TEUDOONGIE WHERE ID = ?";
        this.jdbcTemplate.update(sql, new Object[]{id});
    }

    public void addTeudoongie(Teudoongie t) {
        String sql = "INSERT INTO TEUDOONGIE (name, birthYear) VALUES (?, ?)";
        this.jdbcTemplate.update(sql, new Object[]{t.getName(), t.getBirthYear()});
    }

    public void editTeudoongieById(Teudoongie t) {
        String sql = "UPDATE TEUDOONGIE SET NAME = ? WHERE ID = ?";
        this.jdbcTemplate.update(sql, new Object[]{t.getName(), t.getId()});
    }
}