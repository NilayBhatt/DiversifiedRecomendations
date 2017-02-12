package edu.ccsu.model;

public class Movie {
	private String id;
	private String title;
	private String imdbID;
	private String spanishTitle;
	private String imdbPictureURL;
	private String year;
	private String rtID;
	private String rtAllCriticsRating;
	private String rtAllCriticsNumReviews;
	private String rtAllCriticsNumFresh;
	private String rtAllCriticsNumRotten;
	private String rtAllCriticsScore;
	private String rtTopCriticsRating;
	private String rtTopCriticsNumReviews;
	private String rtTopCriticsNumFresh;
	private String rtTopCriticsNumRotten;
	private String rtTopCriticsScore;
	private String rtAudienceRating;
	private String rtAudienceNumRatings;
	private String rtAudienceScore;
	private String rtPictureURL;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImdbID() {
		return imdbID;
	}
	public void setImdbID(String imdbID) {
		this.imdbID = imdbID;
	}
	public String getSpanishTitle() {
		return spanishTitle;
	}
	public void setSpanishTitle(String spanishTitle) {
		this.spanishTitle = spanishTitle;
	}
	public String getImdbPictureURL() {
		return imdbPictureURL;
	}
	public void setImdbPictureURL(String imdbPictureURL) {
		this.imdbPictureURL = imdbPictureURL;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getRtID() {
		return rtID;
	}
	public void setRtID(String rtID) {
		this.rtID = rtID;
	}
	public String getRtAllCriticsRating() {
		return rtAllCriticsRating;
	}
	public void setRtAllCriticsRating(String rtAllCriticsRating) {
		this.rtAllCriticsRating = rtAllCriticsRating;
	}
	public String getRtAllCriticsNumReviews() {
		return rtAllCriticsNumReviews;
	}
	public void setRtAllCriticsNumReviews(String rtAllCriticsNumReviews) {
		this.rtAllCriticsNumReviews = rtAllCriticsNumReviews;
	}
	public String getRtAllCriticsNumFresh() {
		return rtAllCriticsNumFresh;
	}
	public void setRtAllCriticsNumFresh(String rtAllCriticsNumFresh) {
		this.rtAllCriticsNumFresh = rtAllCriticsNumFresh;
	}
	public String getRtAllCriticsNumRotten() {
		return rtAllCriticsNumRotten;
	}
	public void setRtAllCriticsNumRotten(String rtAllCriticsNumRotten) {
		this.rtAllCriticsNumRotten = rtAllCriticsNumRotten;
	}
	public String getRtAllCriticsScore() {
		return rtAllCriticsScore;
	}
	public void setRtAllCriticsScore(String rtAllCriticsScore) {
		this.rtAllCriticsScore = rtAllCriticsScore;
	}
	public String getRtTopCriticsRating() {
		return rtTopCriticsRating;
	}
	public void setRtTopCriticsRating(String rtTopCriticsRating) {
		this.rtTopCriticsRating = rtTopCriticsRating;
	}
	public String getRtTopCriticsNumReviews() {
		return rtTopCriticsNumReviews;
	}
	public void setRtTopCriticsNumReviews(String rtTopCriticsNumReviews) {
		this.rtTopCriticsNumReviews = rtTopCriticsNumReviews;
	}
	public String getRtTopCriticsNumFresh() {
		return rtTopCriticsNumFresh;
	}
	public void setRtTopCriticsNumFresh(String rtTopCriticsNumFresh) {
		this.rtTopCriticsNumFresh = rtTopCriticsNumFresh;
	}
	public String getRtTopCriticsNumRotten() {
		return rtTopCriticsNumRotten;
	}
	public void setRtTopCriticsNumRotten(String rtTopCriticsNumRotten) {
		this.rtTopCriticsNumRotten = rtTopCriticsNumRotten;
	}
	public String getRtTopCriticsScore() {
		return rtTopCriticsScore;
	}
	public void setRtTopCriticsScore(String rtTopCriticsScore) {
		this.rtTopCriticsScore = rtTopCriticsScore;
	}
	public String getRtAudienceRating() {
		return rtAudienceRating;
	}
	public void setRtAudienceRating(String rtAudienceRating) {
		this.rtAudienceRating = rtAudienceRating;
	}
	public String getRtAudienceNumRatings() {
		return rtAudienceNumRatings;
	}
	public void setRtAudienceNumRatings(String rtAudienceNumRatings) {
		this.rtAudienceNumRatings = rtAudienceNumRatings;
	}
	public String getRtAudienceScore() {
		return rtAudienceScore;
	}
	public void setRtAudienceScore(String rtAudienceScore) {
		this.rtAudienceScore = rtAudienceScore;
	}
	public String getRtPictureURL() {
		return rtPictureURL;
	}
	public void setRtPictureURL(String rtPictureURL) {
		this.rtPictureURL = rtPictureURL;
	}
	
	@Override
	public String toString() {
		return " \"" + id + "\", \"" + title + "\", \"" + imdbID + "\", \"" + spanishTitle
				+ "\", \"" + imdbPictureURL + "\", \"" + year + "\", \"" + rtID + "\", \""
				+ rtAllCriticsRating + "\", \"" + rtAllCriticsNumReviews + "\", \""
				+ rtAllCriticsNumFresh + "\", \"" + rtAllCriticsNumRotten + "\", \""
				+ rtAllCriticsScore + "\", \"" + rtTopCriticsRating + "\", \""
				+ rtTopCriticsNumReviews + "\", \"" + rtTopCriticsNumFresh + "\", \""
				+ rtTopCriticsNumRotten + "\", \"" + rtTopCriticsScore + "\", \""
				+ rtAudienceRating + "\", \"" + rtAudienceNumRatings + "\", \""
				+ rtAudienceScore + "\", \"" + rtPictureURL + "\"";
	}
	
	
}
