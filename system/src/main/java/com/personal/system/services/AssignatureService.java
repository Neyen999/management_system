package com.personal.system.services;

//import com.asaplibs.errorHandling.exception.CustomException;
import com.personal.system.dtos.AssignatureDto;
import com.personal.system.models.Assignature;
import com.personal.system.repositories.AssignatureRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AssignatureService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private AssignatureRepository assignatureRepository;

    @Transactional
    public AssignatureDto saveAssignature(AssignatureDto request) {
        Assignature assignature = modelMapper.map(request, Assignature.class);

        assignatureRepository.save(assignature);

        return modelMapper.map(assignature, AssignatureDto.class);
    }

    public List<AssignatureDto> getAllAssignatures() {
        List<AssignatureDto> assignatures = assignatureRepository
                .findAll()
                .stream()
                .map(assignature -> modelMapper.map(assignature, AssignatureDto.class))
                .collect(Collectors.toList());
        return assignatures;
    }

    public Assignature findById(Long id) {
//        Assignature assignature = assignatureRepository.findById(id).orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND, "Assignature not found", ""));
        Assignature assignature = assignatureRepository.findById(id).orElseThrow(() -> new RuntimeException("Assignature not found"));

        return assignature;
    }

    public AssignatureDto getAssignature(Long id) {
        Assignature assignature = findById(id);

        return modelMapper.map(assignature, AssignatureDto.class);
    }
}
