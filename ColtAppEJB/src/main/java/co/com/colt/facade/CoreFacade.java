package co.com.colt.facade;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import co.com.colt.dao.CoreDAO;
import co.com.colt.dto.CiudadDTO;
import co.com.colt.dto.PerfilDTO;
import co.com.colt.dto.RutaDTO;
import co.com.colt.dto.UsuarioDTO;
import co.com.colt.dto.VehiculoDTO;
import co.com.colt.utilities.ColtConstant;
import co.com.colt.utilities.ColtException;

@Stateless(name = "CoreFacade",
mappedName = "ejb/CoreFacade")
public class CoreFacade implements CoreFacadeLocal {
	
	private static final Logger logger = Logger.getLogger(ColtConstant.LOGGER_NAME);
	private CoreDAO dao;

	@Override
	public RutaDTO grabarRuta(RutaDTO ruta) throws ColtException {
		dao = new CoreDAO();
		try {
			return dao.grabarRuta(ruta);
		} catch (SQLException e) {
			ColtException ex = new ColtException(e.getMessage());
			ex.setStackTrace(e.getStackTrace());
			logger.error(e.getMessage(),e);
			throw ex;
		}
	}

	@Override
	public RutaDTO actualizarRuta(RutaDTO ruta) throws ColtException {
		dao = new CoreDAO();
		try {
			return dao.actualizarRuta(ruta);
		} catch (SQLException e) {
			ColtException ex = new ColtException(e.getMessage());
			ex.setStackTrace(e.getStackTrace());
			logger.error(e.getMessage(),e);
			throw ex;
		}
	}

	@Override
	public RutaDTO eliminarRuta(RutaDTO ruta) throws ColtException {
		dao = new CoreDAO();
		try {
			return dao.eliminarRuta(ruta);
		} catch (SQLException e) {
			ColtException ex = new ColtException(e.getMessage());
			ex.setStackTrace(e.getStackTrace());
			logger.error(e.getMessage(),e);
			throw ex;
		}
	}

	@Override
	public List<RutaDTO> consultarRuta(RutaDTO ruta) throws ColtException {
		dao = new CoreDAO();
		try {
			return dao.consultarRuta(ruta);
		} catch (SQLException e) {
			ColtException ex = new ColtException(e.getMessage());
			ex.setStackTrace(e.getStackTrace());
			logger.error(e.getMessage(),e);
			throw ex;
		}
	}

	@Override
	public VehiculoDTO grabarVehiculo(VehiculoDTO vehiculo)
			throws ColtException {
		dao = new CoreDAO();
		try {
			return dao.grabarVehiculo(vehiculo);
		} catch (SQLException e) {
			ColtException ex = new ColtException(e.getMessage());
			ex.setStackTrace(e.getStackTrace());
			logger.error(e.getMessage(),e);
			throw ex;
		}
	}

	@Override
	public VehiculoDTO actualizarVehiculo(VehiculoDTO vehiculo)
			throws ColtException {
		dao = new CoreDAO();
		try {
			return dao.actualizarVehiculo(vehiculo);
		} catch (SQLException e) {
			ColtException ex = new ColtException(e.getMessage());
			ex.setStackTrace(e.getStackTrace());
			logger.error(e.getMessage(),e);
			throw ex;
		}
	}

	@Override
	public VehiculoDTO eliminarVehiculo(VehiculoDTO vehiculo) throws ColtException {
		dao = new CoreDAO();
		try {
			return dao.eliminarVehiculo(vehiculo);
		} catch (SQLException e) {
			ColtException ex = new ColtException(e.getMessage());
			ex.setStackTrace(e.getStackTrace());
			logger.error(e.getMessage(),e);
			throw ex;
		}
	}

	@Override
	public List<VehiculoDTO> consultarVehiculo(VehiculoDTO vehiculo)
			throws ColtException {
		dao = new CoreDAO();
		try {
			return dao.consultarVehiculo(vehiculo);
		} catch (SQLException e) {
			ColtException ex = new ColtException(e.getMessage());
			ex.setStackTrace(e.getStackTrace());
			logger.error(e.getMessage(),e);
			throw ex;
		}
	}

	@Override
	public UsuarioDTO grabarUsuario(UsuarioDTO usuario) throws ColtException {
		dao = new CoreDAO();
		try {
			return dao.grabarUsuario(usuario);
		} catch (SQLException e) {
			ColtException ex = new ColtException(e.getMessage());
			ex.setStackTrace(e.getStackTrace());
			logger.error(e.getMessage(),e);
			throw ex;
		}
	}

	@Override
	public UsuarioDTO actualizarUsuario(UsuarioDTO usuario)
			throws ColtException {
		return null;
	}

	@Override
	public List<UsuarioDTO> consultarUsuario(UsuarioDTO usuario)
			throws ColtException {
		dao = new CoreDAO();
		try {
			return dao.consultarUsuario(usuario);
		} catch (SQLException e) {
			ColtException ex = new ColtException(e.getMessage());
			ex.setStackTrace(e.getStackTrace());
			logger.error(e.getMessage(),e);
			throw ex;
		}
	}

	@Override
	public PerfilDTO grabarPerfil(PerfilDTO perfil) throws ColtException {
		dao = new CoreDAO();
		try {
			return dao.grabarPerfil(perfil);
		} catch (SQLException e) {
			ColtException ex = new ColtException(e.getMessage());
			ex.setStackTrace(e.getStackTrace());
			logger.error(e.getMessage(),e);
			throw ex;
		}
	}

	@Override
	public PerfilDTO actualizarPerfil(PerfilDTO perfil) throws ColtException {
		dao = new CoreDAO();
		try {
			return dao.actualizarPerfil(perfil);
		} catch (SQLException e) {
			ColtException ex = new ColtException(e.getMessage());
			ex.setStackTrace(e.getStackTrace());
			logger.error(e.getMessage(),e);
			throw ex;
		}
	}

	@Override
	public List<PerfilDTO> consultarPerfil(PerfilDTO perfil)
			throws ColtException {
		dao = new CoreDAO();
		try {
			return dao.consultarPerfil(perfil);
		} catch (SQLException e) {
			ColtException ex = new ColtException(e.getMessage());
			ex.setStackTrace(e.getStackTrace());
			logger.error(e.getMessage(),e);
			throw ex;
		}
	}

	@Override
	public CiudadDTO grabarCiudad(CiudadDTO ciudad) throws ColtException {
		dao = new CoreDAO();
		try {
			return dao.grabarCiudad(ciudad);
		} catch (SQLException e) {
			ColtException ex = new ColtException(e.getMessage());
			ex.setStackTrace(e.getStackTrace());
			logger.error(e.getMessage(),e);
			throw ex;
		}
	}

	@Override
	public CiudadDTO actualizarCiudad(CiudadDTO ciudad) throws ColtException {
		dao = new CoreDAO();
		try {
			return dao.actualizarCiudad(ciudad);
		} catch (SQLException e) {
			ColtException ex = new ColtException(e.getMessage());
			ex.setStackTrace(e.getStackTrace());
			logger.error(e.getMessage(),e);
			throw ex;
		}
	}

	@Override
	public CiudadDTO eliminarCiudad(CiudadDTO ciudad) throws ColtException {
		dao = new CoreDAO();
		try {
			return dao.eliminarCiudad(ciudad);
		} catch (SQLException e) {
			ColtException ex = new ColtException(e.getMessage());
			ex.setStackTrace(e.getStackTrace());
			logger.error(e.getMessage(),e);
			throw ex;
		}
	}

	@Override
	public List<CiudadDTO> consultarCiudad(CiudadDTO ciudad)
			throws ColtException {
		dao = new CoreDAO();
		try {
			return dao.consultarCiudad(ciudad);
		} catch (SQLException e) {
			ColtException ex = new ColtException(e.getMessage());
			ex.setStackTrace(e.getStackTrace());
			logger.error(e.getMessage(),e);
			throw ex;
		}
	}
	
	
}
