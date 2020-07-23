package com.cafe24.travelMaker.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.travelMaker.domain.ReportType;
import com.cafe24.travelMaker.domain.ReviewReport;



@Mapper
public interface ReportMapper {
	public List<ReportType> getReportType();
	public int reportSightsReivew(ReviewReport reviewReport);
}
