package br.edu.fatecpg.consulta.cep;

import br.edu.fatecpg.consulta.cep.model.Endereco;
import br.edu.fatecpg.consulta.cep.service.ConsultaEndereco;
import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        String cep="";
        Scanner scan = new Scanner(System.in);
        var consultaCep = new ConsultaEndereco();
        FileWriter file = new FileWriter("endereços.txt");
        while (true) {
            System.out.println("Digite um cep sem espaços e sem traço ou sair para finalizar: ");
            cep = scan.nextLine();
            if (cep.equalsIgnoreCase("sair")){
                break;
            }
            var json = consultaCep.obterDados("https://viacep.com.br/ws/" + cep + "/json/");
            System.out.println(json);

            file.write(json);

            Gson gson = new Gson();
            Endereco endereco = gson.fromJson(json, Endereco.class);
            System.out.println(endereco);

        }
        file.close();
    }
}