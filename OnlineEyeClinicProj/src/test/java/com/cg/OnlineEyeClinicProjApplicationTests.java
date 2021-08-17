package com.cg;


import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.dao.IReportRepo;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
@Transactional
class OnlineEyeClinicProjApplicationTests {

	//Testing of Methods 
	@Autowired
	private IReportRepo reportRepo;
	//testing the report Id
	@Test
public void testReportId() {
	int id=23;
	assertNotNull(reportRepo.findById(id).get());
}
	//testing all reports
	@Test
	public void testReportGet() {
		assertNotNull(reportRepo.findAll());

	}
	
}

