<!-- 
	Infiniti
	@copy Francesco Garofalo 2017
 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*,Beans.*,Database.*,Servlet.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	Utente utente = (Utente) session.getAttribute("user");

	String email = null;
	ArrayList<Carrello> lista = new ArrayList<>();
	ArrayList<Prodotto> prod = new ArrayList<>();
	int count = 0;
	if (utente != null) {
		
		email = utente.getEmail();
		lista = DatabaseQuery.getCarrello(email);

		System.out.println(lista);
		//Check Quantità e add to array prod
		for (int i = 0; i < lista.size(); i++) {
			Prodotto p = DatabaseQuery.getProdotto(lista.get(i).getIdProdotto());
			if(p.getQuantità() != 0){
				prod.add(p);	
			} else {
				DatabaseQuery.delProdottoCarrello(lista.get(i).getIdProdotto());
			}
		}

		count = prod.size();

	} else {

		response.sendRedirect("Login.jsp");
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
<script type="text/javascript" src="js/validationacq.js"></script>
-->
</head>

<body>
	<section id="main">
		<header>
			<section id="logo">
				<section id="logo_text">
					<!-- class="logo_colour", allows you to change the colour of the text -->
					<h1>
						<a href="Indexlog.jsp"><span class="logo_colour"></span></a>
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
					<li><a href="ProdottiLog.jsp">Prodotti</a></li>
					<li><a href="Profilo.jsp">Profilo</a></li>
					<li><a href="Logout.jsp">Logout</a></li>
					<li class="selected"><a href="CarrelloLog.jsp">Carrello</a></li>
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
				<h2>PER MOTIVI DI SICUREZZA QUESTA SEZIONE NON È ATTIVA E NON È
					POSSIBILE SIMULARE IL PAGAMENTO...</h2>
				<h2>
					Ciao
					<%=utente.getNome()%>, ecco i prodotti che hai aggiunto al
					carrello...
				</h2>

				<%
					if (prod.size() != 0) {
				%>
				<table class="table table-hover">
					<thead class="th-center">
						<tr>
							<th>Foto</th>
							<th>idProdotto</th>
							<th>Nome</th>
							<th>Prezzo</th>
							<th>Quantità</th>
							<th>Condizione</th>
							<th>Tipo</th>

						</tr>
					</thead>
					<tbody>

						<%
							for (int i = 0; i < prod.size(); i++) {
						%>
						<tr>
							<td><img width="70" height="70"
								src=<%=prod.get(i).getPath()%> alt="Img ND"></td>
							<td><%=prod.get(i).getIdProdotto()%></td>
							<td><%=prod.get(i).getNome()%></td>
							<td><%=prod.get(i).getPrezzo()%></td>
							<td><%=prod.get(i).getQuantità()%></td>
							<td><%=prod.get(i).getCondizione()%></td>
							<td><%=prod.get(i).getTipo()%></td>
						</tr>
						<%
							}
						%>
					</tbody>
				</table>

				<form id="insertform" action="AcquistaProdottoServlet" method="post">
					<section class="form_settings">
						<br>
						<p>
							<span>Pagamento</span><input class="contact" type="text"
								name="pagamento" value="" placeholder="Metodo di pagamento"
								pattern="[a-zA-Z0-9]{2,45}$" required />
						</p>
						<br>
						<p>
							<span>Note</span>
							<textarea class="contact textarea" rows="8" cols="40"
								name="descrizione" placeholder="Note" required></textarea>
						</p>
						<br>
						<p>
							<span>Indirizzo</span><input class="contact" type="text"
								name="indirizzo" value="" placeholder="Indirizzo, Città"
								pattern="[a-zA-Z0-9,]{2,45}$" required />
						</p>
						<br> <br>
						<p style="padding-top: 15px">
							<span>&nbsp;</span><input class="insert" type="submit"
								name="contact_submitted" value="Acquista Prodotto" />
						</p>
					</section>

				</form>

				<form id="insertform" action="SvuotaCarrelloServlet" method="post">
					<section class="form_settings">
						<br>
						<p style="padding-top: 15px">
							<span>&nbsp;</span><input class="insert" type="submit"
								name="contact_submitted" value="Svuota Carrello" />
						</p>
					</section>
				</form>
				<%
					} else {
				%>
				<h4>Non hai prodotti nel carrello...</h4>
				<%
					}
				%>
			</section>
		</section>
		<footer></footer>
		<section id="footer">
			Copyright Template fornito da: &copy; colour_blue, WebApplication
			creata da &copy; Francesco Garofalo con la collaborazione di Anna
			Tomeo| <a href="http://validator.w3.org/check?uri=referer">HTML5</a>
			| <a href="http://jigsaw.w3.org/css-validator/check/referer">CSS</a>
			| <a href="http://www.html5webtemplates.co.uk">design from
				HTML5webtemplates.co.uk</a>
		</section>
	</section>
</body>
</html>
