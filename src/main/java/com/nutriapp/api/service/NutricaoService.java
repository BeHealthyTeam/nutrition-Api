package com.nutriapp.api.service;

import com.nutriapp.api.domain.Cliente;
import com.nutriapp.api.domain.nutricao.Alimento;
import com.nutriapp.api.domain.nutricao.Receita;
import com.nutriapp.api.domain.nutricao.Refeicao;
import com.nutriapp.api.mapper.ClienteMapper;
import com.nutriapp.api.mapper.nutricao.AlimentoMapper;
import com.nutriapp.api.mapper.nutricao.ReceitaMapper;
import com.nutriapp.api.repository.AlimentoMongoTemplateRepository;
import com.nutriapp.api.repository.AlimentoRepository;
import com.nutriapp.api.repository.ReceitaRepository;
import com.nutriapp.api.repository.RefeicaoRepository;
import com.nutriapp.api.requests.CadastrarAlimentoRequest;
import com.nutriapp.api.requests.CadastrarClienteRequest;
import com.nutriapp.api.requests.CadastrarReceitaRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class NutricaoService {

    @Autowired
    private AlimentoRepository alimentoRepository;

    @Autowired
    private ReceitaRepository receitaRepository;

    @Autowired
    private RefeicaoRepository refeicaoRepository;

    @Autowired
    private AlimentoMongoTemplateRepository alimentoMongoTemplateRepository;

    public void cadastrarAlimento(CadastrarAlimentoRequest request) {
        Alimento alimento = AlimentoMapper.toAlimento(request);
        alimentoRepository.save(alimento);

    }
    public List<Alimento> listarAlimentos() {
        return alimentoRepository.findAll();
    }
    public void cadastrarReceita(CadastrarReceitaRequest request) {
        Receita receita = ReceitaMapper.toReceita(request);
        receitaRepository.save(receita);
    }

    public List<Receita> listarReceitas() {
        return receitaRepository.findAll();
    }

     public List<Alimento> listarAlimentosBuscados(String charOrWord) {

        List<Alimento> alimentos = alimentoMongoTemplateRepository.findAllByName(charOrWord);

        return alimentos;
    }

}
