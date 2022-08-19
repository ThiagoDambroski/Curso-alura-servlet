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

public class NovaEmpresa implements Acao{
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String nomeEmpresa = request.getParameter("nome");
		String dataEmpresa = request.getParameter("data");
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date dataAbertura;
		try {
			dataAbertura = sdf.parse(dataEmpresa);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		Empresa empresa = new Empresa(null,nomeEmpresa);
		empresa.setDataAbertura(dataAbertura);
		
		Banco banco = new Banco();
		banco.adiciona(empresa);
		
		request.setAttribute("empresa",empresa.getNome());
		
		return "redirect:entrada?acao=ListaEmpresas";
	}

}
