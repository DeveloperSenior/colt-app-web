package co.com.colt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import co.com.colt.dto.UsuarioDTO;
import co.com.colt.utilities.ColtConnection;
import co.com.colt.utilities.ColtProperties;

public class LoginDAO extends ColtConnection {

	private final ColtProperties propiedades;

	public LoginDAO() {
		super();
		propiedades = new ColtProperties();
	}

	public UsuarioDTO login(UsuarioDTO login) throws SQLException {
		UsuarioDTO respuesta = new UsuarioDTO();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			con = getConnection();
			ps = con.prepareStatement(propiedades.getString("LoginMdl.login"));
			ps.setString(1, login.getLogin());
			ps.setString(2, login.getClave());
			ps.setString(3, "S");
			rs = ps.executeQuery();

			while (rs.next()) {
				respuesta.setIdUsuario(rs.getInt("idusuario"));
				respuesta.setCedula(rs.getString("cedula"));
				respuesta.setNombre(rs.getString("nombre"));
				respuesta.setApellido(rs.getString("apellido"));
			}

		} finally {
			closeResources(con, ps, rs);
		}

		return respuesta;
	}

}
