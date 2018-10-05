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
package br.gov.jfrj.siga.wf.util;

import javax.servlet.ServletException;

import org.apache.log4j.Logger;
import org.jbpm.JbpmContext;
import org.jbpm.db.JobSession;
import org.jbpm.graph.exe.ProcessInstance;
import org.jbpm.job.Job;
import org.jbpm.job.executor.JobExecutorThread;

import br.gov.jfrj.siga.wf.bl.Wf;
import br.gov.jfrj.siga.wf.dao.WfDao;

/**
 * Classe que representa um thread de execuï¿½ï¿½o de job
 * 
 * @author kpf
 * 
 */
public class WfJobExecutorThread extends JobExecutorThread {
	private static final Logger log = Logger
			.getLogger(WfJobExecutorThread.class);

	/**
	 * Construtor.
	 * 
	 * @param name
	 * @param jobExecutor
	 */
	public WfJobExecutorThread(String threadName, WfJobExecutor wfJobExecutor) {
		super(threadName, wfJobExecutor);
	}

	/**
	 * Executa o job.
	 * 
	 * @throws Exception
	 */
	@Override
	protected void executeJob(Job j) throws Exception {
		WfExecutionEnvironment ee = new WfExecutionEnvironment();
		JbpmContext jbpmContext = null;
		try {
			Wf.setInstance(null);
			ee.antes();
			WfDao.getInstance().getSessao().merge(j);

			jbpmContext = WfContextBuilder.getJbpmContext().getJbpmContext();

			try {
				JobSession jobSession = jbpmContext.getJobSession();
				Job job = jobSession.getJob(j.getId());
				// register process instance for automatic save
				// https://jira.jboss.org/browse/JBPM-1015
				ProcessInstance processInstance = job.getProcessInstance();
				jbpmContext.addAutoSaveProcessInstance(processInstance);

				// if job is exclusive, lock process instance
				if (job.isExclusive()) {
					jbpmContext.getGraphSession().lockProcessInstance(
							processInstance);
				}

				if (log.isDebugEnabled())
					log.debug("executing " + job);
				job.execute(jbpmContext);
				jobSession.deleteJob(job);
			} catch (Exception e) {
				jbpmContext.setRollbackOnly();
				throw e;
			} catch (Error e) {
				jbpmContext.setRollbackOnly();
				throw e;
			}
			ee.depois();
		} catch (Exception e) {
			ee.excecao();
			if (!jbpmContext.isClosed()) {
				jbpmContext.close();
			}
			throw new ServletException(e);
		} finally {
			((org.hibernate.proxy.HibernateProxy) j.getProcessInstance())
					.getHibernateLazyInitializer().getSession().connection()
					.close();
			ee.finalmente();
		}
	}
}
