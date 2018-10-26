var trocaTela = function(tela){

    // Declaração de Variáveis
    var result = document.getElementById("telaPrincipal");
    var xmlreq = CriaRequest();
    // Exibi a imagem de progresso

    // Iniciar uma requisição
    xmlreq.open("POST",tela, true);
    //xmlreq.open( "POST","insertBanco.php",true);
    xmlreq.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    // Atribui uma função para ser executada sempre que houver uma mudança de ado
    xmlreq.onreadystatechange = function(){

            // Verifica se foi concluído com sucesso e a conexão fechada (readyState=4)
            if (xmlreq.readyState == 4) {

                    // Verifica se o arquivo foi encontrado com sucesso
                    if (xmlreq.status == 200) {
                            console.log(xmlreq.responseText);
                    }else{
                            result.innerHTML = "Erro: " + xmlreq.statusText;
                    }
            }
    };

    
};
function CriaRequest() {
    try{
        request = new XMLHttpRequest();        
    }catch (IEAtual){

        try{
        request = new ActiveXObject("Msxml2.XMLHTTP");       
        }catch(IEAntigo){

            try{
                request = new ActiveXObject("Microsoft.XMLHTTP");          
            }catch(falha){
                request = false;
            }
        }
    }

    if (!request) 
        alert("Seu Navegador não suporta Ajax!");
    else
        return request;
};
