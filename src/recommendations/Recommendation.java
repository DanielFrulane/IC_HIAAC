package recommendations;

public abstract class Recommendation {
	// TODO: "Recommender" codelet with analysis table of most effective recommendation values

	private RecommendationStatusEnum recommendationStatus;
	String recommendationText;
	
	public Recommendation() {
		recommendationStatus = RecommendationStatusEnum.PENDING;
	}
	
	public RecommendationStatusEnum getRecommendationStatus() {
		return recommendationStatus;
	}
	
	public void setRecommendationStatus(RecommendationStatusEnum recommendationStatus) {
		this.recommendationStatus = recommendationStatus;
	}
	
	public String getRecommendationText() {
		return recommendationText;
	}

}
