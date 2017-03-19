<!-- 
	Infiniti
	@copy Francesco Garofalo 2017
 -->
 
<!DOCTYPE HTML>
<html>

<head>
<title>Login - RBR Store</title>
<meta name="description" content="website description" />
<meta name="keywords" content="website keywords, website keywords" />
<meta http-equiv="content-type"
	content="text/html; charset=windows-1252" />
<link rel="stylesheet" type="text/css" href="style/style.css"
	title="style" />
	<link rel="stylesheet" type="text/css" href="style/responsive.css"/>
	
</head>

<body>
	<section id="main">
		<header>
			<section id="logo">
				<section id="logo_text">
					<!-- class="logo_colour", allows you to change the colour of the text -->
					<h1>
						<a href="index.jsp"><span class="logo_colour"></span></a>
					</h1>
					<h2></h2>
				</section>
				<!-- La top_menu continene i pulsanti di sign_up & login.-->
				<section id="top_menu">
					<a href="Login.jsp" class="login">login</a> <a
						href="Registrati.jsp" class="sign_up">register</a> <a
						href="Carrello.jsp" class="carrello">carrello</a>
				</section>
			</section>
			<section id="menubar">
				<ul id="menu">
					<!-- put class="selected" in the li tag for the selected page - to highlight which page you're on -->
					<li><a href="Index.jsp">Home</a></li>
					<li><a href="Prodotti.jsp">Prodotti</a></li>
					<li><a href="Registrati.jsp">Registrati</a></li>
					<li class="selected"><a href="Login.jsp">Login</a></li>
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
				<!-- insert the page content here -->
				<h1>Effettua il Login</h1>
				<form action="LoginAdminServlet" method="post">
					<section class="form_settings">
						<p>
							<span>Email</span><input class="contact" type="email"
								name="user_email" value="" />
						</p>
						<p>
							<span>Password</span><input class="contact" type="password"
								name="user_password" value="" />
						</p>
						<p style="padding-top: 15px">
							<span>&nbsp;</span><input class="submit" type="submit"
								name="contact_submitted" value="Login" />
						</p>
					</section>
				</form>
				<!-- END DIV -->
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
	</section>
</body>
</html>
