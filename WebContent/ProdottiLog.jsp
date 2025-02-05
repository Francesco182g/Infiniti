<!-- 
	Infiniti
	@copy Francesco Garofalo 2017
 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*,  java.math.*, Beans.*,Database.*,Servlet.*"%>

<%
	Utente utente = (Utente) session.getAttribute("user");
	String visible = null;
	int count = 0;
	ArrayList<Prodotto> prodotti = new ArrayList<>();
	if (utente != null) {

		visible = (String) request.getAttribute("vis");
		prodotti = (ArrayList) request.getAttribute("listaProdotti");

		String idUtente = utente.getEmail();

		count = (Integer) session.getAttribute("carrello");

	} else {
		response.sendRedirect("Index.jsp");
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
				<h2>Prodotti</h2>
				<h3>Search</h3>
				<form id="search" method="get" action="CercaProdottiServlet">
					<p>
						<input class="search" type="text" name="nomeProdotto"
							placeholder="Cerca Prodotto..." /> <input name="search"
							type="image" style="border: 0; margin: 0 0 -9px 5px;"
							src="style/search.png" alt="Search" title="Search" />
					</p>
				</form>

				<%
					if (visible == "visible") {
				%>
				<table class="table table-hover">
					<thead class="th-center">
						<tr>
							<th>Foto</th>
							<th>Nome</th>
							<th>Quantità</th>
							<th>Condizione</th>
							<th>Tipo</th>
							<th>Prezzo Consigliato</th>
							<th>Offerta</th>
							<th>Prezzo Offerta</th>
							<th>Aggiungi a Carrello</th>
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
								<td><img width="100" height="100"
									src=<%=prodotti.get(i).getPath()%> alt="Img ND"></td>
								<input size="3" name="prodott" type="hidden"
									value="<%=prodotti.get(i).getIdProdotto()%>" />
								<td><%=prodotti.get(i).getNome()%></td>
								<td><%=prodotti.get(i).getQuantità()%></td>
								<td><%=prodotti.get(i).getCondizione()%></td>
								<td><%=prodotti.get(i).getTipo()%></td>
								<td><%=prodotti.get(i).getPrezzo()%></td>
								<td><%=prodotti.get(i).getOfferta()%></td>
								<%
									String prezzo_offerta = "Nessun Offerta";
											if (prodotti.get(i).getOfferta() == 0) {
											} else {
												BigDecimal offerta = BigDecimal.valueOf(prodotti.get(i).getOfferta());
												BigDecimal prezzoNuovo = prodotti.get(i).getPrezzo().multiply(offerta);
												prezzoNuovo = prezzoNuovo.divide(BigDecimal.valueOf(100));
												prezzoNuovo = prodotti.get(i).getPrezzo().subtract(prezzoNuovo);
												prezzo_offerta = "" + prezzoNuovo;
											}
								%>
								<td><%=prezzo_offerta%></td>
								<td><input type="image" id="addcarr" name="submitta"
									value="addcarr" src="style/carrello.png" /></td>
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
				<form action="AddProdotto.jsp" method="get">
					<section class="form_settings">
						<br>
						<p style="padding-top: 20px">
							<span>&nbsp;</span><input class="insert" type="submit"
								name="contact_submitted" value="Inserisci un Prodotto" />
						</p>
					</section>
				</form>
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
