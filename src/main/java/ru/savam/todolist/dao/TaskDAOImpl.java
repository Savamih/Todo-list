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
    private TaskSetter taskSetter;

    @Autowired
    public TaskDAOImpl(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void saveOrUpdate(Task task) {
        if (task.getTask_id() > 0){
            String sql = "UPDATE task SET DESCRIPTION=?, DUE_TIME=?," +
                    " ISWASTED=?, ISDONE=? WHERE task_id=?";
            jdbcTemplate.update(sql,task.getDescription(), task.getDue_time(),
                    task.getWasted(), task.getDone(), task.getTask_id());
        }else {
            String sql = "INSERT INTO task (description, DUE_TIME," +
                    " ISWASTED, ISDONE) VALUES (?,?,?,?)";
            jdbcTemplate.update(sql, task.getDescription(), task.getDue_time(),
                    task.getWasted(), task.getDone());
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

                   return taskSetter.taskSet(resultSet);
                }

                return null;
            }
        });

    }

    @Override
    public List<Task> list() {
        String sql = "SELECT * FROM task ORDER BY DUE_TIME";
        List<Task> listTask = jdbcTemplate.query(sql, new RowMapper<Task>(){
            public Task mapRow(ResultSet rs, int rowNum) throws SQLException {

               return taskSetter.taskSet(rs);
            }
        });

        return listTask;
    }
}
