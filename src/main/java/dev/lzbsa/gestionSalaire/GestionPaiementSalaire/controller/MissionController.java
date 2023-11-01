package dev.lzbsa.gestionSalaire.GestionPaiementSalaire.controller;

import dev.lzbsa.gestionSalaire.GestionPaiementSalaire.dao.DTO.MissionDTO;
import dev.lzbsa.gestionSalaire.GestionPaiementSalaire.service.MissionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/mission")
@AllArgsConstructor
public class MissionController {
    private MissionService missionService;

    @GetMapping
    @RequestMapping
    public List<MissionDTO> getAllMissions(){ return missionService.getAllMissions();}


    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public MissionDTO getMissionById(@PathVariable("id")UUID missionId){
        MissionDTO missionDTO = missionService.getMissionById(missionId);
        return missionService.getMissionById(missionId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MissionDTO createMission(@RequestBody MissionDTO missionDTO){
        return missionService.createMission(missionDTO);
    }
    

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public MissionDTO updateMission (@PathVariable("id")UUID missionId, @RequestBody MissionDTO missionDTO){
        missionDTO.setId(missionId);
        MissionDTO updateMission = missionService.updateMission(missionDTO);
        return missionService.updateMission(missionDTO);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteMission(@PathVariable("id") UUID missionId){
        missionService.deleteMission(missionId);
        return new ResponseEntity<>("Mission successfully deleted!",HttpStatus.OK);
    }
}
