package br.com.dambroski.gerenciador.acao;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dambroski.gerenciador.modelo.Banco;
import br.com.dambroski.gerenciador.modelo.Empresa;

public class NovaEmpresaForm {
	
		public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		return "forward:fromNovaEmpresa.jsp";
	}

}
