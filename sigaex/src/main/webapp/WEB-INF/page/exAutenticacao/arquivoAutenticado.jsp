<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	buffer="64kb"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://localhost/customtag" prefix="tags"%>
<%@ taglib uri="http://localhost/jeetags" prefix="siga"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://localhost/functiontag" prefix="f"%>

<siga:pagina titulo="Movimentação" desabilitarmenu="sim"
	onLoad="try{var num = document.getElementById('id_number');if (num.value == ''){num.focus();num.select();}else{var cap = document.getElementById('id_captcha');cap.focus();cap.select();}}catch(e){};">
	<div class="gt-bd clearfix">
		<div class="gt-content clearfix">
			<h2>Acompanhamento e Autenticação de Documentos</h2>
			<div>
				<c:url var='pdfAssinado'
					value='/public/app/arquivoAutenticado_stream?jwt=${jwt}&assinado=true' />
				<c:url var='pdf'
					value='/public/app/arquivoAutenticado_stream?jwt=${jwt}&assinado=false' />
				<iframe src="${pdfAssinado}" width="100%" height="600"
					align="center" style="margin-top: 10px;"> </iframe>
			</div>

			<c:if test="${not empty docVO}">
				<div>
					<br />
					<h2>Últimas Movimentações</h2>

					<c:forEach var="m" items="${docVO.mobs}" varStatus="loop">
						<c:if test="${f:resource('isWorkflowEnabled')}">
							<script type="text/javascript">
								var url = "/sigawf/app/doc?sigla=${m.sigla}&ts=1${currentTimeMillis}";
								Siga.ajax(url, null, "GET", function(response) {
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
							<c:set var="dtUlt" value="" />
							<c:set var="temmov" value="${false}" />
							<c:forEach var="mov" items="${m.movs}">
								<c:if
									test="${ (exibirCompleto == true) or (mov.idTpMov != 14 and not mov.cancelada)}">
									<c:set var="temmov" value="${true}" />
								</c:if>
							</c:forEach>
							<c:if test="${temmov}">
								<div class="gt-content-box gt-for-table"
									style="margin-bottom: 25px;">
									<table class="gt-table mov">
										<thead>
											<tr>
												<th align="center" rowspan="2">Data</th>
												<th rowspan="2">Evento</th>
												<th colspan="2" align="left">Cadastrante</th>
												<c:if test="${ (exibirCompleto == 'true')}">
													<th colspan="2" align="left">Responsável</th>
												</c:if>
												<th colspan="2" align="left">Atendente</th>
												<th align="center" rowspan="2">Duração</th>
											</tr>
											<tr>
												<th align="left">Lotação</th>
												<th align="left">Pessoa</th>
												<c:if test="${ (exibirCompleto == 'true')}">
													<th align="left">Lotação</th>
													<th align="left">Pessoa</th>
												</c:if>
												<th align="left">Lotação</th>
												<th align="left">Pessoa</th>
											</tr>
										</thead>
										<c:set var="evenorodd" value="odd" />
										<c:forEach var="mov" items="${m.movs}">
											<c:if
												test="${ (exibirCompleto == true) or (mov.idTpMov != 14 and not mov.cancelada)}">
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
													<td align="center">${dt}</td>
													<td>${mov.descrTipoMovimentacao}</td>
													<td align="left"><siga:selecionado isVraptor="true"
															sigla="${mov.parte.lotaCadastrante.sigla}"
															descricao="${mov.parte.lotaCadastrante.descricaoAmpliada}"
															lotacaoParam="${mov.parte.lotaCadastrante.siglaOrgao}${mov.parte.lotaCadastrante.sigla}" />
													</td>
													<td align="left"><siga:selecionado isVraptor="true"
															sigla="${mov.parte.cadastrante.nomeAbreviado}"
															descricao="${mov.parte.cadastrante.descricao} - ${mov.parte.cadastrante.sigla}"
															pessoaParam="${mov.parte.cadastrante.sigla}" /></td>
													<c:if test="${ (exibirCompleto == 'true')}">
														<td align="left"><siga:selecionado isVraptor="true"
																sigla="${mov.parte.lotaSubscritor.sigla}"
																descricao="${mov.parte.lotaSubscritor.descricaoAmpliada}"
																lotacaoParam="${mov.parte.lotaSubscritor.siglaOrgao}${mov.parte.lotaSubscritor.sigla}" />
														</td>
														<td align="left"><siga:selecionado isVraptor="true"
																sigla="${mov.parte.subscritor.nomeAbreviado}"
																descricao="${mov.parte.subscritor.descricao} - ${mov.parte.subscritor.sigla}"
																pessoaParam="${mov.parte.subscritor.sigla}" /></td>
													</c:if>
													<td align="left"><siga:selecionado isVraptor="true"
															sigla="${mov.parte.lotaResp.sigla}"
															descricao="${mov.parte.lotaResp.descricaoAmpliada}"
															lotacaoParam="${mov.parte.lotaResp.siglaOrgao}${mov.parte.lotaResp.sigla}" />
													</td>
													<td align="left"><siga:selecionado isVraptor="true"
															sigla="${mov.parte.resp.nomeAbreviado}"
															descricao="${mov.parte.resp.descricao} - ${mov.parte.resp.sigla}"
															pessoaParam="${mov.parte.resp.sigla}" /></td>
													<c:if
														test="${exibirCompleto != 'true' and mov.duracaoSpan > 0}">
														<td align="center" class="duracaoborderbottom"
															rowspan="${mov.duracaoSpan}">${mov.duracao}</td>
													</c:if>
													<c:if
														test="${exibirCompleto == 'true' and mov.duracaoSpanExibirCompleto > 0}">
														<td align="center" class="duracaoborderbottom"
															rowspan="${mov.duracaoSpanExibirCompleto}">
															${mov.duracao}</td>
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
						</c:if>
					</c:forEach>
				</div>
			</c:if>
			<div>
				<br />
				<h2>Autenticação: Arquivos para Download</h2>
				<ul>
					<li><a href="${pdf}" target="_blank">PDF do documento</a></li>
				</ul>
				<br />
				<h3>Assinaturas:</h3>
				<ul>
					<c:forEach var="assinatura" items="${assinaturas}" varStatus="loop">
						<c:url var='arqAssinatura'
							value='/public/app/arquivoAutenticado_stream?jwt=${jwt}&idMov=${assinatura.idMov}' />
						<li><a href="${arqAssinatura}" target="_blank">${assinatura.descrMov}</a></li>
					</c:forEach>
				</ul>
				<div id="dados-assinatura" style="visible: hidden">
					<input type="hidden" name="ad_url_base" value="" /> <input
						type="hidden" name="ad_url_next"
						value="${request.contextPath}/public/app/autenticar?jwt=${jwt}" />
					<input type="hidden" name="ad_descr_0" value="${mov.referencia}" />
					<input type="hidden" name="ad_url_pdf_0"
						value="${request.contextPath}/public/app/arquivoAutenticado_stream?jwt=${jwt}&assinado=false" />
					<input type="hidden" name="ad_url_post_0"
						value="${request.contextPath}/public/app/autenticar?jwt=${jwt}&ass=1" />
					<!--  Edson: a assinatura com senha está desabilitada aqui, por enquanto -->
					<input type="hidden" name="ad_url_post_password_0"
						value="${request.contextPath}/public/app/autenticar?jwt=${jwt}&ass=1" />

					<input type="hidden" name="ad_id_0"
						value="${fn:replace(mov.referencia, ':', '_')}" /> <input
						type="hidden" name="ad_description_0" value="${mov.obs}" /> <input
						type="hidden" name="ad_kind_0"
						value="${mov.exTipoMovimentacao.sigla}" />

				</div>
				<c:if test="${mostrarBotaoAssinarExterno}">
					<tags:assinatura_botoes assinar="true" autenticar="false"
						assinarComSenha="false" autenticarComSenha="false"
						idMovimentacao="${mov.idMov}" />
				</c:if>
			</div>
		</div>
	</div>


	<tags:assinatura_rodape />
</siga:pagina>
