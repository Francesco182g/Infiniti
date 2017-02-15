<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*,Beans.*,Database.*,Servlet.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	ArrayList<Prodotto> prodotti = new ArrayList<>();

	String visible = (String) request.getAttribute("vis");
	prodotti = (ArrayList) request.getAttribute("listaProdotti");
%>

<!DOCTYPE HTML>
<html>

<head>
<title>Prodotti - RBR Store</title>
<meta name="description" content="website description" />
<meta name="keywords" content="website keywords, website keywords" />
<meta http-equiv="content-type"
	content="text/html; charset=windows-1252" />
	
<link rel="stylesheet" type="text/css" href="style/style.css" title="style" />
<link rel="stylesheet" type="text/css" href="style/responsive.css"/>

</head>

<body>
	<section id="main">
		<header>
			<section id="logo">
				<section id="logo_text">
					<!-- class="logo_colour", allows you to change the colour of the text -->
					<h1>
						<a href="Index.jsp"><span class="logo_colour"></span></a>
					</h1>
					<h2></h2>
				</section>
				<!-- La top_menu continene i pulsanti di sign_up & login.-->
				<section id="top_menu">
					<a href="Login.jsp" class="login">login</a> 
					<a href="Registrati.jsp" class="sign_up">register</a> 
					<a href="Carrello.jsp" class="carrello">carrello</a>
				</section>
			</section>
			<section id="menubar">
				<ul id="menu">
					<!-- put class="selected" in the li tag for the selected page - to highlight which page you're on -->
					<li><a href="Index.jsp">Home</a></li>
					<li class="selected"><a href="Prodotti.jsp">Prodotti</a></li>
					<li><a href="Registrati.jsp">Registrati</a></li>
					<li><a href="Login.jsp">Login</a></li>
					<li><a href="Carrello.jsp">Carrello</a></li>
				</ul>
			</section>
		</header>
		<section id="content_header"></section>
		<section id="site_content">
									<aside>
				<!-- insert your sidebar items here -->
				<h4></h4>
				<h5>14/02/2017</h5>
				<p>
					Il sito simula un e-commerce non inserire dati per pagamento.<br /> <a href="https://www.redbullshop.com/en/">Store Reale</a>
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
				<h3>Cerca un prodotto...</h3>
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
							<th>Foto Prodotto</th>
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
							for (int i = 0; i < prodotti.size(); i++) {
						%>
						<tr>
							<td><img width="70" height="70"
								src=<%=prodotti.get(i).getPath()%> alt="Img ND"></td>
							<td><%=prodotti.get(i).getIdProdotto()%></td>
							<td><%=prodotti.get(i).getNome()%></td>
							<td><%=prodotti.get(i).getPrezzo()%></td>
							<td><%=prodotti.get(i).getQuantità()%></td>
							<td><%=prodotti.get(i).getCondizione()%></td>
							<td><%=prodotti.get(i).getTipo()%></td>

						</tr>
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
			Template fornito da: &copy; colour_blue, WebApplication
			creata da &copy; Francesco Garofalo|  <a
			href="http://validator.w3.org/check?uri=referer">HTML5</a> | <a
			href="http://jigsaw.w3.org/css-validator/check/referer">CSS</a> | <a
			href="http://www.html5webtemplates.co.uk">design from
			HTML5webtemplates.co.uk</a>
	</section>
</body>
</html>
