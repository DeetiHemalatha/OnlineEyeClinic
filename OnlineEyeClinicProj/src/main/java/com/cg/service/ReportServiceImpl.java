package com.cg.service;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.Exceptions.AdminIdNotFoundException;
import com.cg.Exceptions.ReportIdNotFoundException;
import com.cg.dao.IReportRepo;
import com.cg.dao.ISpectaclesRepo;
import com.cg.model.Admin;
import com.cg.model.Report;
import com.cg.model.Spectacles;

@Service
public class ReportServiceImpl implements IReportService {
	@Autowired
	private IReportRepo reportRepo;
	@Autowired
	private ISpectaclesRepo spectRepo;
//add report
	@Override
	public Report addReport(Report report) {
	     return reportRepo.saveAndFlush(report);
	}

	@Override
	public Report updateReport(Report report) {
		return reportRepo.saveAndFlush(report);
	}
//delete report
	@Override
	public Report removeReport(int reportId)throws ReportIdNotFoundException{
		Supplier<ReportIdNotFoundException> supplier = ()->new ReportIdNotFoundException("Report with given id is not available");
		  Optional<Report> r=Optional.ofNullable(reportRepo.findById(reportId).orElseThrow(supplier));
		  reportRepo.deleteById(reportId);
		  return r.get();
	}
	//view report
	@Override
	public Report viewReport(int reportId)throws ReportIdNotFoundException{
		Supplier<ReportIdNotFoundException> supplier=()->new ReportIdNotFoundException("Report with given id is not available");
		Optional<Report> r=Optional.ofNullable(reportRepo.findById(reportId).orElseThrow(supplier));
		  return r.get();
	}
	//view report by date
	@Override
	public List<Report> viewReportsByDate(Date date) {
		return reportRepo.findReportsByDate(date);
	}
//view spectacles
	@Override
	public List<Spectacles> viewSpectacles() {
		return spectRepo.findAll();
	}
}