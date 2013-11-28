/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// Variables globales

// Verification de formulaire
var check = {};

check['username'] = function(element){
    if(/[a-zA-Z0-9]{5,14}/.test(element.value)){
        return true;
    }
    else{
        $(element).effect('bounce',{},500);
        return false;
    }
    
};

check['email'] = function(element){
    if(/^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/.test(element.value)){
        return true;
    }
    else{
        $(element).effect('bounce',{},500);
        return false;
    }
    
};

check['password'] = function(element){
    if(/[a-zA-Z0-9]{5,14}/.test(element.value)){
        return true;
    }
    else{
        $(element).effect('bounce',{},500);
        return false;
    } 
};

check['confirm'] = function(element){
    
    if(element.value === document.inputs['password'].value){
        return true;
    }
    else{
        $(element).effect('bounce',{},500);
        return false;
    } 
};

// Fonctions globales
function alterneForm(){
    if($('#form-connexion').css('display') === 'none'){
        $('#form-inscription').show('drop').fadeOut('slow',function(){
            $('#form-connexion').hide('drop').fadeIn('slow');
        });
        
        $('#box-logOn h1').html('Connexion');
        $('#box-btn-logon').html('Inscription');
    }
    else if($('#form-inscription').css('display') === 'none'){
        $('#form-connexion').show('drop').fadeOut('slow',function(){
            $('#form-inscription').hide('drop').fadeIn('slow');
        });
        
        $('#box-logOn h1').html('Inscription');
        $('#box-btn-logon').html('Connexion');
    }
}

function verifieInputFormulaire(idForm){
    var result = true;
    var inputs = $('#'+idForm+' input');
    for(var i = 0; i < inputs.length; i++){
        if(inputs[i].type === 'text' || inputs[i].type === 'password') result = check[inputs[i].name](inputs[i]) && result;
    }
    console.log(result);
    return result;
}

$(document).ready(function(){
    // Boite de dialogue Mot de passe oublié
    $('#box-dialog-pwdforget').ready().dialog({
        title: "Mot de passe oublié ?",
        autoOpen: false,
        draggable: false,
        modal: true,
        width: 420,
        show: {
            effect: "drop",
            duration: 500
        },
        hide: {
            effect: "drop",
            duration: 500
        },
        buttons: [
            {
                text: "Envoyer",
                click: function() {
                    //console.log(check['email']($('#box-dialog-pwdforget form input[name="email"]')[0]));
                    if(check['email']($('#box-dialog-pwdforget form input[name="email"]')[0]))$('#box-dialog-pwdforget form').submit();
                    $( this ).dialog( "close" );
                }
            }
        ]
    });
    // Alternance de formulaire connexion to inscription
    $('#box-btn-logon').ready().click(alterneForm);
    // navigue sur le site en tant que visiteur
    $('#box-btn-guessIn').ready().click(function(){
        $('#box-btn-guessIn form').submit();
    });
    // On ouvre la boite de dialogue pour le mot de passe oublié
    $('#link-dialog-pwdforget').ready().click(function(){
        $('#box-dialog-pwdforget').dialog('open');
    });
    // verification du formulaire de connexion
    $('#form-connexion').submit(function(){
        return verifieInputFormulaire(this.id);
    });
    // verification du formulaire d'inscription
    $('#form-inscription').submit(function(){
        return verifieInputFormulaire(this.id);
    });
});