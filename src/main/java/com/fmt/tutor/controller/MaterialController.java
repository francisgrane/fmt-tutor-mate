package com.fmt.tutor.controller;

import com.fmt.tutor.model.MaterialModel;
import com.fmt.tutor.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/materiais")
public class MaterialController {

    private final MaterialService materialService;

    @Autowired
    public MaterialController(MaterialService materialService) {
        this.materialService = materialService;
    }

    @GetMapping
    public ResponseEntity<List<MaterialModel>> listarTodosOsMateriais() {
        ArrayList<MaterialModel> materiais = materialService.listarTodosOsMateriais();
        if (materiais.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(materiais);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<MaterialModel> buscarMaterial(@PathVariable Integer id) {
        Optional<MaterialModel> materialOptional = materialService.buscarMaterialPorId(id);
        return materialOptional.map(material -> ResponseEntity.ok().body(material))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<MaterialModel> criarMaterial(@RequestBody MaterialModel material) {
        MaterialModel novoMaterial = materialService.criarMaterial(material);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoMaterial);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MaterialModel> atualizarMaterial(@PathVariable Integer id, @RequestBody MaterialModel materialAtualizado) {
        Optional<MaterialModel> materialOptional = materialService.buscarMaterialPorId(id);
        if (materialOptional.isPresent()) {
            MaterialModel materialAtualizadoSalvo = materialService.atualizarMaterial(materialAtualizado);
            return ResponseEntity.ok(materialAtualizadoSalvo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarMaterial(@PathVariable Integer id) {
        materialService.deletarMaterialPorId(id);
        return ResponseEntity.noContent().build();
    }
}
