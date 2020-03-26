package org.demo.shopping.productmanagement.repository;


import org.demo.shopping.productmanagement.model.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Long> {

}
