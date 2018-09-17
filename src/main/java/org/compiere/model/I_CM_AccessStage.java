/******************************************************************************
 * Product: iDempiere ERP & CRM Smart Business Solution                       *
 * Copyright (C) 1999-2012 ComPiere, Inc. All Rights Reserved.                *
 * This program is free software, you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY, without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program, if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * ComPiere, Inc., 2620 Augustine Dr. #245, Santa Clara, CA 95054, USA        *
 * or via info@compiere.org or http://www.idempiere.org/license.html           *
 *****************************************************************************/
package org.compiere.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import org.idempiere.common.util.KeyNamePair;

/** Generated Interface for CM_AccessStage
 *  @author iDempiere (generated) 
 *  @version Release 5.1
 */
public interface I_CM_AccessStage 
{

    /** TableName=CM_AccessStage */
    public static final String Table_Name = "CM_AccessStage";

    /** AD_Table_ID=889 */
    public static final int Table_ID = 889;

    KeyNamePair Model = new KeyNamePair(Table_ID, Table_Name);

    /** AccessLevel = 6 - System - Client 
     */
    BigDecimal accessLevel = BigDecimal.valueOf(6);

    /** Load Meta Data */

    
    

	/** Get Client.
	  * Client/Tenant for this installation.
	  */
	public int getAD_Client_ID();

    /** Column name AD_Org_ID */
    public static final String COLUMNNAME_AD_Org_ID = "AD_Org_ID";

	/** Set Organization.
	  * Organizational entity within client
	  */
	public void setAD_Org_ID (int AD_Org_ID);

	/** Get Organization.
	  * Organizational entity within client
	  */
	public int getAD_Org_ID();

    /** Column name CM_AccessProfile_ID */
    public static final String COLUMNNAME_CM_AccessProfile_ID = "CM_AccessProfile_ID";

	/** Set Web Access Profile.
	  * Web Access Profile
	  */
	public void setCM_AccessProfile_ID (int CM_AccessProfile_ID);

	/** Get Web Access Profile.
	  * Web Access Profile
	  */
	public int getCM_AccessProfile_ID();

	public I_CM_AccessProfile getCM_AccessProfile() throws RuntimeException;

    /** Column name CM_AccessStage_UU */
    public static final String COLUMNNAME_CM_AccessStage_UU = "CM_AccessStage_UU";

	/** Set CM_AccessStage_UU	  */
	public void setCM_AccessStage_UU (String CM_AccessStage_UU);

	/** Get CM_AccessStage_UU	  */
	public String getCM_AccessStage_UU();

    /** Column name CM_CStage_ID */
    public static final String COLUMNNAME_CM_CStage_ID = "CM_CStage_ID";

	/** Set Web Container Stage.
	  * Web Container Stage contains the staging content like images, text etc.
	  */
	public void setCM_CStage_ID (int CM_CStage_ID);

	/** Get Web Container Stage.
	  * Web Container Stage contains the staging content like images, text etc.
	  */
	public int getCM_CStage_ID();

	public I_CM_CStage getCM_CStage() throws RuntimeException;

    /** Column name Created */
    public static final String COLUMNNAME_Created = "Created";

	/** Get Created.
	  * Date this record was created
	  */
	public Timestamp getCreated();

    /** Column name CreatedBy */
    public static final String COLUMNNAME_CreatedBy = "CreatedBy";

	/** Get Created By.
	  * User who created this records
	  */
	public int getCreatedBy();

    /** Column name IsActive */
    public static final String COLUMNNAME_IsActive = "IsActive";

	/** Set Active.
	  * The record is active in the system
	  */
	public void setIsActive (boolean IsActive);

	/** Get Active.
	  * The record is active in the system
	  */
	public boolean isActive();

    /** Column name Updated */
    public static final String COLUMNNAME_Updated = "Updated";

	/** Get Updated.
	  * Date this record was updated
	  */
	public Timestamp getUpdated();

    /** Column name UpdatedBy */
    public static final String COLUMNNAME_UpdatedBy = "UpdatedBy";

	/** Get Updated By.
	  * User who updated this records
	  */
	public int getUpdatedBy();
}
