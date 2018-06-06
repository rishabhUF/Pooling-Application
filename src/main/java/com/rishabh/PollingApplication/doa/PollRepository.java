package com.rishabh.PollingApplication.doa;

import com.rishabh.PollingApplication.model.Poll;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface PollRepository extends MongoRepository<Poll,String> {
    Optional<Poll> findById(String pollId);

    Page<Poll> findByCreatedBy(String userId, Pageable pageable);

    Long countByCreatedBy(String userId);

    List<Poll> findByIdIn(List<String> pollIds);

    List<Poll> findByIdIn(List<String> pollIds, Sort sort);
}
