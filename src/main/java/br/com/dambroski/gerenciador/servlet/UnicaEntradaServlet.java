package br.com.dambroski.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dambroski.gerenciador.acao.AlteraEmpresa;
import br.com.dambroski.gerenciador.acao.ListaEmpresas;
import br.com.dambroski.gerenciador.acao.MostraEmpresas;
import br.com.dambroski.gerenciador.acao.NovaEmpresa;
import br.com.dambroski.gerenciador.acao.RemoveEmpresas;



@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String paramAcao = request.getParameter("acao");
		String nome = null;
		if(paramAcao.equals("ListaEmpresas")){
			
			ListaEmpresas acao = new ListaEmpresas();
			nome = acao.executa(request, response);
			
			
		}
		else if(paramAcao.equals("RemovaEmpresa")){
			RemoveEmpresas acao = new RemoveEmpresas();
			nome = acao.executa(request, response);
			
		}
		else if(paramAcao.equals("MostraEmpresa")){
			MostraEmpresas acao = new MostraEmpresas();
			nome = acao.executa(request, response);
			
		}else if(paramAcao.equals("AlteraEmpresa")){
			AlteraEmpresa acao = new AlteraEmpresa();
			nome = acao.executa(request, response);
			
		}else if(paramAcao.equals("NovaEmpresa")){
			NovaEmpresa acao = new NovaEmpresa();
			nome = acao.executa(request, response);
		}
		
		String[] tipoEEndereco = nome.split(":");
		if(tipoEEndereco[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher(tipoEEndereco[1]);
		    rd.forward(request,response);
		}else {
			response.sendRedirect(tipoEEndereco[1]);
		}
		
		
		}

}
