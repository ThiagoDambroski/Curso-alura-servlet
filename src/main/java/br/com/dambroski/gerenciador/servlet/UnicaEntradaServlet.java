package br.com.dambroski.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.dambroski.gerenciador.acao.Acao;
import br.com.dambroski.gerenciador.acao.AlteraEmpresa;
import br.com.dambroski.gerenciador.acao.ListaEmpresas;
import br.com.dambroski.gerenciador.acao.MostraEmpresa;
import br.com.dambroski.gerenciador.acao.NovaEmpresa;
import br.com.dambroski.gerenciador.acao.NovaEmpresaForm;
import br.com.dambroski.gerenciador.acao.RemovaEmpresa;



@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramAcao = request.getParameter("acao");
		/*
		HttpSession sessao = request.getSession();
		boolean usuarioNaoEstarLogado = sessao.getAttribute("usuarioLogado") == null;
		boolean ehUmaAcaoProtegida = !( paramAcao.equals("Login") || paramAcao.equals("LoginFrom"));
		if(ehUmaAcaoProtegida && usuarioNaoEstarLogado) {
			response.sendRedirect("redirect:entrada?acao=LoginFrom");
			return;
		}
		*/
		
		
		String nomeDaClasse = "br.com.dambroski.gerenciador.acao." + paramAcao;
		
		String nome;
		try {
		    Class classe = Class.forName(nomeDaClasse);//carrega a classe com o nome 
		    Acao acao = (Acao) classe.newInstance(); 
		    nome = acao.executa(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
		    throw new ServletException(e);
		}
		
		String[] tipoEEndereco = nome.split(":");
		if(tipoEEndereco[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoEEndereco[1]);
		    rd.forward(request,response);
		}else {
			response.sendRedirect(tipoEEndereco[1]);
		}
		
		/*
		 * String nome = null; if(paramAcao.equals("ListaEmpresas")){
		 * 
		 * ListaEmpresas acao = new ListaEmpresas(); nome = acao.executa(request,
		 * response);
		 * 
		 * 
		 * } else if(paramAcao.equals("RemovaEmpresa")){ RemoveEmpresas acao = new
		 * RemoveEmpresas(); nome = acao.executa(request, response);
		 * 
		 * } else if(paramAcao.equals("MostraEmpresa")){ MostraEmpresas acao = new
		 * MostraEmpresas(); nome = acao.executa(request, response);
		 * 
		 * }else if(paramAcao.equals("AlteraEmpresa")){ AlteraEmpresa acao = new
		 * AlteraEmpresa(); nome = acao.executa(request, response);
		 * 
		 * }else if(paramAcao.equals("NovaEmpresa")){ NovaEmpresa acao = new
		 * NovaEmpresa(); nome = acao.executa(request, response); } else
		 * if(paramAcao.equals("NovaEmpresaForm")){ NovaEmpresaForm acao = new
		 * NovaEmpresaForm(); nome = acao.executa(request, response); }
		 */
		
		
		
		
		}

}

