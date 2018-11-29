	$(document).ready(function () { 
					var $nome= $("#nome");
			        $nome.attr("maxlength","100");
			        
			        var $nomeVeterinario= $("#nomeVeterinario");
			        $nomeVeterinario.attr("maxlength","100");
			        
			        var $nomePet= $("#nomePet");
			        $nomePet.attr("maxlength","50");
			        
			        var $planoSaude= $("#planoSaude");
			        $planoSaude.attr("maxlength","100");
			        
			        var $formacao= $("#formacao");
			        $formacao.attr("maxlength","100");
			        
			        var $porte= $("#porte");
			        $porte.attr("maxlength","10");
			        
			        var $especie= $("#especie");
			        $especie.attr("maxlength","50");
			        
			        var $raca= $("#raca");
			        $raca.attr("maxlength","50");
			        
			        var $registro= $("#numeroRegistro");
			        $registro.attr("maxlength","100");
			        
			        var $numero= $("#numeroEndereco");
			        $numero.attr("min","0");
			        $numero.attr("max","99999");
			        
			        
			        
			        var $numeroV= $("#numero");
			        $numeroV.attr("min","0");
			        $numeroV.attr("max","99999");
			        
					var $cep= $("#cep");
			        $cep.mask('00000-000', {reverse: true});
			        var $celular= $("#celular");
			        $celular.mask('(00)00000-0000', {reverse: true});
			        var $telefone= $("#telefone");
			        $telefone.mask('(00)0000-0000', {reverse: true});
			        
			        $("#cpfCnpj").keydown(function(){
			            try {
			                $("#cpfCnpj").unmask();
			            } catch (e) {}

			            var tamanho = $("#cpfCnpj").val().length;

			            if(tamanho < 11){
			                $("#cpfCnpj").mask("999.999.999-99");
			            } else if(tamanho >= 11){
			                $("#cpfCnpj").mask("99.999.999/9999-99");
			            }

			            // ajustando foco
			            var elem = this;
			            setTimeout(function(){
			                // mudo a posição do seletor
			                elem.selectionStart = elem.selectionEnd = 10000;
			            }, 0);
			            // reaplico o valor para mudar o foco
			            var currentValue = $(this).val();
			            $(this).val('');
			            $(this).val(currentValue);
			        });
			        
					});
	