package com.rishabh.PollingApplication.service;

import com.rishabh.PollingApplication.model.Poll;
import com.rishabh.PollingApplication.payload.PagedResponse;
import com.rishabh.PollingApplication.payload.PollRequest;
import com.rishabh.PollingApplication.payload.PollResponse;
import com.rishabh.PollingApplication.payload.VoteRequest;
import com.rishabh.PollingApplication.security.UserPrincipal;

public class PollService {
    public PagedResponse<PollResponse> getAllPolls(UserPrincipal currentUser, int page, int size) {
    }

    public Poll createPoll(PollRequest pollRequest) {
    }

    public PollResponse getPollById(Long pollId, UserPrincipal currentUser) {
    }

    public PollResponse castVoteAndGetUpdatePoll(Long pollId, VoteRequest voteRequest, UserPrincipal currentUser) {
    }
}
