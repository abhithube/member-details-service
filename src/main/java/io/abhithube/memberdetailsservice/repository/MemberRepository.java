package io.abhithube.memberdetailsservice.repository;

import io.abhithube.memberdetailsservice.model.Member;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends MongoRepository<Member, String> {
    Optional<Member> findByUsername(String username);

    Optional<Member> findByCustomerId(String customerId);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);
}
