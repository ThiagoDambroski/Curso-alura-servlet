package br.com.dambroski.gerenciador.acao;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dambroski.gerenciador.modelo.Banco;

public class RemoveEmpresas {
	
	public void executa(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("removendo empresa");
		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		Banco banco = new Banco();
		banco.remove(id);
		
		response.sendRedirect("entrada?acao=ListaEmpresas");
	}

}
