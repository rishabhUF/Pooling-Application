package com.rishabh.PollingApplication.web;

import com.rishabh.PollingApplication.doa.PollRepository;
import com.rishabh.PollingApplication.doa.UserRepository;
import com.rishabh.PollingApplication.doa.VoteRepository;
import com.rishabh.PollingApplication.model.Poll;
import com.rishabh.PollingApplication.payload.*;
import com.rishabh.PollingApplication.security.CurrentUser;
import com.rishabh.PollingApplication.security.UserPrincipal;
import com.rishabh.PollingApplication.service.PollService;
import com.rishabh.PollingApplication.util.AppConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("api/polls")
public class PollController {

    @Autowired
    private PollRepository pollRepository;

    @Autowired
    private VoteRepository voteRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    PollService pollService;

    private static final Logger logger = LoggerFactory.getLogger(PollController.class);

    @GetMapping
    public PagedResponse<PollResponse> getPolls(@CurrentUser UserPrincipal currentUser,
                                                @RequestParam(value = "page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int page,
                                                @RequestParam(value = "size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int size){
        return pollService.getAllPolls(currentUser,page,size);
    }

    @PostMapping
    @PreAuthorize("hasRole('User')")
    public ResponseEntity<?> createPoll(@Valid @RequestBody PollRequest pollRequest )
    {
        Poll poll = pollService.createPoll(pollRequest);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{pollID}").buildAndExpand(poll.getId()).toUri();

        return ResponseEntity.created(location).body(new ApiResponse(true, "Poll created"));
    }

    @GetMapping
    public PollResponse getPollById(@CurrentUser UserPrincipal currentUser, @PathVariable Long pollId) {
        return pollService.getPollById(pollId,currentUser);
    }

    @PostMapping("/{pollId}/votes")
    @PreAuthorize("hasRole('USER')")
    public PollResponse castVote(@CurrentUser UserPrincipal currentUser, @PathVariable Long pollId, @Valid @RequestBody VoteRequest voteRequest)
    {
        return pollService.castVoteAndGetUpdatePoll(pollId, voteRequest, currentUser);
    }
}
