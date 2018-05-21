package com.bonjourcs.java.ejc.io;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Liang Chenghao
 * Description: object to write
 * Date: 2018/5/17
 */
@Data
public class MockObject implements Serializable {

	private static final long serialVersionUID = -3545643109148992882L;

	/**
	 * object name
	 */
	private String objectName;
	/**
	 * mark date
	 */
	private Date markDate;
	/**
	 * inner object
	 */
	private InnerObject innerObject;

	/**
	 * set inner object
	 *
	 * @param objectName inner object name
	 * @param markDate   inner mark date
	 */
	public void setInnerObject(String objectName, Date markDate) {
		this.innerObject = new InnerObject(objectName, markDate);
	}

	/**
	 * get inner object name
	 *
	 * @return name
	 */
	public String getInnerName() {
		return this.innerObject.innerName;
	}

	@Data
	private class InnerObject implements Serializable {

		private static final long serialVersionUID = -2162438241361956162L;

		/**
		 * inner object name
		 */
		private String innerName;
		/**
		 * inner object mark date
		 */
		private Date innerMarkDate;

		private InnerObject(String name, Date date) {
			setInnerName(name);
			setInnerMarkDate(date);
		}

	}

}
