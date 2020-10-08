package se.atg.service.harrykart.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import se.atg.service.harrykart.model.CompetitionResults;
import se.atg.service.harrykart.model.RankingBean;

@Component
public class JsonDataProcessor {
	
	public String jsonParsor(List<CompetitionResults> competitionWinner) {
		ObjectMapper mapper = new ObjectMapper();
		String jsonData="";
		try {
			RankingBean rankingBean=new RankingBean();
			rankingBean.setRanking(competitionWinner);
			jsonData=mapper.writeValueAsString(rankingBean);
		} catch (JsonProcessingException e) {
			
			e.printStackTrace();
		}
		Map<String, String>  jsonMap=new HashMap<>();
		jsonMap.put("ranking", jsonData);
		
		return jsonData;
	}
}
