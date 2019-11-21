package co.com.colt.session;

import co.com.colt.business.CoreBeanLocal;
import co.com.colt.business.LoginBeanLocal;
import co.com.colt.facade.CoreFacadeLocal;
import co.com.colt.facade.LoginFacadeLocal;

public class DelegateContextEJB extends ColtContextLookUp{
	
	/**
	 * Business Bean
	 */
	
	private static LoginBeanLocal getLoginBean;
	private static CoreBeanLocal getCoreBean;
	
	
	/**
	 * Instancia unica (singelton)  del bean de LoginBean
	 * 
	 * @return
	 */
	public static synchronized LoginBeanLocal getLoginBean() {

		if (getLoginBean == null) {
			getLoginBean = (LoginBeanLocal) getColtContext("LoginBean");
		}

		return getLoginBean;
	}
	
	/**
	 * Instancia unica (singelton)  del bean de CoreBean
	 * 
	 * @return
	 */
	public static synchronized CoreBeanLocal getCoreBean() {

		if (getCoreBean == null) {
			getCoreBean = (CoreBeanLocal) getColtContext("CoreBean");
		}

		return getCoreBean;
	}
	
	
	
	
	/**
	 * Facade Bean
	 */
	
	private static LoginFacadeLocal getLoginFacade;
	private static CoreFacadeLocal getCoreFacade;
	
	/**
	 * Instancia unica (singelton) de la facade getLoginFacade
	 * @return
	 */
	public static synchronized LoginFacadeLocal getLoginFacade() {

		if (getLoginFacade == null) {
			getLoginFacade = (LoginFacadeLocal) getColtContext("LoginFacade");
		}

		return getLoginFacade;
	}
	
	/**
	 * Instancia unica (singelton) de la facade getCoreFacade
	 * @return
	 */
	public static synchronized CoreFacadeLocal getCoreFacade() {

		if (getCoreFacade == null) {
			getCoreFacade = (CoreFacadeLocal) getColtContext("CoreFacade");
		}

		return getCoreFacade;
	}


	

}
