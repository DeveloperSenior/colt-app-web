package co.com.colt.business;

import javax.ejb.Stateless;

import co.com.colt.dto.UsuarioDTO;
import co.com.colt.facade.LoginFacadeLocal;
import co.com.colt.session.ColtContextLookUp;
import co.com.colt.session.DelegateContextEJB;
import co.com.colt.utilities.ColtException;

@Stateless(name = "LoginBean",
mappedName = "ejb/LoginBean")
public class LoginBean extends ColtContextLookUp implements LoginBeanLocal {
	
	private LoginFacadeLocal facade;
	
	/**
	 * Default constructor
	 */
	public LoginBean(){
		facade = DelegateContextEJB.getLoginFacade();
	}
	
	@Override
	public UsuarioDTO login(UsuarioDTO json) throws ColtException {
		return facade.login(json);
	}
	
}
