package org.demo.shopping.productmanagement.controller;

import org.demo.shopping.productmanagement.model.Branch;
import org.demo.shopping.productmanagement.repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/productmanagement")
public class BranchController {

    @Autowired
    BranchRepository branchRepository;

    @PostMapping("/branches")
    public Branch createBranch(@RequestBody Branch branch) {
        return branchRepository.save(branch);
    }
}
