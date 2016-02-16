import java.util.HashMap;
import java.util.ArrayList;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
      staticFileLocation("/public");
      String layout = "templates/layout.vtl";
      get("/", (request, response) -> {
        HashMap<String, Object> model = new HashMap<String, Object>();
        model.put("template", "templates/index.vtl");
        model.put("placeVisited", request.session().attribute("places"));
        return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/places", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();

      ArrayList<PlacesVisited> placeVisited = request.session().attribute("places");
        if (placeVisited == null) {
          placeVisited = new ArrayList<PlacesVisited>();
          request.session().attribute("places", placeVisited);
        }

      String place = request.queryParams("place");
      String date = request.queryParams("date");
      PlacesVisited newPlacesVisited = new PlacesVisited(place, date);
      // request.session().attribute("place", newPlacesVisited);
      // request.session().attribute("date", newPlacesVisited);

      placeVisited.add(newPlacesVisited);

      model.put("template", "templates/success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    }
}
