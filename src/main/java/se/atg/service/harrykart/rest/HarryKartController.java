package se.atg.service.harrykart.rest;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import se.atg.service.harrykart.generated.HarryKartType;
import se.atg.service.harrykart.model.CompetitionResults;

@RestController
@RequestMapping("/api")
public class HarryKartController {
	
	private Logger LOGGER=LoggerFactory.getLogger(HarryKartController.class);
	
	@Autowired
	private se.atg.service.harrykart.service.HarryKartService harryKartService;

    @RequestMapping(method = RequestMethod.POST, path = "/play", consumes = "application/xml", produces = "application/json")
    public ResponseEntity<?> playHarryKart(@RequestBody HarryKartType harryKartType) {
    	LOGGER.info("Process Started");
    	String competitionResult=harryKartService.startCompetion(harryKartType);
        return new ResponseEntity<>(competitionResult,HttpStatus.OK);
    }

}
