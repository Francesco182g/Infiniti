$().ready(function() {
    // Selezione form e definizione dei metodi di validazione
    $("#form").validate({
        // Definiamo le nostre regole di validazione
        rules : {
            // registrazione - nome del campo di input da validare (NON ATTIVO)
            registrazione : {
              // Definiamo il campo login come obbligatorio
              required : true
            },
            user_email : {
                required : true,
                // Definiamo il campo email come un campo di tipo email
            },
            user_password : {
                required : true,
                // Settiamo la lunghezza minima e massima per il campo password
                minlength : 5,
                maxlength : 8
            },
            user_confpassword : {
            	required : true,
            	equalTo : "#user_password"
            },
            user_sesso : {
            	required : true
            },
            
            
        },

        
        // Personalizzimao i mesasggi di errore
        messages: {
            registrazione : "Effettua la Registrazione",
            user_password: {
                required: "Inserisci una password password",
                minlength: "Minimo 5 caratteri",
                maxlength: "Massimo 8 caratteri"
            },
            user_email: { 
            	required:"Inserisci un email valida",
            },
            user_confpassword : {
            	required: "La password deve essere uguale",
            	equalTo: "Password diversa"
            },
            user_sesso : {
            	required: "Specifica il sesso"
            },   
        },
        // Settiamo il submit handler per la form
        submitHandler: function(form) { 
            alert('I dati sono stati inseriti correttamente...Registrazione Riuscita');
            form.submit();
          },

          invalidHandler: function() { 
            alert('I dati inseriti non sono corretti, ricontrollali....');
          }, 
    });
});
