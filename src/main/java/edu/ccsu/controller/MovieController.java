package edu.ccsu.controller;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.ccsu.dao.MovieJDBCTemplate;
import edu.ccsu.model.Movie;

@RestController
public class MovieController {
	@CrossOrigin
    @RequestMapping("/movie")
    public String movie(@RequestParam(value="name", required=false, defaultValue="World") String name) {

    	ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
    	MovieJDBCTemplate studentJDBCTemplate = (MovieJDBCTemplate)context.getBean("MovieJDBCTemplate");

		System.out.println("------Listing Multiple Records--------");
		List<Movie> movies = studentJDBCTemplate.listMovies();
		StringBuilder sb = new StringBuilder();
		sb.append("{\"data\":[");
		for(Movie record : movies) {
			sb.append("[");
			sb.append(record.toString());
			sb.append("],");
		}
		sb.deleteCharAt(sb.length()-1);
		sb.append("]}");
		//Gson gson = new Gson();
		//String json = gson.toJson(sb);
		//sb.append(json);
		//sb.append("}");
		//System.out.println(sb.toString());
        return sb.toString();

    }
}