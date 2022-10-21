package br.com.devmedia.lojavirtual;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListaCdsServlet extends HttpServlet {

	private static final long serialVersionUID = 2051703961578552580L;

	@Override
	public void init() throws ServletException {
		super.init();
		//inicializa o map com o catálogo de cds
		CD cd1 = new CD(1L, "Novelas", "DJavan", 25.0);
		CD cd2 = new CD(2L, "Ao Vivo (vol. 1)", "DJavan", 30.0);
		CD cd3 = new CD(3L, "Ao Vivo (vol. 2)", "DJavan", 30.0);
		CD cd4 = new CD(4L, "Lilás", "DJavan", 20.0);
		CD cd5 = new CD(5L, "Acústico MTV", "Capital Inicial", 23.0);
		CD cd6 = new CD(6L, "Acústico MTV", "Kid Abelha", 21.0);
		CD cd7 = new CD(7L, "Infinito Particular", "Marisa Monte", 35.0);
		CD cd8 = new CD(8L, "Universo ao meu redor", "Marisa Monte", 40.0);
		CD cd9 = new CD(9L, "Greatest hits", "Queen", 20.0);
		CD cd10 = new CD(10L, "Queen Collection", "Queen", 45.0);
		
		HashMap<Long, CD> mapCds = new HashMap<Long, CD>();
		
		mapCds.put(cd1.getCodigo(), cd1);
		mapCds.put(cd2.getCodigo(), cd2);
		mapCds.put(cd3.getCodigo(), cd3);
		mapCds.put(cd4.getCodigo(), cd4);
		mapCds.put(cd5.getCodigo(), cd5);
		mapCds.put(cd6.getCodigo(), cd6);
		mapCds.put(cd7.getCodigo(), cd7);
		mapCds.put(cd8.getCodigo(), cd8);
		mapCds.put(cd9.getCodigo(), cd9);
		mapCds.put(cd10.getCodigo(), cd10);

	    getServletContext().setAttribute("catalogoCds", mapCds);
	}

	   @Override
	   protected void doGet(HttpServletRequest request, HttpServletResponse response)
			   throws ServletException, IOException {
		   //chama o servlet que monta a tabela de cds
		   request.getRequestDispatcher("/catalogoCds.jsp").forward(request, response);

	   }
	 }