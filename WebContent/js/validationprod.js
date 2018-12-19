$().ready(function() {
	// Selezione form e definizione dei metodi di validazione
	$("#insertform").validate({
		// Definiamo le nostre regole di validazione
		rules : {
			// registrazione - nome del campo di input da validare (NON ATTIVO)
			inserisciprodotto : {
				// Definiamo il campo login come obbligatorio
				required : true
			},
			prodotto_nome : {
				required : true,
				minlength : 2,
				maxlength : 30
			},
			prodotto_tipo : {
				required : true,
			},
			prodotto_descrizione : {
				required : true,
				maxlength : 100
			},
			prodotto_quantita : {
				required : true,
				minlength : 1,
				maxlength : 10
			},
			prodotto_prezzo : {
				required : true
			},
			prodotto_condizione : {
				required : true
			},
			prodotto_offerta : {
				required : true,
				minlength : 0,
				maxlength : 100
			},


		},


		// Personalizzimao i mesasggi di errore
		messages: {
			registrazione : "Effettua la Registrazione",
			prodotto_nome: {
				required: "Nome Prodotto",
				minlength: "Minimo 2 caratteri",
				maxlength: "Massimo 30 caratteri"
			},
			prodotto_tipo: { 
				required:"Inserisci tipo di prodotto",
			},
			prodotto_descrizione : {
				required: "Massimo 100 Caratteri",
				maxlength: "MAX 100"
			},
			prodotto_quantita : {
				required: "Specifica la quantità",
				minlength: "Minimo 1",
				maxlength: "Massimo 10"
			}, 
			prodotto_condizione : {
				required: "Specifica la condizione"
			},
			prodotto_offerta : {
				required: "Specifica l'offerta, 0-100 ",
				minlength: "Minimo 0",
				maxlength: "Massimo 100"
			},
		},
		// Settiamo il submit handler per la form
		submitHandler: function(form) { 
			alert('I dati sono stati inseriti correttamente...Inserimento prodotto riuscito');
			form.submit();
		},

		invalidHandler: function() { 
			alert('I dati inseriti non sono corretti, ricontrollali....');
		}, 
	});
});
