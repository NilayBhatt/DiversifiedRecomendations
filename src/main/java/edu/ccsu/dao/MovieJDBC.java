package edu.ccsu.dao;

import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import edu.ccsu.helper.MovieMapper;
import edu.ccsu.helper.RecommendationsMapper;
import edu.ccsu.model.Movie;
import edu.ccsu.model.Recommendations;

public class MovieJDBC implements MovieDAO {

	private DataSource dataSource;
	protected JdbcTemplate jdbcTemplateObject;
    
    public void setDataSource(DataSource ds) {
        this.dataSource = ds;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Movie> listMovies() {
        String SQL = "SELECT * from movies where id in (SELECT id from distinctMovies)";
        List <Movie> branches = jdbcTemplateObject.query(SQL, new MovieMapper());
        
        return branches;
    }
    
    public List<Recommendations> listSpecificMovies(TreeMap<String, Double> rawRecommend) {
    	
    	StringBuilder sb = new StringBuilder();
    	sb.append("select id, title from dbo.distinctMovies where id IN (");
    	
    	for(Entry<String, Double> entry : rawRecommend.entrySet()) {
    		  sb.append("'" + entry.getKey() + "',");
    	}
    	sb.deleteCharAt(sb.length()-1);
    	sb.append(")");
        
    	List<Recommendations> branches = jdbcTemplateObject.query(sb.toString(), new RecommendationsMapper());
       
        return branches;
    }

}