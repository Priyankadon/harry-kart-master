package se.atg.service.harrykart.service;

import java.math.BigInteger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import se.atg.service.harrykart.model.CompetitionResults;

@Component
public class WinnerProcessor {

	private Logger LOGGER=LoggerFactory.getLogger(WinnerProcessor.class);
	@Autowired
	private JsonDataProcessor JsonDataProcessor;
	
	public String  winnerIdenfifier(Map<Integer, List<CompetitionResults>> winner) {
		Map<String, List<CompetitionResults>> horseTrackMap=new HashMap<>();
		LOGGER.info("Winner Processing Started");
		winner.forEach((lane,competitionResults)->{
			competitionResults.forEach(competitionResult->{
				if(horseTrackMap.containsKey(competitionResult.getHorse())) {
					horseTrackMap.get(competitionResult.getHorse()).add(competitionResult);
				}else {
					List<CompetitionResults> competitionResultsList=new ArrayList<>();
					 competitionResultsList.add(competitionResult);
					 horseTrackMap.put(competitionResult.getHorse(), competitionResultsList);
				}
			});
		});
		LOGGER.info("Winner Processing Map:"+horseTrackMap);
		List<CompetitionResults> unOrderedCompetitionResults=new ArrayList<>();
		horseTrackMap.forEach((hourse,competitionResults)->{
			CompetitionResults accumulation=new CompetitionResults();
			competitionResults.forEach(competitionResult->{
				accumulation.setHorse(competitionResult.getHorse());
				Integer time=accumulation.getTimeTotal();
				time=time+competitionResult.getTime();
				accumulation.setTimeTotal(time);
			});
			unOrderedCompetitionResults.add(accumulation);
		});
		//System.out.println(unOrderedCompetitionResults);
		List<CompetitionResults> sortedCompetitionResults=unOrderedCompetitionResults.stream().sorted(Comparator.comparingInt(CompetitionResults::getTimeTotal)).collect(Collectors.toList());
		
		for (int i = 0; i <sortedCompetitionResults.size(); i++) {
			sortedCompetitionResults.get(i).setPosition(i+1);
		}
		//System.out.println(sortedCompetitionResults);
		List<CompetitionResults> competitionWinner=sortedCompetitionResults.stream().limit(3).collect(Collectors.toList());
		return JsonDataProcessor.jsonParsor(competitionWinner);
	}

	
	
}
