package com.nutriapp.api.controller;

import com.nutriapp.api.domain.Cliente;
import com.nutriapp.api.domain.nutricao.Alimento;
import com.nutriapp.api.domain.nutricao.Receita;
import com.nutriapp.api.domain.nutricao.Refeicao;
import com.nutriapp.api.requests.CadastrarAlimentoRequest;
import com.nutriapp.api.requests.CadastrarClienteRequest;
import com.nutriapp.api.requests.CadastrarReceitaRequest;
import com.nutriapp.api.service.NutricaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/nutricao")
public class NutricaoController {

    private final NutricaoService nutricaoService;

    public NutricaoController(NutricaoService nutricaoService){
        this.nutricaoService = nutricaoService;
    }

    @PostMapping("/alimento/cadastrar")
    public void cadastrarAlimento(@Valid @RequestBody CadastrarAlimentoRequest request){
        nutricaoService.cadastrarAlimento(request);
    };
    @GetMapping("/alimentos")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<Alimento> listarAlimentos() {
        return nutricaoService.listarAlimentos();
    }

    @GetMapping("/alimentos/{charOrWord}")
    public List<Alimento> listarAlimentosBuscados(@PathVariable String charOrWord) {
        return nutricaoService.listarAlimentosBuscados(charOrWord);
    }

    @PostMapping("/receita/cadastrar")
    public void cadastrarReceita(@Valid @RequestBody CadastrarReceitaRequest request){
        nutricaoService.cadastrarReceita(request);
    };
    @GetMapping("/receitas")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<Receita> listarReceitas() {
        return nutricaoService.listarReceitas();
    }

}
