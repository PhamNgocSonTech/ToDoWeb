package com.demo.dao;

import com.demo.beans.ToDo;

import java.sql.SQLException;
import java.util.*;

public interface ToDoDao {
    void insertToDo(ToDo toDo) throws SQLException;
    ToDo selectToDo(int id);
    List<ToDo> selectAllToDo();
    boolean deleteToDo(int id) throws SQLException;
    boolean updateToDo(ToDo toDo) throws SQLException;
}
