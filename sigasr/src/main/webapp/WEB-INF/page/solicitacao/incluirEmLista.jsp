<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://localhost/jeetags" prefix="siga"%>
<%@ taglib uri="http://localhost/sigasrtags" prefix="sigasr"%>
<div class="gt-content-box gt-for-table" style="margin-top: 15px;">
	<form id="formSelecionarLista" action="${linkTo[SolicitacaoController].incluirEmListaGravar}?sigla=${solicitacao.siglaCompacta}
		${lista != null ? '&idLista='+lista.idLista : ''}" onsubmit="javascript: return block();" enctype="multipart/form-data">
		<input type="hidden" name="prioridade" />
		<input type="hidden" name="naoReposicionarAutomatico"/>
			
		<div style="max-height: 500px; max-width: 800px; overflow-y: scroll;">
			<table border="0" class="gt-table">
				<col width="20%" />
		   		<col width="20%" />
		    		<thead>
						<tr class="gt-celula-nowrap">
							<th style="color: #333; font-weight: bold; padding: 7px 10px;">Incluir</th>
							<th style="color: #333; font-weight: bold; padding: 7px 10px;">Descri&ccedil;&atilde;o da Lista</th>
		  				</tr>
		  			</thead>
				<tbody>
				<c:forEach items="${solicitacao.getListasDisponiveisParaInclusao(lotaTitular, titular)}" var="lista">
					<tr>
						<td class="gt-celula-nowrap" style="font-size: 13px; font-weight: bold; border-bottom: 1px solid #ccc !important; padding: 7px 10px;">
							<input type="radio" name="idLista" value="${lista.idLista}" data-pode-priorizar="${lista.podePriorizar(lotaTitular, titular)}">	
						</td>
						<td class="gt-celula-nowrap" style="font-size: 9pt; padding: 7px 10px; border-bottom: 1px solid #ccc !important;" "id="descrLista">
							${lista.nomeLista}
						</td>
					</tr>		
				</c:forEach>
				</tbody>
			</table>
		</div>	
		
		<div class="gt-table-button gt-width-66">
			<input type="hidden" name="sigla" value="${solicitacao.siglaCompacta}">
			<input type="button" value="Selecionar Lista" class="gt-btn-medium gt-btn-left" onclick="listaService.incluirEmLista()"/>
			<a href="${linkTo[SolicitacaoController].exibir[solicitacao.siglaCompacta]}" class="gt-btn-medium gt-btn-left">Voltar</a>
		</div>
		
		<sigasr:modal nome="selecionarPrioridade" titulo="Selecionar Prioridade">
			<div class="gt-form gt-content-box">
				<div class="gt-form-row gt-width-66">
					<label>Prioridade <span>*</span></label> 
					
					<select name="prioridade">	
						<option value="">Nenhuma</option>
						<c:forEach items="${prioridades}" var="prioridade">
							<option value="${prioridade}">${prioridade.descPrioridade}</option>
						</c:forEach>
					</select>
				</div>
				
				<div class="gt-form-row gt-width-100">
					<label>N&atilde;o reposicionar automaticamente ao alterar a prioridade: <input type="checkbox" name="naoReposicionarAutomatico"></label> 
				</div>
				
				<div class="gt-width-100 gt-form-row ">
					<input type="button" value="Adicionar" class="gt-btn-medium gt-btn-left" onclick="listaService.gravarInclusaoComPrioridade()"/>
					<input type="button" class="gt-btn-medium gt-btn-left" value="Cancelar" onclick="listaService.fecharModalPrioridade()"/>
				</div>
			</div>
		</sigasr:modal>
	</form>
	
	<script>
		var listaService = {};
		listaService.form =  $('#formSelecionarLista');
		listaService.dialog = $('#selecionarPrioridade_dialog');

		listaService.gravarInclusaoComPrioridade = function() {
			listaService.form.find('[name=prioridade]').val(listaService.dialog.find('[name=prioridade]').val());
			listaService.form.find('[name=naoReposicionarAutomatico]').val(listaService.dialog.find('[name=naoReposicionarAutomatico]').is(':checked'));
			
			listaService.form.submit();
		}
		
		listaService.incluirEmLista = function() {
			if(listaService.selecionou()) {
				if(listaService.podePriorizar()) listaService.abrirModalPrioridade();
				else  listaService.form.submit();
			} else alert('Selecione uma lista para inclusão da solicitação');
		}

		listaService.abrirModalPrioridade = function() {
			listaService.limparDados();
			listaService.dialog.dialog('open');
		}

		listaService.fecharModalPrioridade = function() {
			listaService.limparDados();
			listaService.dialog.dialog('close');
		}

		listaService.limparDados = function() {
			$('[name=prioridade]').val('');
			listaService.form.find('[name=naoReposicionarAutomatico]').val('false');
			listaService.dialog.find('[name=naoReposicionarAutomatico]').attr('checked', false);
		}
		
		listaService.podePriorizar = function() {
			return listaService
					.form
					.find(':checked')
					.attr('data-pode-priorizar') == 'true';
		}

		listaService.selecionou = function() {
			return listaService
					.form
					.find(':checked').size() > 0;
		}
	</script>
</div>
