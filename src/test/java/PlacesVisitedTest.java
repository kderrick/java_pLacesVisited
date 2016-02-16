import org.junit.*;
import static org.junit.Assert.*;

public class PlacesVisitedTest {

  @Test
  public void checkThatObjectInitializes() {
  PlacesVisited testPlacesVisited = new PlacesVisited("Portland");
  assertEquals(true, testPlacesVisited instanceof PlacesVisited);
  }
}
