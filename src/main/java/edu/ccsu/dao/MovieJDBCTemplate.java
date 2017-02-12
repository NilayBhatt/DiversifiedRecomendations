package edu.ccsu.dao;

import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import edu.ccsu.controller.MovieMapper;
import edu.ccsu.model.Movie;

public class MovieJDBCTemplate implements MovieDAO {

    private DataSource dataSource;

    
    protected JdbcTemplate jdbcTemplateObject;

    
    public void setDataSource(DataSource ds) {
        this.dataSource = ds;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Movie> listMovies() {
        String SQL = "select * from dbo.movies";
        List <Movie> branches = jdbcTemplateObject.query(SQL, new MovieMapper());
        return branches;
    }

}