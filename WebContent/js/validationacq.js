$().ready(function() {
    // Selezione form e definizione dei metodi di validazione
    $("#insertform").validate({
        // Definiamo le nostre regole di validazione
        rules : {
            // registrazione - nome del campo di input da validare (NON ATTIVO)
            carrello : {
              required : true
            },
            pagamento : {
                required : true,
            },
            indirizzo : {
                required : true,
            },
            descrizione : {
            	required : true,
            },
            
            
        },

        
        // Personalizzimao i mesasggi di errore
        messages: {
        	carrello : "Effettua il pagamento",
        	pagamento: {
                required: "Inserisci un metodo di pagamento",
            },
            indirizzo: { 
            	required:"Inserisci il tuo indirizzo",
            },
            descrizione : {
            	required: "Note sul pagamento",
            }, 
        },
        // Settiamo il submit handler per la form
        submitHandler: function(form) { 
            alert('I dati sono stati inseriti correttamente...Acquisto riuscito');
            form.submit();
          },

          invalidHandler: function() { 
            alert('I dati inseriti non sono corretti, ricontrollali....');
          }, 
    });
});
