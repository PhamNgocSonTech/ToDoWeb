package com.demo.imple;

import com.demo.beans.ToDo;
import com.demo.connection.ConnectionUtils;
import com.demo.dao.ToDoDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ToDoDaoImpl implements ToDoDao {

    private static final String INSERT_TODO_SQL = "insert into ToDos (title, username, detail, targetDate, statusDo) values\n" +
            "(?, ?, ?, ?, ?)";
    private static final String SELECT_TODO_BY_ID = "select * from ToDos where id = ?\n";
    private static final String SELECT_ALL_TODO = "select * from ToDos\n";
    private static final String DELETE_TODO = "delete from ToDos where id = ?";
    private static final String UPDATE_TODO = "update ToDos set title = ?, username = ?, detail = ?, \n" +
            "targetDate = ?, statusDo = ? where id = ?";
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public ToDoDaoImpl() {

    }

    @Override
    public void insertToDo(ToDo toDo) throws SQLException {
        try {
            System.out.println(INSERT_TODO_SQL);
            conn = ConnectionUtils.getConnection();
            ps = conn.prepareStatement(INSERT_TODO_SQL);
            ps.setString(1, toDo.getTitle());
            ps.setString(2, toDo.getUsername());
            ps.setString(3, toDo.getDetail());
            ps.setDate(4, ConnectionUtils.getSqlDate(toDo.getTargetDate()));
            ps.setBoolean(5, toDo.isStatusDo());
            ps.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ToDo selectToDo(int id) {
        try {
            conn = ConnectionUtils.getConnection();
            ps = conn.prepareStatement(SELECT_TODO_BY_ID);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                ToDo toDo = new ToDo(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getDate(5).toLocalDate(),
                        rs.getBoolean(6));
                return toDo;
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ToDo> selectAllToDo() {
        List<ToDo> toDoList = new ArrayList<>();
        try {
            conn = ConnectionUtils.getConnection();
            ps = conn.prepareStatement(SELECT_ALL_TODO);
            rs = ps.executeQuery();
            while (rs.next()) {
                ToDo toDo = new ToDo(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getDate(5).toLocalDate(),
                        rs.getBoolean(6));
                toDoList.add(toDo);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return toDoList;
    }

    @Override
    public boolean deleteToDo(int id) throws SQLException {
        boolean rowDelete = false;
        try {
            conn = ConnectionUtils.getConnection();
            ps = conn.prepareStatement(DELETE_TODO);
            ps.setInt(1, id);
            rowDelete = ps.executeUpdate() > 0;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return rowDelete;
    }

    @Override
    public boolean updateToDo(ToDo toDo) throws SQLException {
        boolean rowUpdate = false;
        int i = 0;
        try {
            conn = ConnectionUtils.getConnection();
            ps = conn.prepareStatement(UPDATE_TODO);

            ps.setString(1, toDo.getTitle());
            ps.setString(2, toDo.getUsername());
            ps.setString(3, toDo.getDetail());
            ps.setDate(4, ConnectionUtils.getSqlDate(toDo.getTargetDate()));
            ps.setBoolean(5, toDo.isStatusDo());
            ps.setInt(6, toDo.getId());
            rowUpdate = ps.executeUpdate() > 0;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return rowUpdate;
    }
}
