<!-- 
	Infiniti
	@copy Francesco Garofalo 2017
 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*,Beans.*"%>
<%
	Utente utente = (Utente) session.getAttribute("user");
	int count = 0;
	if (utente != null) {
		// SIMULA LA SESSIONE
		//utente = new Utente();
		count = (Integer) session.getAttribute("carrello");

	} else {
		response.sendRedirect("index.jsp");
	}
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

<!--Ultima versione di jQuery (minified) 
<script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>


<script
	src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.14.0/jquery.validate.min.js"></script>
<script type="text/javascript" src="js/validationprod.js"></script>
-->
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
				<!-- insert the page content here -->
				<h1>Aggiungi un prodotto</h1>

				<form id="insertform" action="AddProdottoServlet" method="post">
					<section class="form_settings">
						<br>
						<p>
							<span>Nome</span><input class="contact" type="text"
								name="prodotto_nome" value="" pattern="[a-zA-Z0-9]{2,45}$" required/>
						</p>
						<br>
						<p>
							<span>Tipo</span><input class="contact" type="text"
								name="prodotto_tipo" value="" pattern="[a-zA-Z0-9]{2,45}$" required/>
						</p>
						<br>
						<p>
							<span>Descrizione</span>
							<textarea class="contact textarea" rows="8" cols="40"
								name="prodotto_descrizione" pattern="[a-zA-Z0-9.,]{5,100}$" required></textarea>
						</p>
						<br>
						<p>
							<span>Quantità </span><input class="contact" type="number"
								min="1" max="10" name="prodotto_quantita" value=""
								placeholder="1-10" pattern="[0-9]{1,2}$" required />
						</p>
						<br>
						<p>
							<span>Prezzo </span><input class="contact" type=number step=0.01
								name="prodotto_prezzo" value="" placeholder="x,xx" pattern="[0-9]+(\\.[0-9][0-9]?)?" required />
						</p>
						<br>
						<p>
							<span>Condizione</span><input class="contact" type="text"
								name="prodotto_condizione" value="" pattern="[a-zA-Z0-9]{3,40}$"/>
						</p>
						<br>
						<p>
							<span>Link Immagine</span><input class="contact" type="url"
								name="prodotto_path" value="" required />
						</p>
						<p style="padding-top: 15px">
							<span>&nbsp;</span><input class="insert" type="submit"
								name="contact_submitted" value="Inserisci Prodotto" />
						</p>
					</section>

				</form>
			</section>
		</section>
		<footer></footer>
		<section id="footer">
			Copyright Template fornito da: &copy; colour_blue, WebApplication
			creata da &copy; Francesco Garofalo  <a href="http://validator.w3.org/check?uri=referer">HTML5</a>
			| <a href="http://jigsaw.w3.org/css-validator/check/referer">CSS</a>
			| <a href="http://www.html5webtemplates.co.uk">design from
				HTML5webtemplates.co.uk</a>
		</section>
	</section>
</body>
</html>
