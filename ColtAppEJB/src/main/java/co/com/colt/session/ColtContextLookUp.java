package co.com.colt.session;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.log4j.Logger;

import co.com.colt.utilities.ColtConstant;
import co.com.colt.utilities.ColtException;
import co.com.colt.utilities.ColtUtilities;

/**
 * 
 * @author ColtJugle S.A.S
 *
 */
public class ColtContextLookUp {
	
	private static final Logger logger = Logger.getLogger(ColtConstant.LOGGER_NAME);
	

	/**
	 * Obtiene la instancia del contexto del bean ingresado
	 * @param bean
	 * @return
	 */
	public static Object getColtContext(String bean) {
		Object beanContext = null;
		try {
			InitialContext context = new InitialContext();
			beanContext = context.lookup("java:global/"+ColtUtilities.getProperty("ear")+"/"+ColtUtilities.getProperty("ejb")+"/"+bean);
		} catch (NamingException e) {
			logger.debug(e.getMessage(),e);
			ColtException  exception = new ColtException("Error inicializando el contexto del servicio ["+ bean + "]");
			exception.setStackTrace(e.getStackTrace());
			throw exception;
		}
		return beanContext;
	}
	
}
