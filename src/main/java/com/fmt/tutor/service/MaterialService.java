package com.fmt.tutor.service;

import com.fmt.tutor.exception.ResourceNotFoundException;
import com.fmt.tutor.model.MaterialModel;
import com.fmt.tutor.repository.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MaterialService {

    private final MaterialRepository materialRepository;

    @Autowired
    public MaterialService(MaterialRepository materialRepository) {
        this.materialRepository = materialRepository;
    }

    public MaterialModel criarMaterial(MaterialModel material) {
        return materialRepository.save(material);
    }

    public ArrayList<MaterialModel> listarTodosOsMateriais() {
        return (ArrayList<MaterialModel>) materialRepository.findAll();
    }

    public Optional<MaterialModel> buscarMaterialPorId(Integer id) {
        if (!materialRepository.existsById(id)) {
            throw new ResourceNotFoundException("Material não encontrado.");
        }
        return materialRepository.findById(id);
    }

    public MaterialModel atualizarMaterial(Integer id, MaterialModel materialAtualizado) {
        if (materialRepository.existsById(id)) {
            return materialRepository.save(materialAtualizado);
        } else {
            throw new ResourceNotFoundException("Id do material não encontrado.");
        }
    }

    public void deletarMaterialPorId(Integer id) {
        if (!materialRepository.existsById(id)) {
            throw new ResourceNotFoundException("Id do material não encontrado.");
        }
        materialRepository.deleteById(id);
    }
}
