<!-- 
	Infiniti
	@copy Francesco Garofalo 2017
 -->
 
<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*,Beans.*,Database.*,Servlet.*"%>

<%
	Admin admin = (Admin) session.getAttribute("admin");

	if (admin != null) {
		// SIMULA LA SESSIONE
		//utente = new Utente("a","a","a","a",true,true);

	} else {
		response.sendRedirect("index.jsp");
	}

	ArrayList<Utente> prodotti = new ArrayList<>();

	String visible = "visible";
	prodotti = DatabaseQuery.getUtentiAll();

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
	<link rel="stylesheet" type="text/css" href="style/responsive.css"/>
	
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

			</section>
			<section id="menubar">
				<ul id="menu">
					<!-- put class="selected" in the li tag for the selected page - to highlight which page you're on -->
					<li><a href="AdminProdotto.jsp">Prodotti</a></li>
					<li class="selected"><a href="AdminUtenti.jsp">Utenti</a></li>
				</ul>
			</section>
		</header>
		<section id="content_header"></section>
		<section id="site_content">
			
			<section id="content">
				<h2>Funzionalità Aggiuntive...</h2>
				<h3>Elimina Utenti</h3>
				<%
					if (visible == "visible") {
				%>
				<table class="table table-hover">
					<thead class="th-center">
						<tr>
							<th>Empty</th>
							<th>Nome</th>
							<th>Cognome</th>
							<th>Email</th>
							<th>Elimina</th>
						</tr>
					</thead>
					<tbody>

						<%
							//int [] itera;
								//itera = new int [100];

								for (int i = 0; i < prodotti.size(); i++) {

									//itera[i] = prodotti.get(i).getIdProdotto();
						%>
						<form action="EliminaUtenteServlet" method="get">
						<tr>
						<td><input size="30" name="prodott" type="hidden" value="<%=prodotti.get(i).getEmail()%>"/></td>
							<td><%=prodotti.get(i).getNome()%></td>
							<td><%=prodotti.get(i).getCognome()%></td>
							<td><%=prodotti.get(i).getEmail()%></td>
							<td><input type="image" id="uten" name="uten"
								value="uten" src="style/cestino.png" /></td>
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
				<h3>Nessun Utente...</h3>
				<%
					} else {
				%>
				<h4>NULL...</h4>
				<%
					}
				%>
			</section>
		</section>
	</section>
	<footer></footer>
	<section id="footer">
		Copyright &copy; colour_blue | <a
			href="http://validator.w3.org/check?uri=referer">HTML5</a> | <a
			href="http://jigsaw.w3.org/css-validator/check/referer">CSS</a> | <a
			href="http://www.html5webtemplates.co.uk">design from
			HTML5webtemplates.co.uk</a>
	</section>

</body>
</html>
