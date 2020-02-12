/**
 * 
 */
package br.com.massimo.SorteioVagasMassimoWeb.dto;

import java.io.Serializable;

/**
 * DTO da vaga.
 * 
 * @author zsnw
 *
 */
public class VagaDTO implements Serializable {

	/**
	 * Serial UID.
	 */
	private static final long serialVersionUID = -2527301511633882675L;

	/**
	 * número do apartamento.
	 */
	private String apto;

	/**
	 * Local e numero da vaga.
	 */
	private String vaga;

	/**
	 * @return the apto
	 */
	public String getApto() {
		return apto;
	}

	/**
	 * @param apto the apto to set
	 */
	public void setApto(String apto) {
		this.apto = apto;
	}

	/**
	 * @return the vaga
	 */
	public String getVaga() {
		return vaga;
	}

	/**
	 * @param vaga the vaga to set
	 */
	public void setVaga(String vaga) {
		this.vaga = vaga;
	}

}
