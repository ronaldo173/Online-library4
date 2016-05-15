package ua.ronaldo173.library.web.controllers;

import ua.ronaldo173.library.web.beans.Genre;
import ua.ronaldo173.library.web.db.Database;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

@ManagedBean(eager = true)
@ApplicationScoped
public class GenreController implements Serializable {

    private ArrayList<Genre> genreList;

    public GenreController() {
        fillGenresAll();
    }

    private void fillGenresAll() {
        Statement stmt = null;
        ResultSet rs = null;
        Connection conn = null;

        genreList = new ArrayList<Genre>();

        try {
            conn = Database.getConnection();

            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from genre order by name");
            while (rs.next()) {
                Genre genre = new Genre();
                genre.setName(rs.getString("name"));
                genre.setId(rs.getLong("id"));
                genreList.add(genre);
            }

        } catch (SQLException ex) {
            Logger.getLogger(GenreController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (rs != null) {
                    rs.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(GenreController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public ArrayList<Genre> getGenreList() {
        return genreList;
    }

    public static void main(String[] args) {
        System.out.println(1);
        System.out.println(2);
        System.out.println(3);
        System.out.println(5);

        ArrayList<Genre> genreList = new GenreController().getGenreList();
        for (Genre genre : genreList) {
            System.out.println(genre);
        }
    }
}
