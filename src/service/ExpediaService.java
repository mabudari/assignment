package service;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.databind.ObjectMapper;


public class ExpediaService{
	
	private final String OFFERS_URL = "https://offersvc.expedia.com/offers/v2/getOffers?scenario=deal-finder&page=foo&uid=foo&productType=Hotel";

	public HashMap<String,Object> getOffers(HashMap<String,String> dataModel){
		HashMap<String,Object> response = new HashMap<String,Object>();
		try{
			URI uri = getURI(OFFERS_URL,dataModel);
			response = ApiExecute(uri.toASCIIString());
		}catch(Exception e){
			e.printStackTrace();
		}
		return response;
	}
	
	public URI getURI(String baseUrl , HashMap<String,String> dataModel){
		URI uri = null;
		try{
			URIBuilder urlBuilder = new URIBuilder(baseUrl);
			for(String param : dataModel.keySet())
				urlBuilder.addParameter(param, dataModel.get(param));
			uri = new URI(urlBuilder.toString());
		}catch(Exception e){
			e.printStackTrace();
		}
		return uri;
	}
	
	public HashMap<String,Object> ApiExecute(String url){
		HashMap<String,Object> responseMap = new HashMap<String,Object>();
		try{

			HttpClient client = HttpClientBuilder.create().build();
			HttpGet request = new HttpGet(url);


			HttpResponse response = client.execute(request);
			
			responseMap.put("header", response.getAllHeaders());
			responseMap.put("status", response.getStatusLine());
			HttpEntity entity = response.getEntity();
			
			if(entity!=null){
				HashMap<String,Object> body = new ObjectMapper().readValue(EntityUtils.toString(entity),HashMap.class);
				HashMap<String,Object> offers = (HashMap<String,Object>)body.get("offers");
				List<HashMap<String,Object>> hotel = (ArrayList<HashMap<String,Object>>)offers.get("Hotel");
				responseMap.put("hotel", hotel);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return responseMap;
	}
	
}
	
	
	
	
	


