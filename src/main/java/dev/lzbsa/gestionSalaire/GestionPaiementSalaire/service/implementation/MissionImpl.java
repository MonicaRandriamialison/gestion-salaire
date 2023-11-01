package dev.lzbsa.gestionSalaire.GestionPaiementSalaire.service.implementation;

import dev.lzbsa.gestionSalaire.GestionPaiementSalaire.dao.DTO.MissionDTO;
import dev.lzbsa.gestionSalaire.GestionPaiementSalaire.dao.entity.Mission;
import dev.lzbsa.gestionSalaire.GestionPaiementSalaire.dao.repository.MissionRepository;
import dev.lzbsa.gestionSalaire.GestionPaiementSalaire.exception.RessourceNotFoundException;
import dev.lzbsa.gestionSalaire.GestionPaiementSalaire.service.MissionService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class MissionImpl implements MissionService {

    private MissionRepository missionRepository;
    private ModelMapper modelMapper;

    @Override
    public MissionDTO createMission(MissionDTO missionDTO) {
        Mission mission = modelMapper.map(missionDTO,Mission.class);
        Mission savedMission = missionRepository.save(mission);
        return modelMapper.map(savedMission, MissionDTO.class);
    }

    @Override
    public MissionDTO getMissionById(UUID missionId) {
        Optional<Mission> optionalMission = missionRepository.findById(missionId);
        if (optionalMission.isPresent()){
            Mission mission = optionalMission.get();
            return modelMapper.map(mission, MissionDTO.class);
        }else throw new RessourceNotFoundException(missionId, Mission.class.getName());
    }

    @Override
    public List<MissionDTO> getAllMissions() {
        List<Mission> missions = missionRepository.findAll();
        return missions.stream().map((mission) -> modelMapper.map(mission, MissionDTO.class)).collect(Collectors.toList());
    }

    @Override
    public MissionDTO updateMission(MissionDTO missionDTO) {
        Mission mission = new Mission();
        Optional<Mission> optionalMission = missionRepository.findById(missionDTO.getId());
        if (optionalMission.isPresent()){
            mission = optionalMission.get();
        }else throw new RessourceNotFoundException(missionDTO.getId(),Mission.class.getName());
        mission.setTitle(missionDTO.getTitle());
        mission.setDescription(missionDTO.getDescription());

        Mission updateMission = missionRepository.save(mission);
        return modelMapper.map(mission,MissionDTO.class);
    }

    @Override
    public void deleteMission(UUID missionId) {
        missionRepository.deleteById(missionId);
    }
}
