package ru.savam.todolist.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.savam.todolist.model.Task;


import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TaskDAOImpl implements TaskDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public TaskDAOImpl(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void saveOrUpdate(Task task) {
        if (task.getTask_id() > 0){ //TODO: not null
            String sql = "UPDATE task SET description=?, create_date=?" +
                    "due_date=?, done=? WHERE task_id=?";
            jdbcTemplate.update(sql,task.getDescription(), task.getCreate_date(),
                    task.getDue_date(), task.getDone(), task.getTask_id());
        }else {
            String sql = "INSERT INTO task (description, create_date," +
                    " due_date) VALUES (?,?,?,?)";
            jdbcTemplate.update(sql, task.getDescription(), task.getCreate_date(),
                    task.getDue_date(), task.getDone());
        }

    }

    @Override
    public void delete(int taskId) {
        String sql = "DELETE FROM task WHERE task_id=?";
        jdbcTemplate.update(sql, taskId);
    }

    @Override
    public Task get(int taskId) {
        String sql = "SELECT * FROM task WHERE task_id=" + taskId;
        return jdbcTemplate.query(sql, new ResultSetExtractor<Task>() {
            @Override
            public Task extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                if (resultSet.next()){
                    Task task = new Task();

                    task.setTask_id(resultSet.getInt("task_id"));
                    task.setDescription(resultSet.getString("description"));
                    task.setCreate_date(resultSet.getDate("create_date"));
                    task.setDue_date(resultSet.getDate("due_date"));
                    task.setDone(resultSet.getBoolean("done"));
                    return task;
                }
                return null;
            }
        });

    }

    @Override
    public List<Task> list() {
        String sql = "SELECT * FROM task";
        List<Task> listTask = jdbcTemplate.query(sql, new RowMapper<Task>(){
            public Task mapRow(ResultSet rs, int rowNum) throws SQLException {
                Task task = new Task();

             //   task.setTask_id(rs.getInt("task_id")); //TODO: list without id
                task.setDescription(rs.getString("description"));
                task.setCreate_date(rs.getDate("create_date"));
                task.setDue_date(rs.getDate("due_date"));
                task.setDone(rs.getBoolean("done"));

                return task;
            }
        });

        return listTask;
    }
}
