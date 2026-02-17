package org.example.dao;

import org.example.connection.Conexao;
import org.example.model.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    //CREATE
    public void inserir(Produto produto) throws SQLException {

        String sql = "INSERT INTO produtos (nome, preco) VALUES (?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPreco());
            stmt.executeUpdate();
        }
    }

    //ROAD
    public List<Produto> listar() throws SQLException {

        String sql = "SELECT * FROM produtos";
        List<Produto> lista = new ArrayList<>();

        try (Connection conn = Conexao.conectar();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setPreco(rs.getDouble("preco"));

                lista.add(produto);
            }
        }

        return lista;
    }

    //UPDATE
    public void atualizar(Produto produto) throws SQLException {

        String sql = "UPDATE produtos SET nome =?, preco =? WHERE id =?";

        try (Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPreco());
            stmt.setInt(3, produto.getId());
            stmt.executeUpdate();
        }
    }

    //DELETAR
    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM produtos WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
