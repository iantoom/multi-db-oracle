package id.bts.multidb.oc11g.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import id.bts.multidb.oc11g.domains.TestUser;

@Repository
public interface UserRepository extends JpaRepository<TestUser, Long> {

	
}
