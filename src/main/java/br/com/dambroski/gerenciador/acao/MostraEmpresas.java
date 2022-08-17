package br.com.dambroski.gerenciador.acao;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dambroski.gerenciador.modelo.Banco;
import br.com.dambroski.gerenciador.modelo.Empresa;

public class MostraEmpresas {
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("mostrando empresa");
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		Banco banco = new Banco();
		Empresa empresa = banco.buscaEmpresaId(id);
		
		request.setAttribute("empresa", empresa);
		return "forward:/fromAlteraEmpresa.jsp";
		
		
	}

}
