package se.atg.service.harrykart.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.atg.service.harrykart.generated.HarryKartType;
import se.atg.service.harrykart.generated.LoopType;
import se.atg.service.harrykart.generated.ParticipantType;
import se.atg.service.harrykart.generated.PowerUpsType;
import se.atg.service.harrykart.generated.StartListType;
import se.atg.service.harrykart.model.CompetitionResults;
import se.atg.service.harrykart.model.HarrykartConstants;
import se.atg.service.harrykart.rest.HarryKartController;

@Service
public class HarryKartService {
	
	private Logger LOGGER=LoggerFactory.getLogger(HarryKartService.class);
	
	@Autowired
	private WinnerProcessor winnerProcessor;
	
	public String startCompetion(HarryKartType harryKartType) {
		
		StartListType startListType= harryKartType.getStartList();
		List<ParticipantType> participants=startListType.getParticipant();
		PowerUpsType powerUps=harryKartType.getPowerUps();
		List<LoopType> loopTypes=powerUps.getLoop();
	
		Map<Integer, List<CompetitionResults>> winner=new HashMap<>();
		Map<String, Integer> powerupsTracker=new HashMap<>();
		
		//BASE SPEED 
		List<CompetitionResults> baseResult=new ArrayList<>();
		LOGGER.info("BASE SPEDD RACE STARED");
		participants.forEach(participant->{
			CompetitionResults competitionResults=new CompetitionResults();
			competitionResults.setHorse(participant.getName());
			Integer baseSpeed=participant.getBaseSpeed();
			Integer bigInteger=(HarrykartConstants.MAX_TRACK_DISTANCE/baseSpeed);
			competitionResults.setTime(bigInteger);
			
			powerupsTracker.put(participant.getName(), participant.getBaseSpeed());
			
			baseResult.add(competitionResults);
		});
		winner.put(0, baseResult);
		LOGGER.info("BASE SPEDD RACE COMPLETED:"+winner);
		LOGGER.info("POWER UP/DOWN STARTED ");
		
		loopTypes.forEach(loopType->{
			List<CompetitionResults> raceResult=new ArrayList<>();
			loopType.getLane().forEach(laneType->{
				participants.forEach(participant->{
					if(laneType.getNumber().equals(participant.getLane())){
						CompetitionResults competitionResults=new CompetitionResults();
						competitionResults.setHorse(participant.getName());
						Integer previousePower=powerupsTracker.get(participant.getName());
						Integer modifiedSpeed=previousePower+laneType.getValue();
						powerupsTracker.get(participant.getName());
						powerupsTracker.put(participant.getName(), modifiedSpeed);
						Integer bigInteger=(HarrykartConstants.MAX_TRACK_DISTANCE/modifiedSpeed);
						competitionResults.setTime(bigInteger);
						raceResult.add(competitionResults);
					}
				});
			});
			winner.put(loopType.getNumber(), raceResult);
		});
		LOGGER.info("POWER UP/DOWN COMPLETED:"+winner);
		return winnerProcessor.winnerIdenfifier(winner);
	}

}
