package com.cafe24.travelMaker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.travelMaker.domain.ReportType;
import com.cafe24.travelMaker.mapper.ReportMapper;

@Service
public class ReportService {

	@Autowired private ReportMapper reportMapper;
	
	public List<ReportType> getReportType(){
		return reportMapper.getReportType();
	}
}
