package com.gruppe4.boredoom.backend.spring.repository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

public abstract class Repository {

    protected final String url;
    private final String username;
    private final String password;

    protected Repository(String url,
             String username,
             String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public <T> List<T> executeSql(String sqlSelect, Function<ResultSet, T> transformationAction){

        List<T> resultList = new LinkedList<>();

        try (var connection = DriverManager.getConnection(url, username, password); PreparedStatement statement =
                connection.prepareStatement(sqlSelect)) {

            var resultSet = statement.executeQuery();

            while (resultSet.next()){
                var resultObject = transformationAction.apply(resultSet);
                resultList.add(resultObject);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return resultList;
    }
}
