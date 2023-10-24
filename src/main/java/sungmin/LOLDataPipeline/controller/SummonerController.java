package sungmin.LOLDataPipeline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sungmin.LOLDataPipeline.dto.SummonerDTO;
import sungmin.LOLDataPipeline.service.SummonerService;

@Controller
@RequestMapping("/summonerByName")
public class SummonerController {
    private final SummonerService summonerService;

    @Autowired
    public SummonerController(SummonerService summonerService) {
        this.summonerService = summonerService;
    }

    @PostMapping(path = "/getSummoner", produces = "application/json")
    @ResponseBody
    public SummonerDTO getSummonerByName(@RequestParam(value = "name") String name) {
        SummonerDTO apiResult = summonerService.getAPISummonerByName(name);
        return apiResult;
    }
}