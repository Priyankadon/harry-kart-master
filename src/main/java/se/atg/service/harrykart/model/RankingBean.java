package se.atg.service.harrykart.model;

import java.util.List;

public class RankingBean {
private List<CompetitionResults> ranking;


public RankingBean() {
	
}

public List<CompetitionResults> getRanking() {
	return ranking;
}

public void setRanking(List<CompetitionResults> ranking) {
	this.ranking = ranking;
}


}
