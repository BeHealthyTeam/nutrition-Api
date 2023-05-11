package com.nutrition.api.service;

import com.nutrition.api.domain.Alimento;
import com.nutrition.api.domain.Receita;
import com.nutrition.api.mapper.AlimentoMapper;
import com.nutrition.api.mapper.ReceitaMapper;
import com.nutrition.api.repository.AlimentoMongoTemplateRepository;
import com.nutrition.api.repository.AlimentoRepository;
import com.nutrition.api.repository.ReceitaRepository;
import com.nutrition.api.repository.RefeicaoRepository;
import com.nutrition.api.requests.CadastrarAlimentoRequest;
import com.nutrition.api.requests.CadastrarReceitaRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
