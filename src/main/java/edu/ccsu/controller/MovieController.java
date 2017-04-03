package edu.ccsu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.ccsu.dao.MovieJDBC;
import edu.ccsu.helper.ClassifiersStore;
import edu.ccsu.model.Movie;
import edu.ccsu.model.Recommendations;
import edu.ccsu.weka.UserInstance;
import edu.ccsu.weka.WekaIBk;
import weka.classifiers.lazy.IBk;
import weka.core.Instance;

@RestController
public class MovieController {
	@CrossOrigin
	@RequestMapping("/movie")
	public String movie(@RequestParam(value = "name", required = false, defaultValue = "World") String name) {

		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		MovieJDBC movieJDBC = (MovieJDBC) context.getBean("MovieJDBC");

		// System.out.println("------Listing Multiple Records--------");
		List<Movie> movies = movieJDBC.listMovies();
		StringBuilder sb = new StringBuilder();
		sb.append("{\"data\":[");
		for (Movie record : movies) {
			sb.append("[");
			sb.append(record.toString());
			sb.append("],");
		}
		sb.deleteCharAt(sb.length() - 1);
		sb.append("]}");
		// Gson gson = new Gson();
		// String json = gson.toJson(sb);
		// sb.append(json);
		// sb.append("}");
		// System.out.println(sb.toString());

		return sb.toString();

	}

	@CrossOrigin
	@RequestMapping("/recommendations")
	public String movieRecommendations(HttpServletRequest request, HttpServletResponse response) {
		String trainingFile = "src/main/resources/data/user_ratedmovies.arff";
		List<Recommendations> recommendations;
		// DataSource source;
		ClassifiersStore store = ClassifiersStore.getInstance();
		StringBuilder sb = new StringBuilder();

		try {
			WekaIBk wekaIBk = new WekaIBk(store.getInstances(), (IBk) store.getClassifiers().get("IBK"));
			Instance userInstance = new UserInstance().createUserInstance(store.getInstances(),
					(String) request.getSession().getAttribute("loggedInUser"));

			recommendations = wekaIBk.recommendationsToJson(userInstance);

			sb.append("{\"data\":[");
			for (Recommendations record : recommendations) {
				//sb.append("[");
				sb.append(record.toString());
				sb.append(",");
			}
			sb.deleteCharAt(sb.length() - 1);
			sb.append("]}");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return sb.toString();

	}

}