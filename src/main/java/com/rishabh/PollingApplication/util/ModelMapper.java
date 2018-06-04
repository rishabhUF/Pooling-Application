package com.rishabh.PollingApplication.util;

import com.rishabh.PollingApplication.model.Poll;
import com.rishabh.PollingApplication.model.User;
import com.rishabh.PollingApplication.payload.PollResponse;

import java.util.Map;

public class ModelMapper {

    public static PollResponse mapPollToPollResponse(Poll poll, Map<Long, Long> choiceVotesMap, User creator, Long userVote) {
        PollResponse pollResponse = new PollResponse();
        pollResponse.getId(poll.getId());
        pollResponse.setQuestion(poll.getQuestion());
        pollResponse.setCreationDateTime(poll.);
    }
}
