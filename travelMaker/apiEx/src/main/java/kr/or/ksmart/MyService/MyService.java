package kr.or.ksmart.MyService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import kr.or.ksmart.Dto.KamDto;
import kr.or.ksmart.Dto.KmaListDto;

@Service
public class MyService {

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
			
			for(int i = 0; i < el.size(); i++) {
				Element e = el.get(i);
				String day = e.select("day").text();
				if("0".equals(day)) {
					
					KamDto kam = new KamDto();
					String hour = e.select("hour").text();
					String wfKor = e.select("wfKor").text();
					
					kam.setHour(hour);
					kam.setWfkor(wfKor);
					
					System.out.println(hour + " - " + wfKor);
					
					lkd.add(kam);
					
				}
			}
			kmaListDto.setKamList(lkd);
			
			//System.out.println(el.toString());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return kmaListDto;
	}
	
}
