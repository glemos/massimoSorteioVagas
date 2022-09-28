/**
 * 
 */
package br.com.massimo.SorteioVagasMassimoWeb.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import br.com.massimo.SorteioVagasMassimoWeb.dto.VagaDTO;

/**
 * Classe de serviço de Sorteio.
 * 
 * @author Gustavo Codeço
 *
 */
@Service
public class SorteioService {

	public List<VagaDTO> lista() {

		List<String> aptosFrente = new ArrayList<String>();
		List<String> aptosLateralFrente = new ArrayList<String>();
		List<String> aptosLateralTras = new ArrayList<String>();
		List<String> aptosTras = new ArrayList<String>();

		List<String> vagasTipoAFrente = new ArrayList<String>();
		List<String> vagasTipoBFrente = new ArrayList<String>();
		List<String> vagasTipoATras = new ArrayList<String>();
		List<String> vagasTipoBTras = new ArrayList<String>();

		List<VagaDTO> listaVagas = new ArrayList<>();

		// Adiciono os aptos
		this.adicionaAptosFrente(aptosFrente);
		this.adicionaAptosLateralFrente(aptosLateralFrente);
		this.adicionaAptosTras(aptosTras);
		this.adicionaAptosLateralTras(aptosLateralTras);

		// Adiciono Vaga
		this.adicionaVagasTipoAFrente(vagasTipoAFrente);
		this.adicionaVagasTipoATras(vagasTipoATras);
		this.adicionaVagasTipoBFrente(vagasTipoBFrente);
		this.adicionaVagasTipoBTras(vagasTipoBTras);

		for (int i = 0; i < aptosFrente.size(); i++) {
			VagaDTO vaga = new VagaDTO();
			vaga.setApto(aptosFrente.get(i));
			vaga.setVaga(this.sorteio(vagasTipoBFrente, vagasTipoBTras));
			listaVagas.add(vaga);

		}

		for (int i = 0; i < aptosLateralFrente.size(); i++) {
			VagaDTO vaga = new VagaDTO();
			vaga.setApto(aptosLateralFrente.get(i));
			vaga.setVaga(this.sorteio(vagasTipoAFrente, vagasTipoATras));
			listaVagas.add(vaga);

		}
		
		adicionaVagasTipoB2SubsoloTras(vagasTipoBTras);

		for (int i = 0; i < aptosTras.size(); i++) {
			VagaDTO vaga = new VagaDTO();
			vaga.setApto(aptosTras.get(i));
			vaga.setVaga(this.sorteio(vagasTipoBTras, vagasTipoBFrente));
			listaVagas.add(vaga);

		}

		for (int i = 0; i < aptosLateralTras.size(); i++) {
			VagaDTO vaga = new VagaDTO();
			vaga.setApto(aptosLateralTras.get(i));
			vaga.setVaga(this.sorteio(vagasTipoATras, vagasTipoAFrente));
			listaVagas.add(vaga);
		}

		listaVagas.sort((p1, p2) -> p1.getApto().compareTo(p2.getApto()));

		return listaVagas;

	}

	// Método que faz o sorteio e retira o item sorteado da lista
	private String sorteio(List<String> lista, List<String> listaOpcional) {
		String retorno = null;
		int posicao = -1;
		try {
			Random rand = new Random(System.nanoTime());
			if (lista.size() > 0) {
				posicao = rand.nextInt(lista.size());
				retorno = lista.get(posicao);
				lista.remove(posicao);
			} else {
				if (listaOpcional.size() > 0) {
					posicao = rand.nextInt(listaOpcional.size());
					retorno = listaOpcional.get(posicao);
					listaOpcional.remove(posicao);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return retorno;

	}

	// 31Aptos
	private void adicionaAptosFrente(List<String> aptosFrente) {

		aptosFrente.add("101");
		aptosFrente.add("102");
		aptosFrente.add("103");
		aptosFrente.add("104");

		aptosFrente.add("201");
		aptosFrente.add("202");
		aptosFrente.add("203");
		aptosFrente.add("204");

		aptosFrente.add("301");
		aptosFrente.add("302");
		aptosFrente.add("303");
		aptosFrente.add("304");

		aptosFrente.add("401");
		aptosFrente.add("402");
		aptosFrente.add("403");
		aptosFrente.add("404");

		aptosFrente.add("501");
		aptosFrente.add("502");
		aptosFrente.add("503");
		aptosFrente.add("504");

		aptosFrente.add("601");
		aptosFrente.add("602");
		aptosFrente.add("603");
		aptosFrente.add("604");
		aptosFrente.add("612");

		aptosFrente.add("701");
		aptosFrente.add("702");
		aptosFrente.add("703");
		aptosFrente.add("704");
		aptosFrente.add("705");
		aptosFrente.add("712");

		Collections.shuffle(aptosFrente);

	}

	// 12 Aptos
	private void adicionaAptosLateralFrente(List<String> aptosLateralFrente) {

		aptosLateralFrente.add("605");
		aptosLateralFrente.add("105");
		aptosLateralFrente.add("112");
		aptosLateralFrente.add("205");
		aptosLateralFrente.add("212");
		aptosLateralFrente.add("305");
		aptosLateralFrente.add("312");
		aptosLateralFrente.add("405");
		aptosLateralFrente.add("412");
		aptosLateralFrente.add("505");
		aptosLateralFrente.add("512");
		aptosLateralFrente.add("605");

		Collections.shuffle(aptosLateralFrente);

	}

	// 11 aptos
	private void adicionaAptosLateralTras(List<String> aptosLateralTras) {

		aptosLateralTras.add("106");
		aptosLateralTras.add("111");
		aptosLateralTras.add("206");
		aptosLateralTras.add("211");
		aptosLateralTras.add("306");
		aptosLateralTras.add("311");
		aptosLateralTras.add("406");
		aptosLateralTras.add("411");
		aptosLateralTras.add("506");
		aptosLateralTras.add("511");
		aptosLateralTras.add("606");

		Collections.shuffle(aptosLateralTras);
	}

	// 31 Aptos
	private void adicionaAptosTras(List<String> aptosTras) {

		aptosTras.add("107");
		aptosTras.add("108");
		aptosTras.add("109");
		aptosTras.add("110");
		aptosTras.add("207");
		aptosTras.add("208");
		aptosTras.add("209");
		aptosTras.add("210");
		aptosTras.add("307");
		aptosTras.add("308");
		aptosTras.add("309");
		aptosTras.add("310");
		aptosTras.add("407");
		aptosTras.add("408");
		aptosTras.add("409");
		aptosTras.add("410");
		aptosTras.add("507");
		aptosTras.add("508");
		aptosTras.add("509");
		aptosTras.add("510");
		aptosTras.add("607");
		aptosTras.add("608");
		aptosTras.add("609");
		aptosTras.add("610");
		aptosTras.add("611");
		aptosTras.add("706");
		aptosTras.add("707");
		aptosTras.add("708");
		aptosTras.add("709");
		aptosTras.add("710");
		aptosTras.add("711");

		Collections.shuffle(aptosTras);

	}

	// 14 Vagas
	private void adicionaVagasTipoAFrente(List<String> vagasTipoAFrente) {

		vagasTipoAFrente.add("Acesso - 8");
		vagasTipoAFrente.add("Acesso - 9");
		vagasTipoAFrente.add("Acesso - 10");
		vagasTipoAFrente.add("Acesso - 11");
		vagasTipoAFrente.add("Acesso - 12");
		vagasTipoAFrente.add("Acesso - 13");
		vagasTipoAFrente.add("Acesso - 14");
		vagasTipoAFrente.add("Acesso - 15");
		vagasTipoAFrente.add("Acesso - 16");
		vagasTipoAFrente.add("Acesso - 17");
		vagasTipoAFrente.add("Acesso - 18");
		vagasTipoAFrente.add("Acesso - 19");
		vagasTipoAFrente.add("Acesso - 20");
		vagasTipoAFrente.add("Acesso - 21");
		Collections.shuffle(vagasTipoAFrente);

	}

	// 30 Vagas
	private void adicionaVagasTipoBFrente(List<String> vagasTipoBFrente) {

		vagasTipoBFrente.add("Acesso - 1");
		vagasTipoBFrente.add("Acesso - 2");
		vagasTipoBFrente.add("Acesso - 3");
		vagasTipoBFrente.add("Acesso - 4");
		vagasTipoBFrente.add("Acesso - 5");
		vagasTipoBFrente.add("Acesso - 6");
		vagasTipoBFrente.add("1 Subsolo - 1");
		vagasTipoBFrente.add("1 Subsolo - 2");
		vagasTipoBFrente.add("1 Subsolo - 3");
		vagasTipoBFrente.add("1 Subsolo - 4");
		vagasTipoBFrente.add("1 Subsolo - 5");
		vagasTipoBFrente.add("1 Subsolo - 6");
		vagasTipoBFrente.add("1 Subsolo - 7");
		vagasTipoBFrente.add("1 Subsolo - 8");
		vagasTipoBFrente.add("1 Subsolo - 9");
		vagasTipoBFrente.add("1 Subsolo - 10");
		vagasTipoBFrente.add("1 Subsolo - 11");
		vagasTipoBFrente.add("1 Subsolo - 12");
		vagasTipoBFrente.add("1 Subsolo - 13");
		vagasTipoBFrente.add("1 Subsolo - 14");
		vagasTipoBFrente.add("1 Subsolo - 15");
		vagasTipoBFrente.add("1 Subsolo - 16");
		vagasTipoBFrente.add("1 Subsolo - 17");
		vagasTipoBFrente.add("1 Subsolo - 18");
		vagasTipoBFrente.add("1 Subsolo - 19");
		vagasTipoBFrente.add("1 Subsolo - 20");
		vagasTipoBFrente.add("1 Subsolo - 21");
		vagasTipoBFrente.add("1 Subsolo - 22");
		vagasTipoBFrente.add("1 Subsolo - 23");

		Collections.shuffle(vagasTipoBFrente);
	}

	// 9 Vagas
	private void adicionaVagasTipoATras(List<String> vagasTipoATras) {

		vagasTipoATras.add("1 Subsolo - 46");
		vagasTipoATras.add("1 Subsolo - 47");
		vagasTipoATras.add("1 Subsolo - 48");
		vagasTipoATras.add("1 Subsolo - 49");
		vagasTipoATras.add("1 Subsolo - 50");
		vagasTipoATras.add("2 Subsolo - 10");
		vagasTipoATras.add("2 Subsolo - 11");
		vagasTipoATras.add("2 Subsolo - 12");
		vagasTipoATras.add("2 Subsolo - 13");

		Collections.shuffle(vagasTipoATras);
	}

	// 32 Vagas
	private void adicionaVagasTipoBTras(List<String> vagasTipoBTras) {
		vagasTipoBTras.add("Acesso - 7");
		vagasTipoBTras.add("1 Subsolo - 24");
		vagasTipoBTras.add("1 Subsolo - 25");
		vagasTipoBTras.add("1 Subsolo - 26");
		vagasTipoBTras.add("1 Subsolo - 27");
		vagasTipoBTras.add("1 Subsolo - 28");
		vagasTipoBTras.add("1 Subsolo - 29");
		vagasTipoBTras.add("1 Subsolo - 30");
		vagasTipoBTras.add("1 Subsolo - 31");
		vagasTipoBTras.add("1 Subsolo - 32");
		vagasTipoBTras.add("1 Subsolo - 33");
		vagasTipoBTras.add("1 Subsolo - 34");
		vagasTipoBTras.add("1 Subsolo - 35");
		vagasTipoBTras.add("1 Subsolo - 36");
		vagasTipoBTras.add("1 Subsolo - 37");
		vagasTipoBTras.add("1 Subsolo - 38");
		vagasTipoBTras.add("1 Subsolo - 39");
		vagasTipoBTras.add("1 Subsolo - 40");
		vagasTipoBTras.add("1 Subsolo - 41");
		vagasTipoBTras.add("1 Subsolo - 42");
		vagasTipoBTras.add("1 Subsolo - 43");
		vagasTipoBTras.add("1 Subsolo - 44");
		vagasTipoBTras.add("1 Subsolo - 45");
//		vagasTipoBTras.add("2 Subsolo - 1");
//		vagasTipoBTras.add("2 Subsolo - 2");
//		vagasTipoBTras.add("2 Subsolo - 3");
//		vagasTipoBTras.add("2 Subsolo - 4");
//		vagasTipoBTras.add("2 Subsolo - 5");
//		vagasTipoBTras.add("2 Subsolo - 6");
//		vagasTipoBTras.add("2 Subsolo - 7");
//		vagasTipoBTras.add("2 Subsolo - 8");
//		vagasTipoBTras.add("2 Subsolo - 9");
//		vagasTipoBTras.add("2 Subsolo - 14");

		Collections.shuffle(vagasTipoBTras);

	}

	// 32 Vagas
	private void adicionaVagasTipoB2SubsoloTras(List<String> vagasTipoBTras) {
		vagasTipoBTras.add("2 Subsolo - 1");
		vagasTipoBTras.add("2 Subsolo - 2");
		vagasTipoBTras.add("2 Subsolo - 3");
		vagasTipoBTras.add("2 Subsolo - 4");
		vagasTipoBTras.add("2 Subsolo - 5");
		vagasTipoBTras.add("2 Subsolo - 6");
		vagasTipoBTras.add("2 Subsolo - 7");
		vagasTipoBTras.add("2 Subsolo - 8");
		vagasTipoBTras.add("2 Subsolo - 9");
		vagasTipoBTras.add("2 Subsolo - 14");

		Collections.shuffle(vagasTipoBTras);

	}

}
