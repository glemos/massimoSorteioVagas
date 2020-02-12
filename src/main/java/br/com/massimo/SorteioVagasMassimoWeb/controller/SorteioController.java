/**
 * 
 */
package br.com.massimo.SorteioVagasMassimoWeb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.massimo.SorteioVagasMassimoWeb.dto.ErroApiDTO;
import br.com.massimo.SorteioVagasMassimoWeb.dto.VagaDTO;
import br.com.massimo.SorteioVagasMassimoWeb.service.SorteioService;

/**
 * @author zsnw
 *
 */
@RestController
@RequestMapping("/sorteio")
public class SorteioController {
	
	@Autowired
	SorteioService sorteioService;
	
	
	@GetMapping("")
	public ResponseEntity<Object> lista() {
		ResponseEntity<Object> responseEntity = null;
		
		try {
			List<VagaDTO> vagaDTO = sorteioService.lista();

			responseEntity = new ResponseEntity<>(vagaDTO, HttpStatus.OK	);

		} catch (Exception e) {
			responseEntity = new ResponseEntity<>(
					new ErroApiDTO(HttpStatus.INTERNAL_SERVER_ERROR, e.getLocalizedMessage(), e.getLocalizedMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return responseEntity;
	}

}
