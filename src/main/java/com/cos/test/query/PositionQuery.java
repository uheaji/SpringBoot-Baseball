package com.cos.test.query;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PositionQuery {

	private final EntityManager em;

	public Query positionPivot() {
		StringBuffer sb = new StringBuffer();
		sb.append("select position, ");
		sb.append("max(if(teamId='1', playerName, null)) as 'team1' , ");
		sb.append("max(if(teamId='2', playerName, null)) as 'team2', ");
		sb.append("max(if(teamId='3', playerName, null)) as 'team3' ");
		sb.append("from player ");
		sb.append("group by position; ");
		Query query = em.createNativeQuery(sb.toString());
		return query;
	}

}
