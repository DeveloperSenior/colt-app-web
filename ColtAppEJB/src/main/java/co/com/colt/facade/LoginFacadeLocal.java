package co.com.colt.facade;

import co.com.colt.dto.UsuarioDTO;
import co.com.colt.utilities.ColtException;


public interface LoginFacadeLocal {
	
	/**
	 * getUserValidate
	 * @param login
	 * @return
	 * @throws ColtException
	 */
	public UsuarioDTO login(UsuarioDTO login)throws ColtException;

}
