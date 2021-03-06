package com.cafe24.travelMaker.mapper;

import java.util.*;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.travelMaker.domain.Res;
import com.cafe24.travelMaker.domain.ResCate;

@Mapper
public interface ResMapper {
	public List<ResCate> selectResCate();
	public int addRes(Res res);
	public List<Res> getResList(String search);
	public Res getDetailRes(String resNum);
	public List<Res> getbestRes(String search);
}
