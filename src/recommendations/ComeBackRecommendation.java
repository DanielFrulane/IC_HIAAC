package recommendations;

import java.util.ArrayList;
import java.util.Random;

public class ComeBackRecommendation extends Recommendation { 
	
	@SuppressWarnings("serial") // TODO: check this warning
	private static final ArrayList<String> recommendationTexts = new ArrayList<String>(){{
        add("Come back to the App today and help science!");
        add("Hey, don't forget do come back to the App once in a while!");
        add("Hello! Come back whenever you can :)");
    }};
	
	public ComeBackRecommendation() {
		super();
		this.recommendationText = getRandomRecommendationText();
	}

	private String getRandomRecommendationText() {
		Random random = new Random();
		int index = random.nextInt(recommendationTexts.size());
		return recommendationTexts.get(index);
	}

}
