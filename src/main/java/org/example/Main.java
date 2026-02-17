package org.example;

import org.example.dao.ProdutoDAO;
import org.example.model.Produto;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {

        Produto produto = new Produto("Apple IPhone 16", 5450.00, 2);

        ProdutoDAO dao = new ProdutoDAO();

        for (Produto lista : dao.listar()) {
            System.out.println(lista.getNome() + " | " + lista.getPreco());
        }

        dao.deletar(2); //DELETA O PRODUTO DE ID 2

        System.out.println("----------Atualizado----------");

        for (Produto lista : dao.listar()) {
            System.out.println(lista.getNome() + " | " + lista.getPreco());
        }
    }
}