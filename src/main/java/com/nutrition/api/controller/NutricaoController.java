package com.nutrition.api.controller;

import com.nutrition.api.requests.CadastrarAlimentoRequest;
import com.nutrition.api.domain.Alimento;
import com.nutrition.api.domain.Receita;
import com.nutrition.api.requests.CadastrarReceitaRequest;
import com.nutrition.api.service.NutricaoService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/nutrition")
public class NutricaoController {

    private final NutricaoService nutricaoService;

    public NutricaoController(NutricaoService nutricaoService){
        this.nutricaoService = nutricaoService;
    }

    @PostMapping("/food")
    public void cadastrarAlimento(@Valid @RequestBody CadastrarAlimentoRequest request){
        nutricaoService.cadastrarAlimento(request);
    };
    @GetMapping("/food")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<Alimento> listarAlimentos() {
        return nutricaoService.listarAlimentos();
    }

    @GetMapping("/food/{charOrWord}")
    public List<Alimento> listarAlimentosBuscados(@PathVariable String charOrWord) {
        return nutricaoService.listarAlimentosBuscados(charOrWord);
    }

    @PostMapping("/recipe")
    public void cadastrarReceita(@Valid @RequestBody CadastrarReceitaRequest request){
        nutricaoService.cadastrarReceita(request);
    };
    @GetMapping("/recipe")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<Receita> listarReceitas() {
        return nutricaoService.listarReceitas();
    }

}
