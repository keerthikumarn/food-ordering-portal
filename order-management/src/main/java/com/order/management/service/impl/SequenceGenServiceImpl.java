package com.order.management.service.impl;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.order.management.entity.Sequence;
import com.order.management.service.SequenceGenService;

@Service
public class SequenceGenServiceImpl implements SequenceGenService {

	@Autowired
	private MongoOperations mongoOperations;

	@Override
	public int generateNextOrderId() {
		Sequence counter = mongoOperations.findAndModify(query(where("_id").is("sequence")),
				new Update().inc("sequence", 1), options().returnNew(true).upsert(true), Sequence.class);
		return counter.getSequence();
	}

}
