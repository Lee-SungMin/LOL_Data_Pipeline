package sungmin.LOLDataPipeline.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import sungmin.LOLDataPipeline.dto.SummonerDTO;

@Service
public class SummonerService {
    @Value("${riot.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();
    private final String riotApiBaseUrl = "https://kr.api.riotgames.com/lol";

    public SummonerDTO getAPISummonerByName(String name) {
        String url = riotApiBaseUrl + "/summoner/v4/summoners/by-name/" + name + "?api_key=" + apiKey;
        return restTemplate.getForObject(url, SummonerDTO.class);
    }
}
