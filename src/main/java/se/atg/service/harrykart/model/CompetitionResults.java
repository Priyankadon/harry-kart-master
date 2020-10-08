package se.atg.service.harrykart.model;
//Computing the result
import java.math.BigInteger;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class CompetitionResults {

	private Integer position;
	
	private String horse;
	 @JsonIgnore
	private Integer time;
	 @JsonIgnore
	private Integer timeTotal;

	public CompetitionResults() {

	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public String getHorse() {
		return horse;
	}

	public void setHorse(String horse) {
		this.horse = horse;
	}

	public Integer getTime() {
		return time;
	}

	public void setTime(Integer time) {
		this.time = time;
	}

	public Integer getTimeTotal() {
		if (timeTotal == null) {
			timeTotal = 0;
		}
		return timeTotal;
	}

	public void setTimeTotal(Integer timeTotal) {
		this.timeTotal = timeTotal;
	}

	@Override
	public String toString() {
		return "CompetitionResults [position=" + position + ", horse=" + horse + ", time=" + time + ", timeTotal="
				+ timeTotal + "]";
	}

}
