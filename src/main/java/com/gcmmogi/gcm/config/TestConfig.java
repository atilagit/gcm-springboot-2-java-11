package com.gcmmogi.gcm.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.gcmmogi.gcm.entities.Bairro;
import com.gcmmogi.gcm.entities.BoletimOcorrencia;
import com.gcmmogi.gcm.entities.Endereco;
import com.gcmmogi.gcm.entities.Envolvido;
import com.gcmmogi.gcm.entities.Ocorrencia;
import com.gcmmogi.gcm.entities.Oficial;
import com.gcmmogi.gcm.entities.RG;
import com.gcmmogi.gcm.entities.VeiculoAveriguado;
import com.gcmmogi.gcm.entities.enums.CondicaoDaParte;
import com.gcmmogi.gcm.entities.enums.Dano;
import com.gcmmogi.gcm.entities.enums.Posto;
import com.gcmmogi.gcm.repositories.BairroRepository;
import com.gcmmogi.gcm.repositories.BoletimOcorrenciaRepository;
import com.gcmmogi.gcm.repositories.EnvolvidoRepository;
import com.gcmmogi.gcm.repositories.OcorrenciaRepository;
import com.gcmmogi.gcm.repositories.OficialRepository;
import com.gcmmogi.gcm.repositories.VeiculoAveriguadoRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private OficialRepository oficialRepository;
	
	@Autowired
	private BoletimOcorrenciaRepository boletimOcorrenciaRepository;
	
	@Autowired
	private EnvolvidoRepository envolvidoRepository;
	
	@Autowired
	private BairroRepository bairroRepository;
	
	@Autowired
	private OcorrenciaRepository ocorrenciaRepository;
	
	@Autowired
	private VeiculoAveriguadoRepository veiculoAveriguadoRepository;

	@Override
	public void run(String... args) throws Exception {

		Envolvido env1 = new Envolvido(null, CondicaoDaParte.AUTOR, true, "Ze Lorota", Instant.parse("1980-06-20T19:53:07Z"), "pai do ze", "mae do ze", "Brasileiro", "teste cidade1", "SP", "1988554477", "Açougue", "teste de versao do envolvido1");
		Envolvido env2 = new Envolvido(null, CondicaoDaParte.INDICIADO, true, "Joaquim do bar", Instant.parse("1981-06-20T19:53:07Z"), "pai do joaquim", "mae do joaquim", "Brasileiro", "teste cidade2", "SP", "1999554477", "Padaria", "teste de versao do envolvido2");
		Envolvido env3 = new Envolvido(null, CondicaoDaParte.PEDESTRE, false, "Mariazinha Silva", Instant.parse("1982-06-20T19:53:07Z"), "pai da maria", "mae da maria", "Brasileiro", "teste cidade3", "SP", "1911554477", "Garçonete", "teste de versao do envolvido3");
		Envolvido env4 = new Envolvido(null, CondicaoDaParte.VITIMA, false, "Luquinha Junior", Instant.parse("1983-06-20T19:53:07Z"), "pai do lucas", "mae do lucas", "Brasileiro", "teste cidade4", "SP", "1922554477", null, "teste de versao do envolvido4");
		Envolvido env5 = new Envolvido(null, CondicaoDaParte.INDEFINIDA, true, "Joao Doido", Instant.parse("1984-06-20T19:53:07Z"), "pai do joao", "mae do joao", "Brasileiro", "teste cidade5", "SP", "1933554477", "Bombeiro", "teste de versao do envolvido5");
		
		
		envolvidoRepository.saveAll(Arrays.asList(env1, env2, env3, env4, env5));
		
		RG rg1 = new RG(null, "41.106.298-11", "SSP", "SP", env1);
		RG rg2 = new RG(null, null, null, null, env2);
		RG rg3 = new RG(null, "43.207.298-13", "SSP", "SP", env3);
		RG rg4 = new RG(null, "", null, "", env4);
		RG rg5 = new RG(null, "45.308.298-15", "SSP", "SP", env5);
		
		Endereco end1 = new Endereco(null, "Teste residencia1", 21, "Teste bairro1", "Teste Cidade1", "SP", "Teste complemento1", env1);
		Endereco end2 = new Endereco(null, null, null, null, null, null, null, env2);
		Endereco end3 = new Endereco(null, "Teste residencia3", 23, "Teste bairro3", "Teste Cidade3", "PA", "Teste complemento3", env3);
		Endereco end4 = new Endereco(null, "", 24, "", null, null, "Teste complemento4", env4);
		Endereco end5 = new Endereco(null, "Teste residencia3", 25, "Teste bairro3", "Teste Cidade5", "RS", "Teste complemento5", env5);
		
		env1.setRg(rg1);
		env2.setRg(rg2);
		env3.setRg(rg3);
		env4.setRg(rg4);
		env5.setRg(rg5);
		
		env1.setEndereco(end1);
		env2.setEndereco(end2);
		env3.setEndereco(end3);
		env4.setEndereco(end4);
		env5.setEndereco(end5);
		
		envolvidoRepository.saveAll(Arrays.asList(env1, env2, env3, env4, env5));
		
		Oficial o1 = new Oficial(null, "juca88", "321", "Juca", "Time-B", 6, Posto.EM_CAMPO, "juca@hotmail.com");
		Oficial o2 = new Oficial(null, "marco87", "222", "Marco", "Time-C", 8, Posto.ADMINISTRATIVO, "marco@gmail.com");
		
		Bairro b1 = new Bairro (null, "Aterrado");
		Bairro b2 = new Bairro (null, "Bairro Boa");
		Bairro b3 = new Bairro (null, "Cdhu");
		Bairro b4 = new Bairro (null, "Centro");
		Bairro b5 = new Bairro (null, "Chácara Ipe");
		Bairro b6 = new Bairro (null, "Chácara São Marcelo");
		Bairro b7 = new Bairro (null, "Chácara Sol Nascente");
		Bairro b8 = new Bairro (null, "Cob Brasil Cerealist");
		Bairro b9 = new Bairro (null, "Comeca Piteiras");
		Bairro b10 = new Bairro (null, "Condomínio Morro Vermelho");
		Bairro b11 = new Bairro (null, "Condomínio Santa Úrsula");
		Bairro b12 = new Bairro (null, "Conjunto Habitacional Jardim Europa");
		Bairro b13 = new Bairro (null, "Conjunto Residencial Anselmo Lopes Bueno");
		Bairro b14 = new Bairro (null, "Distrito Industrial");
		Bairro b15 = new Bairro (null, "Distrito Industrial II");
		
		bairroRepository.saveAll(Arrays.asList(b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15));
		
		Ocorrencia oc1 =new Ocorrencia(null, "A01", " HOMICÍDIO");
		Ocorrencia oc2 =new Ocorrencia(null, "A03", " TENTATIVA DE HOMICÍDIO");
		Ocorrencia oc3 =new Ocorrencia(null, "A04", " ABORTO");
		Ocorrencia oc4 =new Ocorrencia(null, "A05", " LESÃO CORPORAL");
		Ocorrencia oc5 =new Ocorrencia(null, "A06", " INFANTICÍDIO");
		Ocorrencia oc6 =new Ocorrencia(null, "A07", " PERCLITAÇÃO DE VIDA");
		Ocorrencia oc7 =new Ocorrencia(null, "A08", " ABANDONA DE INCAPAZ");
		Ocorrencia oc8 =new Ocorrencia(null, "A09", " OMISSÃO DE SOCORRO");
		Ocorrencia oc9 =new Ocorrencia(null, "A10", " AMEAÇA");
		Ocorrencia oc10 =new Ocorrencia(null, "A11", " SEQUESTRO / CÁRCERE PRIVADO");
		Ocorrencia oc11 =new Ocorrencia(null, "A12", " VIOLAÇÃO DE DOMICÍLIO");
		Ocorrencia oc12 =new Ocorrencia(null, "A13", " MAUS TRATOS");
		Ocorrencia oc13 =new Ocorrencia(null, "A14", " RACISMO");
		Ocorrencia oc14 =new Ocorrencia(null, "B01", " FURTO");
		Ocorrencia oc15 =new Ocorrencia(null, "B03", " TENTATIVA DE FURTO");
		
		ocorrenciaRepository.saveAll(Arrays.asList(oc1,oc2,oc3,oc4,oc5,oc6,oc7,oc8,oc9,oc10,oc11,oc12,oc13,oc14,oc15));
		
		VeiculoAveriguado va1 = new VeiculoAveriguado(null, "DRP8D42", "Palio", 2005, "Preto", "00485601956", Dano.GRANDE_MONTA);
		VeiculoAveriguado va2 = new VeiculoAveriguado(null, "FOR-1904", "Ford/fiesta", 2015, "Vermelho", "00409674956", Dano.PEQUENA_MONTA);
		VeiculoAveriguado va3 = new VeiculoAveriguado(null, "HMG-4587", "Uno", 2019, "Branco", "00499406756", Dano.PEQUENA_MONTA);
		
		veiculoAveriguadoRepository.saveAll(Arrays.asList(va1,va2,va3));
		
		BoletimOcorrencia bo1 = new BoletimOcorrencia(null, 4, Instant.parse("2020-06-20T19:53:07Z"), Instant.parse("2020-06-20T19:53:07Z"), 1, 10, Instant.parse("2020-06-20T19:53:07Z"), Instant.parse("2020-06-20T19:53:07Z"), Instant.parse("2020-06-20T19:53:07Z"), Instant.parse("2020-06-20T19:53:07Z"), 11256, 11260, 11260, 11260, "local teste", "Relatorio teste", o1, b4);
		BoletimOcorrencia bo2 = new BoletimOcorrencia(null, 5, Instant.parse("2020-06-20T19:53:07Z"), Instant.parse("2020-06-20T19:53:07Z"), 2, 11, Instant.parse("2020-06-20T19:53:07Z"), Instant.parse("2020-06-20T19:53:07Z"), Instant.parse("2020-06-20T19:53:07Z"), Instant.parse("2020-06-20T19:53:07Z"), 11256, 11260, 11260, 11260, "local teste", "Relatorio teste", o2, b1);
		BoletimOcorrencia bo3 = new BoletimOcorrencia(null, 6, Instant.parse("2020-06-20T19:53:07Z"), Instant.parse("2020-06-20T19:53:07Z"), 3, 12, Instant.parse("2020-06-20T19:53:07Z"), Instant.parse("2020-06-20T19:53:07Z"), Instant.parse("2020-06-20T19:53:07Z"), Instant.parse("2020-06-20T19:53:07Z"), 11256, 11260, 11260, 11260, "local teste", "Relatorio teste", o1, b4);
		BoletimOcorrencia bo4 = new BoletimOcorrencia(null, 7, Instant.parse("2020-06-20T19:53:07Z"), Instant.parse("2020-06-20T19:53:07Z"), 3, 12, Instant.parse("2020-06-20T19:53:07Z"), Instant.parse("2020-06-20T19:53:07Z"), Instant.parse("2020-06-20T19:53:07Z"), Instant.parse("2020-06-20T19:53:07Z"), 11256, 11260, 11260, 11260, "local teste", "Relatorio teste", o1, b4);
		BoletimOcorrencia bo5 = new BoletimOcorrencia(null, 4, Instant.parse("2020-06-20T19:53:07Z"), Instant.parse("2020-06-20T19:53:07Z"), 1, 10, Instant.parse("2020-06-20T19:53:07Z"), Instant.parse("2020-06-20T19:53:07Z"), Instant.parse("2020-06-20T19:53:07Z"), Instant.parse("2020-06-20T19:53:07Z"), 11256, 11260, 11260, 11260, "local teste", "Relatorio teste", o1, b1);
		BoletimOcorrencia bo6 = new BoletimOcorrencia(null, 5, Instant.parse("2020-06-20T19:53:07Z"), Instant.parse("2020-06-20T19:53:07Z"), 2, 11, Instant.parse("2020-06-20T19:53:07Z"), Instant.parse("2020-06-20T19:53:07Z"), Instant.parse("2020-06-20T19:53:07Z"), Instant.parse("2020-06-20T19:53:07Z"), 11256, 11260, 11260, 11260, "local teste", "Relatorio teste", o2, b14);
		
		oficialRepository.saveAll(Arrays.asList(o1, o2));
		boletimOcorrenciaRepository.saveAll(Arrays.asList(bo1, bo2, bo3, bo4, bo5, bo6));
		
		bo1.getVeiculos().add(va2);
		bo2.getVeiculos().add(va1);
		bo2.getVeiculos().add(va3);
		
		bo1.getOcorrencias().add(oc1);
		bo1.getOcorrencias().add(oc3);
		bo2.getOcorrencias().add(oc2);
		bo3.getOcorrencias().add(oc1);
		bo3.getOcorrencias().add(oc2);
		bo3.getOcorrencias().add(oc3);
		
		bo1.getEnvolvidos().add(env1);
		bo1.getEnvolvidos().add(env2);
		bo2.getEnvolvidos().add(env3);
		bo2.getEnvolvidos().add(env4);
		bo3.getEnvolvidos().add(env5);
		
		boletimOcorrenciaRepository.saveAll(Arrays.asList(bo1, bo2, bo3));
	}
}
