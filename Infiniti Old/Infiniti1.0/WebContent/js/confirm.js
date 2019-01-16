$().ready(function() {
    $("#form").validate({
        // Definiamo le nostre regole di validazione
        rules : {
            // (NON ATTIVO)
            delaccount : {
              // Definiamo il campo login come obbligatorio
              required : true
            },
            
            
        },

        // Settiamo il submit handler per la form
        submitHandler: function(form) { 
            alert('Operazione Riuscita');
            form.submit();
          },

          invalidHandler: function() { 
            alert('Impossibile eseguire...riprova');
          }, 
    });
});
