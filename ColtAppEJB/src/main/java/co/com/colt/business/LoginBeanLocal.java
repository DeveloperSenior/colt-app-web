package co.com.colt.business;

import co.com.colt.dto.UsuarioDTO;
import co.com.colt.utilities.ColtException;


public interface LoginBeanLocal {
	
	/**
	 * login
	 * @param json
	 * @return
	 * @throws ColtException
	 */
	public UsuarioDTO login(UsuarioDTO json)throws ColtException;

}
