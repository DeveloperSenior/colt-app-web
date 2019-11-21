package co.com.colt.services;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import co.com.colt.dto.CiudadDTO;
import co.com.colt.dto.PerfilDTO;
import co.com.colt.dto.RutaDTO;
import co.com.colt.dto.UsuarioDTO;
import co.com.colt.dto.VehiculoDTO;
import co.com.colt.utilities.ColtException;

@Path("/ColtCoreServices")
public interface IColtCoreServices {
	
	
	/**
	 * grabarRuta
	 * @param json
	 * @return
	 * @throws ColtException
	 */
	@POST
	@Path("/grabarRuta")
	@Produces(MediaType.APPLICATION_JSON)
	public Response grabarRuta(RutaDTO ruta)throws ColtException;
	
	/**
	 * actualizarRuta
	 * @param json
	 * @return
	 * @throws ColtException
	 */
	@POST
	@Path("/actualizarRuta")
	@Produces(MediaType.APPLICATION_JSON)
	public Response actualizarRuta(RutaDTO ruta)throws ColtException;
	
	/**
	 * actualizarRuta
	 * @param json
	 * @return
	 * @throws ColtException
	 */
	@POST
	@Path("/eliminarRuta")
	@Produces(MediaType.APPLICATION_JSON)
	public Response eliminarRuta(RutaDTO ruta)throws ColtException;
	
	/**
	 * consultarRuta
	 * @param json
	 * @return
	 * @throws ColtException
	 */
	@POST
	@Path("/consultarRuta")
	@Produces(MediaType.APPLICATION_JSON)
	public Response consultarRuta(RutaDTO ruta)throws ColtException;
	
	
	/**
	 * grabarVehiculo
	 * @param json
	 * @return
	 * @throws ColtException
	 */
	@POST
	@Path("/grabarVehiculo")
	@Produces(MediaType.APPLICATION_JSON)
	public Response grabarVehiculo(VehiculoDTO vehiculo)throws ColtException;
	
	/**
	 * actualizarVehiculo
	 * @param json
	 * @return
	 * @throws ColtException
	 */
	@POST
	@Path("/actualizarVehiculo")
	@Produces(MediaType.APPLICATION_JSON)
	public Response actualizarVehiculo(VehiculoDTO vehiculo)throws ColtException;
	
	/**
	 * eliminarVehiculo
	 * @param json
	 * @return
	 * @throws ColtException
	 */
	@POST
	@Path("/eliminarVehiculo")
	@Produces(MediaType.APPLICATION_JSON)
	public Response eliminarVehiculo(VehiculoDTO vehiculo)throws ColtException;
	
	/**
	 * consultarVehiculo
	 * @param json
	 * @return
	 * @throws ColtException
	 */
	@POST
	@Path("/consultarVehiculo")
	@Produces(MediaType.APPLICATION_JSON)
	public Response consultarVehiculo(VehiculoDTO vehiculo)throws ColtException;
	
	/**
	 * grabarUsuario
	 * @param usuario
	 * @return
	 * @throws ColtException
	 */
	@POST
	@Path("/grabarUsuario")
	@Produces(MediaType.APPLICATION_JSON)
	public Response grabarUsuario(UsuarioDTO usuario)throws ColtException;
	
	/**
	 * grabarUsuario
	 * @param usuario
	 * @return
	 * @throws ColtException
	 */
	@POST
	@Path("/actualizarUsuario")
	@Produces(MediaType.APPLICATION_JSON)
	public Response actualizarUsuario(UsuarioDTO usuario)throws ColtException;
	
	/**
	 * consultarUsuario
	 * @param usuario
	 * @return
	 */
	@POST
	@Path("/consultarUsuario")
	@Produces(MediaType.APPLICATION_JSON)
	public Response consultarUsuario(UsuarioDTO usuario)throws ColtException;
	
	/**
	 * grabarPerfil
	 * @param perfil
	 * @return
	 * @throws ColtException
	 */
	@POST
	@Path("/grabarPerfil")
	@Produces(MediaType.APPLICATION_JSON)
	public Response grabarPerfil(PerfilDTO perfil)throws ColtException;
	
	/**
	 * actualizarPerfil
	 * @param perfil
	 * @return
	 * @throws ColtException
	 */
	@POST
	@Path("/actualizarPerfil")
	@Produces(MediaType.APPLICATION_JSON)
	public Response actualizarPerfil(PerfilDTO perfil) throws ColtException;
	
	/**
	 * consultarPerfil
	 * @param perfil
	 * @return
	 * @throws ColtException
	 */
	@POST
	@Path("/consultarPerfil")
	@Produces(MediaType.APPLICATION_JSON)
	public Response consultarPerfil(PerfilDTO perfil)throws ColtException;
	
	/**
	 * consultarPerfil
	 * @param ciudad
	 * @return
	 * @throws ColtException
	 */
	@POST
	@Path("/grabarCiudad")
	@Produces(MediaType.APPLICATION_JSON)
	public Response grabarCiudad(CiudadDTO ciudad)throws ColtException;
	
	/**
	 * actualizarCiudad
	 * @param ciudad
	 * @return
	 * @throws ColtException
	 */
	@POST
	@Path("/actualizarCiudad")
	@Produces(MediaType.APPLICATION_JSON)
	public Response actualizarCiudad(CiudadDTO ciudad)throws ColtException;
	
	/**
	 * eliminarCiudad
	 * @param ciudad
	 * @return
	 * @throws ColtException
	 */
	@POST
	@Path("/eliminarCiudad")
	@Produces(MediaType.APPLICATION_JSON)
	public Response eliminarCiudad(CiudadDTO ciudad) throws ColtException;
	
	/**
	 * consultarCiudad
	 * @param ciudad
	 * @return
	 * @throws ColtException
	 */
	@POST
	@Path("/consultarCiudad")
	@Produces(MediaType.APPLICATION_JSON)
	public Response consultarCiudad(CiudadDTO ciudad)throws ColtException;
	

}
