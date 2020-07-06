package com.cafe24.travelMaker.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.cafe24.travelMaker.domain.KamDto;
import com.cafe24.travelMaker.domain.KamDto2;
import com.cafe24.travelMaker.domain.KamDto3;
import com.cafe24.travelMaker.domain.KmaListDto;


@Service
public class WeatherService {

	private static final String URL = "http://www.kma.go.kr/wid/queryDFSRSS.jsp";
	
	public KmaListDto myService(String zone) {
		
		KmaListDto kmaListDto = new KmaListDto();
		
		try {
			Document doc = Jsoup.connect(URL)
					.data("zone", zone)
					.get();
			
			kmaListDto.setCategory(doc.select("category").text());

			Elements el = doc.select("data");
			
			List<KamDto> lkd = new ArrayList<KamDto>();
			List<KamDto2> lkd2 = new ArrayList<KamDto2>();
			List<KamDto3> lkd3 = new ArrayList<KamDto3>();
			
			for(int i = 0; i < el.size(); i++) {
				Element e = el.get(i);
				String day = e.select("day").text();
				if("0".equals(day)) {
					
					KamDto kam = new KamDto();
					String hour = e.select("hour").text();
					String wfKor = e.select("wfKor").text();
					String tmx = e.select("tmx").text();
					String tmn = e.select("tmn").text();
					String pop = e.select("pop").text();
					String reh = e.select("reh").text();
					String temp = e.select("temp").text();

					kam.setHour(hour);
					kam.setWfkor(wfKor);
					kam.setTmx(tmx);
					kam.setTmn(tmn);
					kam.setPop(pop);
					kam.setReh(reh);
					kam.setTemp(temp);
					lkd.add(kam);
					
				}
			}
			for(int i = 0; i < el.size(); i++) {
				Element e = el.get(i);
				String day = e.select("day").text();
				if("1".equals(day)) {
					
					KamDto2 kam2 = new KamDto2();
					String hour = e.select("hour").text();
					String wfKor = e.select("wfKor").text();
					String tmx = e.select("tmx").text();
					String tmn = e.select("tmn").text();
					String pop = e.select("pop").text();
					String reh = e.select("reh").text();
					String temp = e.select("temp").text();
					
					kam2.setHour(hour);
					kam2.setWfkor(wfKor);
					kam2.setTmx(tmx);
					kam2.setTmn(tmn);
					kam2.setPop(pop);
					kam2.setReh(reh);
					kam2.setTemp(temp);
					
					lkd2.add(kam2);
					
				}
			}
			for(int i = 0; i < el.size(); i++) {
				Element e = el.get(i);
				String day = e.select("day").text();
				if("2".equals(day)) {
					
					KamDto3 kam3 = new KamDto3();
					String hour = e.select("hour").text();
					String wfKor = e.select("wfKor").text();
					String tmx = e.select("tmx").text();
					String tmn = e.select("tmn").text();
					String pop = e.select("pop").text();
					String reh = e.select("reh").text();
					String temp = e.select("temp").text();
					
					kam3.setHour(hour);
					kam3.setWfkor(wfKor);
					kam3.setTmx(tmx);
					kam3.setTmn(tmn);
					kam3.setPop(pop);
					kam3.setReh(reh);
					kam3.setTemp(temp);
					
					lkd3.add(kam3);
					
				}
			}
			kmaListDto.setKamList(lkd);
			kmaListDto.setKamList2(lkd2);
			kmaListDto.setKamList3(lkd3);
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return kmaListDto;
	}
	
}
