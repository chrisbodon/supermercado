package com.ipartek.formacion.supermercado.modelo.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.ipartek.formacion.supermercado.model.ConnectionManager;
import com.ipartek.formacion.supermercado.modelo.pojo.Categoria;
import com.ipartek.formacion.supermercado.modelo.pojo.Producto;
import com.ipartek.formacion.supermercado.modelo.pojo.Categoria;
import com.ipartek.formacion.supermercado.modelo.pojo.Usuario;

public class CategoriaDAO implements ICategoriaDAO {

	private final static Logger LOG = Logger.getLogger(CategoriaDAO.class);

	private static CategoriaDAO INSTANCE;

	private CategoriaDAO() {
		super();
	}

	public static synchronized CategoriaDAO getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new CategoriaDAO();
		}

		return INSTANCE;
	}

	/**
	 * Utilidad para mapear un ResultSet a un Categoria
	 * 
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	private Categoria mapper(ResultSet rs) throws SQLException {

		Categoria c = new Categoria();
		c.setId(rs.getInt("id"));
		c.setNombre(rs.getString("nombre"));

		return c;
	}

	@Override
	public List<Categoria> getAll() {
		LOG.trace("Recuperar todas las categorías");
		List<Categoria> registros = new ArrayList<Categoria>();

		try (Connection con = ConnectionManager.getConnection();
				CallableStatement cs = con.prepareCall("{ CALL pa_categoria_getall(); }");) {

			LOG.debug(cs);

			try (ResultSet rs = cs.executeQuery()) {

				// TODO mapper
				while (rs.next()) {

					registros.add(mapper(rs));

				}

			}

		} catch (SQLException e) {
			LOG.error(e);
		}

		return registros;
	}

	@Override
	public Categoria getById(int id) {

		Categoria c = null;

		try (Connection con = ConnectionManager.getConnection();
				CallableStatement cs = con.prepareCall("{ CALL pa_categoria_getbyid(?); }");) {

			// sustituyo parametros en la SQL, ? por id
			cs.setInt(1, id);
			
			LOG.debug(cs);

			// ejecuto la consulta. executeQuery es para SELECT, executeUpdate es para
			// inserts y deletes.
			try (ResultSet rs = cs.executeQuery()) {
				if (rs.next()) {
					c = mapper(rs);
				} else {
					return null;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return c;
	}

	@Override
	public Categoria delete(int id) throws Exception {
		
		Categoria registro = getById(id);
		
		if (registro == null) {
			throw new Exception("Registro no encontrado" + id);
		} 
		
		try (Connection con = ConnectionManager.getConnection();
				CallableStatement cs = con.prepareCall("{ CALL pa_categoria_delete(?); }");) {

			cs.setInt(1, id);

			cs.executeUpdate(); // eliminar

		}
		return registro;
	}

	@Override
	public Categoria update(int id, Categoria pojo) throws Exception {

		Categoria registro = pojo;
		
		try (Connection con = ConnectionManager.getConnection();
				CallableStatement cs = con.prepareCall("{ CALL pa_categoria_update(?,?); }");) {

			cs.setInt(1, id);
			cs.setString(2, pojo.getNombre());
			LOG.debug(cs);

			if (cs.executeUpdate() == 1) {
				pojo.setId(id);
			} else {
				throw new Exception("No se encontro registro para id=" + id);
			}

		}
		return pojo;
	}

	@Override
	public Categoria create(Categoria pojo) throws Exception {
		LOG.trace("Insertar nueva carpeta " + pojo);

		Categoria registro = pojo;

		try (Connection con = ConnectionManager.getConnection();
				CallableStatement cs = con.prepareCall("{ CALL pa_categoria_insert(?,?); }");) {

			// Parámetro de entrada 1º ?
			cs.setString(1, pojo.getNombre());

			// Parámetro de entrada 2º ?
			cs.registerOutParameter(2, java.sql.Types.INTEGER);

			LOG.debug(cs);

			// Ejecutamos el procedimiento almacenado executeUpdate, CUIDADO no es una
			// SELECT => executeQuery
			cs.executeUpdate();

			// Uns vez ejecutado, podemos recuperar el parámetro de salida 2º ?
			pojo.setId(cs.getInt(2));

		}

		return registro;
	}

}
