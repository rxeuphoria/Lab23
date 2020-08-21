package co.grandcircus.springlab23.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import co.grandcircus.springlab23.entity.Grade;

@Repository
public class GradeDao {

	@Autowired
	private JdbcTemplate jdbc;

	public List<Grade> findAll() {
		String sql = "SELECT * FROM grade";
		// RowMapper converts SQL table results to Room objects, matching the field
		// names.
		return jdbc.query(sql, new BeanPropertyRowMapper<>(Grade.class));
	}

	// ? leaves a blank parameter to fill in later. NOT ACTUALLY BLANK.
	public Grade findById(Long id) {
		String sql = "SELECT * FROM grade WHERE id=?";
		// .queryForObject returns a single object (like a row of values)
		return jdbc.queryForObject(sql, new BeanPropertyRowMapper<>(Grade.class), id);
		// the id at the end of the queryForObject is the ? that gets filled in.
	}

	public void create(Grade grade) {
		String sql = "INSERT INTO `grade` (name, type, score, total) VALUES (?,?,?,?);";
		// update used for any table mods
		// the values for ? params are specified at the end.
		jdbc.update(sql, grade.getName(), grade.getType(), grade.getScore(), grade.getTotal());
	}

	public void update(Grade grade) {
		String sql = "UPDATE grade SET name=?, type=?, score=?, total=? WHERE id=?";
		jdbc.update(sql, grade.getName(), grade.getType(), grade.getScore(), grade.getTotal());
	}

	public void delete(Long id) {
		String sql = "DELETE FROM grade WHERE id =?";
		jdbc.update(sql, id);
	}
}
