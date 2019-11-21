package co.com.colt.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.com.colt.dto.CiudadDTO;
import co.com.colt.dto.PerfilDTO;
import co.com.colt.dto.RutaDTO;
import co.com.colt.dto.UsuarioDTO;
import co.com.colt.dto.VehiculoDTO;
import co.com.colt.utilities.ColtConnection;
import co.com.colt.utilities.ColtProperties;

public class CoreDAO extends ColtConnection {

	private final ColtProperties propiedades;

	public CoreDAO() {
		super();
		propiedades = new ColtProperties();
	}

	public RutaDTO grabarRuta(RutaDTO ruta) throws SQLException {
        Connection con = null;
        PreparedStatement ps =  null;
        RutaDTO respuesta = null;
        try{
         con = getConnection();
         ps =  con.prepareStatement(propiedades.getString("RutaMdl.crear"));
         ps.setString(1, ruta.getCodigo());
         ps.setString(2, ruta.getDescripcion());
         ps.setInt(3, ruta.getDestino().getIdCiudad());
         ps.setInt(4, ruta.getOrigen().getIdCiudad());
         ps.setDate(5, new Date(new java.util.Date().getTime()));
         ps.executeUpdate();
         respuesta = ruta;
        }finally{
            closeResources(con, ps);
        }
        return respuesta;
    }

    public RutaDTO actualizarRuta(RutaDTO ruta) throws SQLException {
                Connection con = null;
        PreparedStatement ps =  null;
        RutaDTO respuesta = null;
        try{
        
         con = getConnection();
         ps =  con.prepareStatement(propiedades.getString("RutaMdl.actualizar"));
         ps.setString(1, ruta.getDescripcion());
         ps.setInt(2, ruta.getDestino().getIdCiudad());
         ps.setInt(3, ruta.getOrigen().getIdCiudad());
         ps.executeUpdate();
         respuesta = ruta;
        }finally{
            closeResources(con, ps);
        }
        return respuesta;
    }
    
        public RutaDTO eliminarRuta(RutaDTO ruta) throws SQLException {
                Connection con = null;
        PreparedStatement ps =  null;
        RutaDTO respuesta = null;
        try{
        
         con = getConnection();
         ps =  con.prepareStatement(propiedades.getString("RutaMdl.eliminar"));
         ps.setInt(1, ruta.getIdRuta());
         ps.executeUpdate();
         respuesta = ruta;
        }finally{
            closeResources(con, ps);
        }
        return respuesta;
    }
    
    public List<RutaDTO> consultarRuta(RutaDTO ruta) throws SQLException{
        ArrayList<RutaDTO> respuesta = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps =  null;
        ResultSet rs = null;
        try{
         con = getConnection();
         ps =  con.prepareStatement(propiedades.getString("RutaMdl.consultar"));
         ps.setString(1, ruta.getCodigo());
         rs = ps.executeQuery();
         if(rs != null){
             while(rs.next()){
                 RutaDTO rutar = new RutaDTO();
                 rutar.setIdRuta(rs.getInt("idRuta"));
                 rutar.setCodigo(rs.getString("codigo"));
                 rutar.setDescripcion(rs.getString("descripcion"));
                 CiudadDTO origen = new CiudadDTO();
                 origen.setIdCiudad(rs.getInt("idCiudadOrigen"));
                 origen.setNombre(rs.getString("ciudadOrigen"));
                 rutar.setOrigen(origen);
                 CiudadDTO destino = new CiudadDTO();
                 destino.setIdCiudad(rs.getInt("idCiudadDestino"));
                 destino.setNombre(rs.getString("ciudadDestino"));
                 rutar.setDestino(destino);
                 respuesta.add(rutar);
             }
         }
        }finally{
            closeResources(con, ps, rs);
        }
        return respuesta;
    }
    
    
    public VehiculoDTO grabarVehiculo(VehiculoDTO vehiculo) throws SQLException {
        Connection con = null;
        PreparedStatement ps =  null;
        VehiculoDTO respuesta = null;
        try{
        
         con = getConnection();
         ps =  con.prepareStatement(propiedades.getString("VehiculoMdl.crear"));
         ps.setString(1, vehiculo.getPlaca());
         ps.setString(2, vehiculo.getModelo());
         ps.setInt(3, vehiculo.getCapacidad());
         ps.setString(4, vehiculo.getSeguro());
         ps.setString(5, vehiculo.getActivo());
         ps.setDate(6, new Date(new java.util.Date().getTime()));
         ps.executeUpdate();
         respuesta = vehiculo;
        }finally{
            closeResources(con, ps);
        }
        return respuesta;
    }

    public VehiculoDTO actualizarVehiculo(VehiculoDTO vehiculo) throws SQLException {
                Connection con = null;
        PreparedStatement ps =  null;
        VehiculoDTO respuesta = null;
        try{
        
         con = getConnection();
         ps =  con.prepareStatement(propiedades.getString("VehiculoMdl.actualizar"));
         ps.setString(1, vehiculo.getPlaca());
         ps.setString(2, vehiculo.getModelo());
         ps.setInt(3, vehiculo.getCapacidad());
         ps.setString(4, vehiculo.getSeguro());
         ps.setString(5, vehiculo.getActivo());
         ps.setInt(6, vehiculo.getIdVehiculo());
         ps.executeUpdate();
         respuesta = vehiculo;
        }finally{
            closeResources(con, ps);
        }
        return respuesta;
    }
    
        public VehiculoDTO eliminarVehiculo(VehiculoDTO vehiculo) throws SQLException {
                Connection con = null;
        PreparedStatement ps =  null;
        VehiculoDTO respuesta = null;
        try{
        
         con = getConnection();
         ps =  con.prepareStatement(propiedades.getString("VehiculoMdl.eliminar"));
         ps.setInt(1, vehiculo.getIdVehiculo());
         ps.executeUpdate();
         respuesta = vehiculo;
        }finally{
            closeResources(con, ps);
        }
        return respuesta;
    }
    
    public List<VehiculoDTO> consultarVehiculo(VehiculoDTO vehiculo) throws SQLException{
        ArrayList<VehiculoDTO> respuesta = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps =  null;
        ResultSet rs = null;
        try{
         con = getConnection();
         ps =  con.prepareStatement(propiedades.getString("VehiculoMdl.consultar"));
         ps.setString(1, vehiculo.getPlaca());
         ps.setString(2, vehiculo.getModelo());
         ps.setInt(3, vehiculo.getCapacidad());
         ps.setString(4, vehiculo.getSeguro());
         ps.setString(5, "S");
         rs = ps.executeQuery();
         if(rs != null){
             while(rs.next()){
                 VehiculoDTO vehiculor = new VehiculoDTO();
                 vehiculor.setIdVehiculo(rs.getInt("idVehiculo"));
                 vehiculor.setPlaca(rs.getString("placa"));
                 vehiculor.setModelo(rs.getString("modelo"));
                 vehiculor.setCapacidad(rs.getInt("capacidad"));
                 vehiculor.setSeguro(rs.getString("seguro"));
                 vehiculor.setActivo(rs.getString("activo"));
                 respuesta.add(vehiculor);
             }
         }
        }finally{
            closeResources(con, ps, rs);
        }
        return respuesta;
    }
    
    public UsuarioDTO grabarUsuario(UsuarioDTO usuario) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        UsuarioDTO respuesta = null;
        try {

            con = getConnection();
            ps = con.prepareStatement(propiedades.getString("UsuarioMdl.crear"));
            ps.setString(1, usuario.getLogin());
            ps.setString(2, usuario.getClave());
            ps.setString(3, "S");
            ps.setDate(4, new java.sql.Date(new java.util.Date().getTime()));
            ps.setString(5, usuario.getCedula());
            ps.setString(6, usuario.getNombre());
            ps.setString(7, usuario.getApellido());
            ps.setString(8, usuario.getTelefono());
            ps.setString(9, usuario.getSexo());
            ps.setDate(10, new java.sql.Date(usuario.getFechaNacimiento().getTime()));
            ps.executeUpdate();
            respuesta = consultarUsuario(usuario).get(0);
            grabarUsuarioxPerfil(respuesta);
        } finally {
            closeResources(con, ps);
        }
        return respuesta;
    }

    private void grabarUsuarioxPerfil(UsuarioDTO usuario) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = getConnection();
            ps = con.prepareStatement(propiedades.getString("UsuarioMdl.crearUsuarioPerfil"));
            ps.setInt(1, usuario.getIdUsuario());
            ps.setInt(2, usuario.getPerfil().getIdPerfil());
            ps.executeUpdate();
        } finally {
            closeResources(con, ps);
        }
    }

    public List<UsuarioDTO> consultarUsuario(UsuarioDTO usuario) throws SQLException {
        ArrayList<UsuarioDTO> respuesta = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            con = getConnection();
            ps = con.prepareStatement(propiedades.getString("UsuarioMdl.consultar"));
            ps.setString(1, "S");
            ps.setString(2, usuario.getCedula());
            rs = ps.executeQuery();
                while (rs.next()) {
                    UsuarioDTO usuarior = new UsuarioDTO();
                    usuarior.setIdUsuario(rs.getInt("idUsuario"));
                    usuarior.setCedula(rs.getString("cedula"));
                    usuarior.setNombre(rs.getString("nombre"));
                    usuarior.setApellido(rs.getString("apellido"));
                    usuarior.setLogin(rs.getString("login"));
                    usuarior.setTelefono(rs.getString("telefono"));
                    usuarior.setSexo(rs.getString("sexo"));
                    PerfilDTO perfil = new PerfilDTO();
                    perfil.setIdPerfil(rs.getInt("idPerfil"));
                    usuarior.setPerfil(perfil);
                    Date fechaN = rs.getDate("fechaNacimiento");
                    if (fechaN != null) {
                        usuarior.setFechaNacimiento(new Date(fechaN.getTime()));
                    }
                    respuesta.add(usuarior);
                }
        } finally {
            closeResources(con, ps, rs);
        }

        return respuesta;
    }

    public PerfilDTO grabarPerfil(PerfilDTO perfil) throws SQLException {
        Connection con = null;
        PreparedStatement ps =  null;
        PerfilDTO respuesta = null;
        try{
        
         con = getConnection();
         ps =  con.prepareStatement(propiedades.getString("PerfilMdl.crear"));
         ps.setString(1, perfil.getNombre());
         ps.setString(2, perfil.getActivo());
         ps.setDate(3, new Date(new java.util.Date().getTime()));
         ps.executeUpdate();
         respuesta = perfil;
        }finally{
            closeResources(con, ps);
        }
        return respuesta;
    }

    public PerfilDTO actualizarPerfil(PerfilDTO perfil) throws SQLException {
                Connection con = null;
        PreparedStatement ps =  null;
        PerfilDTO respuesta = null;
        try{
        
         con = getConnection();
         ps =  con.prepareStatement(propiedades.getString("PerfilMdl.actualizar"));
         ps.setString(1, perfil.getNombre());
         ps.setString(2, perfil.getActivo());
         ps.setInt(3, perfil.getIdPerfil());
         ps.executeUpdate();
         respuesta = perfil;
        }finally{
            closeResources(con, ps);
        }
        return respuesta;
    }
    
    public List<PerfilDTO> consultarPerfil(PerfilDTO perfil) throws SQLException{
        ArrayList<PerfilDTO> respuesta = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps =  null;
        ResultSet rs = null;
        try{
         con = getConnection();
         ps =  con.prepareStatement(propiedades.getString("PerfilMdl.consultar"));
         ps.setString(1, "S");
         ps.setString(2, perfil.getNombre());
         ps.setInt(3, perfil.getIdPerfil());
         rs = ps.executeQuery();
         if(rs != null){
             while(rs.next()){
                 PerfilDTO perfilr = new PerfilDTO();
                 perfilr.setIdPerfil(rs.getInt("idPerfil"));
                 perfilr.setNombre(rs.getString("nombrePerfil"));
                 perfilr.setActivo(rs.getString("activo"));
                 respuesta.add(perfilr);
             }
         }
        }finally{
            closeResources(con, ps, rs);
        }
        return respuesta;
    }
    
    
    public CiudadDTO grabarCiudad(CiudadDTO ciudad) throws SQLException {
        Connection con = null;
        PreparedStatement ps =  null;
        CiudadDTO respuesta = null;
        try{
        
         con = getConnection();
         ps =  con.prepareStatement(propiedades.getString("CiudadMdl.crear"));
         ps.setString(1, ciudad.getNombre());
         ps.setString(2, ciudad.getDepartamento());
         ps.setString(3, ciudad.getPais());
         ps.setDate(4, new Date(new java.util.Date().getTime()));
         ps.executeUpdate();
         respuesta = ciudad;
        }finally{
            closeResources(con, ps);
        }
        return respuesta;
    }

    public CiudadDTO actualizarCiudad(CiudadDTO ciudad) throws SQLException {
                Connection con = null;
        PreparedStatement ps =  null;
        CiudadDTO respuesta = null;
        try{
        
         con = getConnection();
         ps =  con.prepareStatement(propiedades.getString("CiudadMdl.actualizar"));
         ps.setString(1, ciudad.getNombre());
          ps.setString(2, ciudad.getDepartamento());
         ps.setString(3, ciudad.getPais());
         ps.setInt(4, ciudad.getIdCiudad());
         ps.executeUpdate();
         respuesta = ciudad;
        }finally{
            closeResources(con, ps);
        }
        return respuesta;
    }
    
        public CiudadDTO eliminarCiudad(CiudadDTO ciudad) throws SQLException {
                Connection con = null;
        PreparedStatement ps =  null;
        CiudadDTO respuesta = null;
        try{
        
         con = getConnection();
         ps =  con.prepareStatement(propiedades.getString("CiudadMdl.eliminar"));
         ps.setInt(1, ciudad.getIdCiudad());
         ps.executeUpdate();
         respuesta = ciudad;
        }finally{
            closeResources(con, ps);
        }
        return respuesta;
    }
    
    public List<CiudadDTO> consultarCiudad(CiudadDTO ciudad) throws SQLException{
        ArrayList<CiudadDTO> respuesta = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps =  null;
        ResultSet rs = null;
        try{
         con = getConnection();
         ps =  con.prepareStatement(propiedades.getString("CiudadMdl.consultar"));
         ps.setString(1, ciudad.getNombre());
        ps.setString(2, ciudad.getDepartamento());
         ps.setString(3, ciudad.getPais());
         ps.setInt(4, ciudad.getIdCiudad());
         rs = ps.executeQuery();
         if(rs != null){
             while(rs.next()){
                 CiudadDTO ciudadr = new CiudadDTO();
                 ciudadr.setIdCiudad(rs.getInt("idCiudad"));
                 ciudadr.setNombre(rs.getString("nombre"));
                 ciudadr.setDepartamento(rs.getString("departamento"));
                 ciudadr.setPais(rs.getString("pais"));
                 respuesta.add(ciudadr);
             }
         }
        }finally{
            closeResources(con, ps, rs);
        }
        return respuesta;
    }



}
