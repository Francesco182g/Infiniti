<!-- 
	Infiniti
	@copy Francesco Garofalo 2017
 -->
 
<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*,Beans.*,Database.*,Servlet.*"%>

<%
//NON ATTIVA!
	Utente utente = (Utente) session.getAttribute("user");

	ArrayList<Ordine> prodotti = new ArrayList<>();
	String visible = null;
	String idUtente = null;
	int count = 0;
	if (utente != null) {
		prodotti = (ArrayList) request.getAttribute("lista");
		visible = (String) request.getAttribute("vis");
		idUtente = utente.getEmail();
		count = (Integer) session.getAttribute("carrello");

	} else {
		response.sendRedirect("index.jsp");
	}



	

%>

<!DOCTYPE HTML>
<html>

<head>
<title>Prodotti - RBR Store</title>
<meta name="description" content="website description" />
<meta name="keywords" content="website keywords, website keywords" />
<meta http-equiv="content-type"
	content="text/html; charset=windows-1252" />
<link rel="stylesheet" type="text/css" href="style/style.css"
	title="style" />
<link rel="stylesheet" type="text/css" href="style/responsive.css" />

<script type="text/javascript" src="js/jquery-3.1.1.js"></script>

<!--  Controlla se un bottone è stato cliccato o meno e passa il valore submit -->

</head>

<body>
	<section id="main">
		<header>
			<section id="logo">
				<section id="logo_text">
					<!-- class="logo_colour", allows you to change the colour of the text -->
					<h1>
						<a href="index.html"><span class="logo_colour"></span></a>
					</h1>
					<h2></h2>
				</section>
				<!-- La top_menu continene i pulsanti di sign_up & login.-->
				<section id="top_menu">
					<a href="Logout.jsp" class="login">logout</a> <a href="Profilo.jsp"
						class="profilo">profilo</a> <a href="CarrelloLog.jsp"
						class="carrello"><STRONG><%=count%></STRONG> carrello</a>
				</section>
			</section>
			<section id="menubar">
				<ul id="menu">
					<!-- put class="selected" in the li tag for the selected page - to highlight which page you're on -->
					<li><a href="Indexlog.jsp">Home</a></li>
					<li class="selected"><a href="ProdottiLog.jsp">Prodotti</a></li>
					<li><a href="Profilo.jsp">Profilo</a></li>
					<li><a href="Logout.jsp">Logout</a></li>
					<li><a href="CarrelloLog.jsp">Carrello</a></li>
				</ul>
			</section>
		</header>
		<section id="content_header"></section>
		<section id="site_content">
			<aside>
				<!-- insert your sidebar items here -->
				<h3>
					Ciao
					<%=utente.getNome()%>
					<%=utente.getCognome()%></h3>
				<h4></h4>
				<h5>14/02/2017</h5>
				<p>
					Il sito simula un e-commerce non inserire dati per pagamento.<br />
					<a href="https://www.redbullshop.com/en/">Store Reale</a>
				</p>
				<p></p>
				<h3>Collegamenti Utili</h3>
				<ul>
					<li><a href="http://www.redbull.com/it/it">RedBull
							official site</a></li>
					<li><a href="https://www.redbullshop.com/en/">RedBull
							Store</a></li>
					<li><a href="https://www.formula1.com">Formula 1 official
							site</a></li>
					<li><a
						href="http://f1store.formula1.com/stores/F1/it?portal=CHMHGTFG&CMP=PSC-CHMHGTFG">Formula
							1 Store</a></li>
				</ul>
				<h3>Cerca Prodotto</h3>
				<form id="search" method="get" action="CercaProdottiServlet">
					<p>
						<input class="search" type="text" name="nomeProdotto"
							placeholder="Cerca Prodotto..." /> <input name="search"
							type="image" style="border: 0; margin: 0 0 -9px 5px;"
							src="style/search.png" alt="Search" title="Search" />
					</p>
				</form>
			</aside>
			<section id="content">
				<h2>I MIEI ORDINI</h2>


				<%
					if (visible == "visible") {
				%>
				<table class="table table-hover">
					<thead class="th-center">
						<tr>
							<th>idOrdine</th>
							<th>Data</th>
							<th>Pagamento</th>
							<th>Indirizzo Fatturazione</th>
							<th>Note</th>
							<th>Prezzo</th>
						</tr>
					</thead>
					<tbody>

						<%
							//int [] itera;
								//itera = new int [100];

								for (int i = 0; i < prodotti.size(); i++) {

									//itera[i] = prodotti.get(i).getIdProdotto();
						%>
						<form action="AddCarrelloServlet" method="get">
							<tr>
								<td><%=prodotti.get(i).getIdOrdine() %></td>
								<td><%=prodotti.get(i).getData()%></td>
								<td><%=prodotti.get(i).getPagamento()%></td>
								<td><%=prodotti.get(i).getIndirizzo()%></td>
								<td><%=prodotti.get(i).getNote()%></td>
								<td><%=prodotti.get(i).getPrezzo()%></td>

							</tr>
						</form>
						<%
							}
						%>
					</tbody>
				</table>
				<%
					} else if (visible == "nulla") {
				%>
				<h3>La ricerca non ha prodotto risultati...</h3>
				<%
					} else {
				%>
				<h4>Effettua una ricerca...</h4>
				<%
					}
				%>

			</section>
		</section>
	</section>
	<footer></footer>
	<section id="footer">
		Template fornito da: &copy; colour_blue, WebApplication creata da
		&copy; Francesco Garofalo con la collaborazione di Anna Tomeo| <a
			href="http://validator.w3.org/check?uri=referer">HTML5</a> | <a
			href="http://jigsaw.w3.org/css-validator/check/referer">CSS</a> | <a
			href="http://www.html5webtemplates.co.uk">design from
			HTML5webtemplates.co.uk</a>
	</section>

</body>
</html>
