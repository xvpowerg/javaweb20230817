package tw.com.json;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import tw.com.mask.Mask;
import tw.com.net.MaskNetTools;
import java.util.function.Consumer;
public class MaskJsonTools {
	public static void maskJsonObj(String json,Consumer<List<Mask>> callBack)throws JsonMappingException, IOException {
		ObjectMapper objMappter = new ObjectMapper();
		Map map =   objMappter.readValue(json, Map.class);
		 List<Mask> maskList = new ArrayList<>();
		List<Map<String,Object>> jsonList =(List<Map<String,Object>>) map.get("features");
		for (Map<String,Object> jsonMap : jsonList) {
			Map<String,Object> proMap = (Map<String,Object>)jsonMap.get("properties");
			Mask mask = new Mask();
			mask.setId(proMap.get("id").toString());
			mask.setName(proMap.get("name").toString());
			mask.setMaskAdult(proMap.get("mask_adult").toString());
			mask.setMaskChild(proMap.get("mask_child").toString());
			maskList.add(mask);
		}
		callBack.accept(maskList);
		//System.out.println(maskList);
		
	}
	
	public static void main(String[] args) {
		
//		MaskNetTools.getMasJson(josn->{
//			try {
//				maskJsonObj(josn);
//				System.out.println("Finish");
//			}catch(Exception ex) {
//				System.out.println(ex);
//			}
//			
//		});
	}
}
