public class PlacesVisited {
  private String mPlace;
  private String mDate;

  public PlacesVisited(String place, String date) {
    mPlace = place;
    mDate = date;
  }

  public String getPlace(String place) {
    return mPlace;
  }
  public String getDate(String date) {
    return mDate;
  }
  public String getBoth() {
    String both = mPlace + "" + mDate;
    return both;
  }
}
