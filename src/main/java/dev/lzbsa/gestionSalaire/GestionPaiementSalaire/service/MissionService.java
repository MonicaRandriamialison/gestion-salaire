package dev.lzbsa.gestionSalaire.GestionPaiementSalaire.service;

import dev.lzbsa.gestionSalaire.GestionPaiementSalaire.dao.DTO.MissionDTO;

import java.util.List;
import java.util.UUID;

public interface MissionService {
    public MissionDTO createMission(MissionDTO mission);

    public MissionDTO getMissionById(UUID missionId);

    public List<MissionDTO> getAllMissions();

    public MissionDTO updateMission(MissionDTO mission);

    public void deleteMission(UUID missionId);
}
