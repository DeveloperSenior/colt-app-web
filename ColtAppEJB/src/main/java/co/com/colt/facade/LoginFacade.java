package co.com.colt.facade;

import java.sql.SQLException;

import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import co.com.colt.dao.LoginDAO;
import co.com.colt.dto.UsuarioDTO;
import co.com.colt.utilities.ColtConstant;
import co.com.colt.utilities.ColtException;

@Stateless(name = "LoginFacade",
mappedName = "ejb/LoginFacade")
public class LoginFacade implements LoginFacadeLocal {
	
	private static final Logger logger = Logger.getLogger(ColtConstant.LOGGER_NAME);
	
	@Override
	public UsuarioDTO login(UsuarioDTO login) throws ColtException {
		LoginDAO dao = new LoginDAO();
		try {
			return dao.login(login);
		} catch (SQLException e) {
			ColtException ex = new ColtException(e.getMessage());
			ex.setStackTrace(e.getStackTrace());
			logger.error(e.getMessage(),e);
			throw ex;
		}
	}
	
}
