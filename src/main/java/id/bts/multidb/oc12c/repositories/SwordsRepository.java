package id.bts.multidb.oc12c.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import id.bts.multidb.oc12c.domains.TestSword;

@Repository
public interface SwordsRepository extends JpaRepository<TestSword, Long> {

}
