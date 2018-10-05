/*******************************************************************************
 * Copyright (c) 2006 - 2011 SJRJ.
 * 
 *     This file is part of SIGA.
 * 
 *     SIGA is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 * 
 *     SIGA is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 * 
 *     You should have received a copy of the GNU General Public License
 *     along with SIGA.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package br.gov.jfrj.siga.wf.bl;

import java.lang.reflect.Method;

import org.hibernate.LockMode;

import br.gov.jfrj.siga.cp.CpSituacaoConfiguracao;
import br.gov.jfrj.siga.cp.CpTipoConfiguracao;
import br.gov.jfrj.siga.cp.bl.CpCompetenciaBL;
import br.gov.jfrj.siga.dp.DpLotacao;
import br.gov.jfrj.siga.dp.DpPessoa;
import br.gov.jfrj.siga.dp.dao.CpDao;
import br.gov.jfrj.siga.wf.WfConfiguracao;
import br.gov.jfrj.siga.wf.dao.WfDao;

/**
 * Classe que representa as competências da lógica de negócio do sistema de
 * workflow.
 * 
 * @author kpf
 * 
 */
public class WfCompetenciaBL extends CpCompetenciaBL {

	/**
	 * Verifica se a pessoa ou lotação pode instanciar um procedimento
	 * (Process).
	 * 
	 * @param titular
	 * @param lotaTitular
	 * @param procedimento
	 * @return
	 * @throws Exception
	 */
	public Boolean podeInstanciarProcedimento(DpPessoa titular,
			DpLotacao lotaTitular, final String procedimento) throws Exception {
		if (lotaTitular == null)
			return false;
		return podePorConfiguracao(titular, lotaTitular, procedimento,
				CpTipoConfiguracao.TIPO_CONFIG_INSTANCIAR_PROCEDIMENTO);
	}

	/**
	 * Retorna um configuração existente para a combinação dos dados passados
	 * como parâmetros, caso exista.
	 * 
	 * @param titularIniciador
	 * @param lotaTitularIniciador
	 * @param tipoConfig
	 * @param procedimento
	 * @param raia
	 * @param tarefa
	 * @return
	 * @throws Exception
	 */
	private WfConfiguracao preencherFiltroEBuscarConfiguracao(
			DpPessoa titularIniciador, DpLotacao lotaTitularIniciador,
			long tipoConfig, final String procedimento, final String raia,
			final String tarefa) throws Exception {
		WfConfiguracao cfgFiltro = new WfConfiguracao();

		cfgFiltro.setCargo(titularIniciador!=null?titularIniciador.getCargo():null);
		cfgFiltro.setOrgaoUsuario(lotaTitularIniciador!=null?lotaTitularIniciador.getOrgaoUsuario():null);
		cfgFiltro.setFuncaoConfianca(titularIniciador!=null?titularIniciador.getFuncaoConfianca():null);
		cfgFiltro.setLotacao(lotaTitularIniciador);
		cfgFiltro.setDpPessoa(titularIniciador!=null?titularIniciador:null);
		cfgFiltro.setCpTipoConfiguracao(CpDao.getInstance().consultar(
				tipoConfig, CpTipoConfiguracao.class, false));

		cfgFiltro.setProcedimento(procedimento);
		cfgFiltro.setRaia(raia);
		cfgFiltro.setTarefa(tarefa);

		WfConfiguracao cfg = (WfConfiguracao) getConfiguracaoBL()
				.buscaConfiguracao(cfgFiltro, new int[] { 0 }, null);

		// Essa linha é necessária porque quando recuperamos um objeto da classe
		// WfConfiguracao do TreeMap estático que os armazena, este objeto está
		// detached, ou seja, não está conectado com a seção atual do hibernate.
		// Portanto, quando vamos acessar alguma propriedade dele que seja do
		// tipo LazyRead, obtemos um erro. O método lock, attacha ele novamente
		// na seção atual.
		if (cfg != null)
			WfDao.getInstance().getSessao().lock(cfg, LockMode.NONE);

		return cfg;
	}

	/**
	 * Verifica se uma pessoa ou lotação tem permissão em uma configuração
	 * passada como parâmetro.
	 * 
	 * @param titular
	 * @param lotaTitular
	 * @param procedimento
	 * @param tipoConfig
	 *            - Configuração que terá a permissão verificada.
	 * @return
	 * @throws Exception
	 */
	private Boolean podePorConfiguracao(DpPessoa titular,
			DpLotacao lotaTitular, String procedimento, long tipoConfig)
			throws Exception {
		CpSituacaoConfiguracao situacao;
		WfConfiguracao cfg = preencherFiltroEBuscarConfiguracao(titular,
				lotaTitular, tipoConfig, procedimento, null, null);

		if (cfg != null) {
			situacao = cfg.getCpSituacaoConfiguracao();
		} else {
			situacao = CpDao.getInstance().consultar(tipoConfig,
					CpTipoConfiguracao.class, false).getSituacaoDefault();
		}

		if (situacao != null
				&& situacao.getIdSitConfiguracao() == CpSituacaoConfiguracao.SITUACAO_PODE)
			return true;
		return false;
	}

	/**
	 * Retorna uma configuração de designação de tarefa.
	 * 
	 * @param titularIniciador
	 * @param lotaTitularIniciador
	 * @param titularAnterior
	 * @param lotaTitularAnterior
	 * @param procedimento
	 * @param raia
	 * @param tarefa
	 * @return
	 * @throws Exception
	 */
	public WfConfiguracao designar(DpPessoa titularIniciador,
			DpLotacao lotaTitularIniciador, DpPessoa titularAnterior,
			DpLotacao lotaTitularAnterior, final String procedimento,
			final String raia, final String tarefa) throws Exception {

		WfConfiguracao cfg = preencherFiltroEBuscarConfiguracao(
				titularIniciador, lotaTitularIniciador,
				CpTipoConfiguracao.TIPO_CONFIG_DESIGNAR_TAREFA, procedimento,
				raia, tarefa);
		if (cfg == null)
			return null;

		return cfg;
	}

	/**
	 * Verifica se uma pessoa ou lotação tem competência para realizar uma
	 * determinada ação no sistema.
	 * 
	 * @param funcao
	 *            Competência a ser testada (Ex: IntanciarProcedimento)
	 * @param titular
	 *            Pessoa a ser verificada
	 * @param lotaTitular
	 *            Lotação a ser verificada
	 * @param pd
	 *            Procedimento a ser testado
	 * @return true se a pessoa/lotação tem competência para realizar a ação.
	 */
	public boolean testaCompetencia(final String funcao,
			final DpPessoa titular, final DpLotacao lotaTitular, final String pd) {
		final Class[] classes = new Class[] { DpPessoa.class, DpLotacao.class,
				String.class };
		Boolean resposta = false;
		try {
			final Method method = WfCompetenciaBL.class.getDeclaredMethod(
					"pode" + funcao.substring(0, 1).toUpperCase()
							+ funcao.substring(1), classes);
			resposta = (Boolean) method.invoke(WfCompetenciaBL.class,
					new Object[] { titular, lotaTitular, pd });
		} catch (final Exception e) {
			e.printStackTrace();
		}

		return resposta.booleanValue();
	}
}
