package co.com.colt.services;

import javax.ws.rs.core.Response;

import co.com.colt.dto.UsuarioDTO;
import co.com.colt.services.base.ColtResponseBase;
import co.com.colt.session.DelegateContextEJB;

public class ColtLoginServices extends ColtResponseBase implements IColtLoginServices{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Response login(UsuarioDTO login) {
		return getResponse(DelegateContextEJB.getLoginBean().login(login));
	}
	
	

}
