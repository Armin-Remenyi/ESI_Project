package com.esi.backgroundcheckservice.backgroundchecks.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BackgroundCheckController
{
    // private  List<BackgroundCheck> backgroundChecks =  new ArrayList<>(Arrays.asList(
    //    new BackgroundCheck(1, LocalDate.of(2023, 1, 13) ),
    //    new BackgroundCheck(2, LocalDate.of(2022, 12, 13) ),
    //    new BackgroundCheck(3, LocalDate.of(2022, 7, 1) ),
    //    new BackgroundCheck(4, LocalDate.of(2021, 3, 8) ),
    //    new BackgroundCheck(5, LocalDate.of(2023, 4, 23) )
    // ));

    @Autowired
    private BackgroundCheckService backgroundCheckService;

    @GetMapping("/backgroundChecks")
    public List<BackgroundCheck> getAllBackgroundChecks()
    {
        //return backgroundChecks;
        return backgroundCheckService.getAllBackgroundChecks();
    }

    @GetMapping("/backgroundChecks/{backgroundCheckid}")
    public Optional <BackgroundCheck> getBackgroundCheck(@PathVariable Integer backgroundCheckid)
    {
        //return backgroundChecks.stream().filter(bc->bc.getBackgroundCheckid().equals(backgroundCheckid)).findFirst().get();
        return backgroundCheckService.getBackgroundCheck(backgroundCheckid);
    }

    @PostMapping("/backgroundChecks")
    public void addBackgrounCheck(@RequestBody BackgroundCheckDto backgroundCheckDto)
    {
        backgroundCheckService.addBackgrounCheck(backgroundCheckDto);
    }

    @PutMapping("/backgroundChecks/{backgroundCheckid}")
    public void updateBackgroundCheck(@RequestBody BackgroundCheckDto backgroundCheckDto, @PathVariable Integer backgroundCheckid)
    {
        backgroundCheckService.updateBackgroundCheck(backgroundCheckid, backgroundCheckDto);
    }

    @DeleteMapping("/backgroundChecks/{backgroundCheckid}")
    public void deleteBackgroundCheck(@PathVariable Integer backgroundCheckid)
    {
        backgroundCheckService.deleteBackgroundCheck(backgroundCheckid);
    }

}