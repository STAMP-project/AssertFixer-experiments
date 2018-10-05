<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	buffer="64kb"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://localhost/customtag" prefix="tags"%>
<%@ taglib uri="http://localhost/functiontag" prefix="f"%>
<%@ taglib uri="http://localhost/jeetags" prefix="siga"%>
<%@ taglib uri="http://localhost/libstag" prefix="libs"%>

<%@page import="br.gov.jfrj.siga.ex.ExMovimentacao"%>
<%@page import="br.gov.jfrj.siga.ex.ExMobil"%>
<siga:cabecalho titulo="Documento" popup="${popup}" />

<c:if test="${not docVO.digital}">
	<script type="text/javascript">
		$("html").addClass("fisico");
		$("body").addClass("fisico");
	</script>
</c:if>
<div class="gt-bd" style="padding-bottom: 0px;">
	<div class="gt-content">

		<c:if test="${not empty msg}">
			<p align="center">
				<b>
					${msg}
				</b>
			</p>
		</c:if>
		<h2 style="margin-bottom: 0px;">
			<c:if test="${empty ocultarCodigo}">
				${docVO.sigla}
			</c:if>
		</h2>
		<c:set var="primeiroMobil" value="${true}" />
		<c:forEach var="m" items="${docVO.mobs}" varStatus="loop">
			<c:if test="${f:resource('isWorkflowEnabled')}">
				<script type="text/javascript">
					var url = "/sigawf/app/doc?sigla=${m.sigla}&ts=1${currentTimeMillis}";
					Siga.ajax(url, null, "GET", function(response){		
						var div = $(".wf_div${m.mob.codigoCompacto}:last"); 
						$(div).html(response);
					});		
				</script>
			</c:if>
		
			<c:if
				test="${m.mob.geral or true or (((mob.geral or (mob.id == m.mob.id)) and (exibirCompleto or (m.mob.ultimaMovimentacaoNaoCancelada != null) ) ))}">
				<h3 style="margin-top: 10px; margin-bottom: 0px;">
					${m.getDescricaoCompletaEMarcadoresEmHtml(cadastrante,lotaTitular)}
					<c:if test="${docVO.digital and not empty m.tamanhoDeArquivo}">
					 	- ${m.tamanhoDeArquivo}
					 </c:if>
				</h3>
				<c:set var="ocultarCodigo" value="${true}" />
				<c:if test='${popup!="true"}'>
					<c:set var="acoes" value="${m.acoesOrdenadasPorNome}" />
					<siga:links>
						<c:forEach var="acao" items="${acoes}">
							<siga:link icon="${acao.icone}" title="${acao.nomeNbsp}" pre="${acao.pre}" pos="${acao.pos}" 
								url="${pageContext.request.contextPath}${acao.url}" test="${true}" popup="${acao.popup}" confirm="${acao.msgConfirmacao}" 
								classe="${acao.classe}" />
						</c:forEach>
					</siga:links>
				</c:if>

				<c:if test="${f:resource('isWorkflowEnabled')}">
					<c:if test="${(not m.mob.geral)}">
						<div id="${m.sigla}" depende=";wf;" class="wf_div${m.mob.codigoCompacto}" />
						</div>
					</c:if>
					<!--ajax:${m.sigla}-${i}-->
					<!--/ajax:${m.sigla}-${i}-->
				
				</c:if>
				<c:set var="dtUlt" value="" />
				<c:set var="temmov" value="${false}" />
				<c:forEach var="mov" items="${m.movs}">
					<c:if test="${ (exibirCompleto == true) or (mov.idTpMov != 14 and not mov.cancelada)}">
						<c:set var="temmov" value="${true}" />
					</c:if>
				</c:forEach>
				<c:if test="${temmov}">
					<div class="gt-content-box gt-for-table" style="margin-bottom: 25px;">
						<table class="gt-table mov">
							<thead>
								<tr>
									<th align="center" rowspan="2">
										Data
									</th>
									<th rowspan="2">
										Evento
									</th>
									<th colspan="2" align="left">
										Cadastrante
									</th>
									<c:if test="${ (exibirCompleto == 'true')}">
										<th colspan="2" align="left">
											Responsável
										</th>
									</c:if>
									<th colspan="2" align="left">
										Atendente
									</th>
									<th rowspan="2">
										Descrição
									</th>
									<th align="center" rowspan="2">
										Duração
									</th>
								</tr>
								<tr>
									<th align="left">
										Lotação
									</th>
									<th align="left">
										Pessoa
									</th>
									<c:if test="${ (exibirCompleto == 'true')}">
										<th align="left">
											Lotação
										</th>
										<th align="left">
											Pessoa
										</th>
									</c:if>
									<th align="left">
										Lotação
									</th>
									<th align="left">
										Pessoa
									</th>
								</tr>
							</thead>
							<c:set var="evenorodd" value="odd" />
							<c:forEach var="mov" items="${m.movs}">
								<c:if test="${ (exibirCompleto == true) or (mov.idTpMov != 14 and not mov.cancelada)}">
									<tr class="${mov.classe} ${mov.disabled}">
										<c:if test="${ (exibirCompleto == 'true')}">
											<c:set var="dt" value="${mov.dtRegMovDDMMYYHHMMSS}" />
										</c:if>
										<c:if test="${ (exibirCompleto != 'true')}">
											<c:set var="dt" value="${mov.dtRegMovDDMMYY}" />
										</c:if>
										<c:choose>
											<c:when test="${dt == dtUlt}">
												<c:set var="dt" value="" />
											</c:when>
											<c:otherwise>
												<c:set var="dtUlt" value="${dt}" />
											</c:otherwise>
										</c:choose>
										<td align="center">
											${dt}
										</td>
										<td>
											${mov.descrTipoMovimentacao}
										</td>
										<td align="left">
											<siga:selecionado isVraptor="true" sigla="${mov.parte.lotaCadastrante.siglaOrgao}${mov.parte.lotaCadastrante.sigla}"
												descricao="${mov.parte.lotaCadastrante.descricaoAmpliada}"
												lotacaoParam="${mov.parte.lotaCadastrante.siglaOrgao}${mov.parte.lotaCadastrante.sigla}" />
										</td>
										<td align="left">
											<siga:selecionado isVraptor="true" sigla="${mov.parte.cadastrante.nomeAbreviado}"
												descricao="${mov.parte.cadastrante.descricao} - ${mov.parte.cadastrante.sigla}"
												pessoaParam="${mov.parte.cadastrante.sigla}" />
										</td>
										<c:if test="${ (exibirCompleto == 'true')}">
											<td align="left">
												<siga:selecionado isVraptor="true" sigla="${mov.parte.lotaSubscritor.siglaOrgao}${mov.parte.lotaSubscritor.sigla}" 
													descricao="${mov.parte.lotaSubscritor.descricaoAmpliada}" 
													lotacaoParam="${mov.parte.lotaSubscritor.siglaOrgao}${mov.parte.lotaSubscritor.sigla}" />
											</td>
											<td align="left">
												<siga:selecionado isVraptor="true"
													sigla="${mov.parte.subscritor.nomeAbreviado}"
													descricao="${mov.parte.subscritor.descricao} - ${mov.parte.subscritor.sigla}" 
													pessoaParam="${mov.parte.subscritor.sigla}" />
											</td>
										</c:if>
										<td align="left">
											<siga:selecionado isVraptor="true" sigla="${mov.parte.lotaResp.siglaOrgao}${mov.parte.lotaResp.sigla}"
												descricao="${mov.parte.lotaResp.descricaoAmpliada}" 
												lotacaoParam="${mov.parte.lotaResp.siglaOrgao}${mov.parte.lotaResp.sigla}" />
										</td>
										<td align="left">
											<siga:selecionado isVraptor="true" sigla="${mov.parte.resp.nomeAbreviado}"
												descricao="${mov.parte.resp.descricao} - ${mov.parte.resp.sigla}" 
												pessoaParam="${mov.parte.resp.sigla}"/>
										</td>
										<td>
											${mov.descricao}
											<c:if test='${mov.idTpMov != 2}'>
												${mov.complemento}
											</c:if>
											<c:set var="assinadopor" value="${true}" />
											<siga:links inline="${true}"
												separator="${not empty mov.descricao and mov.descricao != null}">
												<c:forEach var="acao" items="${mov.acoes}">
													<siga:link title="${acao.nomeNbsp}" pre="${acao.pre}" pos="${acao.pos}" 
														url="${pageContext.request.contextPath}${acao.url}" test="${true}" popup="${acao.popup}" 
														confirm="${acao.msgConfirmacao}" ajax="${acao.ajax}" 
														idAjax="${mov.idMov}" classe="${acao.classe}" />
													<c:if test='${assinadopor and mov.idTpMov == 2}'>
														${mov.complemento}
														<c:set var="assinadopor" value="${false}" />
													</c:if>
												</c:forEach>
											</siga:links>
										</td>
										<c:if test="${exibirCompleto != 'true' and mov.duracaoSpan > 0}">
											<td align="center" class="duracaoborderbottom" rowspan="${mov.duracaoSpan}">
												${mov.duracao}
											</td>
										</c:if>
										<c:if test="${exibirCompleto == 'true' and mov.duracaoSpanExibirCompleto > 0}">
											<td align="center" class="duracaoborderbottom" rowspan="${mov.duracaoSpanExibirCompleto}">
												${mov.duracao}
											</td>
										</c:if>
									</tr>
									<c:choose>
										<c:when test='${evenorodd == "even"}'>
											<c:set var="evenorodd" value="odd" />
										</c:when>
										<c:otherwise>
											<c:set var="evenorodd" value="even" />
										</c:otherwise>
									</c:choose>
								</c:if>
							</c:forEach>
						</table>
					</div>
				</c:if>
				<c:if test="${not empty m.expedientesFilhosNaoCancelados}">
					<c:set var="first" value="true" />
					<p class="apensados" style="margin-top: 0pt;">
							Documento
						<c:if test="${m.apensos.size() gt 1}">
							s
						</c:if>
						Filho
						<c:if test="${m.apensos.size() gt 1}">
							s
						</c:if>
						:
						<c:forEach var="docFilho" items="${m.expedientesFilhosNaoCancelados}">
							<c:if test="${!docFilho.doc.cancelado}">
							<c:if test="${not first}">
								, 
							</c:if>
							<a href="${pageContext.request.contextPath}/app/expediente/doc/exibir?sigla=${docFilho.sigla}" title="${docFilho.descrDocumento}">
								<b>
									${docFilho.sigla}
								</b>
							</a>
							<c:set var="first" value="false" />
							</c:if>
						</c:forEach>
					</p>
				</c:if>
				<c:if test="${not empty m.processosFilhosNaoCancelados}">
					<c:set var="first" value="true" />
					<p class="apensados" style="margin-top: 0pt;">
						Subprocesso
						<c:if test="${m.apensos.size() gt 1}">
							s
						</c:if>
						:
						<c:forEach var="docFilho" items="${m.processosFilhosNaoCancelados}">
							<c:if test="${!docFilho.doc.cancelado}">
							<c:if test="${not first}">
								, 
							</c:if>
							<a href="${pageContext.request.contextPath}/app/expediente/doc/exibir?sigla=${docFilho.sigla}" title="${docFilho.descrDocumento}">
								<b>
									${docFilho.siglaCurtaSubProcesso}
								</b>
							</a>
							<c:set var="first" value="false" />
							</c:if>
						</c:forEach>
					</p>
				</c:if>	
				<c:if test="${not empty m.apensos}">
					<c:set var="first" value="true" />siga.
					<p class="apensados" style="margin-top: 0pt;">
						Documento
						<c:if test="${m.apensos.size() gt 1}">
							s
						</c:if>
						Apensado
						<c:if test="${m.apensos.size() gt 1}">
							s
						</c:if>
						:
						<c:forEach var="mobItem" items="${m.apensos}">

							<c:if test="${not first}">
								, 
							</c:if>
							<a href="${pageContext.request.contextPath}/app/expediente/doc/exibir?sigla=${mobItem.sigla}" title="${mobItem.mob.doc.descrDocumento}">
								${mobItem.sigla}
							</a>
							<c:set var="first" value="false" />
						</c:forEach>
					</p>
				</c:if>
			</c:if>
		</c:forEach>
	</div>
</div>
<div class="gt-bd gt-cols clearfix"
	style="padding-top: 0px; margin-top: 25px;">
	<div class="gt-content">
		<div class="gt-content-box" style="padding: 10px;">
			<table style="width: 100%">
				<tr>
					<td>
						<c:if test="${docVO.conteudoBlobHtmlString != null}">
							<tags:fixdocumenthtml>
								${docVO.conteudoBlobHtmlString}
							</tags:fixdocumenthtml>
						</c:if>
					</td>
				</tr>
			</table>
		</div>
	</div>
	<div class="gt-sidebar">
		<div class="gt-sidebar-content">
			<h3>
				${docVO.nomeCompleto}
			</h3>
			<p>
				<b>
					Suporte:
				</b>
				${docVO.fisicoOuEletronico}
			</p>
			<p>
				<b>
					Nível de Acesso:
				</b>
					 ${docVO.nmNivelAcesso} 
				<c:if test="${not empty docVO.listaDeAcessos}">
					<c:choose>
						<c:when test="${docVO.listaDeAcessos.size() eq 1}">
							<c:forEach var="acesso" items="${docVO.listaDeAcessos}" varStatus="loop">
								<c:choose>
									<c:when test="${acesso eq 'PUBLICO'}">
										(Público)
									</c:when>
									<c:otherwise>
										(${acesso.sigla})
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<ul>	
								<c:forEach var="acesso" items="${docVO.listaDeAcessos}" varStatus="loop">
									<li>
										${acesso.sigla}
									</li>
								</c:forEach>
							</ul>
						</c:otherwise>
					</c:choose>
				</c:if>
			</p>
			<p>
				<b>
					Data:
				</b>
				 ${docVO.dtDocDDMMYY}
			</p>
			<p>
				<b>
					De:
				</b>
				 ${docVO.subscritorString}
			</p>
			<p>
				<b>
					Para:
				</b>
				 ${docVO.destinatarioString}
			</p>
			<p>
				<b>
					Espécie:
				</b>
				 ${docVO.forma}
			</p>
			<p>
				<b>
					Modelo:
				</b>
				 ${docVO.modelo}
			</p>
			<p>
				<b>
					Descrição:
				</b>
				 ${docVO.descrDocumento}
			</p>
			<p>
				<b>
					Classificação:
				</b>
				 ${docVO.classificacaoDescricaoCompleta}
			</p>
			<p>
				<b>
					Cadastrante:
				</b>
				 ${docVO.cadastranteString} ${docVO.lotaCadastranteString}
			</p>
			<c:if test="${not empty docVO.paiSigla}">
				<p>
					<b>
						Documento Pai:
					</b>
					<a href="${pageContext.request.contextPath}/app/expediente/doc/exibir?sigla=${docVO.paiSigla}">
						${docVO.paiSigla}
					</a>
				</p>
			</c:if>
			<c:if test="${not empty docVO.documentosPublicados}">
				<p class="apensados" style="margin-top: 0pt;">
					<b>
						Documentos Publicados: 
					</b>
					<c:forEach var="documentoPublicado" items="${docVO.documentosPublicados}">
						<a href="${pageContext.request.contextPath}/app/expediente/doc/exibir?sigla=${documentoPublicado.sigla}" title="${documentoPublicado.sigla}">
							${documentoPublicado.sigla}
						</a>
						&nbsp;
					</c:forEach>
				</p>
			</c:if>
			<c:if test="${not empty docVO.boletim}">
				<p class="apensados" style="margin-top: 0pt;">
					<b>
						Publicado no Boletim: 
					</b>
					<a href="${pageContext.request.contextPath}/app/expediente/doc/exibir?sigla=${docVO.boletim.sigla}" title="${docVO.boletim.sigla}">
						${docVO.boletim.sigla}
					</a>
				</p>
			</c:if>
			<c:if test="${not empty docVO.dadosComplementares}">
	        	${docVO.dadosComplementares}
     		</c:if>
		</div>
		<div class="gt-sidebar-content" id="gc">
		</div>
	</div>
</div>
<c:if test="${f:podeUtilizarServicoPorConfiguracao(titular,lotaTitular,'SIGA;GC')}">
	<c:url var="url" value="/../sigagc/app/knowledge">
		<c:param name="tags">
			@documento
		</c:param>
		<c:forEach var="tag" items="${docVO.tags}">
			<c:param name="tags">
				${tag}
			</c:param>
		</c:forEach>
		<c:param name="estilo">
			sidebar
		</c:param>
		<c:param name="ts">
			${currentTimeMillis}
		</c:param>
	</c:url>
	<script type="text/javascript">
		SetInnerHTMLFromAjaxResponse("${url}",document.getElementById('gc'));
	</script>
</c:if>
<siga:rodape />