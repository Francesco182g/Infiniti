<!-- 
	Infiniti
	@copy Francesco Garofalo 2017
 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*,Beans.*, java.math.* ,Database.*,Servlet.*"%>

<%
	Utente utente = (Utente) session.getAttribute("user");
	/* TEST COOKIE
	Cookie mioCookie = new Cookie("nome", "valore");
	
	//specifica il percorso del cookie
	//che ha il privilegio di scrittura e lettura 
	//se omesso è inteso il percorso corrente
	mioCookie.setPath("/");
	
	//indica se il cookie va trasmesso solo su un 
	//protocollo sicuro, protetto cioè da crittografia
	mioCookie.setSecure(false);
	
	//scrive il cookie
	response.addCookie(mioCookie);
	
	*/
	int count = 0;

	if (utente != null) {

		count = (Integer) session.getAttribute("carrello");
	} else {
		response.sendRedirect("index.jsp");

	}
	
	ArrayList<Prodotto> offerte= new ArrayList<>();
	offerte= DatabaseQuery.cerca_Offerte();
%>

<!DOCTYPE HTML>
<html>

<head>
<title>RBR Store</title>
<meta name="description" content="website description" />
<meta name="keywords" content="website keywords, website keywords" />
<meta http-equiv="content-type"
	content="text/html; charset=windows-1252" />
<link rel="stylesheet" type="text/css" href="style/style.css"
	title="style" />
<link rel="stylesheet" type="text/css" href="style/responsive.css" />

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
					<li class="selected"><a href="Indexlog.jsp">Home</a></li>
					<li><a href="ProdottiLog.jsp">Prodotti</a></li>
					<li><a href="Profilo.jsp">Profilo</a></li>
					<li><a href="Logout.jsp">Logout</a></li>
					<li><a href="CarrelloLog.jsp">Carrello</a></li>
				</ul>
			</section>
		</header>
		<section id="site_content">
			<aside>
				<!-- insert your sidebar items here -->
				<h3>
					Ciao
					<%
					if (utente != null) {
				%>
					<%=utente.getNome()%>
					<%=utente.getCognome()%>
					<%
						}
					%>
				</h3>
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
				<!-- insert the page content here -->
				<h1>Benvenuti su un simulation store basato su prodotti redbull</h1>
				<p>
					Questo è un sito creato solo a scopo illustrativo e didattico,
					infatti non è possibile effettuare veri e propri acquisti ma solo
					simularli. Sito creato da <a href="#tonno">Francesco Garofalo</a>
				</p>
				<p>
					Questo sito è stato scritto in <strong>HTML5</strong>,<strong>CSS</strong>,<strong>JSP</strong>,
					<strong>Java Servlet</strong>,<strong>JS</strong> e altri
					linguaggi...
				</p>
				<p>
					Lo store ufficiale della Red Bull Racing è disponibile al sito <a
						href="https://www.redbullshop.com/en/?gclid=Cj0KEQiAifvEBRCVx5up6Ojgr5oBEiQALHw1TgpPafl_1kKOXq0tPfArUF5qBgkYxR7vigpNOMSgb_gaAu0O8P8HAQ">Red
						Bull Store</a>

				</p>

				<h3>Ti interessa un prodotto RBR, cercalo qui!</h3>
				<form id="search" method="get" action="CercaProdottiServlet">
					<p>
						<input class="search" type="text" name="nomeProdotto"
							placeholder="Cerca Prodotto..." /> <input name="search"
							type="image" style="border: 0; margin: 0 0 -9px 5px;"
							src="style/search.png" alt="Search" title="Search" />
					</p>
				</form>

				<%
					if (offerte.size() == 0) {
				%>
				<br> <br>
				<h3>Non sono presenti offerte</h3>
				<br> <br>
				<%
					} else {
				%>

				<br> <br>
				<h3>Ecco le nostre offerte</h3>
				<br> <br>

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

								for (int i = 0; i < offerte.size(); i++) {

									//itera[i] = prodotti.get(i).getIdProdotto();
						%>
						<form action="AddCarrelloServlet" method="get">
							<tr>
								<td><img width="100" height="100"
									src=<%=offerte.get(i).getPath()%> alt="Img ND"></td>
								<input size="3" name="prodott" type="hidden"
									value="<%=offerte.get(i).getIdProdotto()%>" />
								<td><%=offerte.get(i).getNome()%></td>
								<td><%=offerte.get(i).getQuantità()%></td>
								<td><%=offerte.get(i).getCondizione()%></td>
								<td><%=offerte.get(i).getTipo()%></td>
								<td><%=offerte.get(i).getPrezzo()%></td>
								<td><%=offerte.get(i).getOfferta()%></td>
								<%
									String prezzo_offerta = "Nessun Offerta";
											if (offerte.get(i).getOfferta() == 0) {
											} else {
												BigDecimal offerta = BigDecimal.valueOf(offerte.get(i).getOfferta());
												BigDecimal prezzoNuovo = offerte.get(i).getPrezzo().multiply(offerta);
												prezzoNuovo = prezzoNuovo.divide(BigDecimal.valueOf(100));
												prezzoNuovo = offerte.get(i).getPrezzo().subtract(prezzoNuovo);
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
					}
				%>

				<h2>Compatibilità Browser</h2>
				<p>Testato con:</p>
				<ul>
					<li>Internet Explorer 11</li>
					<li>Opera 43</li>
					<li>Edge</li>
					<li>Internet Explorer 11 for mobile</li>
					<li>Opera responsive tools</li>
				</ul>

				<h3>Ultimo Aggiornamento e Link Git</h3>
				<p>
					Link a GitHub: <a href="https://github.com/Francesco182g/Infiniti">https://github.com/Francesco182g/Infiniti</a>
				<p>19/08/2017 Fixato il delete self user.</p>
				<p>01/08/2017 Aggiunti ChangeLog e info su ogni versione nuova.</p>

				<p>Infiniti non riceve aggiornamenti costanti ma solo piccoli
					update per migliorare alcuni problemi di stabilità o errori nei
					sistemi. Il codice sorgente è disponibile su GitHub al link sopra
					indicato.</p>
			</section>
		</section>
		<footer></footer>
		<section id="footer">
			Template fornito da: &copy; colour_blue, WebApplication creata da
			&copy; Francesco Garofalo con la collaborazione di Anna Tomeo | <a
				href="http://validator.w3.org/check?uri=referer">HTML5</a> | <a
				href="http://jigsaw.w3.org/css-validator/check/referer">CSS</a> | <a
				href="AdminLogin.jsp">Accedi come Admin</a>
		</section>
	</section>
</body>
</html>
